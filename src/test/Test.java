package test;

import cpu.Cpu;
import cpu.memory.MemoryStateCreator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpu c = new Cpu(60, 1000);
		
		MemoryStateCreator mem = new MemoryStateCreator(60);
		
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

		c.insertMemState(mem.getState());
		
		c.start();
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c);
	}
}
