package TODOList.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TODOList.dao.UserDao;
import TODOList.entity.Login;
import TODOList.entity.Tasks;

@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserDao userDaoImpl;
	
	@Override
	@Transactional
	public void saveUser(Login newRegister) {
		
		userDaoImpl.saveUser(newRegister);	
	}
	
	@Override
	@Transactional
	public Login verify(Login user) {

		return userDaoImpl.verify(user);
	}

	@Override
	@Transactional
	public List<Tasks> getTasks(int userInfo) {
 
		return userDaoImpl.getTasks(userInfo); 
	}

	@Override
	@Transactional
	public void saveTask(Tasks task, int userInfo) {

		userDaoImpl.saveTask(task, userInfo);
	}

	@Override
	@Transactional
	public String getUserName(int userInfo) {

		return userDaoImpl.getUserName(userInfo);

	}

	@Override
	@Transactional
	public void changeStatus(int taskid) {
		
		userDaoImpl.changeStatus(taskid);		
	}

	@Override
	@Transactional
	public void deleteTask(int taskid) {
		
		userDaoImpl.deleteTask(taskid);
	}

	@Override
	@Transactional
	public Tasks getTask(int taskid) {
		
		return userDaoImpl.getTask(taskid);	
	}
	@Override
	@Transactional
	public List<Tasks> getTasksOrderByName(int userInfo) {
		return userDaoImpl.getTasksOrderByName(userInfo);
	}

	@Override
	@Transactional
	public List<Tasks> getTasksOrderByStatus(int userInfo) {
		return userDaoImpl.getTasksOrderByStatus(userInfo);
	}

	@Override
	@Transactional
	public List<Tasks> getTasksOrderByDeadline(int userInfo) {
		return userDaoImpl.getTasksOrderByDeadline(userInfo);
	}

	@Override
	@Transactional
	public List<Tasks> getTasksOrderByCreateDate(int userInfo) {
		return userDaoImpl.getTasksOrderByCreateDate(userInfo);
	}

}
