package logic;
import java.util.ArrayList;
import java.util.List;


public class ForInstruction extends Instruction {

	private List<Instruction> coreInstructions; 
	
	public ForInstruction(String code) {
		super(code);
		coreInstructions = new ArrayList<Instruction>();
	}

	public List<Instruction> getCoreInstructions() {
		return coreInstructions;
	}

	public void setCoreInstructions(List<Instruction> coreInstructions) {
		this.coreInstructions = coreInstructions;
	}

	public void addCoreInstruction(Instruction instruction)
	{
		this.coreInstructions.add(instruction);
	}
}
