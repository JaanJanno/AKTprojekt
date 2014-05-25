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
	public static boolean hadParseException = false;

	public ASMControllerImpl() {
		pureAsm = new ArrayList<>();
		asmReader = new AsmReader();
		processedCommands = new ArrayList<>();
	}

	@Override
	public void loadFile(String absoulutePath, int memory, int frequency) {
		reset(memory);
		cpu = new Cpu(memory, frequency);
		try {
			// currently test file
			if (absoulutePath.equals("/test.asm"))
				pureAsm = asmReader.readAsmTest(absoulutePath);
			else
				pureAsm = asmReader.readAsm(absoulutePath);
			Intro.window.setMessage("File loaded");
		} catch (IOException e) {
			Intro.window.setMessage("Could not load file");
			e.printStackTrace();
		}
		memState = createMemState(memory);
		// Currently unused
		if (hadParseException) {
			Intro.window
					.setMessage("Something went wrong with parsing. Check console.");
			hadParseException = false;
		}
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
		while (cpu.isPoweredOn()) {
			cpu.callStep();
			processedCommands.add(cpu.getCurrentOpString());
			Intro.window.update();
		}
		Intro.window.setMessage("All commands processed");

	}

	@Override
	public void reset(int memory) {
		cpu = new Cpu(memory, 0);

		pureAsm.clear();
		memState = new MemoryStateCreator(memory);
		cpu.insertMemState(memState.getState());
		processedCommands.clear();
		hadParseException = false;
		// Intro.window.update();

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
			output = String.format("%-3s : %-12s", Integer.toString(i),
					Integer.toString(byteList[i].getValue()));
			if (i == cpu.getProgramCounter().getValue()) {
				output += "<- PC ";
			}
			if (i == cpu.getStackPointer().getValue()) {
				output += "<- SP ";
			}
			memList.add(output);
		}
		return memList;
	}

	@Override
	public void nextStep() {
		cpu.callStep();
		if (cpu.isPoweredOn())
			processedCommands.add(cpu.getCurrentOpString());
		else
			Intro.window.setMessage("All commands processed");
		Intro.window.update();
	}

	@Override
	public List<String> getProcessedCommands() {

		return processedCommands;
	}

	private MemoryStateCreator createMemState(int memory) {
		String asm = "";
		for (int i = 0; i < pureAsm.size(); i++) {
			asm += pureAsm.get(i) + " ";
		}
		return compiler.Compiler.compileAsmToMem(asm, memory);
	}

}
