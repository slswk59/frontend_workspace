package member.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// http://localhost:8090/myapp/signup.do
@Controller
public class MemberController {
	
		@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
		public String signup() {
			
			return "signup";
		}

}
