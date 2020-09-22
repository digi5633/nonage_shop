package nonage_shop.dao;

import java.util.ArrayList;

import nonage_shop.dto.Address;

public interface AddressDao {

	// 주소 리스트 가져오기
	ArrayList<Address> selectAddressByAll();

	// 시도 주소 리스트 가져오기
	// ArrayList<Address> listSidoAddress(Address add);

	// 구군 주소 리스트 가져오기
	// ArrayList<Address> listGugunAddress(Address add);

	// 동 주소 가져오기
	ArrayList<Address> listDongAddress(Address add);

}
