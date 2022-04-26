package example;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Demo {

	public static void main(String[] args) {

		final TraineeFactory tf = new TraineeFactory();

		Trainee zach = tf.create(1, "Zachary Ceme", "J1 Data Access", ThreadLocalRandom.current().nextBoolean());

		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(zach);

		em.getTransaction().commit();

		em.getTransaction().begin();

		zach.setModule("J2 Servlets");

		em.getTransaction().commit();

		em.close();

//		em = emf.createEntityManager();
//
//		zach = em.find(Trainee.class, 1);
//
//		em.getTransaction().begin();
//
//		em.remove(zach);
//
//		em.getTransaction().commit();
//
//		em.close();

		zach.setModule("nothing");
		final Trainee alec = tf.create(2, "Alec Flanigan", "Something", false);

		em = emf.createEntityManager();

		em.getTransaction().begin();

		// YOU HAVE TO USE THE RETURN VALUE OF MERGE
		zach = em.merge(zach);
		em.merge(alec);

		em.getTransaction().commit();

		em.getTransaction().begin();

		em.remove(zach);

		em.getTransaction().commit();

		em.close();

		emf.close();

	}

}
