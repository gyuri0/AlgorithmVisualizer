package gui;

import javax.swing.JPanel;

import logic.State;

public class PaintPanel<StateType> extends JPanel {
	protected StateType state;
	protected int width;
	protected int height;
	
	public PaintPanel(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
		this.width = width;
		this.height = height;
	}

	public StateType getState() {
		return state;
	}

	public void setState(State state) {
		this.state = (StateType)state;
	}
}
