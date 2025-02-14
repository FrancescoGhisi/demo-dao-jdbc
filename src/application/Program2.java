package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Department findByID ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== Test 2: Department findAll ===");
        List<Department> departmentList = new ArrayList<>();
        departmentList.addAll(departmentDao.findAll());
        departmentList.forEach(System.out::println);

        System.out.println("\n=== Test 3: Department insert ===");
        department = new Department(null, "Smartwatches");
        departmentDao.insert(department);
        System.out.printf("Inserted! New id = %d%n", department.getId());

        System.out.println("\n=== Test 4: Department update ===");
        department = departmentDao.findById(1);
        department.setName("Laptops");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n=== Test 5: Department delete ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
