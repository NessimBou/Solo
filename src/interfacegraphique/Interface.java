package interfacegraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.*;

public class Interface extends JFrame implements ActionListener{
	private double calcul;
	private boolean operateur;
	private boolean effacer;
	private String[] tab = {"1","2","3","4","5","6","7","8","9","0","+","-","*","/","c"};
	
	Bouton bouton = new Bouton("Je sais pas encore a quoi il va servir");
	Bouton quitter = new Bouton("quitter");
	JPanel pan = new JPanel();
	
	public Interface(){
		this.setTitle("Calculatrice");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		pan.add(bouton);
		pan.add(quitter);
		this.setContentPane(pan);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("je suis ici");
		if(e.getSource()== quitter){
			System.out.println("je suis la ");
		    this.setVisible(false);
		    this.dispose();
		}
	}
	

}
