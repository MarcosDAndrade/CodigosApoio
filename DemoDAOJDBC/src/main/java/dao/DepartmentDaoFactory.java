package dao;

import db.DB;
import entities.Department;
import impl.DepartmentDaoJDBC;

public class DepartmentDaoFactory {
    public static DepartmentDao createDepartment(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }

}
