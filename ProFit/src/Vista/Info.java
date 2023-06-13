package Vista;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info extends JPanel implements ActionListener{

	public JButton pierna;
	public JButton volver;
	
	public Info () {
		
		this.setLayout(null);
		this.setSize(1280, 720);  
		this.setPreferredSize(new Dimension(1280, 720));
		
		volver=new JButton("Volver");
		volver.setBounds(600,535,100,35);
		volver.setFont(new Font("Arial", Font.PLAIN, 17));
		volver.setBackground(Color.WHITE);
	    add(volver);
	    volver.setVisible(true);
	    volver.addActionListener(this);

        JButton sentadillas = new JButton("Sentadillas");
        sentadillas.setBounds(260,320,230,35);
        sentadillas.setFont(new Font("Arial", Font.PLAIN, 17));
        sentadillas.setBackground(Color.WHITE);
        
        sentadillas.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/bY5jTN-z-7Q"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(sentadillas);
        setVisible(true);
        
        JButton rumano = new JButton("Peso muerto rumano");
        rumano.setBounds(260,370,230,35);
        rumano.setFont(new Font("Arial", Font.PLAIN, 17));
        rumano.setBackground(Color.WHITE);
        
        rumano.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/pTh60ObXXrY"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(rumano);
        setVisible(true);
        
        JButton facepull = new JButton("Facepull");
        facepull.setBounds(260,420,230,35);
        facepull.setFont(new Font("Arial", Font.PLAIN, 17));
        facepull.setBackground(Color.WHITE);
        
        facepull.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/quU7svHBoJg"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(facepull);
        setVisible(true);
        
        JButton dominadas = new JButton("Dominadas");
        dominadas.setBounds(260,470,230,35);
        dominadas.setFont(new Font("Arial", Font.PLAIN, 17));
        dominadas.setBackground(Color.WHITE);
        
        dominadas.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=NZWPyh7IpW4"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(dominadas);
        setVisible(true);
        
        JButton hipthrust = new JButton("Hip thrust");
        hipthrust.setBounds(520,320,230,35);
        hipthrust.setFont(new Font("Arial", Font.PLAIN, 17));
        hipthrust.setBackground(Color.WHITE);
        
        hipthrust.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/byUYVdawl7g"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(hipthrust);
        setVisible(true);
        
        JButton prensa = new JButton("Prensa");
        prensa.setBounds(520,370,230,35);
        prensa.setFont(new Font("Arial", Font.PLAIN, 17));
        prensa.setBackground(Color.WHITE);
        
        prensa.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/SIOFo3AgE8k"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(prensa);
        setVisible(true);
        
        
        JButton jalon = new JButton("Jalón al pecho");
        jalon.setBounds(520,420,230,35);
        jalon.setFont(new Font("Arial", Font.PLAIN, 17));
        jalon.setBackground(Color.WHITE);
        
        jalon.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/jFb1bulUIVA"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(jalon);
        setVisible(true);
        
        JButton semisumo = new JButton("Peso muerto semisumo");
        semisumo.setBounds(520,470,230,35);
        semisumo.setFont(new Font("Arial", Font.PLAIN, 17));
        semisumo.setBackground(Color.WHITE);
        
        semisumo.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/15PNdXjmN3o"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(semisumo);
        setVisible(true);
        
        JButton militar = new JButton("Press militar");
        militar.setBounds(780,320,230,35);
        militar.setFont(new Font("Arial", Font.PLAIN, 17));
        militar.setBackground(Color.WHITE);
        
        militar.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/5l0MuKKd5W4"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(militar);
        setVisible(true);
        
        JButton exttriceps = new JButton("Extensión tríceps");
        exttriceps.setBounds(780,370,230,35);
        exttriceps.setFont(new Font("Arial", Font.PLAIN, 17));
        exttriceps.setBackground(Color.WHITE);
        
        exttriceps.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/QSifGxxpH6M"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(exttriceps);
        setVisible(true);
        
        JButton banca = new JButton("Press banca");
        banca.setBounds(780,470,230,35);
        banca.setFont(new Font("Arial", Font.PLAIN, 17));
        banca.setBackground(Color.WHITE);
        
        banca.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/XE1uDaZhyNU"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(banca);
        setVisible(true);
        
        JButton martillo = new JButton("Martillo");
        martillo.setBounds(780,420,230,35);
        martillo.setFont(new Font("Arial", Font.PLAIN, 17));
        martillo.setBackground(Color.WHITE);
        
        martillo.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
                 try {
                     // Abrir la URL en el navegador predeterminado
                     Desktop.getDesktop().browse(new URI("https://www.youtube.com/shorts/MKfF8LbnsdU"));
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        
        add(martillo);
        setVisible(true);
        

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
