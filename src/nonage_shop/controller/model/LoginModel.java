package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nonage_shop.controller.Command;
import nonage_shop.dto.Member;
import nonage_shop.service.MemberService;

public class LoginModel implements Command {

	private MemberService service = new MemberService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			
			return "member/login.jsp";

		} else {
			System.out.println("POST");
			
			String url = "member/login_fail.jsp";
			
			HttpSession session = request.getSession();
			
			String id = request.getParameter("id").trim();
			String pwd = request.getParameter("pwd").trim();
			System.out.println("id > " + id + ", pwd > " + pwd);
			
			Member getId = service.selectMemberByUserId(new Member(id));
			System.out.println("getId > " + getId);
		
			if (getId.getPwd().equals(pwd)) {	// 성공
				session.removeAttribute(id);
				session.setAttribute("loginUser", getId);
				url = "index2.jsp";
			}
			return url;
		}

	}

}
