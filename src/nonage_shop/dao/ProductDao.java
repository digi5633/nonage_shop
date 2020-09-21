package nonage_shop.dao;

import java.util.ArrayList;

import nonage_shop.dto.Product;

public interface ProductDao {

	// 신상품 리스트 가져오기
	ArrayList<Product> listNewProduct();

	// 베스트 상품 리스트 가져오기
	ArrayList<Product> listBestProduct();

	// 상품번호로 상품 정보 한개 가져오기
	Product getProduct(Product pdt);

	// 상품종류별 상품 리스트 가져오기
	ArrayList<Product> listKindProduct(Product pdt);

}
