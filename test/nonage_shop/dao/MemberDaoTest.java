package nonage_shop.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nonage_shop.dao.impl.MemberDaoImpl;
import nonage_shop.ds.JdbcUtil;
import nonage_shop.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {

	private static Connection con;
	private MemberDao dao;

	@Before
	public void setUp() throws Exception {
		con = JdbcUtil.getConnection();
		dao = MemberDaoImpl.getInstance();
		((MemberDaoImpl) dao).setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test05SelectMemberByAll() {
		System.out.println("test05SelectMemberByAll");
		List<Member> list = dao.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test04SelectMemberByUserId() {
		System.out.printf("%s()%n", "test04SelectMemberByUserId");
		Member getMember = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("one"));
		Assert.assertNotNull(getMember);

		System.out.printf("%s%n%n", getMember);
	}

	@Test
	public void test01InsertMember() {
		System.out.printf("%s()%n", "test01InsertMember");
		Member insertMember = new Member("three", "3333", "김자바", "aaaa@bbbb.com", "333-333", "대구시", "019-999-9999");
		int res = MemberDaoImpl.getInstance().insertMember(insertMember);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", insertMember);
	}

	@Test
	public void test02UpdateMember() {
		System.out.printf("%s()%n", "test02UpdateMember");
		Member updateMember = new Member("three", "4444", "이자바", "ccc@dddd.com","555-555","제주도", "010-7777-7777");
		int res = MemberDaoImpl.getInstance().updateMember(updateMember);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", updateMember);
	}

	@Test
	public void test03DeleteMember() {
		System.out.printf("%s()%n", "test03DeleteMember");
		Member deleteMember = new Member("three");
		int res = MemberDaoImpl.getInstance().deleteMember(deleteMember);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", deleteMember);
	}

}
