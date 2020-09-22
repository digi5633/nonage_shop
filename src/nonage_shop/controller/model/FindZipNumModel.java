package nonage_shop.controller.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nonage_shop.controller.Command;
import nonage_shop.dto.Address;
import nonage_shop.service.AddressService;

public class FindZipNumModel implements Command {

	private AddressService service = new AddressService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			return "member/findZipNum.jsp";

		} else {
			System.out.println("POST");

			String dong = request.getParameter("dong").trim();
			System.out.println("dong > " + dong);

			if (dong != null && dong.trim().equals("") == false) {
				ArrayList<Address> dongList = service.listDongAddress(new Address(dong));
				System.out.println("dongList > " + dongList);

				request.setAttribute("dongList", dongList);
			}
			return "member/findZipNum.jsp";
		}

	}

}
