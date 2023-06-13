package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Vista.*;
import BBDD.*;

public class MisDatosPanel extends JPanel implements ActionListener{
	
	public JLabel label2;
	public JTextField nombre;
	public JLabel label3;
	public JTextField apellido;
	public JLabel label4;
	public JTextField email;
	public JLabel label5;
	public JTextField edad;
	public JLabel label6;
	public JTextField contrasena;
	public JLabel label7;
	public JLabel label8;
	public JTextField altura;	
	public JLabel label9;
	public JTextField peso;
	public JButton calcularIMC;
	public JButton volver;
	public JButton guardar;
	public MiUsuario usuario; //Para traer los datos del getUser de la clase Usuario: ya tengo id, nombre, contraseña
	
	public MisDatosPanel() {
		 
		this.setLayout(null);
		this.setSize(1280, 720);  //Asignamos el ancho y alto a la ventana JFrame
		float IMC = 0;
		
	    label2=new JLabel("Nombre:");
	    label2.setBounds(160,250,80,50);
	    label2.setForeground(Color.white);
	    label2.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label2);
	
        nombre=new JTextField();
        nombre.setBounds(160,300,200,30);
        nombre.addKeyListener(new KeyAdapter() { //Limitar que el usuario solo pueda introducir letras
            @Override
            public void keyTyped(KeyEvent evt) {
                char key = evt.getKeyChar();

                boolean mayusculas = key >= 'A' && key <= 'Z'; // Rango de letras mayúsculas en ASCII
                boolean minusculas = key >= 'a' && key <= 'z'; 
                boolean espacio = key == ' ';

                if (!(mayusculas || minusculas || espacio)) {
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras", "Error", JOptionPane.ERROR_MESSAGE);
                    evt.consume();
                }
            }
        });
	    add(nombre);
	    
	    label3=new JLabel("Apellido:");
	    label3.setBounds(450,250,150,50);
	    label3.setForeground(Color.white);
	    label3.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label3);
	
        apellido=new JTextField();
        apellido.setBounds(450,300,250,30);
        apellido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char key = evt.getKeyChar();

                boolean mayusculas = key >= 'A' && key <= 'Z'; // Rango de letras mayúsculas en ASCII
                boolean minusculas = key >= 'a' && key <= 'z'; 
                boolean espacio = key == ' ';

                if (!(mayusculas || minusculas || espacio)) {
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras", "Error", JOptionPane.ERROR_MESSAGE);
                    evt.consume();
                }
            }
        });
	    add(apellido);
	    
	    label4=new JLabel("Email:");
	    label4.setBounds(750,250,150,50);
	    label4.setForeground(Color.white);
	    label4.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label4);
	
        email=new JTextField();
        email.setBounds(750,300,350,30);
	    add(email);
	    
	    label5=new JLabel("Edad:");
	    label5.setBounds(160,350,159,50);
	    label5.setForeground(Color.white);
	    label5.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label5);
	
        edad=new JTextField();
        edad.setBounds(160,400,70,30);
        edad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
            	 int key = evt.getKeyChar();
            	 boolean numeros = key >= 48 && key <= 57;
            	 
            	 if (!numeros) {
                     JOptionPane.showMessageDialog(null, "Solo se permiten números", "Error", JOptionPane.ERROR_MESSAGE);
            		 evt.consume();
            	 }
            }
        });
	    add(edad);
	    
	    label6=new JLabel("Nueva contraseña:");
	    label6.setBounds(300,350,200,50);
	    label6.setForeground(Color.white);
	    label6.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label6);
	
        contrasena=new JTextField();
        contrasena.setBounds(300,400,220,30);
	    add(contrasena);
	    
	    label8=new JLabel("Altura (cm):");
	    label8.setBounds(600,350,150,50);
	    label8.setForeground(Color.white);
	    label8.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label8);
	    
        altura=new JTextField();
        altura.setBounds(600,400,70,30);
        altura.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
            	 int key = evt.getKeyChar();
            	 boolean numeros = key >= 48 && key <= 57;
            	 
            	 if (!numeros) {
                     JOptionPane.showMessageDialog(null, "Solo se permiten números", "Error", JOptionPane.ERROR_MESSAGE);
            		 evt.consume();
            	 }
            }
        });
	    add(altura);
	    
	    label9=new JLabel("Peso (kg):");
	    label9.setBounds(750,350,150,50);
	    label9.setForeground(Color.white);
	    label9.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label9);
	    
        peso=new JTextField();
        peso.setBounds(750,400,70,30);
        peso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
            	 int key = evt.getKeyChar();
            	 boolean numeros = key >= 48 && key <= 57;
            	 
            	 if (!numeros) {
                     JOptionPane.showMessageDialog(null, "Solo se permiten números", "Error", JOptionPane.ERROR_MESSAGE);
            		 evt.consume();
            	 }
            }
        });	    
        add(peso);
	    
	    calcularIMC=new JButton("Calcular IMC");
	    calcularIMC.setBounds(900,380,200,30);
	    calcularIMC.setFont(new Font("Arial", Font.PLAIN, 17));
	    calcularIMC.setBackground(Color.WHITE);
	    add(calcularIMC);
	    calcularIMC.addActionListener(this);
        
	    calcularIMC.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 label7.setText("IMC: " + String.format("%.2f", calcularIMC()));
	         }
	    });
	    
	    
	    /* Etiqueta de usuario */
	    label7=new JLabel("IMC:" +IMC);
	    label7.setBounds(930,420,150,50);
	    label7.setForeground(Color.white);
	    label7.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label7);
	    
	    //Botón guardar datos
	    guardar=new JButton("Guardar");
	    guardar.setBounds(440,500,160,30);
	    guardar.setFont(new Font("Arial", Font.PLAIN, 17));
	    guardar.setBackground(Color.WHITE);
	    add(guardar);
	    guardar.addActionListener(this);
	    
	    guardar.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
	            addData();
		    }
		});
	    
	    
	    //Botón salir
	    volver=new JButton("Volver");
	    volver.setBounds(660,500,160,30);
	    volver.setFont(new Font("Arial", Font.PLAIN, 17));
	    volver.setBackground(Color.WHITE);
	    add(volver);
	    volver.addActionListener(this);
	    
	    
	}
	    
	private void addData() {
		// Conexión a la base de datos y consulta SQL para agregar un usuario
		String name = nombre.getText();
		String password = contrasena.getText();
		String surname= apellido.getText();
		String correo= email.getText();
		float weight=Float.parseFloat(peso.getText());
		int height=Integer.parseInt(altura.getText());
		int age=Integer.parseInt(edad.getText());
		   
		try {
		    BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
		    conexionusuario.addData(usuario.getId_usuario(),name, password,surname,correo,weight,height,age); //Para rellenar mi usuario con el usuario que devuelve getuser
		    JOptionPane.showMessageDialog(this, "Guardado.");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
		    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
		}
		
	}	
	
	//Método para calcular el IMC y llamarlo arriba en el botón
	public double calcularIMC() {
		
		float weight=Float.parseFloat(peso.getText());
		float height=Float.parseFloat(altura.getText());
		height=height/100;

		float IMC=weight/(height*height);
		
		return IMC;
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
        
        Dimension dimension3 = this.getSize();
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/Multimedia/corazon.png"));
        g.drawImage(icon3.getImage(), 1040, 430, 30, 30, null);
        setOpaque(false);
        super.paintChildren(g);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
