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
import nonage_shop.service.OrderService;

public class OrderInsertModel implements Command {

	private OrderService orderService = new OrderService();
	private CartService cartService = new CartService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			return "mypage/orderList.jsp";

		} else {
			System.out.println("POST");

			String url = "OrderList.do";

			HttpSession session = request.getSession();

			Member loginUser = (Member) session.getAttribute("loginUser");
			System.out.println("loginUser > " + loginUser);

			if (loginUser == null) {
				url = "member/login.jsp";
			} else {
				ArrayList<Cart> cartList = cartService.getCart(loginUser.getId());
				System.out.println("cartList > " + cartList);

				int maxOseq = orderService.insertOrder(cartList, loginUser.getId());
				System.out.println("maxOseq > " + maxOseq);
				
				url = "OrderList.do?oseq="+maxOseq;

				response.sendRedirect(url);

			}

		}
		return null;

	}

}
