package model.dao;

import model.entities.Seller;

public interface SellerDao {

	void create(Seller seller);
	void update(Seller seller);
	void deleteById(Integer Id);
	void findById(Integer id);
	void findAll();
}
