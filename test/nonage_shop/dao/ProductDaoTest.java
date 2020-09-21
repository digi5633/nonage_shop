package nonage_shop.dao;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import nonage_shop.dao.impl.ProductDaoImpl;
import nonage_shop.ds.JdbcUtil;
import nonage_shop.dto.Product;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest {

	private static Connection con;
	private ProductDao dao;

	@Before
	public void setUp() throws Exception {
		con = JdbcUtil.getConnection();
		dao = ProductDaoImpl.getInstance();
		((ProductDaoImpl) dao).setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test01ListNewProduct() {
		System.out.println("test01ListNewProduct");
		List<Product> list = dao.listNewProduct();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test02ListBestProduct() {
		System.out.println("test02ListBestProduct");
		List<Product> list = dao.listBestProduct();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test03GetProduct() {
		System.out.printf("%s()%n", "test03GetProduct");
		Product selectProduct = ProductDaoImpl.getInstance().getProduct(new Product(1));
		Assert.assertNotNull(selectProduct);

		System.out.printf("%s%n%n", selectProduct);
	}

	@Test
	public void test04ListKindProduct() {
		System.out.printf("%s()%n", "test04ListKindProduct");
		List<Product> list = dao.listKindProduct(new Product("3"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);

	}

}
