package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vista.*;
import BBDD.*;

public class MiRutinaPanel extends JPanel implements ActionListener{
	
	public JButton boton1;
	public JButton boton2;
	public JButton boton3;
	public JButton boton4;
	public JButton boton5;
	public JButton volver;
	public JButton volver2;
	public JLabel saludo;
	public JLabel emogi;
	public JLabel dia;
	public MiUsuario usuario; //Para traer los datos del getUser de la clase Usuario: ya tengo id, nombre, contraseña
	
	public MiRutinaPanel () {
		
		this.setLayout(null);
		this.setSize(1280, 720); 
		this.setPreferredSize(new Dimension(1280, 720));
				
		saludo=new JLabel("¡Hola! Esta es tu rutina: ");
		saludo.setBounds(450,270,350,50);
	    saludo.setForeground(Color.white);
	    saludo.setFont(new Font("Arial", Font.PLAIN, 30));
	    add(saludo);
	    
	    //Emoticono brazo fuerte
	    emogi=new JLabel("\uD83D\uDCAA");
	    emogi.setBounds(770,270,350,50); 
	    emogi.setForeground(new Color(255, 194, 0, 255));
	    emogi.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
	    add(emogi);
		
		volver2=new JButton("Volver");
	    volver2.setBounds(580,535,100,35);
	    volver2.setFont(new Font("Arial", Font.PLAIN, 17));
	    volver2.setBackground(Color.WHITE);
	    add(volver2);
	    volver2.setVisible(true);
	    volver2.addActionListener(this);
	    	    
		boton1=new JButton("DÍA 1");
		boton1.setBounds(180,400,100,35);
		boton1.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton1.setBackground(Color.WHITE);
	    add(boton1);
	    boton1.addActionListener(this);
        
	    boton1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton1) {
	        		 
	        		ArrayList<String> miRutina=new ArrayList();
	        		
	        		volver=new JButton("Volver");
		       	    volver.setBounds(580,565,100,35);
		       	    volver.setFont(new Font("Arial", Font.PLAIN, 17));
		       	    volver.setBackground(Color.WHITE);
		       	    add(volver);
		       	    volver.setVisible(true);
		       	    volver.addActionListener(this);
		
		        	volver.addActionListener(new ActionListener() {
		        			
						@Override
						public void actionPerformed(ActionEvent e) {
			        		 boton1.setVisible(true);
			        		 boton2.setVisible(true);
			        		 boton3.setVisible(true);
			        		 boton4.setVisible(true);
			        		 boton5.setVisible(true);
			        		 volver2.setVisible(true);
			        		 volver.setVisible(false);
						}
		   	    	
		       	    });
 
		        	//Llamo a la base de datos e introduzco los datos de cada tabla, día y usuario en el ArrayList
	        		try {
			      		BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
						miRutina= conexionusuario.showRutina(1, usuario.getId_usuario(), "piernas");
						miRutina.addAll(conexionusuario.showRutina(1, usuario.getId_usuario(), "abdominales"));
	        		} catch (SQLException e1) {
	        			e1.printStackTrace();
	        		}
 
	        		int bounds []= {340,230,400,300}; //Para especificar dimensiones
	        	    int contadorFilas=0;
	        	    
	        	    //Bucle para ir introduciendo en el label los datos del ArrayList
	        		for (String ejercicio : miRutina) {
	        			
						JLabel dia1 = new JLabel("- " + ejercicio);
					    dia1.setForeground(Color.white);
					    dia1.setFont(new Font("Arial", Font.PLAIN, 20));
						
						if (contadorFilas==5) { //Para saber cuándo se ha llenado una columna
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 360; //Distancia a la siguiente columna
		                	bounds[1]= 260; //Colocar el dato en la primera posición
		                } else {
		                	bounds[1]= bounds[1] + 30; //Distancia a la siguiente fila
		                }
		                
						dia1.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(dia1);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								dia1.setVisible(false);
							}
		        	    });	
		                
		                contadorFilas++;

					}
	        		
	        		boton1.setVisible(false);
		 		    boton2.setVisible(false);
		 		    boton3.setVisible(false);
		 		    boton4.setVisible(false);
		 		    boton5.setVisible(false);
		 		    volver2.setVisible(false);
	        	}

	        }
	         
	     });
	    
        
	    boton2=new JButton("DÍA 2");
	    boton2.setBounds(380,400,100,35);
	    boton2.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton2.setBackground(Color.WHITE);
	    add(boton2);
	    boton2.addActionListener(this);
        
	    boton2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	if (e.getSource()==boton2) {
	        		 
        		ArrayList<String> miRutina=new ArrayList();
	        		
        		volver=new JButton("Volver");
       	    	volver.setBounds(580,565,100,35);
       	    	volver.setFont(new Font("Arial", Font.PLAIN, 17));
	       	    volver.setBackground(Color.WHITE);
	       	    add(volver);
	       	    volver.setVisible(true);
	       	    volver.addActionListener(this);
	       	    
	       	    volver.addActionListener(new ActionListener() {
		        			
					@Override
					public void actionPerformed(ActionEvent e) {
		        		 boton1.setVisible(true);
		        		 boton2.setVisible(true);
		        		 boton3.setVisible(true);
		        		 boton4.setVisible(true);
		        		 boton5.setVisible(true);
		        		 volver2.setVisible(true);
		        		 volver.setVisible(false);
					}
	   	    	
	       	    });
 
	        	try {
			      	BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
					miRutina= conexionusuario.showRutina(2, usuario.getId_usuario(), "espalda");
					miRutina.addAll(conexionusuario.showRutina(2, usuario.getId_usuario(), "triceps"));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
    		 
	    		int bounds []= {340,230,400,300}; //Para especificar dimensiones
	    	    int contadorFilas=0;
	    	    
	    		for (String ejercicio : miRutina) {
	    			
					JLabel dia2 = new JLabel("- " + ejercicio);
					dia2.setForeground(Color.white);
					dia2.setFont(new Font("Arial", Font.PLAIN, 20));
					
					if (contadorFilas==5) { //Para saber cuándo se ha llenado una columna
	                	contadorFilas=0;
	                	bounds[0]= bounds[0] + 360; //Distancia a la siguiente columna
	                	bounds[1]= 260; //Colocar el dato en la primera posición
	                } else {
	                	bounds[1]= bounds[1] + 30; //Distancia a la siguiente fila
	                }
	                
					dia2.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
	                add(dia2);
	                
	                volver.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dia2.setVisible(false);
						}
	        	    });	
	                
	                contadorFilas++;
	
				}
	
	        	boton1.setVisible(false);
	 		    boton2.setVisible(false);
	 		    boton3.setVisible(false);
	 		    boton4.setVisible(false);
	 		    boton5.setVisible(false);
	 		    volver2.setVisible(false);
		 		    
	    	 }
        		 
	        }
	    });
        
	    //Botón rutina de 5 días
	    boton3=new JButton("DÍA 3");
	    boton3.setBounds(580,400,100,35);
	    boton3.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton3.setBackground(Color.WHITE);
	    add(boton3);
	    boton3.addActionListener(this);
        
	    boton3.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton3) {
	        		 
	        		ArrayList<String> miRutina=new ArrayList();
		        		
	         		volver=new JButton("Volver");
	        	    volver.setBounds(580,565,100,35);
	        	    volver.setFont(new Font("Arial", Font.PLAIN, 17));
	 	       	    volver.setBackground(Color.WHITE);
	 	       	    add(volver);
	 	       	    volver.setVisible(true);
	 	       	    volver.addActionListener(this);
	 	       	    
	 	       	    volver.addActionListener(new ActionListener() {
	 		        			
	 					@Override
	 					public void actionPerformed(ActionEvent e) {
	 		        		 boton1.setVisible(true);
	 		        		 boton2.setVisible(true);
	 		        		 boton3.setVisible(true);
	 		        		 boton4.setVisible(true);
	 		        		 boton5.setVisible(true);
	 		        		 volver2.setVisible(true);
	 		        		 volver.setVisible(false);
	 					}
	 	   	    	
	 	       	    });
	  
	 	        	try {
	 			      	BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
	 					miRutina= conexionusuario.showRutina(3, usuario.getId_usuario(), "piernas");
	 					miRutina.addAll(conexionusuario.showRutina(3, usuario.getId_usuario(), "abdominales"));
	 				} catch (SQLException e1) {
	 					e1.printStackTrace();
	 				}
	     		 
	 	    		int bounds []= {340,230,400,300}; //Para especificar dimensiones
	 	    	    int contadorFilas=0;
	 	    	    
	 	    		for (String ejercicio : miRutina) {
	 	    			
	 					JLabel dia3 = new JLabel("- " + ejercicio);
	 					dia3.setForeground(Color.white);
	 					dia3.setFont(new Font("Arial", Font.PLAIN, 20));
	 					
	 					if (contadorFilas==5) { //Para saber cuándo se ha llenado una columna
	 	                	contadorFilas=0;
	 	                	bounds[0]= bounds[0] + 360; //Distancia a la siguiente columna
	 	                	bounds[1]= 260; //Colocar el dato en la primera posición
	 	                } else {
	 	                	bounds[1]= bounds[1] + 30; //Distancia a la siguiente fila
	 	                }
	 	                
	 					dia3.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
	 	                add(dia3);
	 	                
	 	                volver.addActionListener(new ActionListener() {
	 						@Override
	 						public void actionPerformed(ActionEvent e) {
	 							dia3.setVisible(false);
	 						}
	 	        	    });	
	 	                
	 	                contadorFilas++;
	 	
	 				}
	 	
	 	        	boton1.setVisible(false);
	 	 		    boton2.setVisible(false);
	 	 		    boton3.setVisible(false);
	 	 		    boton4.setVisible(false);
	 	 		    boton5.setVisible(false);
	 	 		    volver2.setVisible(false);
	 	 		    
	 	    	 }
	         }
	         
	     });
	    
	    boton4=new JButton("DÍA 4");
	    boton4.setBounds(780,400,100,35);
	    boton4.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton4.setBackground(Color.WHITE);
	    add(boton4);
	    boton4.addActionListener(this);
        
	    boton4.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton4) {
	        		 
	        		ArrayList<String> miRutina=new ArrayList();
		        		
	         		volver=new JButton("Volver");
	        	    volver.setBounds(580,565,100,35);
	        	    volver.setFont(new Font("Arial", Font.PLAIN, 17));
	 	       	    volver.setBackground(Color.WHITE);
	 	       	    add(volver);
	 	       	    volver.setVisible(true);
	 	       	    volver.addActionListener(this);
	 	       	    
	 	       	    volver.addActionListener(new ActionListener() {
	 		        			
	 					@Override
	 					public void actionPerformed(ActionEvent e) {
	 		        		 boton1.setVisible(true);
	 		        		 boton2.setVisible(true);
	 		        		 boton3.setVisible(true);
	 		        		 boton4.setVisible(true);
	 		        		 boton5.setVisible(true);
	 		        		 volver2.setVisible(true);
	 		        		 volver.setVisible(false);
	 					}
	 	   	    	
	 	       	    });
	  
	 	        	try {
	 			      	BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
	 					miRutina= conexionusuario.showRutina(4, usuario.getId_usuario(), "pecho");
	 					miRutina.addAll(conexionusuario.showRutina(4, usuario.getId_usuario(), "biceps"));
	 				} catch (SQLException e1) {
	 					e1.printStackTrace();
	 				}
		     		 
	 	    		int bounds []= {340,230,400,300}; //Para especificar dimensiones
	 	    	    int contadorFilas=0;
		 	    	    
	 	    		for (String ejercicio : miRutina) {
	 	    			
	 					JLabel dia4 = new JLabel("- " + ejercicio);
	 					dia4.setForeground(Color.white);
	 					dia4.setFont(new Font("Arial", Font.PLAIN, 20));
	 					
	 					if (contadorFilas==5) { //Para saber cuándo se ha llenado una columna
	 	                	contadorFilas=0;
	 	                	bounds[0]= bounds[0] + 360; //Distancia a la siguiente columna
	 	                	bounds[1]= 260; //Colocar el dato en la primera posición
	 	                } else {
	 	                	bounds[1]= bounds[1] + 30; //Distancia a la siguiente fila
	 	                }
	 	                
	 					dia4.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
	 	                add(dia4);
	 	                
	 	                volver.addActionListener(new ActionListener() {
	 						@Override
	 						public void actionPerformed(ActionEvent e) {
	 							dia4.setVisible(false);
	 						}
	 	        	    });	
	 	                
	 	                contadorFilas++;
	 	
	 					}
		 	
		 	        	boton1.setVisible(false);
		 	 		    boton2.setVisible(false);
		 	 		    boton3.setVisible(false);
		 	 		    boton4.setVisible(false);
		 	 		    boton5.setVisible(false);
		 	 		    volver2.setVisible(false); 
		 	    	 
	        	 }
	         }
	     });
	    
	    boton5=new JButton("DÍA 5");
	    boton5.setBounds(980,400,100,35);
	    boton5.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton5.setBackground(Color.WHITE);
	    add(boton5);
	    boton5.addActionListener(this);
        
	    boton5.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton5) {
	        		 
	        		ArrayList<String> miRutina=new ArrayList();
		        		
	         		volver=new JButton("Volver");
	        	    volver.setBounds(580,565,100,35);
	        	    volver.setFont(new Font("Arial", Font.PLAIN, 17));
	 	       	    volver.setBackground(Color.WHITE);
	 	       	    add(volver);
	 	       	    volver.setVisible(true);
	 	       	    volver.addActionListener(this);
	 	       	    
	 	       	    volver.addActionListener(new ActionListener() {
	 		        			
	 					@Override
	 					public void actionPerformed(ActionEvent e) {
	 		        		 boton1.setVisible(true);
	 		        		 boton2.setVisible(true);
	 		        		 boton3.setVisible(true);
	 		        		 boton4.setVisible(true);
	 		        		 boton5.setVisible(true);
	 		        		 volver2.setVisible(true);
	 		        		 volver.setVisible(false);
	 					}
	 	   	    	
	 	       	    });
		  
	 	        	try {
	 			      	BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
	 					miRutina= conexionusuario.showRutina(5, usuario.getId_usuario(), "hombro");
	 					miRutina.addAll(conexionusuario.showRutina(5, usuario.getId_usuario(), "abdominales"));
	 				} catch (SQLException e1) {
	 					e1.printStackTrace();
	 				}
	     		 
	 	    		int bounds []= {340,230,400,300}; //Para especificar dimensiones
	 	    	    int contadorFilas=0;
		 	    	    
	 	    		for (String ejercicio : miRutina) {
	 	    			
	 					JLabel dia5 = new JLabel("- " + ejercicio);
	 					dia5.setForeground(Color.white);
	 					dia5.setFont(new Font("Arial", Font.PLAIN, 20));
	 					
	 					if (contadorFilas==5) { //Para saber cuándo se ha llenado una columna
	 	                	contadorFilas=0;
	 	                	bounds[0]= bounds[0] + 360; //Distancia a la siguiente columna
	 	                	bounds[1]= 260; //Colocar el dato en la primera posición
	 	                } else {
	 	                	bounds[1]= bounds[1] + 30; //Distancia a la siguiente fila
	 	                }
	 	                
	 					dia5.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
	 	                add(dia5);
	 	                
	 	                volver.addActionListener(new ActionListener() {
	 						@Override
	 						public void actionPerformed(ActionEvent e) {
	 							dia5.setVisible(false);
	 						}
	 	        	    });	
	 	                
	 	                contadorFilas++;
	 	
	 				}
		 	
		 	        	boton1.setVisible(false);
		 	 		    boton2.setVisible(false);
		 	 		    boton3.setVisible(false);
		 	 		    boton4.setVisible(false);
		 	 		    boton5.setVisible(false);
		 	 		    volver2.setVisible(false);
		 	 		     
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
