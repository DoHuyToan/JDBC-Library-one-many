package library.service.card;

import library.config.ConnectionSingleton;
import library.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idS");
                String name = rs.getString("name");
                String className = rs.getString("className");
                studentList.add(new Student(id, name, className));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findById(int id) {
        Student student = null;
        try {
            PreparedStatement ps = connection.prepareStatement("select * from student where idS=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String className = rs.getString("className");
                student = new Student(name, className);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void insert(Student student) throws SQLException {

    }

    @Override
    public void update(Student student) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }


}
