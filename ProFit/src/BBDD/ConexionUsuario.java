package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Vista.RutinaPersonalizadaPanel;

import java.awt.Checkbox;
import java.sql.*;

public class ConexionUsuario {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	//dirección de la BBDD MySQL
	private static final String URL = "jdbc:mysql://localhost:3306/ProFit";
	//usuario y contraseña de acceso a la BD
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public Connection conectar() {
		Connection conexion = null;

		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			System.out.println("Conexión OK");

		} catch (ClassNotFoundException e) { 
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}
	   
	//Insertar usuarios en la base de datos
	public boolean addUser(String nombre, String contraseña) throws SQLException {
	   
	   if (getUser(nombre,contraseña)==null) {
		   Connection conexion = conectar();
	       Statement statement = conexion.createStatement();
	       String sql = "INSERT INTO usuario (nombre, contraseña) VALUES ('" + nombre + "', '" + contraseña + "')";
	       statement.executeUpdate(sql);
	       statement.close();
	       return true; //Si no existe un usuario con ese nombre devuelve true y se inserta
	   } else {
		   return false; //Si existe ya un usuario con ese nombre devuelve false y no se inserta
	   }
	}
	   
	//Devolver usuario con nombre y contraseña
	public MiUsuario getUser(String nombre, String contraseña) throws SQLException{
		Connection conexion = conectar();
		MiUsuario miusuario=null; //Lo declaro nulo por si no se encuentra ningún usuario

		if(conexion!=null) {
			try {

				//Datos a consultar
				String consultasSeleccion = "SELECT id_usuario,nombre,contraseña FROM usuario WHERE nombre='" + nombre + "' AND contraseña='" + contraseña + "'";
				Statement statement = conexion.createStatement();
				
				//Ejecución de la consulta
				if (statement.execute(consultasSeleccion)) {
					ResultSet resultset = statement.getResultSet();
					if (resultset.next()) { //Para saber si existe
						miusuario = new MiUsuario (resultset.getInt("id_usuario"),resultset.getString("nombre"), resultset.getString("contraseña"));
						System.out.println(miusuario.toString());
					}
					
				}
				
				//Cierre del Statement
				statement.close();
				
			} finally {
				//Cierre de la conexión
				close(conexion);
			}
		}
			
			return miusuario;
		}
	
		//Añadir los datos al usuario o modificarlos
	   public void addData(int id_usuario,String name, String password, String surname, String email, float weight,int height, int age) throws SQLException{		   	
	    	Connection conexion = conectar();
			MiUsuario miusuario=null;
	    	
		    Statement statement = conexion.createStatement();
		    String sql2 = "UPDATE usuario SET nombre = '"+ name + "', contraseña = '" + password + "' , apellido = '" + surname + "', email = '" + email + "' , peso = '" + weight + 
		            "' , altura = '" + height + "' , edad = '" + age + "' WHERE id_usuario = '" + id_usuario + "'";

		    statement.executeUpdate(sql2);
		    statement.close();

	   }
	   
	   //Selecciono todos los ejercicios de la tabla del músculo seleccionado para meter los datos en el HashMap y así poder introducirlos en el checkbox
	   public HashMap<Integer,String> loadEjercicios(String tabla) throws SQLException{ 
		   Connection conexion = conectar();
		   HashMap<Integer,String> ejercicios=null; //Lo declaro nulo por si no se encuentra ningún dato
		   
		   if(conexion!=null) {
				try {

					//Datos a consultar
					String consultaEjercicios = "SELECT * FROM " + tabla;
					Statement statement = conexion.createStatement();
					
					//Ejecución de la consulta
					if (statement.execute(consultaEjercicios)) {
						ResultSet resultset = statement.getResultSet();
						ejercicios=new HashMap(); //Inicializar el HashMap
						
						while (resultset.next()) { //Para saber si existe
							ejercicios.put(resultset.getInt("id"), resultset.getString("nombre")); //Introduzco los datos en el HashMap
						}
						
					};
					
					//Cierre del Statement
					statement.close();
					
				} finally {
					//Cierre de la conexión
					close(conexion);
				}
			}		
		   return ejercicios;
	   }
	   
