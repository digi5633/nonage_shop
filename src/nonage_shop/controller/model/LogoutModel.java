package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nonage_shop.controller.Command;

public class LogoutModel implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			HttpSession session = request.getSession(false);

			if (session != null) {
				session.invalidate();
			}

			return "index2.jsp";

		} else {
			System.out.println("POST");

			return null;
		}

	}

}
