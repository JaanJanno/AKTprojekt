package cpu;

import java.rmi.AccessException;
import cpu.constants.Byte32;

public class ArithmeticUnit {
	
	public static void doAdd(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() + second.getValue());
	}
	
	public static void doSubtraction(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() - second.getValue());
	}
	
	public static void doMultiplication(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() * second.getValue());
	}
	
	public static void doDivision(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() / second.getValue());
	}
	
	public static void doModulo(Evaluator evaluator) throws AccessException{
		Byte32 first	= evaluator.nextValue();
		Byte32 second 	= evaluator.nextValue();
		first.setValue(first.getValue() % second.getValue());
	}
}