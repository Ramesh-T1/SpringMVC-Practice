package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("username")
@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(ModelMap model, @RequestParam("username") String un,
			@RequestParam("password") String pw) {
		System.out.println(un);
		System.out.println(pw);
		if (service.validateUser(un, pw)) {
			model.addAttribute("username", un);
			model.addAttribute("password", pw);
			// model.put("username",un);
			// model.put("password",pw);
			return "welcome";
		} else {
			model.put("errormsg", "InvalidCredentials");
			return "login";
		}
	}
}
