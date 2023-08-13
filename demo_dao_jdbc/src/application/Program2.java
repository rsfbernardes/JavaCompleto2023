package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println();
		System.out.println("=== TESTE 1 DEPARTMENT FIND BY ID ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println();
		System.out.println("=== TESTE 2 DEPARTMENT FIND ALL ===");
		List<Department> departmentListFindAll = departmentDao.findAll();
		for (Department dept : departmentListFindAll) {
			System.out.println(dept);
		}
		
		System.out.println();
		System.out.println("=== TESTE 3 DEPARTMENT CREATE ===");
		System.out.print("Enter the name of the new department: ");
		String name = sc.nextLine();
		Department newDepartment = new Department(null, name);
		departmentDao.create(newDepartment);
		System.out.println("Created! New id = " + newDepartment.getId());
		
		System.out.println();
		System.out.println("=== TESTE 4 DEPARTMENT UPDATE ===");
		System.out.print("Enter id for update test: ");
		int id = sc.nextInt();
		department = departmentDao.findById(id);
		System.out.print("Enter the name of the department: ");
		sc.nextLine();
		name = sc.nextLine();
		department.setName(name);
		departmentDao.update(department);
		System.out.println("Updated completed!");
		
		System.out.println();
		System.out.println("=== TESTE 5 DEPARTMENT DELETE ===");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
