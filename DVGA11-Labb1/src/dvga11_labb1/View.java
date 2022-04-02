package dvga11_labb1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JFrame implements Observer{
	private ArrayList<JButton> buttonList;
	private JPanel spelPlan, loggaPanel, spelarPanel, startScreen;
	private JLabel turnPanel;
	private BorderLayout b;
	private Model model;
	private JOptionPane op;
	private Controller controller;
	private JOptionPane start;
	private JButton startKnapp;
	public View(Controller controller) {
		setVisible(true);
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(b = new BorderLayout());
		model = new Model();
		op = new JOptionPane();
		turnPanel= new JLabel();
		loggaPanel = new JPanel();
		spelarPanel = new JPanel();
		spelPlan = new JPanel();
		startKnapp = new JButton();
		spelPlan.setLayout(new GridLayout(3,3));
		startScreen = new JPanel();
		startKnapp.setText("Start");
		startKnapp.addActionListener(controller);
		startKnapp.setActionCommand("start");
		spelarPanel.add(turnPanel);
		startScreen.add(startKnapp);
		add(spelPlan, b.CENTER);
		add(startScreen, b.CENTER);
		add(loggaPanel, b.SOUTH);
		add(spelarPanel, b.NORTH);
		
		//Sätta denna i update kanske?
		turnPanel.setText("Aktuell spelare är: " + model.getP());
		this.controller = controller;
		buttonList = new ArrayList<JButton>();
		//addButtons();
	}
	
	//Lägger till Knapparna i GUI:t + lägger på en actionListener på dem
	private void addButtons() {
		for(JButton button : buttonList) {
			Integer index = buttonList.indexOf(button);
			String stringIndex = index.toString();
			spelPlan.add(button);
			button.addActionListener(controller);//Sätta actionListeners till 'controller' istället för 'this'
			button.setActionCommand(stringIndex);
			button.setFont(new Font("MV Boli", Font.BOLD, 75));
			button.setBackground(Color.white);
			button.setText("");
		}
	}
	//Tar bort ActionListeners på knapparna, körs när spelet är avslutat
	private void removeAction() {
		for(JButton button : buttonList) {
			button.removeActionListener(controller);
		}
	}
	//Ett pop-up fönster visas med vinnaren 
	private void popUp(String s) {
		if(s != "")
			op.showMessageDialog(spelPlan, s);
		
	}
/*	public void fillButtonList() {
		for(int i = 0;i < 9;i++)
			buttonList.add(new JButton());	
	}
	//Returnerar Listan
	public ArrayList<JButton> getBL() {
		return buttonList;
	}*/
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Model model = (Model)o;
		//Fuckar allt, måste start spelet och visa upp knapparna innan detta kan köras
		/*if(buttonList.get(model.getButtonPressed()).getText() == "" && model.getP() == 1 && model.getStart() == true) {
			buttonList.get(model.getButtonPressed()).setText("X");
		}
		else if(buttonList.get(model.getButtonPressed()).getText() == "" && model.getP() == 2 && model.getStart() == true) {
			buttonList.get(model.getButtonPressed()).setText("O");
		}
		if(model.checkGameOver(buttonList) != 0) {
			popUp(model.showWinner(model.checkGameOver(buttonList)));
			removeAction();
		}*/
		if(model.getStart() == true) {
			startScreen.setVisible(false);
			addButtons();
			buttonList = model.getBL();
			add(spelPlan, b.CENTER);
		}
		System.out.println(model.getButtonPressed());
	}
}
