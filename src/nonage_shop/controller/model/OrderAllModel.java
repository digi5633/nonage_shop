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

public class OrderAllModel implements Command {

	private OrderService service = new OrderService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			String url = "mypage/mypage.jsp";

			HttpSession session = request.getSession();

			Member loginUser = (Member) session.getAttribute("loginUser");
			System.out.println("loginUser > " + loginUser);

			if (loginUser == null) {
				url = "member/login.jsp";
			} else {

				ArrayList<Integer> oseqList = service.selectSeqOrder(loginUser.getId());
				System.out.println("oseqList > " + oseqList);

				ArrayList<Order> orderList = new ArrayList<Order>();
				System.out.println("orderList > " + orderList);

				for (int oseq : oseqList) {
					ArrayList<Order> orderListIng = service.listOrderById(loginUser.getId(), "%", oseq);
					System.out.println("orderListIng > " + orderListIng);

					Order order = orderListIng.get(0);
					order.setPname(order.getPname() + " 외 " + orderListIng.size() + "건");

					int totalPrice = 0;
					for (Order ovo : orderListIng) {
						totalPrice += ovo.getPrice2() * ovo.getQuantity();
					}
					order.setPrice2(totalPrice);
					orderList.add(order);
				}
				request.setAttribute("title", "총 주문 내역");
				request.setAttribute("orderList", orderList);
			}
			return url;

		} else {
			System.out.println("POST");

			return null;
		}

	}

}
