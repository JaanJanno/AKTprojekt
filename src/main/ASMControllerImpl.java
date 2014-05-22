package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cpu.Cpu;
import cpu.constants.Byte32;
import cpu.memory.MemoryStateCreator;

public class ASMControllerImpl implements ASMController {
	private Cpu cpu;
	private List<String> pureAsm; // THIS IS (PROBABLY) VERY BAD
	private AsmReader asmReader;
	private MemoryStateCreator memState;
	private List<String> processedCommands; 

	public ASMControllerImpl() {
		pureAsm = new ArrayList<>();
		asmReader = new AsmReader();
		processedCommands = new ArrayList<>();
	}

	@Override
	public void loadFile(String absoulutePath, int memory, int frequency) {
		cpu = new Cpu(memory, frequency);
		try {
			// currently test file
			pureAsm = asmReader.readAsm("/test.asm");
		} catch (IOException e) {
			e.printStackTrace();
		}
		memState = createMemState(memory);
		cpu.insertMemState(memState.getState());
		Intro.window.update();

	}

	@Override
	public void start() {
		Intro.window.update();
		cpu.setLive(false);
		cpu.start();
	}
	
	@Override
	public void runToEnd() {
		while(cpu.isPoweredOn()) {
			cpu.callStep();		
			processedCommands.add(cpu.getCurrentOpString());
			Intro.window.update();
		}
		
	}

	@Override
	public void reset(int memory) {
		cpu = new Cpu(memory, 0);

		pureAsm.clear();
		memState = new MemoryStateCreator(memory);
		cpu.insertMemState(memState.getState());
		processedCommands.clear();
//		Intro.window.update();

	}

	@Override
	public List<Integer> currentRegisterStatus() {
		List<Integer> in = new ArrayList<>();
		Byte32[] b = cpu.getRegister();
		for (int i = 0; i < b.length; i++) {
			in.add(b[i].getValue());
		}
		return in;
	}

	@Override
	public List<Integer> currentPointerStatus() {
		List<Integer> in = new ArrayList<>();
		in.add(cpu.getStackPointer().getValue());
		in.add(cpu.getProgramCounter().getValue());
		return in;
	}

	@Override
	public void stop() {
		try {
			cpu.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<String> getAsm() {
		return pureAsm;
	}

	@Override
	public List<String> getCpuMemory() {
		String output = "";
		List<String> memList = new ArrayList<>();
		Byte32[] byteList = cpu.getMemory();

		for (int i = 0; i < byteList.length; i++) {
			// output = Integer.toString(i) + " : " +
			// Integer.toString(byteList[i].getValue());
			output = String.format("%-3s : %-12s", Integer.toString(i),
					Integer.toString(byteList[i].getValue()));
			if(i == cpu.getProgramCounter().getValue()) {
				output += "<- PC ";
			}
			if(i == cpu.getStackPointer().getValue()) {
				output += "<- SP ";
			}
			memList.add(output);
		}
		return memList;
	}
	
	@Override
	public void nextStep() {
		cpu.callStep();
		if(cpu.isPoweredOn())
			processedCommands.add(cpu.getCurrentOpString());
		Intro.window.update();
	}
	
	@Override
	public List<String> getProcessedCommands() {

		return processedCommands;
	}

	private MemoryStateCreator createMemState(int memory) {
		// TODO make pureAsm into memState. should put this method into
		// asmReader
		MemoryStateCreator mem = new MemoryStateCreator(memory);

		mem.addAdd();
			mem.addRegisterA();
			mem.addLiteral(50);
		mem.addOr();
			mem.addPointer(2);
			mem.addLiteral(66);
		mem.addAdd();
			mem.addPointer(5);
			mem.addLiteral(5000);
		mem.addAnd();
			mem.addPointer(5);
			mem.addLiteral(1023);
		mem.addPush();
			mem.addLiteral(5);
		mem.addPush();
			mem.addLiteral(5);
		mem.addPop();
		mem.addIfEq();
			mem.addLiteral(3);
			mem.addLiteral(5);
		mem.addMov();
			mem.addRegisterB();
			mem.addLiteral(111);
		mem.addMov();
			mem.addRegisterC();
			mem.addLiteral(222);
		mem.addIfNe();
			mem.addLiteral(3);
			mem.addLiteral(5);
		mem.addMov();
			mem.addRegisterX();
			mem.addLiteral(111);
		mem.addShutDown();
		return mem;
	}

}
