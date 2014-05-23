grammar ASM;

program
	:	(statement | label) (statement | label)* EOF
	;

statement
	:	Operator (value (value)?)?
	;

Operator
	    : 'MOV'
        | 'ADD'
        | 'SUB'
        | 'MUL'
        | 'DIV'
        | 'MOD'
        | 'AND'
        | 'OR'
        | 'XOR'
        | 'IFE'
        | 'IFN'
        | 'IFG'
        | 'IFL'
        | 'IFGE'
        | 'IFLE'
        | 'PUSH'
        | 'NOT'
        | 'SHR'
        | 'SHL'
        | 'POP'
        | 'SD'
        | 'DAT'
        ;

value
	:	register
	|	literal
	|   label
	|	pointer
	;

literal
    :   NumberLiteral
    ;

register
    :   RegisterValue       #   registerValue
    |   RegisterPointer     #   registerPointer
    ;

RegisterValue
    : 'A'|'B'|'C'|'X'|'Y'|'Z'
    ;

RegisterPointer
    : '[A]'|'[B]'|'[C]'|'[X]'|'[Y]'|'[Z]'
    ;

SpecialValue
	:	'SP'
	|	'PC'
	|	'PEEK'
	|	'POP'
	;

label
	:	Label
	;

Label
	: ':' .* ':'
	;

pointer
	:	'[' RegisterValue '+' NumberLiteral ']' #   pointerNumPlusReg
	|	'[' NumberLiteral ']'                   #   poinerNum
	;

NumberLiteral
	:	('1' .. '9') ('0' .. '9')*
	|	'0'
	;

Whitespace
	:   [ \t\r\n,]+ -> skip
	;