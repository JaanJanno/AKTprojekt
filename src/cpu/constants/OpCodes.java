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
	public static final int EPOP 	= 18;
	
	// Logical
	
	public static final int AND 	= 8;
	public static final int OR 		= 9;
	public static final int XOR 	= 10;
	public static final int NOT 	= 17;
	
	// Bitshifts
	
	public static final int SHL 	= 19;
	public static final int SHR 	= 20;
	
	// Control
	
	public static final int SD		= 7;
	
	// Branch
	
	public static final int IFE	 	= 11;
	public static final int IFN	 	= 12;
	public static final int IFG 	= 13;
	public static final int IFL 	= 14;
	public static final int IFGE 	= 15;
	public static final int IFLE 	= 16;
	
	public static String getOperation(int i){
		switch (i) {
		case MOV:			
			return "MOV ?1, ?2";
		case ADD:			
			return "ADD ?1, ?2";		
		case SUB:			
			return "SUB ?1, ?2";
		case MUL:			
			return "MUL ?1, ?2";
		case DIV:			
			return "DIV ?1, ?2";
		case MOD:			
			return "MOD ?1, ?2";
			
		case PUSH:			
			return "PUSH ?1";
		case EPOP:			
			return "EPOP";
			
			
		case AND:			
			return "AND ?1, ?2";
		case OR:			
			return "OR ?1, ?2";
		case XOR:			
			return "XOR ?1, ?2";
		case NOT:			
			return "NOT ?1";
			
		case SHL:			
			return "SHL ?1, ?2";
		case SHR:			
			return "SHR ?1, ?2";
			
		case SD:			
			return "SD";
			
		case IFE:			
			return "IFE ?1, ?2";
		case IFN:			
			return "IFN ?1, ?2";		
		case IFG:			
			return "IFG ?1, ?2";
		case IFL:			
			return "IFL ?1, ?2";
		case IFGE:			
			return "IFGE ?1, ?2";
		case IFLE:			
			return "IFLE ?1, ?2";
			
			
		default:
			System.out.println(i);
			return "INVALID OP";
		}
	}

}
