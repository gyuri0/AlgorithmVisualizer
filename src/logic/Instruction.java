package logic;

public class Instruction {
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Instruction(String code) {
		super();
		this.code = code;
	}
	
	@Override
	public String toString() {
		return this.code;
	}
}
