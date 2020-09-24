package nonage_shop.service;

import java.sql.Connection;
import java.util.ArrayList;

import nonage_shop.dao.CartDao;
import nonage_shop.dao.impl.CartDaoImpl;
import nonage_shop.ds.JndiDS;
import nonage_shop.dto.Cart;

public class CartService {

	private static Connection con;
	private CartDao dao;

	public CartService() {
		con = JndiDS.getConnection();
		dao = CartDaoImpl.getInstance();
		((CartDaoImpl) dao).setCon(con);
	}

	public ArrayList<Cart> selectCartByAll() {
		return dao.selectCartByAll();
	}

	public int insertCart(Cart cart) {
		return dao.insertCart(cart);
	}

	public int deleteCart(Cart cart) {
		return dao.deleteCart(cart);
	}

	public ArrayList<Cart> getCart(Cart cart) {
		return dao.getCart(cart);
	}

}
