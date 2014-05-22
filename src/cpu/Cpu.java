package cpu;

import cpu.constants.Byte32;
import cpu.constants.OpCodes;

public class Cpu implements Runnable{

	private Thread thread = new Thread(this);
	private boolean poweredOn = true;
	
	private boolean liveMode  = true;
	private boolean steppable = false;
	
	private Byte32[] 	memory;
	private Integer  	frequency;
	
	private Byte32[] 	register;
	private Byte32		programCounter;
	private Byte32		stackPointer;
	
	private Evaluator		evaluator;
	private StackController stackController;
	private BranchController branchController;
	
	private String lastCommand = null;
	
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
		branchController = new BranchController(evaluator);
		init();
	}
	
	private boolean isSteppable(){
		boolean wasSteppable = steppable;
		steppable = false;
		return wasSteppable;
	}
	
	public void callStep(){
		steppable = true;
	}
	
	public void setLive(boolean mode){
		liveMode = mode;
	}
	
	public void insertMemState(Byte32[] memory){
		for(int i=0; i < this.memory.length && i < memory.length; i++){
			this.memory[i] = new Byte32(memory[i].getValue());
		}
	}

	private void nextOperation() {
		
		lastCommand = evaluator.toString();

		switch (evaluator.getNextOperationCode()) {
		
		case OpCodes.MOV:
			Byte32 first	= evaluator.nextValue();
			Byte32 second 	= evaluator.nextValue();
			first.setValue(second.getValue());
			break;
		
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
			
		case OpCodes.IFE:
			branchController.doIfe();
			break;
		case OpCodes.IFN:
			branchController.doIfn();
			break;
		case OpCodes.IFG:
			branchController.doIfg();
			break;
		case OpCodes.IFL:
			branchController.doIfl();
			break;
		case OpCodes.IFGE:
			branchController.doIfge();
			break;
		case OpCodes.IFLE:
			branchController.doIfle();
			break;
		default:
			poweredOn = false;
			break;
		}
	}

	@Override
	public void run() {
		try {
			while (poweredOn && programCounter.getValue() < memory.length){
				Thread.sleep(1000 / frequency);
				if (liveMode || isSteppable())
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
	
	public Byte32[] getMemory() {
		return memory;
	}

	public void setMemory(Byte32[] memory) {
		this.memory = memory;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Byte32[] getRegister() {
		return register;
	}

	public Byte32 getProgramCounter() {
		return programCounter;
	}

	public Byte32 getStackPointer() {
		return stackPointer;
	}

	public boolean isPoweredOn() {
		return poweredOn;
	}
	
	public void setPoweredOn(boolean poweredOn) {
		this.poweredOn = poweredOn;
	}
	
	public String getCurrentOpString() {
		return lastCommand;
	}
}


