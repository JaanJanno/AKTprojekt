package cpu;

import java.rmi.AccessException;
import cpu.constants.Byte32;

public class LogicUnit {
	
	public static void doAnd(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() & second.getValue());
	}
	
	public static void doOr(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() | second.getValue());
	}
	
	public static void doXor(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() ^ second.getValue());
	}
}
