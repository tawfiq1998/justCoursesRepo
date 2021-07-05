/**
 * this class to manipulate databas 
 * 
 * by Tawfiq toubeh 
 * 
 * last update 4/10/2020
 * */
package bean;

import java.util.List;
import java.util.logging.Logger;

import model.Department;
import model.Faculty;
import model.User;

public class HomeBean {
	private final Logger LOGGER = Logger.getLogger(HomeBean.class.getName());// to inform the status of project

	static GeneralDAO dao = GeneralDAO.getInstance();// to use sql easly
	Department department = new Department();
	Faculty faculty = new Faculty();
	User users = new User();

	/** to load departments */
	public List<Department> getSelectedDepartments(int selectdFaculty) {
		LOGGER.info("start getSelectedDepartments method");
		return dao.excuteSelectingQuery("DAO", "SELECT d FROM Department d WHERE d.faculty_ID = " + selectdFaculty);
		// return dao.getAllRecords("DAO", department);
	}

	/** to load all faculty */
	public List<Faculty> getAllFaculy() {
		LOGGER.info("start getAllFaculy method");
		return dao.getAllRecords("DAO", faculty);
	}

	/** to load all Users */
//	public List<Faculty> getAllUsers() {
//
//		return dao.getAllRecords("DAO", users);
//	}

	/** to load User info */
	public User checkUser(String user, String pass) {
		LOGGER.info("start checkUser method");

		List<User> list = dao.excuteSelectingQuery("DAO",
				"SELECT u FROM User u WHERE u.userName = '" + user + "' AND u.password = '" + pass + "'");
		/*
		 * this try catch to return null if user name dosn't match the pass
		 */
		try {
			return list.get(0);
		} catch (NullPointerException e) {
			LOGGER.warning("no user back be NullPointerException");
			return null;
		} catch (Exception e) {
			LOGGER.warning("no user back");
			return null;
		}
	}

	public User signUp(User user) {
		LOGGER.info("start signUp method");
		dao.insert("DAO", user);
		return user;
	}
}