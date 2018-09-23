package mainTest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import interfacegraphique.Bouton;
import interfacegraphique.Interface;

public class TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface inte = new Interface();

	}
}
//
//private double calcul;
//private boolean operateur;
//private boolean effacer;
//private JLabel label = new JLabel();
//
//
//private String[] tab = {"1","2","3","4","5","6","7","8","9","0","+","-","*","/","c"};
//GridLayout gl = new GridLayout(4,3);
//GridLayout gl1 = new GridLayout(5,1);
//Bouton quitter = new Bouton("quitter");
//
//
//Bouton bouton1= new Bouton("1");
//Bouton bouton2= new Bouton("2");
//Bouton bouton3= new Bouton("3");
//Bouton bouton4= new Bouton("4");
//Bouton bouton5= new Bouton("5");
//Bouton bouton6= new Bouton("6");
//Bouton bouton7= new Bouton("7");
//Bouton bouton8= new Bouton("8");
//Bouton bouton9= new Bouton("9");
//Bouton bouton0= new Bouton("0");
//Bouton boutonplus= new Bouton("+");
//Bouton boutonfois= new Bouton("*");
//Bouton boutonmoins= new Bouton("-");
//Bouton boutondivise= new Bouton("/");
//Bouton boutonsupp= new Bouton("c");
//
//
//
//JPanel contenair = new JPanel();
//JPanel pantexte = new JPanel();
//JPanel pannombre = new JPanel();
//JPanel panoperateur = new JPanel();
//
//public Interface(){
//	super();
//	Fenetre();
//	
//}
//
//public void Fenetre(){
//	//JPanel panel = new JPanel();	
//	this.setTitle("Calculatrice");
//	this.setSize(500, 500);
//	this.setLocationRelativeTo(null);
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setVisible(true);
//	pannombre.setLayout(gl);
//	gl.setHgap(10);
//	gl.setVgap(10);
//	pantexte.add(label, BorderLayout.NORTH);
//	pantexte.add(quitter);
//	
//	
//	pannombre.add(bouton1);
//	pannombre.add(bouton2);
//	pannombre.add(bouton3);
//	pannombre.add(bouton4);
//	pannombre.add(bouton5);
//	pannombre.add(bouton6);
//	pannombre.add(bouton7);
//	pannombre.add(bouton8);	
//	pannombre.add(bouton9);
//	pannombre.add(bouton0);
//	
//	
//	panoperateur.add(boutonplus);
//	panoperateur.add(boutonmoins);
//	panoperateur.add(boutonfois);
//	panoperateur.add(boutondivise);
//	panoperateur.add(boutonsupp);
//	panoperateur.setLayout(gl1);
//	gl.setHgap(10);
//	gl.setVgap(10);
//	
//	contenair.setLayout(new BorderLayout());
//	
//	contenair.add(pantexte, BorderLayout.NORTH);
//	contenair.add(pannombre, BorderLayout.CENTER);
//	contenair.add(panoperateur, BorderLayout.EAST);
//	
//	
//	//pan.add(quitter);
//	//bouton.addActionListener(this);
//	quitter.addActionListener(this);
//	this.setContentPane(contenair);
//}
//
//
//@Override
//public void actionPerformed(ActionEvent e) {
//	// TODO Auto-generated method stub
//	System.out.println("je suis ici");
//	if(e.getSource()== quitter){
//		System.out.println("je suis la ");
//	    this.setVisible(false);
//	    this.dispose();
//	}
//}