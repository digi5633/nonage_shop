package nonage_shop.dao;

import java.util.ArrayList;

import nonage_shop.dto.Cart;

public interface CartDao {
	
	// 카트 리스트 가져오기
	ArrayList<Cart> selectCartByAll();
	
	// 카트 가져오기
	ArrayList<Cart> getCart(Cart cart);
	
	// 카트 추가
	int insertCart(Cart cart);
	
	// 카트 삭제
	int deleteCart(Cart cart);

}
