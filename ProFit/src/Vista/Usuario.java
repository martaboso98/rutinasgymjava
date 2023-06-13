package Vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BBDD.*;
import Logica.*;
import Vista.*;

public class Usuario extends JFrame {
	
	//Llamo a los paneles
	UsuarioPanel panel1 = new UsuarioPanel();
	TuUsuarioPanel panel2 = new TuUsuarioPanel();
	MisDatosPanel panel3=new MisDatosPanel();
	RutinaPredeterminadaPanel panel4=new RutinaPredeterminadaPanel();
	RutinaPersonalizadaPanel panel5= new RutinaPersonalizadaPanel();
	MiRutinaPanel panel6= new MiRutinaPanel();
	Info panel7 = new Info();
	public JButton entrar;
	public JButton misdatos;
	public JButton rutinapredet;
    
	public Usuario() {

	    this.setSize(1280, 720);  //Asignamos el ancho y alto a la ventana JFrame
        this.setLocationRelativeTo(null);  //Centramos la ventana en pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.add(panel1);
        panel1.setBounds(0,0,1280,720);
	    panel1.entrar.addActionListener(new ActionListener() {
	    	 
	    	public void actionPerformed(ActionEvent e) {
					
					// Conexión a la base de datos y consulta SQL para agregar un usuario
					String name = panel1.nombre.getText();
					String password = panel1.contrasena.getText();
					MiUsuario miusuario=null;
					   
					try {
					    BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
					    miusuario=conexionusuario.getUser(name, password); //Para rellenar mi usuario con el usuario que devuelve getuser
					    //Para pasarle los datos recibidos a los paneles
					    panel5.usuario=miusuario;
					    panel6.usuario=miusuario;
					    panel3.usuario=miusuario;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					if (miusuario!=null) { //Si el usuario no es nulo, significa que ha encontrado coincidencia y entro en el siguiente panel
						panel1.setVisible(false);
			    		panel2.setVisible(true);
			    		panel3.setVisible(false);
			    		panel4.setVisible(false);
			    		panel5.setVisible(false);
			    		panel6.setVisible(false);
			    		panel7.setVisible(false);
					} else {
					    JOptionPane.showMessageDialog(null, "Datos incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
	    		
	    	
	    });
	    
	    this.add(panel2);
        panel2.setBounds(0,0,1280,720);
	    panel2.setVisible(false);
	    panel2.misdatos.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(false);
	    		panel3.setVisible(true);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
	    });
	    
	    this.add(panel2);
        panel2.setBounds(0,0,1280,720);
	    panel2.setVisible(false);
	    panel2.turutina.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(false);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(true);
	    		panel7.setVisible(false);
	    	}
	    });
	    
	    panel3.volver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(true);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
		});
	    
	    
	    panel2.rutinapredet.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(false);
	    		panel3.setVisible(false);
	    		panel4.setVisible(true);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
		});
	    
	    panel2.rutinapers.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(false);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(true);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
		});
	    
	    panel4.volver2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(true);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
		});
	    
	    panel5.volver2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(true);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
	    });

	    panel6.volver2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(true);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
	    });
	    
	    panel5.info.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(false);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(true);
	    	}
	    });
	    
	    panel7.volver.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel1.setVisible(false);
	    		panel2.setVisible(true);
	    		panel3.setVisible(false);
	    		panel4.setVisible(false);
	    		panel5.setVisible(false);
	    		panel6.setVisible(false);
	    		panel7.setVisible(false);
	    	}
	    });
	    
	    this.add(panel3);
        panel3.setBounds(0,0,1280,720);
	    panel3.setVisible(false);
	    
		
	    this.add(panel4);
	    panel4.setBounds(0,0,1280,720);
	    panel4.setVisible(false);
	    
	    this.add(panel5);
	    panel5.setBounds(0,0,1280,720);
	    panel5.setVisible(false);
	    
	    this.add(panel6);
	    panel6.setBounds(0,0,1280,720);
	    panel6.setVisible(false);
	    
	    this.add(panel7);
	    panel7.setBounds(0,0,1280,720);
	    panel7.setVisible(false);

	    //Título
	    setTitle("ProFit");

	    //No redimensionable
	    setResizable(false);
	    
	    //Muestro JFrame (lo último para que lo pinte todo correctamanete)
	    setVisible(true);

		
	}
		  
}