package main;

import java.util.List;

public interface ASMController {
	public void loadFile(String absoulutePath, int memory, int frequency);

	public void start();

	public void runToEnd();

	public void stop();

	public void reset(int memory);

	public List<Integer> currentRegisterStatus();

	public List<Integer> currentPointerStatus();

	public List<String> getAsm();

	public List<String> getCpuMemory();

	public void nextStep();

	public List<String> getProcessedCommands();

}
