package nonage_shop.controller;

import nonage_shop.dto.Product;

public class Test {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Product p = new Product();
		System.out.println(p);
		// reflexing 기법을 이용

		Class<?> cls = Class.forName("nonage_shop.dto.Product");
		Product p2 = (Product) cls.newInstance();
		System.out.println(p2);

	}

}
