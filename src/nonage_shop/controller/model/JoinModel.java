package nonage_shop.controller.model;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import nonage_shop.controller.Command;
import nonage_shop.dto.Member;
import nonage_shop.service.MemberService;

public class JoinModel implements Command {

	private MemberService service = new MemberService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			return "member/memberJoin.jsp";

		} else {
			System.out.println("POST");

			Gson gson = new Gson();
			Member addMember = gson.fromJson(new InputStreamReader(request.getInputStream(), "UTF-8"), Member.class);
			System.out.println(addMember);

			int res = service.insertMember(addMember);
			response.getWriter().print(res);

			return "member/login.jsp";
		}

	}

}
