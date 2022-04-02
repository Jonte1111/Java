package dvga11_labb1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonList {
	ArrayList<JButton> buttonList = new ArrayList<JButton>();
	CurrentPlayer p = new CurrentPlayer();
//Fyller ArrayListan med 9 knappar
public void fillButtonList() {
		for(int i = 0;i < 9;i++)
			buttonList.add(new JButton());	
	}
	//Returnerar Listan
	public ArrayList<JButton> getBL() {
		return buttonList;
	}

}
