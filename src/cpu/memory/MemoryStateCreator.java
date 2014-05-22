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
		if (counter < memory.length)
			memory[counter++].setValue(code);
	}
	
	public Byte32[] getState(){
		return memory;
	}
	
	public void addSp(){
		
		// SP
		
		add(ValCodes.SP);
		
	}
	
	public void addPc(){
		
		// PC
		
		add(ValCodes.PC);
		
	}
	
	public void addRegisterA_pointerPlusLiteral(int literal){
		
		// [A + a]
		
		add(ValCodes.atA_plusLiteral);
		add(literal);
	}
	
	public void addRegisterB_pointerPlusLiteral(int literal){
		
		// [B + a]
		
		add(ValCodes.atB_plusLiteral);
		add(literal);
	}
	
	public void addRegisterC_pointerPlusLiteral(int literal){
		
		// [C + a]
		
		add(ValCodes.atC_plusLiteral);
		add(literal);
	}
	
	public void addRegisterX_pointerPlusLiteral(int literal){
		
		// [X + a]
		
		add(ValCodes.atX_plusLiteral);
		add(literal);
	}
	
	public void addRegisterY_pointerPlusLiteral(int literal){
		
		// [Y + a]
		
		add(ValCodes.atY_plusLiteral);
		add(literal);
	}
	
	public void addRegisterZ_pointerPlusLiteral(int literal){
		
		// [Z + a]
		
		add(ValCodes.atZ_plusLiteral);
		add(literal);
	}
	
	public void addRegisterA_pointer(){
		
		// [A]
		
		add(ValCodes.atA);
	}
	
	public void addRegisterB_pointer(){
		
		// [B]
		
		add(ValCodes.atB);
	}
	
	public void addRegisterC_pointer(){
		
		// [C]
		
		add(ValCodes.atC);
	}
	
	public void addRegisterX_pointer(){
		
		// // [X]
		
		add(ValCodes.atX);
	}
	
	public void addRegisterY_pointer(){
		
		// [Y]
		
		add(ValCodes.atY);
	}
	
	public void addRegisterZ_pointer(){
		
		// [Z]
		
		add(ValCodes.atZ);
	}
	
	public void addRegisterA(){
		
		// A
		
		add(ValCodes.A);
	}
	
	public void addRegisterB(){
		
		// B
		
		add(ValCodes.B);
	}
	
	public void addRegisterC(){
		
		// C
		
		add(ValCodes.C);
	}
	
	public void addRegisterX(){
		
		// X
		
		add(ValCodes.X);
	}
	
	public void addRegisterY(){
		
		// Y
		
		add(ValCodes.Y);
	}
	
	public void addRegisterZ(){
		
		// Z
		
		add(ValCodes.Z);
	}
	
	public void addLiteral(int literal){
		
		// a
		
		add(ValCodes.LITERAL);
		add(literal);
	}
	
	public void addPointer(int pointer){
		
		// [a]
		
		add(ValCodes.POINTER);
		add(pointer);
	}
	
	public void addMov(){
		
		// MOV a, b
		
		add(OpCodes.MOV);
	}
	
	public void addAdd(){
		
		// // ADD a, b
		
		add(OpCodes.ADD);
	}
	
	public void addSub(){
		
		// SUB a, b
		
		add(OpCodes.SUB);
	}
	
	public void addMul(){
		
		// ADD a, b
		
		add(OpCodes.MUL);
	}
	
	public void addDiv(){
		
		// DIV a, b
		
		add(OpCodes.DIV);
	}
	
	public void addMod(){
		
		// MOD a, b
		
		add(OpCodes.MOD);
	}
	
	public void addPush(){
		
		// PUSH a
		
		add(OpCodes.PUSH);
	}
	
	public void addEPop(){
		
		// POP
		
		add(OpCodes.EPOP);
	}
	
	public void addAnd(){
		
		// AND a, b
		
		add(OpCodes.AND);
	}
	
	public void addOr(){
		
		// OR a, b
		
		add(OpCodes.OR);
	}
	
	public void addXor(){
		
		// XOR a, b
		
		add(OpCodes.XOR);
	}
	
	public void addNot(){
		
		// NOT a
		
		add(OpCodes.NOT);
	}
	
	public void addShr(){
		
		// NOT a
		
		add(OpCodes.SHR);
	}
	
	public void addShl(){
		
		// NOT a
		
		add(OpCodes.SHL);
	}
	
	public void addIfEq(){
		
		// IFE a, b
		
		add(OpCodes.IFE);
		
	}
	
	public void addIfNe(){
		
		// IFN a, b
		
		add(OpCodes.IFN);
		
	}
	
	public void addIfGt(){
		
		// IFG a, b
		
		add(OpCodes.IFG);
		
	}
	
	public void addIfLt(){
		
		// IFL a, b
		
		add(OpCodes.IFL);
		
	}
	
	public void addIfGe(){
		
		// IFGE a, b
		
		add(OpCodes.IFGE);
		
	}
	
	public void addIfLe(){
		
		// IFLE a, b
		
		add(OpCodes.IFLE);
		
	}
	
	public void addShutDown(){
		
		// SD
		
		add(OpCodes.SD);
	}
}
