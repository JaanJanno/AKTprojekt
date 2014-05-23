MOV A, 10
_check_
IFE A, 0
MOV PC :end:
PUSH 5
SUB A, 1
MOV PC, :check:
_end_
MOV C, [:global1:]
MOV Z, 1
MOV X, [Z + :global1:]
SD
DAT 555, 654, 76
_global1_
DAT 777
DAT 888