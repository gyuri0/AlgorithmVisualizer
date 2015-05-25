package bubblesort;
import java.util.ArrayList;
import java.util.List;

import logic.ForInstruction;
import logic.IfInstruction;
import logic.Instruction;
import logic.SortAlgorithm;
import logic.Step;
import logic.Util;

public class BubbleSort extends SortAlgorithm<BubbleSortState> {

	private int i;
	private int j;

	private static List<Instruction> allInstructions = new ArrayList<Instruction>();
	private static List<Instruction> instructions = new ArrayList<Instruction>();
	static
	{
		Instruction swapInstruction = new Instruction("Util.swap(a, j, j+1)");
		
		IfInstruction ifInstruction = new IfInstruction("a[j]>a[j+1]");
		ifInstruction.addCoreInstruction(swapInstruction);
		
		ForInstruction innerForInstruction = new ForInstruction("j=0;j<a.length-i-1;j++");
		innerForInstruction.addCoreInstruction(ifInstruction);
		
		ForInstruction outerForInstruction = new ForInstruction("i=0;i<a.length-1;i++");
		outerForInstruction.addCoreInstruction(innerForInstruction);
		
		BubbleSort.instructions.add(outerForInstruction);
		
		BubbleSort.allInstructions.add(outerForInstruction);
		BubbleSort.allInstructions.add(innerForInstruction);
		BubbleSort.allInstructions.add(ifInstruction);
		BubbleSort.allInstructions.add(swapInstruction);
	}
	


	@Override
	public List<Step<BubbleSortState>> run() {
		List<Step<BubbleSortState>> stepList = new ArrayList<Step<BubbleSortState>>();
		
		for (i = 0; i < a.length - 1; i++)
		{
			stepList.add(this.getStep(BubbleSort.allInstructions.get(0)));
			for (j = 0; j < a.length - i - 1; j++)
			{
				stepList.add(this.getStep(BubbleSort.allInstructions.get(1)));
				stepList.add(this.getStep(BubbleSort.allInstructions.get(2)));
				if (a[j] > a[j + 1]) {
					Util.swap(a, j, j + 1);
					stepList.add(this.getStep(BubbleSort.allInstructions.get(3)));
				}
			}
		}
		return stepList;
	}

	@Override
	public BubbleSortState getState() {
		BubbleSortState bubbleSortState = new BubbleSortState();
		bubbleSortState.setArray(this.a.clone());
		bubbleSortState.setI(this.i);
		bubbleSortState.setJ(this.j);
		
		return bubbleSortState;
	}

	@Override
	public List<Instruction> getInstructions() {
		return BubbleSort.instructions;
	}
	
}
