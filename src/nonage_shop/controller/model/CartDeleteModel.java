package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nonage_shop.controller.Command;
import nonage_shop.service.CartService;

public class CartDeleteModel implements Command {

	private CartService service = new CartService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			return null;

		} else {
			System.out.println("POST");

			String[] cseqArr = request.getParameterValues("cseq");

			for (String cseq : cseqArr) {
				System.out.println(cseq);
				service.deleteCart(Integer.parseInt("cseq"));
			}

			return "mypage/cartList.jsp";
		}

	}

}
