package logic;

public abstract class SortAlgorithm<StateType extends State> extends Algorithm<SortAlgorithmInput, StateType> {
	protected int[] a;
	
	@Override
	public void setInput(SortAlgorithmInput input) {
		this.a = input.getArray().clone();
	}
}
