package TODOList.dao;

import java.util.List;

import TODOList.entity.Login;
import TODOList.entity.Tasks;

public interface UserDao{

	public void saveUser(Login newRegister);
	
	public Login verify(Login user);
	
	public List<Tasks> getTasks(int userInfo);
	
	public void saveTask(Tasks task, int userInfo);
	
	public String getUserName(int userInfo);
	
	public void changeStatus(int taskid);

	public void deleteTask(int taskid);
	
	public Tasks getTask(int taskid);
	
	public List<Tasks> getTasksOrderByName(int userInfo);

	public List<Tasks> getTasksOrderByStatus(int userInfo);

	public List<Tasks> getTasksOrderByDeadline(int userInfo);

	public List<Tasks> getTasksOrderByCreateDate(int userInfo);
	
}
