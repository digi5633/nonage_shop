package nonage_shop.service;

import java.sql.Connection;
import java.util.ArrayList;

import nonage_shop.dao.AddressDao;
import nonage_shop.dao.impl.AddressDaoImpl;
import nonage_shop.ds.JndiDS;
import nonage_shop.dto.Address;

public class AddressService {

	private static Connection con;
	private AddressDao dao;

	public AddressService() {
		con = JndiDS.getConnection();
		dao = AddressDaoImpl.getInstance();
		((AddressDaoImpl) dao).setCon(con);
	}

	public ArrayList<Address> selectAddressByAll() {
		return dao.selectAddressByAll();
	}

	public ArrayList<Address> listDongAddress(Address add) {
		return dao.listDongAddress(add);
	}

}
