package nonage_shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import nonage_shop.dao.QnADao;
import nonage_shop.dto.QnA;

public class QnADaoImpl implements QnADao {

	private static final QnADaoImpl instance = new QnADaoImpl();
	private Connection con;

	public QnADaoImpl() {
		super();
	}

	public static QnADaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public ArrayList<QnA> listQnA(String id) {
		String sql = "SELECT * FROM QNA WHERE id = ? ORDER BY QSEQ DESC";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				ArrayList<QnA> list = new ArrayList<QnA>();
				do {
					list.add(getQnAList(rs));
				} while (rs.next());
				return list;
			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private QnA getQnAList(ResultSet rs) throws SQLException {
		int qseq = rs.getInt("qseq");
		String subject = rs.getString("subject");
		String content = rs.getString("content");
		String reply = rs.getString("reply");
		String id = rs.getString("id");
		String rep = rs.getString("rep");
		Timestamp indate = rs.getTimestamp("indate");
		return new QnA(qseq, subject, content, reply, id, rep, indate);
	}

	@Override
	public QnA getQnA(int qseq) {
		String sql = "SELECT * FROM QNA WHERE QSEQ = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, qseq);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getQnAList(rs);
				}

			}

		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	@Override
	public int insertQnA(QnA qna, String id) {
		String sql = "INSERT INTO QNA(SUBJECT, CONTENT, ID) VALUES(?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
