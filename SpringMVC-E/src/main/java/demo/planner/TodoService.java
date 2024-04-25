package demo.planner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
  public static List<Todo> t=new ArrayList<Todo>();
  private static int todoCount=3;
  static {
	  t.add(new Todo(1,"ramesh","Learn Spring MVC",new Date(),false));
	  t.add(new Todo(2,"ramesh","Learn Struts",new Date(),false));
	  t.add(new Todo(3,"ramesh","Learn Hibernate",new Date(),false));
  }
  public void addTodo(String u,String d,Date td,boolean isd)
  {
	 t.add(new Todo(++todoCount,u,d,td,isd)); 
  }
  public List<Todo> retrieveTodos(String user)
  {
	  List<Todo> filteredTodos=new ArrayList<Todo>();
	  for(Todo x:t)
	  {
		  if(x.getUser().equals(user))
		  {
			  filteredTodos.add(x);
		  }
	  }
	return filteredTodos;
  }
  public void deleteTodo(int id)
  {
	  Iterator<Todo> it=t.iterator();
	  while(it.hasNext())
	  {
		  Todo y=it.next();
		  if(y.getId()==id)
		  {
			  it.remove();
		  }
	  }
  }
  public void updateTodo(Todo z)
  {
	  t.remove(z);
	  t.add(z);
  }
  public Todo retrieveTodo(int id)
  {
	  for(Todo todo:t)
	  {
		  if(todo.getId()==id)
		  {
			  return todo;
		  }
	  }
	return null;
  }
}
