package nonage_shop.controller.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nonage_shop.controller.Command;
import nonage_shop.dto.Cart;
import nonage_shop.dto.Member;
import nonage_shop.service.CartService;

public class CartListModel implements Command {

	private CartService service = new CartService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			String url = "mypage/cartList.jsp";

			HttpSession session = request.getSession();

			Member loginUser = (Member) session.getAttribute("loginUser");
			System.out.println("loginUser > " + loginUser);
			
			if (loginUser == null) {
				url = "member/login.jsp";
			} else {
				ArrayList<Cart> getCart = service.getCart(new Cart(loginUser.getId()));
				int totalPrice = 0;

				for (Cart cart : getCart) {
					totalPrice += cart.getPrice2() * cart.getQuantity();
				}
				request.setAttribute("getCart", getCart);
				request.setAttribute("totalPrice", totalPrice);
			}
			return url;

		} else {
			System.out.println("POST");

			return null;
		}

	}

}
