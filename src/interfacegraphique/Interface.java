package interfacegraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.*;

public class Interface extends JFrame implements ActionListener{
	
	  private JPanel container = new JPanel();
	  //Tableau stockant les �l�ments � afficher dans la calculatrice
	  String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
	  //Un bouton par �l�ment � afficher
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
		  
		  for (int i = 0;i < tab_string.length; i++) {
			  tab_button[i] = new JButton(tab_string[i]);
			  tab_button[i].setPreferredSize(dim);
			  switch(i) {
			  	case 11:
			  		tab_button[i].addActionListener(new EgalListener());
			  		chiffre.add(tab_button[i]);
			  		break;
			  	case 12:
			  		tab_button[i].addActionListener(new SuppListener());
			  		operateur.add(tab_button[i]);
			  		operateur.setPreferredSize(dim2);
			  		break;
			  	case 13:
			  		tab_button[i].addActionListener(new PlusListener());
			  		operateur.add(tab_button[i]);
			  		operateur.setPreferredSize(dim2);
			  		break;
			  	case 14:
			  		tab_button[i].addActionListener(new MoinsListener());
			  		operateur.add(tab_button[i]);
			  		operateur.setPreferredSize(dim2);
			  		break;
			  	case 15:
			  		tab_button[i].addActionListener(new FoisListener());
			  		operateur.add(tab_button[i]);
			  		operateur.setPreferredSize(dim2);
			  		break;
			  	case 16:
			  		tab_button[i].addActionListener(new DivListener());
			  		operateur.add(tab_button[i]);
			  		operateur.setPreferredSize(dim2);
			  		break;
			  	
			  }
		  }
	  }

	  public void calcul() {
		  
	  }
	  
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public class EgalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class SuppListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class PlusListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class MoinsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class FoisListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class DivListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}


	


