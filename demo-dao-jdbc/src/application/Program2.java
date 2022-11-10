package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	
	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById =====");
		Department department = departmentDao.findById(3);		
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: seller findAll =====");
		List<Department> listAll = departmentDao.findAll();
		listAll.forEach(System.out::println);

		System.out.println("\n=== TEST 3: department insert =====");
		Department newDep = new Department(null, "Games");
		departmentDao.insert(newDep);
		System.out.println(newDep);
		
		System.out.println("\n=== TEST 4: department update =====");
		department = departmentDao.findById(1);
		department.setName("Dep Name Test");
		departmentDao.update(department);
		department = departmentDao.findById(1);
		System.out.println(department);
		

		System.out.println("\n=== TEST 5: seller delete =====");
		department = departmentDao.findById(6);
		System.out.println(department);
		departmentDao.deleteById(6);
		department = departmentDao.findById(10);
		System.out.println(department);
	}

}
