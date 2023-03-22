package shopping.service;

import java.util.List;

import shopping.dao.AddressDAO;
import shopping.dao.ProductDAO;
import shopping.dto.AddressDTO;

public class AddressServiceImp implements AddressService {
	
	private AddressDAO addressDao;
	
	public AddressServiceImp() {
		
	}
	
	public void setAddressDao(AddressDAO addressDao) {
		this.addressDao = addressDao;
	}
	
	@Override
	public void updateAddress(AddressDTO addressDTO) {
		addressDao.updateAddress(addressDTO);
	}

	@Override
	public void deleteAddress(int del_key) {
		addressDao.deleteAddress(del_key);
	}

	@Override
	public List<AddressDTO> selectAllAddresses(String id) {
		return addressDao.selectAllAddresses(id);
	}

	@Override
	public void insertAddress(AddressDTO addressDTO) {
		addressDao.insertAddress(addressDTO);
	}

}
