package orm;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static final EntityManagerFactory entityManagerFactory;

	static {

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("exo3-JPA");

		} catch (Throwable ex) {

			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
