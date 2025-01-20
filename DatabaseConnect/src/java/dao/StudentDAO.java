/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author kminh
 */
public class StudentDAO {
    public static ArrayList<Student> getStudents() {
        DBContext db = DBContext.getInstance();
        ArrayList<Student> students = new ArrayList<>();
        
        try {
            String sql = """
                         SELECT * FROM Students
                         """;
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                /*Student student = new Student(
                rs.getString("rollNumber"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("birthday"),
                rs.getString("gender"),
                rs.getString("english1"),
                rs.getString("english2"),
                rs.getString("english3"),
                rs.getString("english4"),
                rs.getInt("specId")
                );*/
                
                Student student = new Student();
                student.setRollNumber(rs.getString("rollNumber"));
                student.setLastName(rs.getString("lastName"));
                student.setFirstName(rs.getString("firstName"));
                student.setDate(rs.getString("birthday"));
                student.setGender(rs.getString("gender"));
                student.setEnglish1(rs.getString("english1"));
                student.setEnglish2(rs.getString("english2"));
                student.setEnglish3(rs.getString("english3"));
                student.setEnglish4(rs.getString("english4"));
                student.setSpecId(rs.getInt("specId"));
                students.add(student);
            }
        } catch (SQLException e) {
            return null;
        }
        
        if (students.isEmpty()) {
            return null;
        } else {
            return students;
        }
        
    }
}
