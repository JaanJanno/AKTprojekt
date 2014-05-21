package cpu;

import cpu.constants.Byte32;
import cpu.constants.ValCodes;

public class Evaluator {
	
	Byte32[] 	memory;
	Byte32[] 	register;
	Byte32		programCounter;
	Byte32		stackPointer;
	
	public Evaluator(Byte32[] memory, Byte32[] register, Byte32 programCounter, Byte32 stackPointer) {
		this.memory = memory;
		this.register = register;
		this.programCounter = programCounter;
		this.stackPointer = stackPointer;
	}
	
	public int getNextLiteral(){
		return memory[programCounter.getNextValue()].getValue();
	}
	
	public int getNextOperationCode(){
		return memory[programCounter.getNextValue()].getValue();
	}
	
	public int getNextValueCode(){
		return memory[programCounter.getNextValue()].getValue();
	}
	
	public Byte32 getMemReference(int index) {
		if(index < memory.length)
			return memory[index];
		throw new RuntimeException();
	}
	
	public Byte32 nextValue() {
		
		switch (getNextValueCode()) {
		
			// Value in register.
		
		case ValCodes.A:
			return register[0];
		case ValCodes.B:
			return register[1];
		case ValCodes.C:
			return register[2];
		case ValCodes.X:
			return register[3];
		case ValCodes.Y:
			return register[4];
		case ValCodes.Z:
			return register[5];
			
			// Value register points at in memory.
			
		case ValCodes.atA:
			return getMemReference(register[0].getValue());
		case ValCodes.atB:
			return getMemReference(register[1].getValue());
		case ValCodes.atC:
			return getMemReference(register[2].getValue());
		case ValCodes.atX:
			return getMemReference(register[3].getValue());
		case ValCodes.atY:
			return getMemReference(register[4].getValue());
		case ValCodes.atZ:
			return getMemReference(register[5].getValue());
			
			// Value register points at offset by a literal.
			
		case ValCodes.atA_plusLiteral:
			return getMemReference(register[0].getValue() + getNextLiteral());
		case ValCodes.atB_plusLiteral:
			return getMemReference(register[1].getValue() + getNextLiteral());
		case ValCodes.atC_plusLiteral:
			return getMemReference(register[2].getValue() + getNextLiteral());
		case ValCodes.atX_plusLiteral:
			return getMemReference(register[3].getValue() + getNextLiteral());
		case ValCodes.atY_plusLiteral:
			return getMemReference(register[4].getValue() + getNextLiteral());
		case ValCodes.atZ_plusLiteral:
			return getMemReference(register[5].getValue() + getNextLiteral());
			
			// Stack top element values.
			
		case ValCodes.POP:
			return getMemReference(stackPointer.getNextValue());
		case ValCodes.PEEK:
			return getMemReference(stackPointer.getValue());
			
			// SP and PC values.
			
		case ValCodes.SP:
			return stackPointer;
		case ValCodes.PC:
			return programCounter;
			
			// Literal value and pointer to byte in memory.
			
		case ValCodes.POINTER:
			return getMemReference(getNextLiteral());
		case ValCodes.LITERAL:
			return new Byte32(getNextLiteral());
		default:
			return null;
		}
	}

}
