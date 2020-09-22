package nonage_shop.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nonage_shop.dao.impl.AddressDaoImpl;
import nonage_shop.ds.JdbcUtil;
import nonage_shop.dto.Address;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressDaoTest {

	private static Connection con;
	private AddressDao dao;

	@Before
	public void setUp() throws Exception {
		con = JdbcUtil.getConnection();
		dao = AddressDaoImpl.getInstance();
		((AddressDaoImpl) dao).setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectAddressByAll() {
		System.out.println("test01SelectAddressByAll");
		List<Address> list = dao.selectAddressByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test02ListDongAddress() {
		System.out.printf("%s()%n", "test02ListDongAddress");
		List<Address> list = dao.listDongAddress(new Address("삼성"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

}
