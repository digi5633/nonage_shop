package nonage_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import nonage_shop.dao.ProductDao;
import nonage_shop.dto.Product;

public class ProductDaoImpl implements ProductDao {

	private static final ProductDaoImpl instance = new ProductDaoImpl();
	private Connection con;

	public ProductDaoImpl() {

	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public static ProductDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Product> listNewProduct() {
		String sql = "SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE USEYN = 'y' ORDER BY PSEQ DESC";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Product> list = new ArrayList<Product>();
				do {
					list.add(getProductList(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Product getProductList(ResultSet rs) throws SQLException {
		int pseq = rs.getInt("PSEQ");
		String name = rs.getString("NAME");
		String kind = rs.getString("KIND");
		int price1 = rs.getInt("PRICE1");
		int price2 = rs.getInt("PRICE2");
		int price3 = rs.getInt("PRICE3");
		String content = rs.getString("CONTENT");
		String image = rs.getString("IMAGE");
		String useyn = rs.getString("USEYN");
		String bestyn = rs.getString("BESTYN");
		Timestamp indate = rs.getTimestamp("INDATE");
		return new Product(pseq, name, kind, price1, price2, price3, content, image, useyn, bestyn, indate);
	}

	@Override
	public ArrayList<Product> listBestProduct() {
		String sql = "SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE BESTYN = 'y' ORDER BY PSEQ DESC";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Product> list = new ArrayList<Product>();
				do {
					list.add(getProductList(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public Product getProduct(Product pdt) {
		String sql = "SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE PSEQ = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, pdt.getPseq());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getProductList(rs);
				}

			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public ArrayList<Product> listKindProduct(Product pdt) {
		String sql = "SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE KIND = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, pdt.getKind());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Product> list = new ArrayList<Product>();
					do {
						list.add(getProductList(rs));
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
