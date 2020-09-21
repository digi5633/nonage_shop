package nonage_shop.controller.model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nonage_shop.controller.Command;
import nonage_shop.dto.Product;
import nonage_shop.service.ProductService;

public class ProductDetailModel implements Command {
	
	private ProductService service = new ProductService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");
			
			int produtcNo = Integer.parseInt(request.getParameter("pseq").trim());
			System.out.println("produtcNo > " + produtcNo);
			
			Product getProduct = service.getProduct(new Product(produtcNo));
			System.out.println("getProduct > " + getProduct);
			
			request.setAttribute("getProduct", getProduct);
			
			return "product/productDetail.jsp";
			
		} else {
			System.out.println("POST");
			
			return null;
		}
		
	}

}
