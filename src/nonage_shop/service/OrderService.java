package nonage_shop.service;

import java.sql.Connection;
import java.util.ArrayList;

import nonage_shop.dao.OrderDao;
import nonage_shop.dao.impl.OrderDaoImpl;
import nonage_shop.ds.JndiDS;
import nonage_shop.dto.Cart;
import nonage_shop.dto.Order;

public class OrderService {

	private static Connection con;
	private OrderDao dao;

	public OrderService() {
		con = JndiDS.getConnection();
		dao = OrderDaoImpl.getInstance();
		((OrderDaoImpl) dao).setCon(con);
	}

	public ArrayList<Order> listOrderById(String id, String result, int oseq) {
		return dao.listOrderById(id, result, oseq);
	}

	public ArrayList<Integer> selectSeqOrder(String id) {
		return dao.selectSeqOrder(id);
	}

	public int insertOrder(ArrayList<Cart> cart, String id) {
		return dao.insertOrder(cart, id);
	}

	public int insertOrderDetail(Order ord) {
		return dao.insertOrderDetail(ord);
	}

}
