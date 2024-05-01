import java.sql.*;

public class Main {
    //    Manage these according to your user and password
    private static final String url="jdbc:mysql://localhost:3306/wscubetech";
    private static final String userName="root";
    private static final String password="@Demo123";
    public static void main(String[] args) {

//        Statement Fetch data
/*

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement();
            String query="SELECT * FROM wscubetech.students";
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                int age=resultSet.getInt("age");
                int status=resultSet.getInt("status");
                System.out.println(id+" : "+name+" : "+email+" : "+age+" : "+status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

*/


//        Statement Insert Data
/*
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement();

            String query=String.format("INSERT INTO STUDENTS(NAME, EMAIL, AGE, STATUS) VALUES( '%s','%s', %d, %b)","anuj2","anuj2@gmail.com",44,false);
            int rowsAffected= statement.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println("Data Inserted Successfully!");
            }else {
                System.out.println("Data Not Inserted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */


//      Statement Update Data

/*
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement();

            String query=String.format("UPDATE STUDENTS SET NAME = '%S' WHERE ID = %d ","Rajesh Dora", 12);
            int rowsAffected= statement.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println("Data Updated Successfully!");
            }else {
                System.out.println("Data Not Updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        */


//        Statement Delete Data

  /*      try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            Statement statement=connection.createStatement();

            String query=String.format("Delete from STUDENTS WHERE ID = %d ", 14);
            int rowsAffected= statement.executeUpdate(query);
            if (rowsAffected>0){
                System.out.println("Data Deleted Successfully!");
            }else {
                System.out.println("Data Not Deleted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

//       using prepared Statement



//        prepared Statement insert

       /* try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            String query="INSERT INTO STUDENTS(NAME, EMAIL, AGE, STATUS) VALUES( ?,?,?,?)";
//            Statement statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,"Ankita");
            preparedStatement.setString(2,"ankita@gmail.com");
            preparedStatement.setInt(3,22);
            preparedStatement.setBoolean(4,false);
            int rowsAffected= preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Data Inserted Successfully!");
            }else {
                System.out.println("Data Not Inserted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/


//        prepared Statement fetch data
        /*
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            String query="SELECT age FROM students where id =?";
//            Statement statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,7);

           *//* int rowsAffected= preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Data Inserted Successfully!");
            }else {
                System.out.println("Data Not Inserted");
            }*//*

            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                int age=resultSet.getInt("age");
                System.out.println("Age : "+age);
            }else {
                System.out.println("Marks not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/


//        prepared Statement Update data

       /*  try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            String query="UPDATE STUDENTS SET age = ? WHERE ID =? ";
//            Statement statement=connection.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,20);
            preparedStatement.setInt(2,2);
            int rowsAffected= preparedStatement.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Data Updated Successfully!");
            }else {
                System.out.println("Data Not Updated");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/






    }
}
