package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nonage_shop.controller.Command;
import nonage_shop.dto.Member;
import nonage_shop.service.MemberService;

public class IdCheckModel implements Command {

	private MemberService service = new MemberService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			String id = request.getParameter("id").trim();
			System.out.println("id > " + id);

			int message = service.getId(new Member(id));
			System.out.println("message > " + message);

			request.setAttribute("id", id);
			request.setAttribute("message", message);

			return "member/idCheck.jsp";

		} else {
			System.out.println("POST");

			String id = request.getParameter("id").trim();
			System.out.println("id > " + id);

			int message = service.getId(new Member(id));
			System.out.println("message > " + message);

			request.setAttribute("id", id);
			request.setAttribute("message", message);

			return "member/idCheck.jsp";
		}

	}

}
