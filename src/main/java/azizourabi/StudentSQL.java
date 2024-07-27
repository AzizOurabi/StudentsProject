package azizourabi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentSQL {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("mydriver");
            String url = "jdbc:mysql://localhost/servletdb";
            con = DriverManager.getConnection(url, "dbaziz", "dbpassaziz");
            System.out.println("Connection established successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
        }
        return con;
    }

    public static int save(Student st) {
        int s = 0;
        Connection con = null;
        PreparedStatement pr = null;

        try {
            con = StudentSQL.getConnection();
            if (con != null) {
                String sql = "INSERT INTO `studentinfo`(`name`, `password`, `email`, `country`) VALUES (?,?,?,?)";
                pr = con.prepareStatement(sql);
                pr.setString(1, st.getName());
                pr.setString(2, st.getPassword());
                pr.setString(3, st.getEmail());
                pr.setString(4, st.getCountry());
                s = pr.executeUpdate();
            } else {
                System.out.println("Connection is null. Cannot save student.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pr != null) pr.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    public static int update(Student st) {
        int s = 0;
        Connection con = null;
        PreparedStatement pr = null;

        try {
            con = StudentSQL.getConnection();
            if (con != null) {
                String sql = "UPDATE `studentinfo` SET `name`=?,`password`=?,`email`=?,`country`=? WHERE `id` = ?";
                pr = con.prepareStatement(sql);
                pr.setString(1, st.getName());
                pr.setString(2, st.getPassword());
                pr.setString(3, st.getEmail());
                pr.setString(4, st.getCountry());
                pr.setInt(5, st.getId());
                s = pr.executeUpdate();
            } else {
                System.out.println("Connection is null. Cannot update student.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pr != null) pr.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    public static int delete(int id) {
        int s = 0;
        Connection con = null;
        PreparedStatement pr = null;

        try {
            con = StudentSQL.getConnection();
            if (con != null) {
                String sql = "DELETE FROM `studentinfo` WHERE `id` = ?";
                pr = con.prepareStatement(sql);
                pr.setInt(1, id);
                s = pr.executeUpdate();
            } else {
                System.out.println("Connection is null. Cannot delete student.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pr != null) pr.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    public static Student getStudentById(int id) {
        Student student = new Student();
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;

        try {
            con = StudentSQL.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM `studentinfo` WHERE `id` = ?";
                pr = con.prepareStatement(sql);
                pr.setInt(1, id);
                rs = pr.executeQuery();

                if (rs.next()) {
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setPassword(rs.getString(3));
                    student.setEmail(rs.getString(4));
                    student.setCountry(rs.getString(5));
                }
            } else {
                System.out.println("Connection is null. Cannot get student by ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pr != null) pr.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;

        try {
            con = StudentSQL.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM `studentinfo`";
                pr = con.prepareStatement(sql);
                rs = pr.executeQuery();

                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setPassword(rs.getString(3));
                    student.setEmail(rs.getString(4));
                    student.setCountry(rs.getString(5));
                    list.add(student);
                }
            } else {
                System.out.println("Connection is null. Cannot get all students.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pr != null) pr.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
