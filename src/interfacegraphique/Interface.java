package interfacegraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.*;

public class Interface extends JFrame implements ActionListener{
	
	  private JPanel container = new JPanel();
	  //Tableau stockant les éléments à afficher dans la calculatrice
	  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
	  //Un bouton par élément à afficher
	  JButton[] tab_button = new JButton[tab_string.length];
	  private JLabel ecran = new JLabel();
	  private Dimension dim = new Dimension(50, 40);
	  private Dimension dim2 = new Dimension(50, 31);
	  private double chiffre1;
	  private boolean clicOperateur = false, update = false;
	  private String operateur = "";
	  
	  public Interface(){
	    this.setSize(240, 260);
	    this.setTitle("Calculette");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    //On initialise le conteneur avec tous les composants
		initComposant();
		  //On ajoute le conteneur
	    this.setContentPane(container);
	    this.setVisible(true);
	  }
	  
	  public void initComposant(){
		  ecran = new JLabel("0");
		  ecran.setHorizontalAlignment(JLabel.RIGHT);
		  ecran.setPreferredSize(new Dimension(220,20));
		  
		  JPanel operateur = new JPanel();
		  operateur.setPreferredSize(new Dimension(55,220));
		  
		  JPanel chiffre = new JPanel();
		  chiffre.setPreferredSize(new Dimension(55,220));
		  
		  JPanel ecran1 = new JPanel();
		  ecran1.setPreferredSize(new Dimension(55,220));
		  
		  
	  }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	      
	

}
