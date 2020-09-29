package nonage_shop.controller.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nonage_shop.controller.Command;
import nonage_shop.dto.Member;
import nonage_shop.dto.Order;
import nonage_shop.service.OrderService;

public class OrderDetailModel implements Command {

	private OrderService service = new OrderService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			String url = "mypage/orderDetail.jsp";

			HttpSession session = request.getSession();

			Member loginUser = (Member) session.getAttribute("loginUser");
			System.out.println("loginUser > " + loginUser);

			if (loginUser == null) {
				url = "member/login.jsp";
			} else {
				int oseq = Integer.parseInt(request.getParameter("oseq"));

				ArrayList<Order> orderList = service.listOrderById(loginUser.getId(), "%", oseq);

				int totalPrice = 0;
				for (Order order : orderList) {
					totalPrice += order.getPrice2() * order.getQuantity();
				}
				request.setAttribute("orderDetail", orderList.get(0));
				request.setAttribute("orderList", orderList);
				request.setAttribute("totalPrice", totalPrice);
			}
			return url;

		} else {
			System.out.println("POST");

			return null;
		}

	}

}
