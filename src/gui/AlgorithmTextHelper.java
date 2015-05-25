package gui;

import java.util.List;

import logic.Algorithm;
import logic.ForInstruction;
import logic.IfInstruction;
import logic.Instruction;

public class AlgorithmTextHelper {
	public static String getAsText(Algorithm alg, Instruction currentInstruction)
	{
		StringBuilder sb = new StringBuilder();
		
		List<Instruction> instructions = alg.getInstructions();
		for(Instruction instruction : instructions)
		{
			sb.append(getAsText(instruction, currentInstruction, 0)).append("\n");
		}
		
		return sb.toString();
	}
	private static String getAsText(Instruction instruction, Instruction currentInstruction, int tabNumber)
	{
		StringBuilder sb = new StringBuilder();
		if(instruction instanceof IfInstruction){
			IfInstruction ifInstruction = (IfInstruction)instruction;
			for(int i=0;i<tabNumber*4;i++){
				sb.append(' ');
			}
			
			if(currentInstruction == ifInstruction)
			{
				sb.append('*');
			}
			
			sb.append("if(").append(instruction.getCode()).append("){\n");
			
			for(Instruction coreinstruction : ifInstruction.getCoreInstructions()){
				sb.append(AlgorithmTextHelper.getAsText(coreinstruction, currentInstruction, tabNumber+1)).append("\n");
			}
			
			for(int i=0;i<tabNumber*4;i++){
				sb.append(' ');
			}
			sb.append("}");
		}
		else if(instruction instanceof ForInstruction)
		{
			ForInstruction forInstruction = (ForInstruction)instruction;
			for(int i=0;i<tabNumber*4;i++){
				sb.append(' ');
			}
			
			if(currentInstruction == forInstruction)
			{
				sb.append('*');
			}
			
			sb.append("for(").append(instruction.getCode()).append("){\n");
			
			for(Instruction coreinstruction : forInstruction.getCoreInstructions()){
				sb.append(AlgorithmTextHelper.getAsText(coreinstruction, currentInstruction, tabNumber+1)).append("\n");
			}
			
			for(int i=0;i<tabNumber*4;i++){
				sb.append(' ');
			}
			sb.append("}");
		}
		else
		{
			for(int i=0;i<tabNumber*4;i++){
				sb.append(' ');
			}
			
			if(currentInstruction == instruction)
			{
				sb.append('*');
			}
			
			sb.append(instruction.getCode());
		}
		
		return sb.toString();
	}
}
