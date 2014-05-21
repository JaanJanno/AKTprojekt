package cpu.constants;

public class OpCodes {
	
	// Arithmetic
	
	public static final int MOV 	= 0;
	public static final int ADD 	= 1;
	public static final int SUB 	= 2;
	public static final int MUL 	= 3;
	public static final int DIV 	= 4;
	public static final int MOD 	= 5;
	
	// Stack
	
	public static final int PUSH  	= 6;
	public static final int POP 	= 18;
	
	// Logical
	
	public static final int AND 	= 8;
	public static final int OR 		= 9;
	public static final int XOR 	= 10;
	
	// Control
	
	public static final int EXPLODE = 666;
	
	// Branch
	
	public static final int IFE	 	= 11;
	public static final int IFN	 	= 12;
	public static final int IFG 	= 13;
	public static final int IFL 	= 14;
	public static final int IFGE 	= 15;
	public static final int IFLE 	= 16;

}
