package test;

import cpu.Cpu;
import cpu.memory.MemoryStateCreator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpu c = new Cpu(60, 1000);
		
		MemoryStateCreator mem = new MemoryStateCreator(60);
		
		mem.addMov();
			mem.addRegisterA();
			mem.addLiteral(10);
			
		mem.addIfEq();
			mem.addRegisterA();
			mem.addLiteral(0);
			
		mem.addMov();
			mem.addPc();
			mem.addLiteral(23);
			
		mem.addPush();
			mem.addLiteral(5);
			
		mem.addSub();
			mem.addRegisterA();
			mem.addLiteral(1);
		
		mem.addMov();
			mem.addPc();
			mem.addLiteral(4);

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
