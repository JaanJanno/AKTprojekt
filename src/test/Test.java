package test;

import cpu.Cpu;
import cpu.memory.MemoryStateCreator;
import static compiler.Compiler.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpu c = new Cpu(60, 1000);
		
		MemoryStateCreator mem = compileAsmToMem("ADD A, 5 MOV [A + 50], A", 100);

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
