package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {

	void create(Seller seller);
	void update(Seller seller);
	void deleteById(Integer Id);
	Seller findById(Integer id);
	List<Seller> findAll();
}
