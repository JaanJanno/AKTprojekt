package cpu.constants;

public class ValCodes {
	
	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int Z = 5;
	
	public static final int atA = 6;
	public static final int atB = 7;
	public static final int atC = 8;
	public static final int atX = 9;
	public static final int atY = 10;
	public static final int atZ = 11;
	
	public static final int atA_plusLiteral = 12;
	public static final int atB_plusLiteral = 13;
	public static final int atC_plusLiteral = 14;
	public static final int atX_plusLiteral = 15;
	public static final int atY_plusLiteral = 16;
	public static final int atZ_plusLiteral = 17;
	
	public static final int POP 	= 18;
	public static final int PEEK  	= 19;
	
	public static final int SP  	= 20;
	public static final int PC  	= 21;
	
	public static final int POINTER = 22;
	public static final int LITERAL = 23;

	public static boolean isOneByteValue(int val){
		switch (val) {
		case A:
			return true;
		case B:
			return true;
		case C:
			return true;
		case X:
			return true;
		case Y:
			return true;
		case Z:
			return true;
			
		case atA:
			return true;
		case atB:
			return true;
		case atC:
			return true;
		case atX:
			return true;
		case atY:
			return true;
		case atZ:
			return true;
			
		case POP:
			return true;
		case PEEK:
			return true;
		case SP:
			return true;
		case PC:
			return true;

		default:
			return false;
		}
	}
	
	public static String getValString(int val){
		switch (val) {
		case A:
			return "A";
		case B:
			return "B";
		case C:
			return "C";
		case X:
			return "X";
		case Y:
			return "Y";
		case Z:
			return "Z";
			
		case atA:
			return "[A]";
		case atB:
			return "[B]";
		case atC:
			return "[C]";
		case atX:
			return "[X]";
		case atY:
			return "[Y]";
		case atZ:
			return "[Z]";
			
		case POP:
			return "POP";
		case PEEK:
			return "PEEK";
		case SP:
			return "SP";
		case PC:
			return "PC";

		default:
			return "NULL";
		}
	}
	
	private static String getValTemplate(int i){
		switch (i) {
		case LITERAL:
			return "?1";
		case POINTER:
			return "[?1]";
		case atA_plusLiteral:
			return "[A + ?1]";
		case atB_plusLiteral:
			return "[B + ?1]";
		case atC_plusLiteral:
			return "[C + ?1]";
		case atX_plusLiteral:
			return "[X + ?1]";
		case atY_plusLiteral:
			return "[Y + ?1]";
		case atZ_plusLiteral:
			return "[Z + ?1]";
		default:
			return "NULL";
		}
	}

	public static String getValString(int value, int value2) {
		String valString = getValTemplate(value);
		valString = valString.replaceAll("\\?1", Integer.toString(value2));
		return valString;
	}
}
