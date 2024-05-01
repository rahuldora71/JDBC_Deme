import javax.management.Query;
import java.sql.*;
import java.util.Scanner;

public class Batch_Processing {
    //    Manage these according to your user and password
    private static final String url="jdbc:mysql://localhost:3306/wscubetech";
    private static final String userName="root";
    private static final String password="@Demo123";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            Scanner scanner=new Scanner(System.in);
            Statement statement=connection.createStatement();
            while (true){
                System.out.print("Enter Name: ");
                String name=scanner.nextLine();
                System.out.print("Enter Email: ");
                String email=scanner.nextLine();
                System.out.print("Enter Age: ");
                int age=scanner.nextInt();
                System.out.print("Enter status: ");
                boolean status=scanner.nextBoolean();
                System.out.println("Enter more data(Y/N) : ");
                String choice=scanner.next();
                String query=String.format("INSERT INTO STUDENTS(NAME, EMAIL, AGE, STATUS) VALUES( '%s','%s', %d, %b)",name,email,age,status);

                statement.addBatch(query);
                if (choice.equalsIgnoreCase("N")){
                    break;
                }
                scanner.nextLine();



            }


            int [] arr= statement.executeBatch();
           /* if (rowsAffected>0){
                System.out.println("Data Inserted Successfully!");
            }else {
                System.out.println("Data Not Inserted");
            }*/
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]==0){
                    System.out.println("Query "+i+" not execute succesfully");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
