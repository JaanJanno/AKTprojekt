package cpu.memory;

import cpu.constants.Byte32;
import cpu.constants.OpCodes;
import cpu.constants.ValCodes;

public class MemoryStateCreator {
	
	private int counter;
	private Byte32[] memory;
	
	private void init(){
		for(int i = 0; i < memory.length; i++){
			memory[i] = new Byte32(0);
		}
	}

	public MemoryStateCreator(int memSize) {
		this.memory = new Byte32[memSize];
		this.init();
		this.counter = 0;
	}
	
	public void add(int code){
		memory[counter++].setValue(code);
	}
	
	public Byte32[] getState(){
		return memory;
	}
	
	public void addRegisterA_pointerPlusLiteral(int literal){
		add(ValCodes.atA_plusLiteral);
		add(literal);
	}
	
	public void addRegisterB_pointerPlusLiteral(int literal){
		add(ValCodes.atB_plusLiteral);
		add(literal);
	}
	
	public void addRegisterC_pointerPlusLiteral(int literal){
		add(ValCodes.atC_plusLiteral);
		add(literal);
	}
	
	public void addRegisterX_pointerPlusLiteral(int literal){
		add(ValCodes.atX_plusLiteral);
		add(literal);
	}
	
	public void addRegisterY_pointerPlusLiteral(int literal){
		add(ValCodes.atY_plusLiteral);
		add(literal);
	}
	
	public void addRegisterZ_pointerPlusLiteral(int literal){
		add(ValCodes.atZ_plusLiteral);
		add(literal);
	}
	
	public void addRegisterA_pointer(){
		add(ValCodes.atA);
	}
	
	public void addRegisterB_pointer(){
		add(ValCodes.atB);
	}
	
	public void addRegisterC_pointer(){
		add(ValCodes.atC);
	}
	
	public void addRegisterX_pointer(){
		add(ValCodes.atX);
	}
	
	public void addRegisterY_pointer(){
		add(ValCodes.atY);
	}
	
	public void addRegisterZ_pointer(){
		add(ValCodes.atZ);
	}
	
	public void addRegisterA(){
		add(ValCodes.A);
	}
	
	public void addRegisterB(){
		add(ValCodes.B);
	}
	
	public void addRegisterC(){
		add(ValCodes.C);
	}
	
	public void addRegisterX(){
		add(ValCodes.X);
	}
	
	public void addRegisterY(){
		add(ValCodes.Y);
	}
	
	public void addRegisterZ(){
		add(ValCodes.Z);
	}
	
	public void addLiteral(int literal){
		add(ValCodes.LITERAL);
		add(literal);
	}
	
	public void addPointer(int pointer){
		add(ValCodes.POINTER);
		add(pointer);
	}
	
	public void addMov(){
		add(OpCodes.MOV);
	}
	
	public void addAdd(){
		add(OpCodes.ADD);
	}
	
	public void addSub(){
		add(OpCodes.SUB);
	}
	
	public void addMul(){
		add(OpCodes.MUL);
	}
	
	public void addDiv(){
		add(OpCodes.DIV);
	}
	
	public void addMod(){
		add(OpCodes.MOD);
	}
	
	public void addPush(){
		add(OpCodes.PUSH);
	}
	
	public void addPop(){
		add(OpCodes.POP);
	}
	
	public void addAnd(){
		add(OpCodes.AND);
	}
	
	public void addOr(){
		add(OpCodes.OR);
	}
	
	public void addXor(){
		add(OpCodes.XOR);
	}
	
	public void addShutDown(){
		add(OpCodes.EXPLODE);
	}
}
