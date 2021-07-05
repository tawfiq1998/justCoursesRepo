/**
 * this class is a general class to manipulate data base easily 
 * 
 * by Tawfiq toubeh 
 * 
 * last update 4/10/2020
 * */
package bean;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GeneralDAO {
	private final Logger LOGGER = Logger.getLogger(GeneralDAO.class.getName());//to inform the status of project

	public static GeneralDAO generalDAO; // to use this class in other projects
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public static GeneralDAO getInstance() {
		if (generalDAO == null)
			return new GeneralDAO();
		return generalDAO;
	}

	/**
	 * to insert new rrcord to Database
	 */
	public void insert(String db, Object object) {
		LOGGER.info("start insert method");

		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			entityManager.persist(object);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.warning("Error while insert");
			// TODO: handle exception
		} finally {
			entityManager.close();
		}
	}

	/**
	 * to Delete Existing record in Data base
	 */
	public <T> void deleteRecord(String db, Object object, T pk) {
		LOGGER.info("start deleteRecord method");

		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();

			Object obj = (Object) entityManager.find(object.getClass(),pk);

			entityManager.remove(obj);
			entityManager.getTransaction().commit();
		} catch (Exception e) {			
			LOGGER.warning("Error while delete");

		} finally {
			entityManager.close();

		}
	}

	/**
	 * this method to get Existing record from Database by Primary Key
	 * 
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public <T> Object GetRecordByPK(String db, Object object, T pk) throws NoSuchMethodException, SecurityException {
		LOGGER.info("start GetRecordByPK method");
		
		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			return entityManager.find(object.getClass(), pk);
		} catch (Exception e) {
			LOGGER.warning("Error while getteng revord");
		} finally {
			entityManager.close();
		}
		System.out.println("error");
		return null;
	}

	/**
	 * this method to get all records From Database
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(String db, Object object) {
		LOGGER.info("start getAllRecords method");

		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("Select e FROM " + object.getClass().getName() + " e");

		return query.getResultList();
	}

	/**
	 * this method to get spasific number of records From Database
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getAllRecords(String db, Object object, int maxNum) {
		LOGGER.info("start getAllRecords method which take max");

		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("Select e FROM " + object.getClass().getName() + " e");

		return query.setMaxResults(maxNum).getResultList();
	}

	/**
	 * this method to excute selecting query
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> excuteSelectingQuery(String db, String query) {
		LOGGER.info("start excuteSelectingQuery method");

		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();

		Query q = entityManager.createQuery(query);

		return q.getResultList();

	}

	/**
	 * this method to update existing record in Database (retern false if record is
	 * not exist)
	 */
	public <T> boolean updateRecord(String db, Object object, T pk) {
		LOGGER.info("start updateRecord method");

		entityManagerFactory = Persistence.createEntityManagerFactory(db);
		entityManager = entityManagerFactory.createEntityManager();
		Object ob = entityManager.find(object.getClass(), pk);
		if (ob == null) { // if there are no record in db return false
			return false;
		}
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(object);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			LOGGER.warning("Error while updating the record");
		} finally {
			entityManager.close();
		}

		return false;
	}
}