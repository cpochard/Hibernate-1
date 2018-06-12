package com.cpochard;

public class Animal {
	
	private int id;
	private String nom;
	private String espece;
	private int age;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", espece=" + espece + ", age=" + age + "]";
	}

	public Animal() {}
	
	public Animal(String nom, String espece, int age) {
		this.nom = nom;
		this.espece = espece;
		this.age = age;
	}
}
