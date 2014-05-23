MOV A, 10
_check_
IFE A, 0
MOV PC :end:
PUSH 5
SUB A, 1
MOV PC, :check:
_end_
SD
DAT 555, 654, 76