package demo;

import org.springframework.stereotype.Service;

@Service
public class LoginService 
{
  public boolean validateUser(String user,String password)
  {
	  if(user.equalsIgnoreCase("ramesh")&&password.equalsIgnoreCase("hayabusa"))
		  return true;
	  else
		  return false;
  }
}
