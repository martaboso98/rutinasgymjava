package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import BBDD.MiUsuario;
import Vista.*;
import Logica.*;

public class TuUsuarioPanel extends JPanel implements ActionListener{

	public JButton turutina;
	public JButton nuevarutina;
	public JButton misdatos;
	public JButton rutinapredet;
	public JButton rutinapers;
	public JButton salir;
	
	public TuUsuarioPanel() {
		
		this.setLayout(null);
		this.setSize(1280, 720);  //Asignamos el ancho y alto a la ventana JFrame
		
		turutina=new JButton("TU RUTINA");
		turutina.setBounds(480,270,280,30);
		turutina.setFont(new Font("Arial", Font.PLAIN, 17));
		turutina.setBackground(Color.WHITE); 
	    add(turutina);
	    turutina.addActionListener(this);
        
	    misdatos=new JButton("MIS DATOS");
	    misdatos.setBounds(480,330,280,30);
	    misdatos.setFont(new Font("Arial", Font.PLAIN, 17));
	    misdatos.setBackground(Color.WHITE);
	    add(misdatos);
	    misdatos.addActionListener(this);
	    
	    nuevarutina=new JButton("NUEVA RUTINA");
	    nuevarutina.setBounds(480,390,280,30);
	    nuevarutina.setFont(new Font("Arial", Font.PLAIN, 17));
	    nuevarutina.setBackground(Color.WHITE);
	    add(nuevarutina);
	    nuevarutina.addActionListener(this);
        
	    nuevarutina.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
        	        if(e.getSource()==nuevarutina) {
        	            rutinapredet.setVisible(true);
        	            rutinapers.setVisible(true);
        	            nuevarutina.setVisible(false);
        	        }
	         }
	     });
        
	    rutinapredet=new JButton("RUTINAS PREDETERMINADAS");
	    rutinapredet.setBounds(480,450,280,30);
	    rutinapredet.setFont(new Font("Arial", Font.PLAIN, 17));
	    rutinapredet.setBackground(Color.WHITE);
	    add(rutinapredet);
	    rutinapredet.addActionListener(this);
	    rutinapredet.setVisible(false); 
        
	    //Botón rutinas personalizadas
	    rutinapers=new JButton("RUTINAS PERSONALIZADAS");
	    rutinapers.setBounds(480,510,280,30);
	    rutinapers.setFont(new Font("Arial", Font.PLAIN, 17));
	    rutinapers.setBackground(Color.WHITE);
	    add(rutinapers);
	    rutinapers.addActionListener(this);
	    rutinapers.setVisible(false);

	    salir=new JButton("Salir");
	    salir.setBounds(480,570,280,30);
	    salir.setFont(new Font("Arial", Font.PLAIN, 17));
	    salir.setBackground(Color.WHITE);
	    add(salir);
	    salir.addActionListener(this);
	    
	    salir.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) { //Cuando hace click en el botón, sale del programa
	        	 if (e.getSource() == salir) {
	        		    System.exit(0);
	        		    }
	         }
	     });
	
	}
	
	@Override
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Multimedia/inicio.png"));
        g.drawImage(icon.getImage(), 0, 0, 1280, 720, null);
        setOpaque(false);
        super.paintChildren(g);
        
        Dimension dimension2 = this.getSize();
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Multimedia/nombrea.png"));
        g.drawImage(icon2.getImage(), 430, 50, 400, 190, null);
        setOpaque(false);
        super.paintChildren(g);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
