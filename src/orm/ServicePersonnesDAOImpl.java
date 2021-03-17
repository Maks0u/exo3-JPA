package orm;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Personne;

public class ServicePersonnesDAOImpl implements ServicePersonnesDAO {

	Connection cx = null;
	Statement stmt = null;

	public ServicePersonnesDAOImpl() {
	}

	@Override
	public List<Personne> lireTout() {

		// method GET
		System.out.println("lireTout");

		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

		try {
			TypedQuery<Personne> query = entityManager.createNamedQuery("Personne.findAll", Personne.class);
			List<Personne> liste = query.getResultList();
			return liste;
		} catch (Exception e) {
			return null;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Personne lire(int id) {

		// method GET
		System.out.println("lire" + " id: " + id);

		EntityManager entityManager = JpaUtils.getEntityManagerFactory().createEntityManager();

		try {
			TypedQuery<Personne> query = entityManager.createNamedQuery("Personne.findById", Personne.class);
			query.setParameter("id", id);
			List<Personne> liste = query.getResultList();
			Personne p = liste.get(0);
			return p;
		} catch (Exception e) {
			return null;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public String ajouter(Personne p) {

		// method POST
		System.out.println("ajouter " + p);

		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		try {

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.merge(p);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return "NOK";
		} finally {
			em.close();
		}

		return "OK";
	}

	@Override
	public String modifier(Personne p) {

		// method PUT
		System.out.println("modifier " + p);

		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		try {

			Personne _p = em.find(Personne.class, p.getId());
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			_p.setNom(p.getNom());
			transaction.commit();

		} catch (Exception e) {
			return "NOK";
		} finally {
			em.close();
		}

		return "OK";
	}

	@Override
	public String supprimer(int id) {

		// method DELETE
		System.out.println("supprimer id: " + id);

		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();

		try {

			Personne p = em.find(Personne.class, id);
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(p);
			transaction.commit();

		} catch (Exception e) {
			return "NOK";
		} finally {
			em.close();
		}
		return "OK";
	}
}
