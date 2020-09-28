package nonage_shop.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nonage_shop.dao.impl.OrderDaoImpl;
import nonage_shop.ds.JdbcUtil;
import nonage_shop.dto.Cart;
import nonage_shop.dto.Order;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoTest {

	private static Connection con;
	private OrderDao dao;

	@Before
	public void setUp() throws Exception {
		con = JdbcUtil.getConnection();
		dao = OrderDaoImpl.getInstance();
		((OrderDaoImpl) dao).setCon(con);
	}

	@Test
	public void test01ListOrderById() {
		System.out.printf("%s()%n", "test01ListOrderById");
		ArrayList<Order> list = dao.listOrderById("one", "1", 1);
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test02SelectSeqOrder() {
		System.out.printf("%s()%n", "test02SelectSeqOrder");
		ArrayList<Integer> list = dao.selectSeqOrder("two");
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test03InsertOrder() {
		System.out.printf("%s()%n", "test03InsertOrder");
		ArrayList<Cart> cart = null;
		int res = OrderDaoImpl.getInstance().insertOrder(cart, "two");
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", res);
	}

	@Test
	public void test04InsertOrderDetail() {
		System.out.printf("%s()%n", "test04InsertOrderDetail");
		Order insertOrderDetail = new Order(1, 1, 1);
		int res = OrderDaoImpl.getInstance().insertOrderDetail(insertOrderDetail);
		Assert.assertEquals(1, res);

		System.out.printf("%s%n%n", insertOrderDetail);
	}

}
