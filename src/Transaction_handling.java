import java.sql.*;
import java.util.Scanner;

public class Transaction_handling {
    //    Manage these according to your user and password
    private static final String url="jdbc:mysql://localhost:3306/lenden";
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
            connection.setAutoCommit(false);
            String debit_query ="Update accounts set balance = balance - ? where account_number=? ";
            String credit_query ="Update accounts set balance = balance + ? where account_number=? ";
            PreparedStatement debitPreparedStatement= connection.prepareStatement(debit_query);
            PreparedStatement creditPreparedStatement= connection.prepareStatement(credit_query);
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Account number");
            int account_number= scanner.nextInt();
            System.out.println("Enter Amount");
            double amount = scanner.nextDouble();
            System.out.println("Credit to ");
            int account_number2= scanner.nextInt();

            debitPreparedStatement.setDouble(1,amount);
            debitPreparedStatement.setInt(2,account_number);
            creditPreparedStatement.setDouble(1,amount);
            creditPreparedStatement.setInt(2,account_number2);
            debitPreparedStatement.executeUpdate();
            creditPreparedStatement.executeUpdate();
            if (isSufficient(connection,account_number,amount)){
                connection.commit();
                System.out.println("Transaction Successful");
//                int affectedRow1=debitPreparedStatement.executeUpdate();
//                int affectedRow2=creditPreparedStatement.executeUpdate();
            }else {
                connection.rollback();

                System.out.println("Transaction Failed");
            }
            debitPreparedStatement.close();
            creditPreparedStatement.close();
            scanner.close();
            connection.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static boolean isSufficient(Connection connection, int account_number, double amount){
        try {
        String query ="select balance from accounts where account_number = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,account_number);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()){
               double current_balance=resultSet.getDouble("balance");
               if (amount>current_balance){
                   preparedStatement.close();
                   resultSet.close();
                   return false;
               }else {
                   preparedStatement.close();
                   resultSet.close();
                   return true;
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return false;
    }
}