	   //Introducir el id de los ejercicios en la base de datos por día y usuario
	   public void setEjercicios(int dia,int id_usuario,ArrayList <Integer>misEjercicios) throws SQLException{
		   	
	    	Connection conexion = conectar();
		    Statement statement = conexion.createStatement();
		    String cadenaMisEjercicios="";
		    
		    if(conexion!=null) {
				try {

					//Datos a consultar
					String consultaDia = "SELECT * FROM dia_usuario_ejercicio WHERE id_usuario = " + id_usuario + " AND dia = " + dia;
					statement = conexion.createStatement();
					
					//Ejecución de la consulta
					if (statement.execute(consultaDia)) {
						ResultSet resultset = statement.getResultSet();
						
						if (resultset.next()) { //Para saber si existe
							//Si existe ya la rutina, se borran los datos para sobreescribirlos
							String borrarDia = "DELETE FROM dia_usuario_ejercicio WHERE id_usuario = " + id_usuario + " AND dia = " + dia;
							statement = conexion.createStatement();
							
							//Ejecución de la consulta
							statement.execute(borrarDia);
							statement.close();
						
						}
					}
					
					//Cierre del Statement
					statement.close();
					
				
				    for (int i=0;i<misEjercicios.size();i++) { //Recorro el ArrayList y voy metiendo los datos separados por comas en mi cadena
				    	if (misEjercicios.size()-1==i) {
				    		cadenaMisEjercicios=cadenaMisEjercicios+misEjercicios.get(i);
				    	} else {
				    		cadenaMisEjercicios=cadenaMisEjercicios+misEjercicios.get(i)+",";
				    	}
					}
				    
			    	String sql3 = "INSERT INTO dia_usuario_ejercicio VALUES ('" + dia +"', '" + id_usuario +"', '"+ cadenaMisEjercicios+"')";
					statement = conexion.createStatement();
			    	statement.executeUpdate(sql3);
				    statement.close();
			    
				} finally {
					//Cierre de la conexión
					close(conexion);
	
				}
			
		    }	

	   }
	   
	   //Devuelve un array con los nombres de los ejercicios
	   public ArrayList<String> showRutina (int dia,int id_usuario,String tabla) throws SQLException{
		   Connection conexion = conectar();
		   ArrayList<String>miRutina = new ArrayList();
		   String cadenaMisEjercicios="";

			if(conexion!=null) {
				try {

					//Datos a consultar
					String consultasEjercicios = "SELECT ejercicios FROM dia_usuario_ejercicio WHERE id_usuario=" + id_usuario + " AND dia=" + dia; //Cojo los números del array de ejercicios del usuario y día
					Statement statement = conexion.createStatement();
					
					//Ejecución de la consulta
					if (statement.execute(consultasEjercicios)) {
						ResultSet resultset = statement.getResultSet();
						
						if (resultset.next()) { //Para saber si existe
							cadenaMisEjercicios=resultset.getString("ejercicios"); 
						}
						
					}

					if (cadenaMisEjercicios!="") {
						//Split para separar el array
						String[] ejercicios = cadenaMisEjercicios.split(",");
				        int[] ejerciciosArray = new int[ejercicios.length];
				        for (int i = 0; i < ejercicios.length; i++) {
				        	ejerciciosArray[i] = Integer.parseInt(ejercicios[i]);
				        }
	
				        
						//Cambio los números del array con los id de los ejercicios por los nombres de estos
						String consultasNombre = "SELECT nombre FROM " + tabla + " WHERE id =" + ejerciciosArray[0];
						
						for (int i=1;i<ejerciciosArray.length;i++) { //sigo la consulta dentro del bucle para todos los ejercicios
				        	consultasNombre = consultasNombre + " OR id =" + ejerciciosArray[i];
				        }
											
						//Ejecución de la consulta
						if (statement.execute(consultasNombre)) {
							ResultSet resultset = statement.getResultSet();
							
							while (resultset.next()) { //Para saber si existe
								miRutina.add(resultset.getString("nombre")); //Introduzco los datos en el ArrayList
							}
						}
						
						//Cierre del Statement
						statement.close();
						
					} 
					
				} finally {
					//Cierre de la conexión
					close(conexion);
				}
			}
			return miRutina;
	   }
	   
	   public void close(Connection conection) throws SQLException {
	      conection.close();
	   }


	
}
