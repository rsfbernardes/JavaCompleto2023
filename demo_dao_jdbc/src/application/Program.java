package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1 SELLER FIND BY ID ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TESTE 2 SELLER FIND BY DEPARTMENT ===");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		for (Seller seller2 : sellerList) {
			System.out.println(seller2);
		}
		
		System.out.println("=== TESTE 3 SELLER FIND ALL ===");
		List<Seller> sellerListFindAll = sellerDao.findAll();
		for (Seller seller3 : sellerListFindAll) {
			System.out.println(seller3);
		}
	}
}
