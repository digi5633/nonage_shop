package nonage_shop.dao;

import java.util.ArrayList;

import nonage_shop.dto.Cart;
import nonage_shop.dto.Order;

public interface OrderDao {
	
	// 주문 내역 리스트
	ArrayList<Order> listOrderById(String id, String result, int oseq);
	
	// 진행중인 주문 내역
	ArrayList<Integer> selectSeqOrder(String id);
	
	// 주문하기
	int insertOrder(ArrayList<Cart> cart, String id);
	
	// 주문 상세보기
	int insertOrderDetail(Order ord);
	
}
