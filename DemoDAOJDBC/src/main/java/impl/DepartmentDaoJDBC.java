package impl;

import dao.DepartmentDao;
import db.DB;
import db.DbException;
import entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO department " +
                            "(Name) " +
                            "VALUES " +
                            "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rowsAffeted = st.executeUpdate();

            if (rowsAffeted > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error, no row affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE department " +
                    "SET Name = ? WHERE Id= ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            int rowsUpdate = st.executeUpdate();

            if (rowsUpdate > 0){
                System.out.println("Success! Rows update: "  + rowsUpdate);
            } else {
                System.out.println("Unexpected error, no rows affected");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM department WHERE id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            System.out.println("Success! Rows Affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM department WHERE id = ?");
            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Department obj = instantiateDepartment(rs);
                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department ORDER BY id");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
                Department depId = map.get(rs.getInt("Id"));
                if (depId == null) {
                    //Se for nulo, vai instanciar um novo ID
                    depId = instantiateDepartment(rs);
                    map.put(rs.getInt("Id"), depId);
                }
                Department obj = instantiateDepartment(rs);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("name"));
        return dep;
    }
}
