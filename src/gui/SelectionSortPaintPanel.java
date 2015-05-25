package gui;

import java.awt.Font;
import java.awt.Graphics;

import selectionsort.SelectionSortState;

public class SelectionSortPaintPanel extends PaintPanel<SelectionSortState>{
	public SelectionSortPaintPanel(int x, int y, int width, int height) {
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
		Font font = new Font(fontString, Font.PLAIN, 20);
		g.setFont(font);
		
		if(this.state.getI()<this.state.getArray().length)
		{
			g.drawString("i", this.state.getI()*width/state.getArray().length, height-10*this.state.getArray()[this.state.getI()]-10);
		}
		if(this.state.getJ()<this.state.getArray().length)
		{
			g.drawString("j", this.state.getJ()*width/state.getArray().length, height-10*this.state.getArray()[this.state.getJ()]-30);
		}
		if(this.state.getMin()<this.state.getArray().length)
		{
			g.drawString("min", this.state.getMin()*width/state.getArray().length, height-10*this.state.getArray()[this.state.getMin()]-50);
		}
	}
}
