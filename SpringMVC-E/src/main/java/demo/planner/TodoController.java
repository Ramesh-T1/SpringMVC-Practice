package demo.planner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@SessionAttributes("username")
@Controller
public class TodoController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}
	
	@Autowired
	TodoService service;
	


	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(/*@RequestParam("name") String n,*/ ModelMap model) {
		//model.addAttribute("usern", n); //@RequestParam and addAttribute is not required as we are using Session Attributes
		model.addAttribute("to-dos", service.retrieveTodos("ramesh"));
		return "list-todos";

	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showTodoPage(ModelMap model)
	{
		model.addAttribute("todo",new Todo(0,"ramesh","",new Date(),false));
		return "todo";
	}
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo,BindingResult result,@RequestParam("targetDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		//service.addTodo("ramesh",todo.getDesc(),new Date(), false);
		//service.addTodo("ramesh",todo.getDesc(),todo.getTargetDate(), false);
		service.addTodo("ramesh",todo.getDesc(),date, false);
		model.clear();
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam("id") int id) {
		service.deleteTodo(id);
		model.clear();
		return "redirect:list-todos";

	}
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodo(ModelMap model,@RequestParam("id") int id)
	{
		Todo todo=service.retrieveTodo(id);
		model.addAttribute("todo",todo);
		return "todo";	
	}
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result,@RequestParam("targetDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date)
	{
		todo.setUser("ramesh");
		if(result.hasErrors())
		{
			return "todo";
		}
		service.updateTodo(todo);
		return "redirect:list-todos";
	}	
	
}
