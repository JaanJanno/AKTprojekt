package compiler;

import java.util.HashMap;
import java.util.Map;

import gen.ASMLexer;
import gen.ASMParser;
import gen.ASMParser.LabelContext;
import gen.ASMParser.LiteralContext;
import gen.ASMParser.PoinerNumContext;
import gen.ASMParser.PointerNumPlusRegContext;
import gen.ASMParser.ProgramContext;
import gen.ASMParser.RegisterContext;
import gen.ASMParser.RegisterPointerContext;
import gen.ASMParser.SpecialValContext;
import gen.ASMParser.StatementContext;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import cpu.memory.MemoryStateCreator;

public class Compiler {
	
	public static void main(String[] args) {
		System.out.println();
	}
	
	static Map<Integer, String> labelUses;
	static Map<String,Integer>  labelLocations;
	
	public static MemoryStateCreator compileAsmToMem(String asm, int memSize){
		labelUses 		= new HashMap<>();
		labelLocations  = new HashMap<>();
		
		ParseTree tree = createParseTree(asm);
		MemoryStateCreator mem = new MemoryStateCreator(memSize);
		
		createMemState(mem, tree);
		
		for (int i: labelUses.keySet()){
			mem.setMemSlot(i, labelLocations.get(labelUses.get(i)));
		}
		
		return mem;
	}
	
	private static void createMemState(MemoryStateCreator mem, ParseTree tree) {
		if (tree instanceof ASMParser.ProgramContext){
			visitProgram(mem, (ProgramContext) tree);
		}
		else if (tree instanceof ASMParser.StatementContext){
			visitStatement(mem, (StatementContext) tree);
		}
		else if (tree instanceof ASMParser.ValueContext){
			createMemState(mem, tree.getChild(0));
		}
		else if (tree instanceof ASMParser.LabelContext){
			visitLabel(mem, (LabelContext)tree);
		}
		else if (tree instanceof ASMParser.PoinerNumContext){
			visitPointerNum(mem, (PoinerNumContext)tree);
		}
		else if (tree instanceof ASMParser.PointerNumPlusRegContext){
			visitPointerNumPlusReg(mem, (PointerNumPlusRegContext)tree);
		}
		else if (tree instanceof ASMParser.LiteralContext){
			visitLiteral(mem, (LiteralContext)tree);
		}
		else if (tree instanceof ASMParser.RegisterValueContext){
			visitRegister(mem, (RegisterContext) tree);
		}
		else if (tree instanceof ASMParser.RegisterPointerContext){
			visitRegisterPointer(mem, (RegisterPointerContext) tree);
		}
		else if (tree instanceof ASMParser.SpecialValContext){
			visitSpecialVal(mem, (SpecialValContext) tree);
		}
	}

	private static void visitSpecialVal(MemoryStateCreator mem,	SpecialValContext tree) {
		switch (tree.getText()) {
			case "SP":
				mem.addSp();				break;
			case "PC":
				mem.addPc();				break;
			case "POP":
				mem.addPop();				break;
			case "PEEK":
				mem.addPeek();				break;
		}
	}

	private static void visitRegisterPointer(MemoryStateCreator mem, RegisterPointerContext tree) {
		switch (tree.getText()) {
			case "[A]":
				mem.addRegisterA_pointer();				break;
			case "[B]":
				mem.addRegisterB_pointer();				break;
			case "[C]":
				mem.addRegisterC_pointer();				break;
			case "[X]":
				mem.addRegisterX_pointer();				break;
			case "[Y]":
				mem.addRegisterY_pointer();				break;
			case "[Z]":
				mem.addRegisterZ_pointer();				break;
		}
	}

	private static void visitLiteral(MemoryStateCreator mem, LiteralContext tree) {
		mem.addLiteral(Integer.parseInt(tree.getText()));
	}

