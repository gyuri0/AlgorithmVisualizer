package logic;
import java.util.List;

public abstract class Algorithm<InputType extends Input, StateType extends State> {
	
	public abstract List<Instruction> getInstructions();
	
	public abstract void setInput(InputType input);
	
	public abstract List<Step<StateType>> run();
	
	public abstract StateType getState();
	
	public Step<StateType> getStep(Instruction instruction)
	{
		return new Step<StateType>(instruction, this.getState());
	}
}
