package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BBDD.ConexionUsuario;

public class RutinaPredeterminadaPanel extends JPanel implements ActionListener{

	//Llamo a los paneles
	TuUsuarioPanel panel2 = new TuUsuarioPanel();
	MisDatosPanel panel3=new MisDatosPanel();
	ConexionUsuario conexion=new ConexionUsuario();
	 
	public JLabel label1;
	public JLabel labeldia1;
	public JLabel labeldia2;
	public JLabel labeldia3;
	public JLabel labeldia4;
	public JLabel labeldia5;
	public JButton tres;
	public JButton cuatro;
	public JButton cinco;
	public JButton volver;
	public JButton volver2;
	public JLabel ejercicio1;
	public JLabel ejercicio2;
	public JLabel ejercicio3;
	public JLabel ejercicio4;
	public JLabel ejercicio5;


	public RutinaPredeterminadaPanel() {
		
		this.setLayout(null);
		this.setSize(1280, 720); 
		this.setPreferredSize(new Dimension(1280, 720));

	    volver2=new JButton("Volver");
	    volver2.setBounds(580,555,100,35);
	    volver2.setFont(new Font("Arial", Font.PLAIN, 17));
	    volver2.setBackground(Color.WHITE);
	    add(volver2);
	    volver2.setVisible(true);
	    volver2.addActionListener(this);
	    
	    label1=new JLabel("Indica el número de días:");
	    label1.setBounds(520,300,300,30);
	    label1.setForeground(Color.white);
	    label1.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(label1);
        
	    labeldia1=new JLabel("DÍA 1:");
	    labeldia1.setForeground(new Color(255, 194, 0, 255));
	    labeldia1.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(labeldia1);
	    labeldia1.setVisible(false);
	    
	    //Para el salto de línea en un jlabel necesito ponerlo con código html
	    ejercicio1 = new JLabel("<html>1. Sentadillas<br>2. Peso muerto semisumo<br>3. Extensión de cuádriceps<br>4. Búlgaras<br>5. Crunch diagonal<br>6. Plancha<br>7. Plancha lateral<br>8. Bicicleta</html>");
	    ejercicio1.setForeground(Color.white);
	    ejercicio1.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(ejercicio1);
	    ejercicio1.setVisible(false);

	    labeldia2=new JLabel("DÍA 2:");
	    labeldia2.setForeground(new Color(255, 194, 0, 255));
	    labeldia2.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(labeldia2);
	    labeldia2.setVisible(false);
	    
	    ejercicio2 = new JLabel("<html>1. Press Banca<br>2. Flexiones<br>3. Fondo<br>4. Curl bíceps Barra Z<br>5. Martillo<br>6. Elevación talón<br>7. Elevaciones frontales</html>");
	    ejercicio2.setForeground(Color.white);
	    ejercicio2.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(ejercicio2);
	    ejercicio2.setVisible(false);
	    
	    labeldia3=new JLabel("DÍA 3:");
	    labeldia3.setForeground(new Color(255, 194, 0, 255));
	    labeldia3.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(labeldia3);
	    labeldia3.setVisible(false);
	    
	    ejercicio3 = new JLabel("<html>1. Dominadas<br>2. Jalón al pecho<br>3. Remo mancuerna<br>4. Remo máquina<br>5. Empuje tríceps<br>6. Fondo<br>7. Press francés</html>");
	    ejercicio3.setForeground(Color.white);
	    ejercicio3.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(ejercicio3);
	    ejercicio3.setVisible(false);
	    
	    labeldia4=new JLabel("DÍA 4:");
	    labeldia4.setBounds(110,280,300,30);
	    labeldia4.setForeground(new Color(255, 194, 0, 255));
	    labeldia4.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(labeldia4);
	    labeldia4.setVisible(false);
	    
	    ejercicio4 = new JLabel("<html>1. Press militar<br>2. Elevaciones laterales<br>3. Landmine Press<br>4. Escalador de montaña<br>5. Crunch<br>6. Plancha<br>7. Spiderman</html>");
	    ejercicio4.setForeground(Color.white);
	    ejercicio4.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(ejercicio4);
	    ejercicio4.setVisible(false);
	    
	    labeldia5=new JLabel("DÍA 5:");
	    labeldia5.setForeground(new Color(255, 194, 0, 255));
	    labeldia5.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(labeldia5);
	    labeldia5.setVisible(false);
	    
	    ejercicio5 = new JLabel("<html>1. Prensa<br>2. Hip thurst<br>3. Abducción<br>4. Aducción<br>5. Hiperextensión<br>6. Zancada</html>");
	    ejercicio5.setForeground(Color.white);
	    ejercicio5.setFont(new Font("Arial", Font.PLAIN, 20));
	    add(ejercicio5);
	    ejercicio5.setVisible(false);
	    
	    //Botón rutina de 3 días
	    tres=new JButton("3 DÍAS");
	    tres.setBounds(400,400,100,35);
	    tres.setFont(new Font("Arial", Font.PLAIN, 17));
	    tres.setBackground(Color.WHITE);
	    add(tres);
	    tres.addActionListener(this);
	    
	    tres.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==tres) {
	        		 	        		 
	        		labeldia1.setVisible(true);
	        		ejercicio1.setVisible(true);
	        		labeldia2.setVisible(true);
	        		ejercicio2.setVisible(true);
	        		labeldia3.setVisible(true);
	        		ejercicio3.setVisible(true);
	        		 
	        	    labeldia1.setBounds(270,280,300,30);
	        	    ejercicio1.setBounds(260,320,300,200);
	        	    labeldia2.setBounds(560,280,300,30);
	        	    ejercicio2.setBounds(550,310,300,200);
	        	    labeldia3.setBounds(850,280,300,30);
	        	    ejercicio3.setBounds(840,310,300,200);

	        		volver=new JButton("Volver");
	        		volver.setBounds(580,555,100,35);
	        		volver.setFont(new Font("Arial", Font.PLAIN, 17));
	        		volver.setBackground(Color.WHITE);
	        	    add(volver);
	        	    volver.setVisible(true);
	        	    volver.addActionListener(this);
	        	    volver.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
			        		tres.setVisible(true);
			        		cuatro.setVisible(true);
			        		cinco.setVisible(true);
			        		volver2.setVisible(true);
			        		volver.setVisible(false);
			        		label1.setVisible(true);
		        			labeldia1.setVisible(false);
			        		ejercicio1.setVisible(false);
			        		labeldia2.setVisible(false);
			        		ejercicio2.setVisible(false);
			        		labeldia3.setVisible(false);
			        		ejercicio3.setVisible(false);
						}
	        	    	
	        	    });
	        	    
	        	    tres.setVisible(false);
	        	    cuatro.setVisible(false);
	        	    cinco.setVisible(false);
        		    volver2.setVisible(false);
	        		label1.setVisible(false);
	        		labeldia1.setVisible(true);
        		    
	        	 }
	         }
	     });
	    
	    
	    
	    //Botón rutina de 4 días
	    cuatro=new JButton("4 DÍAS");
	    cuatro.setBounds(580,400,100,35);
	    cuatro.setFont(new Font("Arial", Font.PLAIN, 17));
	    cuatro.setBackground(Color.WHITE);
	    add(cuatro);
	    cuatro.addActionListener(this);
        
	    cuatro.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==cuatro) {
	        		 
	        		labeldia1.setVisible(true);
	        		ejercicio1.setVisible(true);
	        		labeldia2.setVisible(true);
	        		ejercicio2.setVisible(true);
	        		labeldia3.setVisible(true);
	        		ejercicio3.setVisible(true);
	        		labeldia4.setVisible(true);
	        		ejercicio4.setVisible(true);
	        		
	        		labeldia1.setBounds(120,280,300,30);
	        	    ejercicio1.setBounds(110,320,300,200);
	        	    labeldia2.setBounds(410,280,300,30);
	        	    ejercicio2.setBounds(400,310,300,200);
	        	    labeldia3.setBounds(690,280,300,30);
	        	    ejercicio3.setBounds(680,310,300,200);
	        	    labeldia4.setBounds(930,280,300,30);
	        	    ejercicio4.setBounds(920,310,300,200);

	        		volver=new JButton("Volver");
	        		volver.setBounds(580,555,100,35);
	        		volver.setFont(new Font("Arial", Font.PLAIN, 17));
	        		volver.setBackground(Color.WHITE);
	        	    add(volver);
	        	    volver.setVisible(true);
	        	    volver.addActionListener(this);
	        	    volver.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
			        		tres.setVisible(true);
			        		cuatro.setVisible(true);
			        		cinco.setVisible(true);
			        		volver2.setVisible(true);
			        		volver.setVisible(false);
			        		label1.setVisible(true);
			        		labeldia1.setVisible(false);
			        		ejercicio1.setVisible(false);
			        		labeldia2.setVisible(false);
			        		ejercicio2.setVisible(false);
			        		labeldia3.setVisible(false);
			        		ejercicio3.setVisible(false);
			        		labeldia4.setVisible(false);
			        		ejercicio4.setVisible(false);
						}
	        	    	
	        	    });
	        	    
	        	    tres.setVisible(false);
	        	    cuatro.setVisible(false);
	        	    cinco.setVisible(false);
        		    volver2.setVisible(false);
	        		label1.setVisible(false);
	        		labeldia1.setVisible(true); 
	        		
	        	 }
	         }
	     });
        
	    //Botón rutina de 5 días
	    cinco=new JButton("5 DÍAS");
	    cinco.setBounds(760,400,100,35);
	    cinco.setFont(new Font("Arial", Font.PLAIN, 17));
	    cinco.setBackground(Color.WHITE);
	    add(cinco);
	    cinco.addActionListener(this);
        
	    cinco.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==cinco) {
	        		 
	        		labeldia1.setVisible(true);
	        		ejercicio1.setVisible(true);
	        		labeldia2.setVisible(true);
	        		ejercicio2.setVisible(true);
	        		labeldia3.setVisible(true);
	        		ejercicio3.setVisible(true);
	        		labeldia4.setVisible(true);
	        		ejercicio4.setVisible(true);
	        		labeldia5.setVisible(true);
	        		ejercicio5.setVisible(true);
	        		
	        		labeldia1.setBounds(80,280,300,30);
	        	    ejercicio1.setBounds(70,320,300,200);
	        	    labeldia2.setBounds(350,280,300,30);
	        	    ejercicio2.setBounds(340,310,300,200);
	        	    labeldia3.setBounds(590,280,300,30);
	        	    ejercicio3.setBounds(580,310,300,200);
	        	    labeldia4.setBounds(790,280,300,30);
	        	    ejercicio4.setBounds(780,310,300,200);
	        	    labeldia5.setBounds(1040,280,300,30);
	        	    ejercicio5.setBounds(1030,300,300,200);
		        		 
	        		volver=new JButton("Volver");
	        		volver.setBounds(580,555,100,35);
	        		volver.setFont(new Font("Arial", Font.PLAIN, 17));
	        		volver.setBackground(Color.WHITE);
	        	    add(volver);
	        	    volver.setVisible(true);
	        	    volver.addActionListener(this);
	        	    volver.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
			        		tres.setVisible(true);
			        		cuatro.setVisible(true);
			        		cinco.setVisible(true);
			        		volver2.setVisible(true);
			        		volver.setVisible(false);
			        		label1.setVisible(true);
			        		labeldia1.setVisible(false);
			        		ejercicio1.setVisible(false);
			        		labeldia2.setVisible(false);
			        		ejercicio2.setVisible(false);
			        		labeldia3.setVisible(false);
			        		ejercicio3.setVisible(false);
			        		labeldia4.setVisible(false);
			        		ejercicio4.setVisible(false);
			        		labeldia5.setVisible(false);
			        		ejercicio5.setVisible(false);
						}
	        	    	
	        	    });
	        	    
	        	    tres.setVisible(false);
	        	    cuatro.setVisible(false);
	        	    cinco.setVisible(false);
        		    volver2.setVisible(false);
	        		label1.setVisible(false);
	        		labeldia1.setVisible(true);
        		    
	        		 
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
        g.drawImage(icon2.getImage(), 410, 50, 440, 210, null);
        setOpaque(false);
        super.paintChildren(g);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

