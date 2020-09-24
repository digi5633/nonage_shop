package nonage_shop.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nonage_shop.dao.impl.CartDaoImpl;
import nonage_shop.ds.JdbcUtil;
import nonage_shop.dto.Cart;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CartDaoTest {

	private static Connection con;
	private CartDao dao;

	@Before
	public void setUp() throws Exception {
		con = JdbcUtil.getConnection();
		dao = CartDaoImpl.getInstance();
		((CartDaoImpl) dao).setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test04SelectCartByAll() {
		System.out.println("test04SelectCartByAll");
		ArrayList<Cart> list = dao.selectCartByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test01InsertCart() {
		System.out.printf("%s()%n", "test01InsertCart");
		Cart insertCart = new Cart("two", 1, 1);
		int res = CartDaoImpl.getInstance().insertCart(insertCart);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", insertCart);
	}

	@Test
	public void test03DeleteCart() {
		System.out.printf("%s()%n", "test03DeleteCart");
		Cart deleteCart = new Cart(4);
		int res = CartDaoImpl.getInstance().deleteCart(deleteCart);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", deleteCart);
	}

	@Test
	public void test04GetCart() {
		System.out.printf("%s()%n", "test04GetCart");
		ArrayList<Cart> list = dao.getCart(new Cart("two"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

}
