import dao.DepartmentDao;
import dao.DepartmentDaoFactory;
import entities.Department;

import java.util.ArrayList;
import java.util.List;


public class Program2 {
    static void main(String[] args) {
        DepartmentDao depdao = DepartmentDaoFactory.createDepartment();

        System.out.println("==== Test 1 FindById ====");
        Department department = depdao.findById(1);
        System.out.println(department);


        System.out.println("==== Test 2 FindAll ====");
        List<Department> list = new ArrayList<>();

        list = depdao.findAll();
        for (Department id:list){
            System.out.println(id);
        }
        System.out.println("==== Test 3 Insert ====");
        Department newDep = new Department(null, "Food");
        depdao.insert(newDep);
        System.out.println("Inserted! new id: " + newDep.getId());

        System.out.println("==== Test 4 Delete ====");
        depdao.deleteById(7);

        System.out.println("==== Test 5 Update ====");
        department = depdao.findById(1);
        department.setName("Padarias");
        depdao.update(department);
    }
}
