package logic;

public class Step<StateType extends State> {
	private Instruction instruction;
	private StateType state;
	
	public Instruction getInstruction() {
		return instruction;
	}
	
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	public StateType getState() {
		return state;
	}
	
	public void setState(StateType state) {
		this.state = state;
	}
	
	public Step(Instruction instruction, StateType state) {
		super();
		this.instruction = instruction;
		this.state = state;
	}
}
