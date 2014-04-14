package cpu;

import java.rmi.AccessException;
import cpu.constants.Byte32;

public class StackController {
	
	Evaluator 	evaluator;
	Byte32[]	memory;
	Byte32		stackPointer;
	
	public StackController(Evaluator evaluator, Byte32[] memory, Byte32 stackPointer) {
		this.evaluator = evaluator;
		this.memory = memory;
		this.stackPointer = stackPointer;
	}

	public void doPush() throws AccessException{
		Byte32 pushed = evaluator.nextValue();
		System.out.println(pushed.getValue());
		memory[stackPointer.getPushValue()].setValue(pushed.getValue());
	}
	
	public void doPop() throws AccessException{
		stackPointer.getNextValue();
	}
}
