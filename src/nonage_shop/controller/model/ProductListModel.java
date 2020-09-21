package nonage_shop.controller.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nonage_shop.controller.Command;
import nonage_shop.dto.Product;
import nonage_shop.service.ProductService;

public class ProductListModel implements Command {

	private ProductService service = new ProductService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET");

			ArrayList<Product> productList = service.listNewProduct();
			request.setAttribute("productList", productList);

			ArrayList<Product> bestProductList = service.listBestProduct();
			request.setAttribute("bestProductList", bestProductList);

			return "index.jsp";

		} else {
			System.out.println("POST");
			
			return null;
		}

	}

}
