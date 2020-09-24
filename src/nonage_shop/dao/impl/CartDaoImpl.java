package nonage_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
		String sql = "SELECT CSEQ, ID, PSEQ, QUANTITY, RESULT, INDATE FROM CART";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Cart> list = new ArrayList<Cart>();
				do {
					list.add(getCartList(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Cart getCartList(ResultSet rs) throws SQLException {
		int cseq = rs.getInt("cseq");
		String id = rs.getString("id");
		int pseq = rs.getInt("pseq");
		int quantity = rs.getInt("quantity");
		Timestamp indate = rs.getTimestamp("INDATE");
		return new Cart(cseq, id, pseq, quantity, indate);
	}

	@Override
	public int insertCart(Cart cart) {
		String sql = "INSERT INTO CART(ID, PSEQ, QUANTITY) VALUES(?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, cart.getId());
			pstmt.setInt(2, cart.getPseq());
			pstmt.setInt(3, cart.getQuantity());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int deleteCart(Cart cart) {
		String sql = "DELETE FROM CART WHERE CSEQ = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, cart.getCseq());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public ArrayList<Cart> getCart(Cart cart) {
		String sql = "SELECT CSEQ, ID, PSEQ, QUANTITY, RESULT, INDATE FROM CART WHERE ID = ? ORDER BY CSEQ DESC";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, cart.getId());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Cart> list = new ArrayList<Cart>();
					do {
						list.add(getCartList(rs));
					} while (rs.next());
					return list;
				}

			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

}
