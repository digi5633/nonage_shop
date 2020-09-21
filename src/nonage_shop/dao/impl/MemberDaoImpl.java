package nonage_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import nonage_shop.dao.MemberDao;
import nonage_shop.dto.Member;

public class MemberDaoImpl implements MemberDao {

	private static final MemberDaoImpl instance = new MemberDaoImpl();
	private Connection con;

	public MemberDaoImpl() {

	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public static MemberDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Member> selectMemberByAll() {
		String sql = "SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, USEYN, INDATE FROM MEMBER ORDER BY NAME ASC";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<Member> list = new ArrayList<Member>();
				do {
					list.add(getMemberList(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Member getMemberList(ResultSet rs) throws SQLException {
		String id = rs.getString("ID");
		String pwd = rs.getString("PWD");
		String name = rs.getString("NAME");
		String email = rs.getString("EMAIL");
		String zipNum = rs.getString("ZIP_NUM");
		String address = rs.getString("ADDRESS");
		String phone = rs.getString("PHONE");
		String useyn = rs.getString("USEYN");
		Timestamp indate = rs.getTimestamp("INDATE");
		return new Member(id, pwd, name, email, zipNum, address, phone, useyn, indate);
	}

	@Override
	public Member selectMemberByUserId(Member member) {
		String sql = "SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, USEYN, INDATE FROM MEMBER WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getMemberList(rs);
				}

			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}
	
	@Override
	public int getId(Member member) {
		String sql = "SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, USEYN, INDATE FROM MEMBER WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int insertMember(Member member) {
		String sql = "INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getZipNum());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getPhone());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int updateMember(Member member) {
		String sql = "UPDATE MEMBER SET PWD=?, NAME=?, EMAIL=?, ZIP_NUM=?, ADDRESS=?, PHONE=? WHERE ID=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getZipNum());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public int deleteMember(Member member) {
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, member.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
