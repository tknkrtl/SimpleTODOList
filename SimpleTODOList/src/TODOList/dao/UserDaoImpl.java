package TODOList.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttribute;

import TODOList.entity.Login;
import TODOList.entity.Tasks;
import sun.print.resources.serviceui_es;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveUser(Login newRegister) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(newRegister);	
	}
	@Override
	public Login verify(Login user) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query <Login> query = currentSession.createQuery("from Login where username=:userId and password=:userPass",Login.class);
		query.setParameter("userId", user.getUsername());
		query.setParameter("userPass", user.getPassword());
		
		List<Login>checkUser = query.getResultList();
		
		if(checkUser.isEmpty())
		{
			return null;
		}
		else return checkUser.get(0);
	}
	@Override
	public List<Tasks> getTasks(int userInfo){
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query <Tasks> query = currentSession.createQuery("from Tasks where username_id=:usernameid",Tasks.class);
		query.setParameter("usernameid", userInfo);
		
		List<Tasks> tasks = query.getResultList();
		
		return tasks;
	}
	@Override
	public void saveTask(Tasks task, int userInfo) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Login login = currentSession.get(Login.class, userInfo);
		task.setLogin(login);
		task.setStatus("Not Completed");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		task.setCreateDate((dateFormat.format(date))); //2016/11/16 12:08:43
		
		currentSession.saveOrUpdate(task);
	
	}
	@Override
	public String getUserName(int userInfo) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query <Login> query = currentSession.createQuery("from Login where id=:userid",Login.class);
		query.setParameter("userid", userInfo);
		
		List<Login>checkUser = query.getResultList();
		
		if(checkUser.isEmpty())
		{
			return null;
		}
		else return checkUser.get(0).getUsername();
		
	}
	@Override
	public void changeStatus(int taskid) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Tasks task = currentSession.get(Tasks.class, taskid);
		System.out.println(task.getStatus());
		
		if(task.getStatus().equals("Not Completed"))
		{
			task.setStatus("Completed");
			currentSession.update(task);
		}
		else
		{	
			task.setStatus("Not Completed");
			currentSession.update(task);
		}
	}
	@Override
	public void deleteTask(int taskid) {

		Session currentSession = sessionFactory.getCurrentSession();
		Tasks task = currentSession.get(Tasks.class, taskid);
		currentSession.delete(task);
	}
	@Override
	public Tasks getTask(int taskid) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Tasks task = currentSession.get(Tasks.class, taskid);
		return task;
	}
	@Override
	public List<Tasks> getTasksOrderByName(int userInfo) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tasks>query = currentSession.createQuery("from Tasks where username_id=:userId order by name",Tasks.class);
		query.setParameter("userId", userInfo);
		List<Tasks>tasks= query.getResultList();
		
		return tasks;
	}
	@Override
	public List<Tasks> getTasksOrderByStatus(int userInfo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tasks>query = currentSession.createQuery("from Tasks where username_id=:userId order by status",Tasks.class);
		query.setParameter("userId", userInfo);
		List<Tasks>tasks= query.getResultList();
		
		return tasks;
	}
	@Override
	public List<Tasks> getTasksOrderByDeadline(int userInfo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tasks>query = currentSession.createQuery("from Tasks where username_id=:userId order by deadline",Tasks.class);
		query.setParameter("userId", userInfo);
		List<Tasks>tasks= query.getResultList();
		
		return tasks;
	}
	@Override
	public List<Tasks> getTasksOrderByCreateDate(int userInfo) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Tasks>query = currentSession.createQuery("from Tasks where username_id=:userId order by createDate",Tasks.class);
		query.setParameter("userId", userInfo);
		List<Tasks>tasks= query.getResultList();
		
		return tasks;
	}

}
