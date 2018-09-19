package interfacegraphique;

import javax.swing.*;
import java.awt.*;
import javafx.*;

public class Interface extends JFrame{
	private double calcul;
	private boolean operateur;
	public boolean effacer;
	JButton bouton = new JButton("Je sais pas encore à quoi il va servir");
	JButton quitter = new JButton("quitter");
	JPanel pan = new JPanel();
	
	public Interface(){
		Fenetre();
	}
	
	public void Fenetre(){
		this.setTitle("Calculatrice");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		pan.add(bouton);
		pan.add(quitter);
		this.setContentPane(pan);
	}
	
}
