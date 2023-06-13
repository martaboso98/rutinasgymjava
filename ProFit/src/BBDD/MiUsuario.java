package BBDD;

public class MiUsuario {

	//Atributos
	private int id_usuario;
    private String name;
    private String password;
	private String surname;
	private String email;
	private int age;
	private int height;	
	private float weight;

	//Constructor para getUser
	public MiUsuario(int id_usuario, String name, String password) {
        this.name = name;
        this.password = password;
        this.id_usuario=id_usuario;
    }

	//Constructor para addData
    public MiUsuario(String name, String password, String surname, String email,float weight,int height,int age) {
        this.name = name;
        this.password = password;
        this.surname=surname;
        this.email=email;
        this.age=age;
        this.height=height;
        this.weight=weight;
    }
    
    //Getter y setter
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	@Override
    public String toString() {
        return "Usuario: nombre:" + name + ", contraseña: " + password + ", apellido: " + surname + ", edad: " + age + ", email: " + email + ", altura: " + height + ", peso: " + weight;
    }

}
