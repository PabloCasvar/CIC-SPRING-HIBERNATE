package mx.ipn.cic.biblioteca.AdminControl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UserModel {

	// Propiedades privadas
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "identificador")
	private Integer id;

	@Column(name="nombre")
	private String name;
	
	@Column(name="apellido_paterno")
	private String lastnameP;
	
	@Column(name="apellido_materno")
	private String lastnameM;
	
	@Column(name="edad")
	private int age;
	
	@Column(name="direccion")
	private String address;

	// Constructores
	public UserModel() {
		super();

	}

	public UserModel(Integer id, String name, String lastnameP, String lastnameM, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastnameP = lastnameP;
		this.lastnameM = lastnameM;
		this.age = age;
		this.address = address;
	}

	public UserModel(String name, String lastnameP, String lastnameM, int age, String address) {
		super();
		this.name = name;
		this.lastnameP = lastnameP;
		this.lastnameM = lastnameM;
		this.age = age;
		this.address = address;
	}

	// Métodos de acceso
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastnameP() {
		return lastnameP;
	}

	public void setLastnameP(String lastnameP) {
		this.lastnameP = lastnameP;
	}

	public String getLastnameM() {
		return lastnameM;
	}

	public void setLastnameM(String lastnameM) {
		this.lastnameM = lastnameM;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Método toString optimizado
	@Override
	public String toString() {
		return String.format("UserModel [id=%s, name=%s, lastnameP=%s, lastnameM=%s, age=%s, address=%s]", id, name,
				lastnameP, lastnameM, age, address);
	}

}
