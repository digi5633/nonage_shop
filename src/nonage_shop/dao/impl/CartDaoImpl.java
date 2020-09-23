package nonage_shop.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;

import nonage_shop.dao.CartDao;
import nonage_shop.dto.Cart;

public class CartDaoImpl implements CartDao {

	private static final CartDaoImpl instance = new CartDaoImpl();
	private Connection con;

	public CartDaoImpl() {
		super();
	}

	public static CartDaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<Cart> selectCartByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

}
