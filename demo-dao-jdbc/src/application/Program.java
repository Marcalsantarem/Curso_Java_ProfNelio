package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll =====");
		List<Seller> listAll = sellerDao.findAll();
		listAll.forEach(System.out::println);

		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Marcal", "marcal@gmail.com", new Date(), 10.00, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println(newSeller);
		
		System.out.println("\n=== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Phoebe Buffay");
		sellerDao.update(seller);
		seller = sellerDao.findById(1);
		System.out.println(seller);
		

		System.out.println("\n=== TEST 6: seller delete =====");
		seller = sellerDao.findById(10);
		System.out.println(seller);
		sellerDao.deleteById(10);
		seller = sellerDao.findById(10);
		System.out.println(seller);
	}

}
