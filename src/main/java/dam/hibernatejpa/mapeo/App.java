package dam.hibernatejpa.mapeo;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		//se utiliza el método de factoría de Persistence para crear el entity manager factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaMapeo");

		//gestor de entidades
		EntityManager em = emf.createEntityManager();

		//se inicia la transacción
		em.getTransaction().begin();

		//obtengo un objeto LocalDate para asignarlo como fecha de cumpleaños
		//del usuario
		Calendar calendar = Calendar.getInstance(); 
		calendar.set(1998, 2, 23);

		User user1 = new User();
		user1.setUserName("Rafa");
		user1.setBirthDay(calendar.getTime());
		em.persist(user1);
		
		Phone phone = new Phone("123456789");
		phone.setUser(user1);
		
		em.persist(phone);
		
		em.flush();
		

		em.getTransaction().commit();

		em.close();
	}
}
