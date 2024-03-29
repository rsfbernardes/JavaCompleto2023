package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println();
		System.out.println("=== TESTE 1 SELLER FIND BY ID ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== TESTE 2 SELLER FIND BY DEPARTMENT ===");
		Department department = new Department(2, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		for (Seller seller2 : sellerList) {
			System.out.println(seller2);
		}
		
		System.out.println();
		System.out.println("=== TESTE 3 SELLER FIND ALL ===");
		List<Seller> sellerListFindAll = sellerDao.findAll();
		for (Seller seller3 : sellerListFindAll) {
			System.out.println(seller3);
		}
		
		System.out.println();
		System.out.println("=== TESTE 4 SELLER CREATE ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.create(newSeller);
		System.out.println("Created! New id = " + newSeller.getId());
		
		System.out.println();
		System.out.println("=== TESTE 5 SELLER UPDATE ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.println("Updated completed!");
		
		System.out.println();
		System.out.println("=== TESTE 6 SELLER DELETE ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
