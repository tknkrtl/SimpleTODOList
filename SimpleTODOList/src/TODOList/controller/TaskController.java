package TODOList.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import TODOList.entity.Login;
import TODOList.entity.Tasks;
import TODOList.service.UserService;

@Controller
@SessionAttributes("userInfo")
public class TaskController {

	
	@Autowired
	private UserService userServiceImpl;
	
	@GetMapping("/authentication")
	public String authentication(Model model)
	{
		// kayýt mý olmuþ yoksa varolan kaydý mý giriyor kontrol et

		Login tempLogin = new Login();
		model.addAttribute("tempLogin",tempLogin);	
		
		return "authentication";
	}
	
	@PostMapping("/verify")
	public String verify(Model model,@Valid @ModelAttribute("tempLogin") Login user,
						BindingResult theBindingResult,RedirectAttributes redirectAttrs)
	{
		if(theBindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("bindingError","Username and password must have a value");
			return "redirect:/authentication";
		}
		
		Login checkUser = userServiceImpl.verify(user);
		if(checkUser!=null)
		{
			model.addAttribute("userInfo",checkUser.getId());
			return "redirect:/home";
		}
		else
		{
			redirectAttrs.addFlashAttribute("loginErr","Invalid username or password");
			return "redirect:/authentication";
		}
	}
	@GetMapping("/home")
	public String home(Model model,@ModelAttribute("userInfo") int userInfo)
	{
		
		List <Tasks> tasks=userServiceImpl.getTasks(userInfo); 
		model.addAttribute("tasks", tasks);
		
		String userName =  userServiceImpl.getUserName(userInfo);
		model.addAttribute("userName", userName);
		
		return "home-page";
	}
	@GetMapping("/registration")
	public String registration(Model model)
	{
		Login tempLogin = new Login();
		model.addAttribute("tempLogin",tempLogin);
		
		return "register-user";  
	}
	@PostMapping("/registerUser")
	public String RegisterUser(Model model,@Valid @ModelAttribute ("tempLogin") Login user
								,BindingResult theBindingResult,RedirectAttributes redirectAttrs)
	{
		if(theBindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("bindingError","Username and password must have a value");
			return "redirect:/registration";
		}
		else
		{
			userServiceImpl.saveUser(user);
			redirectAttrs.addFlashAttribute("successRegister","Succesfully Registered!");
			return "redirect:/authentication";
		}
	}
	@GetMapping("/addTask")
	public String AddTask(Model model)
	{
		Tasks task = new Tasks();
		
		model.addAttribute("task", task);
		
		return "task-form";
	}
	@PostMapping("/verifyTask")
	public String verifyTask(@Valid @ModelAttribute("task") Tasks task,BindingResult theBindingResult
							,RedirectAttributes redirectAttrs,@ModelAttribute("userInfo") int usernameInfo)
	{
		if(theBindingResult.hasErrors())
		{
			redirectAttrs.addFlashAttribute("bindingError", "Name,description and deadline must have a value");
			return "redirect:/addTask";	
		}
		else
		{
			userServiceImpl.saveTask(task,usernameInfo);
			redirectAttrs.addFlashAttribute("success", "Your task is successfully added or updated");
			
			return "redirect:/home";
		}
	}
	
	@GetMapping("/changeStatus")
	public String ChangeStatus(@RequestParam ("taskId") int taskid) 
	{
		userServiceImpl.changeStatus(taskid);
		return "redirect:/home";
		
	}
	@GetMapping("/deleteTask")
	public String DeleteTask(@RequestParam ("taskId") int taskid)
	{
		userServiceImpl.deleteTask(taskid);
		return "redirect:/home";
	}
	@GetMapping("/updateTask")
	public String UpdateTask(@RequestParam ("taskId") int taskid, Model model)
	{
		Tasks task = userServiceImpl.getTask(taskid);
		
		model.addAttribute("task",task);
		
		return "task-form";
	}
	@GetMapping("/orderByName")
	public String OrderByName(Model model,@ModelAttribute("userInfo") int userInfo)
	{
		List <Tasks> tasks=userServiceImpl.getTasksOrderByName(userInfo); 
		model.addAttribute("tasks", tasks);
		
		String userName =  userServiceImpl.getUserName(userInfo);
		model.addAttribute("userName", userName);
		
		return "home-page";
			}
	@GetMapping("/orderByDeadline")
	public String OrderByDeadline(Model model,@ModelAttribute("userInfo") int userInfo)
	{
		List <Tasks> tasks=userServiceImpl.getTasksOrderByDeadline(userInfo); 
		model.addAttribute("tasks", tasks);
		
		String userName =  userServiceImpl.getUserName(userInfo);
		model.addAttribute("userName", userName);
		
		return "home-page";
		
	}
	@GetMapping("/orderByStatus")
	public String OrderByStatus(Model model,@ModelAttribute("userInfo") int userInfo)
	{
		List <Tasks> tasks=userServiceImpl.getTasksOrderByStatus(userInfo); 
		model.addAttribute("tasks", tasks);
		
		String userName =  userServiceImpl.getUserName(userInfo);
		model.addAttribute("userName", userName);
		
		return "home-page";
	}
	@GetMapping("/orderByCreateDate")
	public String OrderByCreateDate(Model model,@ModelAttribute("userInfo") int userInfo)
	{
		List <Tasks> tasks=userServiceImpl.getTasksOrderByCreateDate(userInfo); 
		model.addAttribute("tasks", tasks);
	
		String userName =  userServiceImpl.getUserName(userInfo);
		model.addAttribute("userName", userName);
		
		return "home-page";
	}
	
	
	
}
