package dvga11_labb1;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JButton;

public class Model extends Observable{
	ButtonList bl = new ButtonList();
	private int p;
	private int i;
	private boolean startGame;
	private ArrayList<JButton> buttonList;
	public Model() {
		buttonList = new ArrayList<JButton>();
		startGame = false;
	}
	public void startGame() {
		firstPlayer();
		fillButtonList();
		startGame = true;
		setChanged();
		notifyObservers();
	}
	public boolean getStart() {
		return startGame;
	}
	//Slumpar ut vem som får spela först
	public void firstPlayer() {
		double r = Math.random();
		if(r <= 0.5) {
			p = 1;
		}
		else
			p = 2;
	}
	//Byter spelare efter drag
	public void changePlayer() {
		if(p == 1) {
			p = 2;
		} else
				p = 1;
	}
	//Returnerar den aktuella spelaren
	public int getP() {
		return p;
	}
	//Win Logics
	public int checkGameOver(ArrayList<JButton> bl) { //Kontrollerar alla winstates, returnerar olika beroende på vem som vinner eller om det blir oavgjort
		//Horisontellt
		if(!bl.isEmpty() && bl.get(0).getText() == "X" && bl.get(1).getText() == "X" && bl.get(2).getText() == "X")
			return 1;
		else if(!bl.isEmpty() && bl.get(3).getText() == "X" && bl.get(4).getText() == "X" && bl.get(5).getText() == "X")
			return 1;
		else if(!bl.isEmpty() && bl.get(6).getText() == "X" && bl.get(7).getText() == "X" && bl.get(8).getText() == "X")
			return 1;
		else if(!bl.isEmpty() && bl.get(0).getText() == "O" && bl.get(1).getText() == "O" && bl.get(2).getText() == "O")
			return 2;
		else if(!bl.isEmpty() && bl.get(3).getText() == "O" && bl.get(4).getText() == "O" && bl.get(5).getText() == "O")
			return 2;
		else if(!bl.isEmpty() && bl.get(6).getText() == "O" && bl.get(7).getText() == "O" && bl.get(8).getText() == "O")
			return 2;
		//Vertikalt
		else if(!bl.isEmpty() && bl.get(0).getText() == "X" && bl.get(3).getText() == "X" && bl.get(6).getText() == "X")
			return 1;
		else if(!bl.isEmpty() && bl.get(1).getText() == "X" && bl.get(4).getText() == "X" && bl.get(7).getText() == "X")
			return 1;
		else if(!bl.isEmpty() && bl.get(2).getText() == "X" && bl.get(5).getText() == "X" && bl.get(8).getText() == "X")
			return 1;

		else if(!bl.isEmpty() && bl.get(0).getText() == "O" && bl.get(3).getText() == "O" && bl.get(6).getText() == "O")
			return 2;
		else if(!bl.isEmpty() && bl.get(1).getText() == "O" && bl.get(4).getText() == "O" && bl.get(7).getText() == "O")
			return 2;
		else if(!bl.isEmpty() && bl.get(2).getText() == "O" && bl.get(5).getText() == "O" && bl.get(8).getText() == "O")
			return 2;
		//Diagonalt
		else if(!bl.isEmpty() && bl.get(0).getText() == "X" && bl.get(4).getText() == "X" && bl.get(8).getText() == "X")
			return 1;
		else if(!bl.isEmpty() && bl.get(2).getText() == "X" && bl.get(4).getText() == "X" && bl.get(6).getText() == "X")
			return 1;

		else if(!bl.isEmpty() && bl.get(0).getText() == "O" && bl.get(4).getText() == "O" && bl.get(8).getText() == "O")
			return 2;
		else if(!bl.isEmpty() && bl.get(2).getText() == "O" && bl.get(4).getText() == "O" && bl.get(6).getText() == "O")
			return 2;
		else if(!bl.isEmpty() && checkDraw(bl)) 
			return 3;
		
		else
			return 0;
	}
	//Kontrollerar om spelomgången är oavgjord genom att kolla om alla rutor är fyllda eller inte
	public boolean checkDraw(ArrayList<JButton> bl) {
		int i = 0;
		for(JButton button : bl) {
			if(button.getText() == "O" || button.getText() == "X") 
				i++;
		}
		if(i < 9) //Om i är 9 är alla rutor fyllda med antingen x eller o
			return false;
		else 
			return true;
	}
	//Returnerar vinnaren
	public String showWinner(int i) { 
		if(i == 1)
			return "Spelare 1 Vinner";
		else if(i == 2) 
			return "Spelare 2 Vinner";
		else if(i == 3) 
			return "Oavgjort";
		else {
			//Kör funktionen Update i view
			//setChanged();
			//notifyObservers();
			return "";
		}
	}
	public void setButtonPressed(int i) {
		this.i = i;
		setChanged();
		notifyObservers();
	}
	public int getButtonPressed() {
		return i;
	}
	//Skapar en lista av knappar
	public void fillButtonList() {
		for(int i = 0;i < 9;i++)
			buttonList.add(new JButton());	
	}
	//Returnerar Listan
	public ArrayList<JButton> getBL() {
		return buttonList;
	}

}