	private static void visitPointerNumPlusReg(MemoryStateCreator mem, PointerNumPlusRegContext tree) {
		int literal = Integer.parseInt(tree.getChild(3).getText());		
		switch (tree.getChild(1).getText()) {
			case "A":
				mem.addRegisterA_pointerPlusLiteral(literal);				break;
			case "B":
				mem.addRegisterB_pointerPlusLiteral(literal);				break;
			case "C":
				mem.addRegisterC_pointerPlusLiteral(literal);				break;
			case "X":
				mem.addRegisterX_pointerPlusLiteral(literal);				break;
			case "Y":
				mem.addRegisterY_pointerPlusLiteral(literal);				break;
			case "Z":
				mem.addRegisterZ_pointerPlusLiteral(literal);				break;
		}
	}

	private static void visitPointerNum(MemoryStateCreator mem,	PoinerNumContext tree) {
		mem.addPointer(Integer.parseInt(tree.getChild(1).getText()));
	}

	private static void visitLabel(MemoryStateCreator mem, LabelContext tree) {
		mem.addLiteral(0);
		labelUses.put(mem.getCounter()-1, tree.getText().substring(1, tree.getText().length()-1));
	}

	private static void visitStatement(MemoryStateCreator mem, StatementContext tree) {
		visitOpCode(mem, tree.getChild(0));
		for (int i=1; i<tree.getChildCount(); i++){
			createMemState(mem, tree.getChild(i));
		}
	}

	private static void visitOpCode(MemoryStateCreator mem, ParseTree child) {
		switch (child.getText()) {
			case "MOV":			
				mem.addMov();				break;
			case "ADD":			
				mem.addAdd();				break;		
			case "SUB":				
				mem.addSub();				break;		
			case "MUL":					
				mem.addMul();				break;			
			case "DIV":						
				mem.addDiv();				break;		
			case "MOD":						
				mem.addMod();				break;		
				
			case "PUSH":					
				mem.addPush();				break;			
			case "EPOP":					
				mem.addEPop();				break;			
			
			case "AND":						
				mem.addAnd();				break;		
			case "OR":					
				mem.addOr();				break;			
			case "XOR":						
				mem.addXor();				break;		
			case "NOT":						
				mem.addNot();				break;		
	
			case "SHL":						
				mem.addShl();				break;		
			case "SHR":						
				mem.addShr();				break;		
	
			case "SD":						
				mem.addShutDown();			break;		
				
			case "IFE":						
				mem.addIfEq();				break;		
			case "IFN":						
				mem.addIfNe();				break;		
			case "IFG":						
				mem.addIfGt();				break;		
			case "IFL":						
				mem.addIfLt();				break;		
			case "IFGE":					
				mem.addIfGe();				break;			
			case "IFLE":					
				mem.addIfLe();				break;			
		}
	}

	private static void visitRegister(MemoryStateCreator mem, RegisterContext tree) {
		switch (tree.getText()) {
			case "A":
				mem.addRegisterA();				break;
			case "B":
				mem.addRegisterB();				break;
			case "C":
				mem.addRegisterC();				break;
			case "X":
				mem.addRegisterX();				break;
			case "Y":
				mem.addRegisterY();				break;
			case "Z":
				mem.addRegisterZ();				break;
		}
	}

	private static void visitProgram(MemoryStateCreator mem, ASMParser.ProgramContext tree) {
		for (ParseTree subTree : tree.children){			
			if (subTree instanceof ASMParser.LabelDeclarationContext){
				labelLocations.put(subTree.getText().substring(1, subTree.getText().length()-1), mem.getCounter());
			}
			else if (subTree instanceof ASMParser.StatementContext){
				createMemState(mem, subTree);
			}
		}
	}

	private static ParseTree createParseTree(String program) {
		ANTLRInputStream antlrInput = new ANTLRInputStream(program);
		ASMLexer lexer = new ASMLexer(antlrInput);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ASMParser parser = new ASMParser(tokens);
		ParseTree tree = parser.program();
		return tree;
	}
}
