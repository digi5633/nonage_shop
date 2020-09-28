package nonage_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import nonage_shop.dao.OrderDao;
import nonage_shop.dto.Cart;
import nonage_shop.dto.Order;

public class OrderDaoImpl implements OrderDao {

	private static final OrderDaoImpl instance = new OrderDaoImpl();
	private Connection con;

	public OrderDaoImpl() {
		super();
	}

	public static OrderDaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<Order> listOrderById(String id, String result, int oseq) {
		String sql = "SELECT * FROM ORDER_VIEW WHERE ID = ? AND RESULT LIKE '%'||?||'%' AND OSEQ = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);
			pstmt.setString(2, result);
			pstmt.setInt(3, oseq);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Order> list = new ArrayList<Order>();
					do {
						list.add(getOrderList(rs));
					} while (rs.next());
					return list;
				}

			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Order getOrderList(ResultSet rs) throws SQLException {
		int odseq = rs.getInt("ODSEQ");
		int oseq = rs.getInt("OSEQ");
		String id = rs.getString("ID");
		Timestamp indate = rs.getTimestamp("INDATE");
		String mname = rs.getString("MNAME");
		String zipNum = rs.getString("ZIP_NUM");
		String address = rs.getString("ADDRESS");
		String phone = rs.getString("PHONE");
		int pseq = rs.getInt("PSEQ");
		String pname = rs.getString("PNAME");
		int quantity = rs.getInt("QUANTITY");
		int price2 = rs.getInt("PRICE2");
		String result = rs.getString("RESULT");
		return new Order(odseq, oseq, id, indate, mname, zipNum, address, phone, pseq, pname, quantity, price2, result);
	}

	@Override
	public ArrayList<Integer> selectSeqOrder(String id) {
		String sql = "SELECT DISTINCT OSEQ FROM ORDER_VIEW WHERE ID = ? AND RESULT= '1' ORDER BY OSEQ DESC";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					do {
						list.add(getSeqOrder(rs));
					} while (rs.next());
					return list;
				}

			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Integer getSeqOrder(ResultSet rs) throws SQLException {
		int oseq = rs.getInt("OSEQ");
		return oseq;
	}

	@Override
	public int insertOrder(ArrayList<Cart> cart, String id) {
		String sql = "INSERT INTO ORDERS(ID) VALUES(?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int insertOrderDetail(Order ord) {
		String sql = "INSERT INTO ORDER_DETAIL(OSEQ, PSEQ, QUANTITY) VALUES(?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, ord.getOseq());
			pstmt.setInt(2, ord.getPseq());
			pstmt.setInt(3, ord.getQuantity());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
