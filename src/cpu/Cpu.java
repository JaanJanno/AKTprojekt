package cpu;

import java.rmi.AccessException;

import cpu.constants.Byte32;
import cpu.constants.OpCodes;

public class Cpu implements Runnable{
	
	private Thread thread = new Thread(this);
	private boolean poweredOn = true;
	
	private Byte32[] 	memory;
	private Integer  	frequency;
	
	private Byte32[] 	register;
	private Byte32		programCounter;
	private Byte32		stackPointer;
	
	private Evaluator		evaluator;
	private StackController stackController;
	
	private void init(){
		for(int i = 0; i < memory.length; i++){
			memory[i] = new Byte32(0);
		}
		for(int i = 0; i < register.length; i++){
			register[i] = new Byte32(0);
		}
	}
	
	public Cpu(int memory, int frequency) {
		this.memory 	= new Byte32[memory];
		this.frequency	= frequency;		
		register		= new Byte32[6];
		programCounter 	= new Byte32(0);
		stackPointer   	= new Byte32(this.memory.length-1);
		evaluator		= new Evaluator(this.memory, register, programCounter, stackPointer);
		stackController = new StackController(evaluator, this.memory, stackPointer);
		init();
	}
	
	public void insertMemState(Byte32[] memory){
		for(int i=0; i < this.memory.length; i++){
			this.memory[i] = new Byte32(memory[i].getValue());
		}
	}

	private void nextOperation() throws AccessException{

		switch (evaluator.getNextOperationCode()) {
		
			// Arithmetic operators.
		
		case OpCodes.ADD:	
			ArithmeticUnit.doAdd(evaluator);			
			break;
		case OpCodes.SUB:	
			ArithmeticUnit.doSubtraction(evaluator); 
			break;
		case OpCodes.MUL:	
			ArithmeticUnit.doMultiplication(evaluator); 
			break;
		case OpCodes.DIV:	
			ArithmeticUnit.doDivision(evaluator); 
			break;
		case OpCodes.MOD:
			ArithmeticUnit.doModulo(evaluator); 
			break;
			
			// Stack operators.
			
		case OpCodes.PUSH:
			stackController.doPush(); 			
			break;
		case OpCodes.POP:			
			stackController.doPop();
			break;
		
			// Logic operators.
			
		case OpCodes.AND:
			LogicUnit.doAnd(evaluator); 
			break;
		case OpCodes.OR:
			LogicUnit.doOr(evaluator); 			
			break;
		case OpCodes.XOR:			
			LogicUnit.doXor(evaluator);
			break;
			
			// Control flow.
			
		case OpCodes.EXPLODE:			
			poweredOn = false;
			break;
			
		default:
			break;
		}
	}

	@Override
	public void run() {
		try {
			while (poweredOn && programCounter.getValue() < memory.length){
				Thread.sleep(1000 / frequency);
				nextOperation();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		thread.start();
	}
	
	public void join() throws InterruptedException{
		thread.join();
	}
	
	@Override
	public String toString() {
		String output = "";
		for(int i=0;i<register.length;i++){
			output += "R" + Integer.toString(i) + " : " + Integer.toString(register[i].getValue()) + '\n';
		}
		output += "SP" + " : " + Integer.toString(stackPointer.getValue()) + '\n';
		for(int i=0;i<memory.length;i++){
			output += Integer.toString(i) + " : " + Integer.toString(memory[i].getValue()) + '\n';
		}
		return output;
	}
}


