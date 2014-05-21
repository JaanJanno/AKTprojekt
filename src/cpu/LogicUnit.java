package cpu;

import cpu.constants.Byte32;

public class LogicUnit {
	
	public static void doAnd(Evaluator evaluator) {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() & second.getValue());
	}
	
	public static void doOr(Evaluator evaluator) {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() | second.getValue());
	}
	
	public static void doXor(Evaluator evaluator) {
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() ^ second.getValue());
	}
}
