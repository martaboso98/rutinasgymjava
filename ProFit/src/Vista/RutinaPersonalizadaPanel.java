package Vista;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BBDD.*;

public class RutinaPersonalizadaPanel extends JPanel implements ActionListener{

	//Llamo a los paneles
	TuUsuarioPanel panel2 = new TuUsuarioPanel();
	MisDatosPanel panel3=new MisDatosPanel();
	ConexionUsuario conexion=new ConexionUsuario(); 
	
	public JButton boton1;
	public JButton boton2;
	public JButton boton3;
	public JButton boton4;
	public JButton boton5;
	public JButton guardar;
	public JButton volver;
	public JButton volver2;
	public MiUsuario usuario; //Para traer los datos del getUser de la clase Usuario: ya tengo id, nombre, contraseña
	public JButton info;

	public RutinaPersonalizadaPanel () {
		
		this.setLayout(null);
		this.setSize(1280, 720);  
		this.setPreferredSize(new Dimension(1280, 720));

	    volver2=new JButton("Volver");
	    volver2.setBounds(600,535,100,35);
	    volver2.setFont(new Font("Arial", Font.PLAIN, 17));
	    volver2.setBackground(Color.WHITE);
	    add(volver2);
	    volver2.setVisible(true);
	    volver2.addActionListener(this);
	    
	    info=new JButton("+ Info");
	    info.setBounds(1080,100,90,35);
	    info.setFont(new Font("Arial", Font.PLAIN, 17));
	    info.setBackground(Color.WHITE);
	    add(info);
	    info.setVisible(true);
	    info.addActionListener(this);
		
		boton1=new JButton("DÍA 1");
		boton1.setBounds(200,400,100,35);
		boton1.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton1.setBackground(Color.WHITE);
	    add(boton1);
	    boton1.addActionListener(this);
        
	    boton1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton1) {
	        		 
	        		ArrayList <Integer> misEjercicios = new ArrayList();
	        		HashMap<Integer,String> ejPiernas=null;
	        		HashMap<Integer,String> ejAbs=null;
	        		 
	        		//Conexión con la base de datos para ir cargando los datos de la tabla introducida
	      		   	try {
			      		BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
						ejPiernas=conexionusuario.loadEjercicios("piernas");
						ejAbs=conexionusuario.loadEjercicios("abdominales");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        		 	        		
	        		guardar=new JButton("Guardar");
	        		guardar.setBounds(990,135,100,35);
	        		guardar.setFont(new Font("Arial", Font.PLAIN, 17));
	        		guardar.setBackground(Color.WHITE);
	        	    add(guardar);
	        	    guardar.addActionListener(this);
	        	    guardar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
							try {
								conexionusuario.setEjercicios(1,usuario.getId_usuario(),misEjercicios);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
	        	    	
	        	    });
	        	    
	        		volver=new JButton("Volver");
	        		volver.setBounds(180,135,100,35);
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
			        		 guardar.setVisible(false);
			        		 volver2.setVisible(true);
			        		 volver.setVisible(false);
			        		 info.setVisible(true);
						}
	        	    	
	        	    });
	        	    
	        	    int bounds []= {200,240,200,30}; //Para especificar dimensiones
	        	    int contadorFilas=0;
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejPiernas.entrySet()) {//Recorro el HashMap con los ejercicios de piernas para mostrarlos en checkbox
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==6) { //Para saber cuándo se ha llenado una columna
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; //Distancia a la siguiente columna
		                	bounds[1]= 290; //Colocar el dato en la primera posición
		                } else {
		                	bounds[1]= bounds[1] + 50; //Distancia a la siguiente fila
		                }
		                
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
																							
								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}

							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejAbs.entrySet()) {
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==6) {  
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; 
		                	bounds[1]= 290; 
		                } else {
		                	bounds[1]= bounds[1] + 50; 
		                }
		                
		                ejercicio.setName(registro.getKey().toString());
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    

        		    boton1.setVisible(false);
        		    boton2.setVisible(false);
        		    boton3.setVisible(false);
        		    boton4.setVisible(false);
        		    boton5.setVisible(false);
        		    guardar.setVisible(true);
        		    volver2.setVisible(false);
        		    info.setVisible(false);
        		    
	        	 }
	         }
	     });
	    
        
	    boton2=new JButton("DÍA 2");
	    boton2.setBounds(400,400,100,35);
	    boton2.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton2.setBackground(Color.WHITE);
	    add(boton2);
	    boton2.addActionListener(this);
        
	    boton2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton2) {
	        		 		        		 
	        		ArrayList <Integer> misEjercicios = new ArrayList();
 	        		HashMap<Integer,String> ejEspalda=null;
 	        		HashMap<Integer,String> ejTriceps=null;
 	        		 
 	      		   	try {
 			      		BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
 			      		ejEspalda=conexionusuario.loadEjercicios("espalda");
 			      		ejTriceps=conexionusuario.loadEjercicios("triceps");
 					} catch (SQLException e1) {
 						e1.printStackTrace();
 					}
 	        		 	        		
 	        		guardar=new JButton("Guardar");
 	        		guardar.setBounds(990,135,100,35);
 	        		guardar.setFont(new Font("Arial", Font.PLAIN, 17));
 	        		guardar.setBackground(Color.WHITE);
 	        	    add(guardar);
 	        	    guardar.addActionListener(this);
 	        	    guardar.addActionListener(new ActionListener() {

 						@Override
 						public void actionPerformed(ActionEvent e) {
 							BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
 							try {
 								conexionusuario.setEjercicios(2,usuario.getId_usuario(),misEjercicios);
 							} catch (SQLException e1) {
 								e1.printStackTrace();
 							}
 						}
 	        	    	
 	        	    });
 	        	    
 	        		volver=new JButton("Volver");
 	        		volver.setBounds(180,135,100,35);
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
 			        		 guardar.setVisible(false);
 			        		 volver2.setVisible(true);
 			        		 volver.setVisible(false);
			        		 info.setVisible(true);
 						}
 	        	    	
 	        	    });
 	        	    
 	        	    int bounds []= {300,240,200,30}; //Para especificar dimensiones
 	        	    int contadorFilas=0;
 	        	    
 	        	    for (HashMap.Entry<Integer,String> registro : ejEspalda.entrySet()) {//Recorro el HashMap con los ejercicios de piernas para mostrarlos en checkbox
 	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
 	        	    	
 		                if (contadorFilas==5) { //Para saber cuándo se ha llenado una columna
 		                	contadorFilas=0;
 		                	bounds[0]= bounds[0] + 220; //Distancia a la siguiente columna
 		                	bounds[1]= 290; //Colocar el dato en la primera posición
 		                } else {
 		                	bounds[1]= bounds[1] + 50; //Distancia a la siguiente fila
 		                }
 		                
 	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
 		                add(ejercicio);
 		                
 		                volver.addActionListener(new ActionListener() {
 							@Override
 							public void actionPerformed(ActionEvent e) {
 								ejercicio.setVisible(false);
 							}
 		        	    });	
 		                
 		                ejercicio.addActionListener(new ActionListener() {

 							@Override
 							public void actionPerformed(ActionEvent e) {

 								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
 							}
 		                	
 		                });
 		                
 		                contadorFilas++;
 	        	    }
 	        	    
 	        	    for (HashMap.Entry<Integer,String> registro : ejTriceps.entrySet()) {
 	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
 	        	    	
 		                if (contadorFilas==5) { 
 		                	contadorFilas=0;
 		                	bounds[0]= bounds[0] + 220; 
 		                	bounds[1]= 290; 
 		                } else {
 		                	bounds[1]= bounds[1] + 50; 
 		                }
 		                
 		                ejercicio.setName(registro.getKey().toString());
 	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
 		                add(ejercicio);
 		                
 		                volver.addActionListener(new ActionListener() {
 							@Override
 							public void actionPerformed(ActionEvent e) {
 								ejercicio.setVisible(false);
 							}
 		        	    });	
 		                
 		               ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
 		                
 		                contadorFilas++;
 	        	    }
	        	    
           		    boton1.setVisible(false);
        		    boton2.setVisible(false);
        		    boton3.setVisible(false);
        		    boton4.setVisible(false);
        		    boton5.setVisible(false);
        		    guardar.setVisible(true);
        		    volver2.setVisible(false);
        		    info.setVisible(false);
		        	
	        	 }
	         }
	     });
        
	    //Botón rutina de 5 días
	    boton3=new JButton("DÍA 3");
	    boton3.setBounds(600,400,100,35);
	    boton3.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton3.setBackground(Color.WHITE);
	    add(boton3);
	    boton3.addActionListener(this);
        
	    boton3.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton3) {
	        		
	        		ArrayList <Integer> misEjercicios = new ArrayList();
	        		HashMap<Integer,String> ejPiernas=null;
	        		HashMap<Integer,String> ejAbs=null;
	        		 
	      		   	try {
			      		BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
						ejPiernas=conexionusuario.loadEjercicios("piernas");
						ejAbs=conexionusuario.loadEjercicios("abdominales");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        		 	        		
	        		guardar=new JButton("Guardar");
	        		guardar.setBounds(990,135,100,35);
	        		guardar.setFont(new Font("Arial", Font.PLAIN, 17));
	        		guardar.setBackground(Color.WHITE);
	        	    add(guardar);
	        	    guardar.addActionListener(this);
	        	    guardar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
							try {
								conexionusuario.setEjercicios(3,usuario.getId_usuario(),misEjercicios);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
	        	    	
	        	    });
	        	    
	        		volver=new JButton("Volver");
	        		volver.setBounds(180,135,100,35);
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
			        		 guardar.setVisible(false);
			        		 volver2.setVisible(true);
			        		 volver.setVisible(false);
			        		 info.setVisible(true);
						}
	        	    	
	        	    });
	        	    
	        	    int bounds []= {200,240,200,30}; //Para especificar dimensiones
	        	    int contadorFilas=0;
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejPiernas.entrySet()) {//Recorro el HashMap con los ejercicios de piernas para mostrarlos en checkbox
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==6) { //Para saber cuándo se ha llenado una columna
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; //Distancia a la siguiente columna
		                	bounds[1]= 290; //Colocar el dato en la primera posición
		                } else {
		                	bounds[1]= bounds[1] + 50; //Distancia a la siguiente fila
		                }
		                
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejAbs.entrySet()) {
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==6) { 
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; 
		                	bounds[1]= 290; 
		                } else {
		                	bounds[1]= bounds[1] + 50; 
		                }
		                
		                ejercicio.setName(registro.getKey().toString());
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
        		    boton1.setVisible(false);
        		    boton2.setVisible(false);
        		    boton3.setVisible(false);
        		    boton4.setVisible(false);
        		    boton5.setVisible(false);
        		    guardar.setVisible(true);
        		    volver2.setVisible(false);
        		    info.setVisible(false);
			        	
	        	 }
	         }
	     });
	    
	    boton4=new JButton("DÍA 4");
	    boton4.setBounds(800,400,100,35);
	    boton4.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton4.setBackground(Color.WHITE);
	    add(boton4);
	    boton4.addActionListener(this);
        
	    boton4.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton4) {
	        		 
	        		ArrayList <Integer> misEjercicios = new ArrayList();
	        		HashMap<Integer,String> ejPecho=null;
	        		HashMap<Integer,String> ejBiceps=null;
	        		 
	      		   	try {
			      		BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
			      		ejPecho=conexionusuario.loadEjercicios("pecho");
			      		ejBiceps=conexionusuario.loadEjercicios("biceps");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        		 	        		
	        		guardar=new JButton("Guardar");
	        		guardar.setBounds(990,135,100,35);
	        		guardar.setFont(new Font("Arial", Font.PLAIN, 17));
	        		guardar.setBackground(Color.WHITE);
	        	    add(guardar);
	        	    guardar.addActionListener(this);
	        	    guardar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
							try {
								conexionusuario.setEjercicios(4,usuario.getId_usuario(),misEjercicios);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
	        	    	
	        	    });
	        	    
	        		volver=new JButton("Volver");
	        		volver.setBounds(180,135,100,35);
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
			        		 guardar.setVisible(false);
			        		 volver2.setVisible(true);
			        		 volver.setVisible(false);
			        		 info.setVisible(true);
						}
	        	    	
	        	    });
	        	    
	        	    int bounds []= {420,240,200,30}; //Para especificar dimensiones
	        	    int contadorFilas=0;
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejPecho.entrySet()) {//Recorro el HashMap con los ejercicios de piernas para mostrarlos en checkbox
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==6) { //Para saber cuándo se ha llenado una columna
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; //Distancia a la siguiente columna
		                	bounds[1]= 290; //Colocar el dato en la primera posición
		                } else {
		                	bounds[1]= bounds[1] + 50; //Distancia a la siguiente fila
		                }
		                
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
								
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejBiceps.entrySet()) {
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==6) { 
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; 
		                	bounds[1]= 290; 
		                } else {
		                	bounds[1]= bounds[1] + 50; 
		                }
		                
		                ejercicio.setName(registro.getKey().toString());
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
        		    boton1.setVisible(false);
        		    boton2.setVisible(false);
        		    boton3.setVisible(false);
        		    boton4.setVisible(false);
        		    boton5.setVisible(false);
        		    guardar.setVisible(true);
        		    volver2.setVisible(false);
        		    info.setVisible(false);
	        		 
	        	 }
	         }
	     });
	    
	    boton5=new JButton("DÍA 5");
	    boton5.setBounds(1000,400,100,35);
	    boton5.setFont(new Font("Arial", Font.PLAIN, 17));
	    boton5.setBackground(Color.WHITE);
	    add(boton5);
	    boton5.addActionListener(this);
        
	    boton5.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if (e.getSource()==boton5) {
	        		 
	        		ArrayList <Integer> misEjercicios = new ArrayList();
	        		HashMap<Integer,String> ejHombro=null;
	        		HashMap<Integer,String> ejAbs=null;
	        		 
	      		   	try {
			      		BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
			      		ejHombro=conexionusuario.loadEjercicios("hombro");
			      		ejAbs=conexionusuario.loadEjercicios("abdominales");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	        		 	        		
	        		guardar=new JButton("Guardar");
	        		guardar.setBounds(990,135,100,35);
	        		guardar.setFont(new Font("Arial", Font.PLAIN, 17));
	        		guardar.setBackground(Color.WHITE);
	        	    add(guardar);
	        	    guardar.addActionListener(this);
	        	    guardar.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							BBDD.ConexionUsuario conexionusuario = new BBDD.ConexionUsuario();
							try {
								conexionusuario.setEjercicios(5,usuario.getId_usuario(),misEjercicios);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
	        	    	
	        	    });
	        	    
	        		volver=new JButton("Volver");
	        		volver.setBounds(180,135,100,35);
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
			        		 guardar.setVisible(false);
			        		 volver2.setVisible(true);
			        		 volver.setVisible(false);
			        		 info.setVisible(true);
						}
	        	    	
	        	    });
	        	    
	        	    int bounds []= {420,240,200,30}; //Para especificar dimensiones
	        	    int contadorFilas=0;
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejHombro.entrySet()) {//Recorro el HashMap con los ejercicios de piernas para mostrarlos en checkbox
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==7) { //Para saber cuándo se ha llenado una columna
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; //Distancia a la siguiente columna
		                	bounds[1]= 290; //Colocar el dato en la primera posición
		                } else {
		                	bounds[1]= bounds[1] + 50; //Distancia a la siguiente fila
		                }
		                
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
	        	    for (HashMap.Entry<Integer,String> registro : ejAbs.entrySet()) {
	        	    	JCheckBox ejercicio=new JCheckBox(registro.getValue());
	        	    	
		                if (contadorFilas==7) { 
		                	contadorFilas=0;
		                	bounds[0]= bounds[0] + 220; 
		                	bounds[1]= 290; 
		                } else {
		                	bounds[1]= bounds[1] + 50; 
		                }
		                
		                ejercicio.setName(registro.getKey().toString());
	        	    	ejercicio.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
		                add(ejercicio);
		                
		                volver.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ejercicio.setVisible(false);
							}
		        	    });	
		                
		                ejercicio.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								if (ejercicio.isSelected()==true) {
									if (misEjercicios.size()<9) {
										misEjercicios.add(registro.getKey());	//Cuando selecciono un checkbox, lo añade a mi arraylist de ejercicios con los ID							
									} else {
										ejercicio.setSelected(false); // Desmarca el checkbox si se ha alcanzado el límite de selección
						                JOptionPane.showMessageDialog(null, "Máximo 9 ejercicios.", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
									}
								}

								if (ejercicio.isSelected()==false || ejercicio.isVisible()==false) {
									misEjercicios.remove(registro.getKey());
								}
							}
		                	
		                });
		                
		                contadorFilas++;
	        	    }
	        	    
        		    boton1.setVisible(false);
        		    boton2.setVisible(false);
        		    boton3.setVisible(false);
        		    boton4.setVisible(false);
        		    boton5.setVisible(false);
        		    guardar.setVisible(true);
        		    volver2.setVisible(false);
        		    info.setVisible(false);

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
