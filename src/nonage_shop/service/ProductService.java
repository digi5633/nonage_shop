package nonage_shop.service;

import java.sql.Connection;
import java.util.ArrayList;

import nonage_shop.dao.ProductDao;
import nonage_shop.dao.impl.ProductDaoImpl;
import nonage_shop.ds.JndiDS;
import nonage_shop.dto.Product;

public class ProductService {

	private static Connection con;
	private ProductDao dao;

	public ProductService() {
		con = JndiDS.getConnection();
		dao = ProductDaoImpl.getInstance();
		((ProductDaoImpl) dao).setCon(con);
	}

	public ArrayList<Product> listNewProduct() {
		return dao.listNewProduct();
	}

	public ArrayList<Product> listBestProduct() {
		return dao.listBestProduct();
	}

	public Product getProduct(Product pdt) {
		return dao.getProduct(pdt);
	}

	public ArrayList<Product> listKindProduct(Product pdt) {
		return dao.listKindProduct(pdt);
	}

}
