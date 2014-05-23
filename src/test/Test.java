package test;

import cpu.Cpu;
import cpu.memory.MemoryStateCreator;
import static compiler.Compiler.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cpu c = new Cpu(60, 1000);
		
		MemoryStateCreator mem = compileAsmToMem(
				  "_ALGUS_\nADD A, 5 "
				+ "MOV [A + 50], :TERE:"
				+ "IFE A, 4"
				+ "MOV B, C"
				+ "\n_TERE_\n"
				+ "MOV C, 3"
						
				, 100);

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
