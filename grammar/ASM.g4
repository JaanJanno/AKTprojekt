grammar ASM;

program
	:	(statement | labelDeclaration) (statement | labelDeclaration)* EOF
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
        | 'EPOP'
        | 'SD'
        | 'DAT'
        ;

value
	:	register
	|	literal
	|   label
	|	pointer
	|   specialVal
	;

specialVal
    :   SpecialValue
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

labelDeclaration
	:	LabelDeclaration
	;

Label
	: ':' (.)*? ':'
	;

LabelDeclaration
	: '_' (.)*? '_'
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