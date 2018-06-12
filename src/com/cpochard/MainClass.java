package com.cpochard;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainClass {

	public static void main(String[] args) {
		exempleTestEmployee();
		exempleTestAnimal();

	}

	public static void exempleTestEmployee() {
		Employee employe1 = new Employee("Misharl", "Monsoor", 10000);
		Employee employe2 = new Employee("Camille", "Pochard", 50000);
		Employee employe3 = new Employee("Robert", "Michou", 2500);
		Employee employe4 = new Employee("Josiane", "Loupie", 20000);
		Employee employe5 = new Employee("Marc", "Croubert", 8000);

		// Preparation de la construction de sessions
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		// Ouverture session
		Session session = sessionFactory.openSession();
		//Creation d'une transaction
		session.beginTransaction();
		//Demande de sauvegarder en base les deux instances
		session.save(employe1);
		session.save(employe2);
		session.save(employe3);
		session.save(employe4);
		session.save(employe5);
		
		List<Employee> result = session.createQuery("from Employee E WHERE E.firstName LIKE 'M%' ORDER BY E.salary").list();
		for (Employee e : result) {
			System.out.println(e);
		}
		//Commit de la transaction
		session.getTransaction().commit();
		// Fermeture session
		session.close();
	}
	
	public static void exempleTestAnimal() {
		//On dispose d'une information dans une variable
		String espece = "Chien";
		Animal a1 = new Animal ("Kiki", "Pigeon", 2);
		Animal a2 = new Animal ("Koko", "Dodo", 4);
		Animal a3 = new Animal ("Filou", "Chien", 5);
		Animal a4 = new Animal ("Miouw", "Chat", 10);
		Animal a5 = new Animal ("Rex", "Chien", 9);
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		session.save(a5);
		//On prépare la transaction en indiquant une variable avec :
		Query query = session.createQuery("from Animal A WHERE A.espece=:esp");
		//On applique le remplacement de la variable
		query.setParameter("esp", espece);
		//On récupere les résultats de la requete
		List<Animal> result = query.list();
		for (Animal a : result) {
			System.out.println(a);
		}
		session.getTransaction().commit();
		session.close();
	}

}
