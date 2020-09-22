package nonage_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nonage_shop.dao.AddressDao;
import nonage_shop.dto.Address;

public class AddressDaoImpl implements AddressDao {

	private static final AddressDaoImpl instance = new AddressDaoImpl();
	private Connection con;

	public AddressDaoImpl() {
		super();
	}

	public static AddressDaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<Address> selectAddressByAll() {
		String sql = "SELECT ZIP_NUM, SIDO, GUGUN, DONG, BUNJI, ZIP_CODE FROM ADDRESS";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Address> list = new ArrayList<Address>();
				do {
					list.add(getAddressList(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Address getAddressList(ResultSet rs) throws SQLException {
		String zipNum = rs.getString("ZIP_NUM");
		String sido = rs.getString("SIDO");
		String gugun = rs.getString("GUGUN");
		String dong = rs.getString("DONG");
		String bunji = rs.getString("BUNJI");
		String zipCode = rs.getString("ZIP_CODE");
		return new Address(zipNum, sido, gugun, dong, bunji, zipCode);
	}

	@Override
	public ArrayList<Address> listDongAddress(Address add) {
		String sql = "SELECT * FROM ADDRESS WHERE DONG LIKE '%'||?||'%'";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, add.getDong());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<Address> list = new ArrayList<Address>();
					do {
						list.add(getAddressList(rs));
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
