package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nonage_shop.controller.Command;
import nonage_shop.dto.Cart;
import nonage_shop.dto.Member;
import nonage_shop.service.CartService;

public class CartInsertModel implements Command {

	private CartService service = new CartService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			return null;

		} else {
			System.out.println("POST");

			String url = "CartList.do";

			HttpSession session = request.getSession();

			Member loginUser = (Member) session.getAttribute("loginUser");
			System.out.println("loginUser > " + loginUser);

			if (loginUser == null) {
				url = "member/login.jsp";
			} else {
				Cart cart = new Cart();
				cart.setId(loginUser.getId());
				cart.setPseq(Integer.parseInt(request.getParameter("pseq")));
				cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));

				service.insertCart(cart);
				System.out.println("cart > " + cart);

				response.sendRedirect(url);

			}

		}
		return null;
	}

}
