package cpu.constants;

public class Byte32 {

	private int value;	

	public Byte32(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public int getNextValue() {
		return value++;
	}
	
	public int getPushValue() {
		return value--;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
}
