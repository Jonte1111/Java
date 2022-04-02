package dvga11_labb1;

import java.awt.Color;
import java.awt.Graphics2D;

public class Draw {
	public void draw(Graphics2D g, String s) {
		g.setColor(Color.red);
		g.drawString(s, 0, 0);
	}
}
