package cpu;

import cpu.constants.Byte32;
import cpu.constants.OpCodes;
import cpu.constants.ValCodes;

public class BranchController {
	
	private Evaluator evaluator;

	public BranchController(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	public void doIfe() {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		if (first.getValue() != second.getValue())
			skipInstruction();
	}

	public void doIfn() {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		if (first.getValue() == second.getValue())
			skipInstruction();
	}

	public void doIfg() {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		if (!(first.getValue() > second.getValue()))
			skipInstruction();
	}

	public void doIfl() {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		if (!(first.getValue() < second.getValue()))
			skipInstruction();
	}

	public void doIfge() {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		if (!(first.getValue() >= second.getValue()))
			skipInstruction();
	}

	public void doIfle() {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		if (!(first.getValue() <= second.getValue()))
			skipInstruction();
	}
	
	private void skipInstruction(){
		int opCode = evaluator.getNextOperationCode();
		for (int i = 0; i < argCount(opCode); i++){
			skipValue();
		}
	}
	
	private void skipValue() {
		int valCode = evaluator.getNextValueCode();
		if (isTwoByteVal(valCode)){
			evaluator.nextValue();
		}	
	}

	private boolean isTwoByteVal(int valCode) {
		switch (valCode) {
		case ValCodes.LITERAL:			
			return true;
		case ValCodes.POINTER:			
			return true;
		case ValCodes.atA_plusLiteral:			
			return true;
		case ValCodes.atB_plusLiteral:			
			return true;
		case ValCodes.atC_plusLiteral:			
			return true;
		case ValCodes.atX_plusLiteral:			
			return true;
		case ValCodes.atY_plusLiteral:			
			return true;
		case ValCodes.atZ_plusLiteral:			
			return true;
		default:
			return false;
		}
	}

	public static int argCount(int opCode){
		switch (opCode) {
		
		// Arithmetic
		
		case OpCodes.MOV:
			return 2;
		case OpCodes.ADD:
			return 2;
		case OpCodes.SUB:
			return 2;
		case OpCodes.MUL:
			return 2;
		case OpCodes.DIV:
			return 2;
		case OpCodes.MOD:
			return 2;
			
		// Logic
		
		case OpCodes.AND:
			return 2;
		case OpCodes.OR:
			return 2;
		case OpCodes.XOR:
			return 2;
			
		// Branching
			
		case OpCodes.IFE:
			return 2;
		case OpCodes.IFN:
			return 2;
		case OpCodes.IFG:
			return 2;
		case OpCodes.IFL:
			return 2;
		case OpCodes.IFGE:
			return 2;
		case OpCodes.IFLE:
			return 2;
			
		// Stack
			
		case OpCodes.PUSH:
			return 1;
		case OpCodes.POP:
			return 0;
			
		// Control
			
		case OpCodes.EXPLODE:
			return 0;	

		default:
			return 0;
		}
	}

}
