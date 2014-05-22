package main;

import java.util.List;

public interface ASMController {
	public void loadFile(String absoulutePath, int memory, int frequency);
	
	public void start(int frequency, int memory);
	
	public void stop();
	
	public void reset(int memory);
	
	public List<Integer> currentRegisterStatus();
	
	public List<Integer> currentPointerStatus();
	
	public List<String> getAsm();
	
	public List<String> getCpuMemory();
	
	public void nextStep();
	

}
