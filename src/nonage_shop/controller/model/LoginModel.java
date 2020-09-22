package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nonage_shop.controller.Command;

public class LoginModel implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			
			return "member/login.jsp";

		} else {
			System.out.println("POST");
			
			return "member/login.jsp";

		}

	}

}
