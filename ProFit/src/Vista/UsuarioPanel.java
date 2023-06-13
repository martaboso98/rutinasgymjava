package Vista;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Logica.*;
import Vista.*;
import BBDD.*;

public class UsuarioPanel extends JPanel implements ActionListener{

	public JButton entrar;
	public JTextField nombre;
	public JTextField contrasena;
	public JLabel label1;
	public JLabel label2;
	public JButton nuevousuario;
	
	//Llamo a los paneles
	TuUsuarioPanel panel2 = new TuUsuarioPanel();
	MisDatosPanel panel3=new MisDatosPanel();

	public UsuarioPanel() {
		
		this.setLayout(null);
		this.setSize(1280, 720);  //Asignamos el ancho y alto a la ventana JFrame

	    label1=new JLabel("Usuario:"); 
	    label1.setBounds(440,320,100,30);
	    label1.setForeground(Color.white);
	    label1.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label1);

	    nombre=new JTextField();
        nombre.setBounds(430,360,400,30);
	    add(nombre);
	    
	    label2=new JLabel("Contraseña:");
	    label2.setBounds(440,400,150,50);
	    label2.setForeground(Color.white);
	    label2.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label2);
	
        contrasena=new JTextField();
        contrasena.setBounds(430,450,400,30);
	    add(contrasena);

	    nuevousuario=new JButton("Guardar usuario");
	    nuevousuario.setBounds(450,520,160,35);
	    nuevousuario.setFont(new Font("Arial", Font.PLAIN, 17));
	    nuevousuario.setBackground(Color.WHITE);
	    add(nuevousuario);
	    nuevousuario.addActionListener(this);
        
        nuevousuario.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            saveUser(); //Cuando pulso el botón accedo al método de guardar usuario 
	         }
	     });
        
	    entrar=new JButton("Acceder");
	    entrar.setBounds(650,520,160,35);
	    entrar.setFont(new Font("Arial", Font.PLAIN, 17));
	    entrar.setBackground(Color.WHITE);
	    add(entrar);
	    entrar.addActionListener(this);
	    
		}
		
		//Pintar el fondo
		@Override
	    public void paint(Graphics g){
	        Dimension dimension = this.getSize();
	        ImageIcon icon = new ImageIcon(getClass().getResource("/Multimedia/inicio.png"));
	        g.drawImage(icon.getImage(), 0, 0, 1280, 720, null);
	        setOpaque(false);
	        super.paintChildren(g);
	        
	        Dimension dimension2 = this.getSize();
	        ImageIcon icon2 = new ImageIcon(getClass().getResource("/Multimedia/nombrea.png"));
	        g.drawImage(icon2.getImage(), 410, 50, 440, 210, null);
	        setOpaque(false);
	        super.paintChildren(g);
	        
	        Dimension dimension3 = this.getSize();
	        ImageIcon icon3 = new ImageIcon(getClass().getResource("/Multimedia/login.jpg"));
	        // Establecer opacidad
	        Graphics2D g2d = (Graphics2D) g;
	        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f); // Valor de opacidad (0.0f a 1.0f)
	        g2d.setComposite(alpha);
	        super.paintChildren(g);
	        g.drawImage(icon3.getImage(), 370, 290, 520, 310, null);
	    }
	

		//Método guardar usuario
		private void saveUser() {
			
		   // Conexión a la base de datos y consulta SQL para agregar un usuario
		   String name = nombre.getText();
		   String password = contrasena.getText();
		   
		   if (password.equals("") || name.equals("")) { //Por si algún campo está vacío
				JOptionPane.showMessageDialog(null, "Hay campos vacíos, debe rellenar todos los campos.");
		   } else {
		   
			   try {
			      BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
			      if (conexionusuario.addUser(name, password)) {
			    	  JOptionPane.showMessageDialog(this, "Usuario añadido con éxito.");
			      } else {
			    	  JOptionPane.showMessageDialog(this, "Introduce un nuevo nombre de usuario.");
			      }
			   } catch (SQLException ex) {
			      JOptionPane.showMessageDialog(this, "Error");
			   }

		   }
				
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
}


