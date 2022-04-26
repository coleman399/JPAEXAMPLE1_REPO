package jpaex;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class Demo {

	static EntityManagerFactory emf;

	public static List<User> findAll() {
		final EntityManager em = emf.createEntityManager();
		final String jpql = "SELECT u FROM User u";
		final TypedQuery<User> query = em.createQuery(jpql, User.class);
		final List<User> results = query.getResultList();
		em.close();
		return results;
	}

	public static List<User> findAllAdmin() {
		final EntityManager em = emf.createEntityManager();
		final String jpql = "SELECT u FROM User u WHERE u.adminRights = true";
		final TypedQuery<User> query = em.createQuery(jpql, User.class);
		final List<User> results = query.getResultList();
		em.close();
		return results;
	}

	public static List<String> findAllUsernames() {
		final EntityManager em = emf.createEntityManager();
		final String jpql = "SELECT u.username FROM User u";
		final TypedQuery<String> query = em.createQuery(jpql, String.class);
		final List<String> results = query.getResultList();
		em.close();
		return results;
	}

	public static Optional<User> findByUsername(final String username) {
		Optional<User> foundUser = Optional.empty();
		final EntityManager em = emf.createEntityManager();
		final TypedQuery<User> query = em.createNamedQuery("findByUsername", User.class);
		query.setParameter("name", username);
		final List<User> results = query.getResultList();
		if (!results.isEmpty())
			foundUser = Optional.of(results.get(0));
		em.close();
		return foundUser;
	}

	public static void main(final String[] args) {

		emf = Persistence.createEntityManagerFactory("JPA");

		EntityManager em = emf.createEntityManager();

		User user1 = new User("Captain Jack Sparrow", false);
		final User user2 = new User("Captain James T Kirk", true);
		Thing thing = new Thing();
		System.out.println(user1);
		em.getTransaction().begin();

		user1 = em.merge(user1);
		em.merge(user2);
		thing = em.merge(thing);

		em.getTransaction().commit();
		System.out.println(user1);
		System.out.println(thing);

		em.close();

		em = emf.createEntityManager();

		final List<User> results = findAll();
		System.out.println(results);

		em.close();

		emf.close();

	}

}
