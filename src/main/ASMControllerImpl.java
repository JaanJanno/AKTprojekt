package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cpu.Cpu;
import cpu.constants.Byte32;
import cpu.memory.MemoryStateCreator;

public class ASMControllerImpl implements ASMController {
	private Cpu cpu;
	private Pinger pinger;
	private List<String> pureAsm; // THIS IS (PROBABLY) VERY BAD
	private AsmReader asmReader;
	private MemoryStateCreator memState;

	public ASMControllerImpl() {
		cpu = new Cpu(30, 1);
		pinger = new Pinger();
		pureAsm = new ArrayList<>();
		asmReader = new AsmReader();
	}

	@Override
	public void loadFile(String absoulutePath) {
		try {
			// currently test file
			pureAsm = asmReader.readAsm("test.asm");
		} catch (IOException e) {
			e.printStackTrace();
		}
		MemoryStateCreator memState = createMemState();

		cpu.insertMemState(memState.getState());
		Intro.window.update();

	}

	@Override
	public void start(int frequency, int memory) {
		Intro.window.update();
		cpu.setFrequency(frequency);
		// TODO memory size must be set
		// cpu.setMemory(new Byte32[memory]);
		cpu.start();
		pinger.start();
		try {
			cpu.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

		cpu = new Cpu(10, 10);

		pureAsm.clear();

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
			pinger.join();
			cpu.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
		Byte32[] byteList = cpu.getMemory();
		List<String> memList = new ArrayList<>();
		for (int i = 0; i < byteList.length; i++) {
			// output = Integer.toString(i) + " : " +
			// Integer.toString(byteList[i].getValue());
			output = String.format("%-3s : %-12s", Integer.toString(i),
					Integer.toString(byteList[i].getValue()));
			memList.add(output);
		}
		return memList;
	}

	private MemoryStateCreator createMemState() {
		// TODO make pureAsm into memState. should put this method into
		// asmReader
		MemoryStateCreator mem = new MemoryStateCreator(30);

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
			mem.addPointer(5);
		mem.addPop();
		mem.addShutDown();
		return mem;
	}

	/**
	 * Class to keep the connection open. Credit to Jaan Janno.
	 * https://github.com
	 * /JaanJanno/OnTime/blob/master/app/controllers/chat/ChatSocket.java
	 */
	private class Pinger extends Thread {

		public Pinger() {
		}

		@Override
		public synchronized void run() {
			while (cpu.isPoweredOn()) {
				Intro.window.update();
				System.out.println(cpu.toString());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(cpu.toString());
			Intro.window.update();
		}
	}

}
