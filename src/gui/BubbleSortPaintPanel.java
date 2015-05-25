package gui;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import logic.State;
import bubblesort.BubbleSortState;

public class BubbleSortPaintPanel extends PaintPanel<BubbleSortState>
{
	public BubbleSortPaintPanel(int x, int y, int width, int height) {
		super(x,y,width,height);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<state.getArray().length;i++)
		{
			g.fillRect(i*width/state.getArray().length, height-10*state.getArray()[i], width/state.getArray().length, state.getArray()[i]*10);
		}
		String fontString = "MS Gothic";
		Font font = new Font(fontString, Font.PLAIN, 24);
		g.setFont(font);
		g.drawString("j", this.state.getJ()*width/state.getArray().length, height-10*this.state.getArray()[this.state.getJ()]-10);
		if (this.state.getJ() + 1 < this.state.getArray().length) {
			g.drawString("j+1",(this.state.getJ() + 1) * width / state.getArray().length,
					height - 10 * this.state.getArray()[this.state.getJ() + 1]- 10);
		}
	}
}
