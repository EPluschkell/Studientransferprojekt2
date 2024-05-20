import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void savePerishableFood(PerishableFood food,String url, String tableName){
        var sql="INSERT INTO "+tableName+"(name,quantity,bestbeforedate,isOpen,isGram) VALUES(?,?,?,?,?)";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

                //pstmt.setInt(1,i);
                pstmt.setString(1,food.getName());
                pstmt.setInt(2,food.getQuantity());
                pstmt.setDate(3, Date.valueOf(food.getBestBeforeDate()));
                pstmt.setBoolean(4,food.getOpen());
                pstmt.setBoolean(5,food.getGram());
                pstmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void savePerishableList(PerishableList list, String url,String tableName){
        var sql="INSERT INTO "+tableName+"(name,quantity,bestbeforedate,isOpen,isGram) VALUES(?,?,?,?,?)";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < list.itemList.size(); i++) {
                //pstmt.setInt(1,i);
                pstmt.setString(1,list.itemList.get(i).getName());
                pstmt.setInt(2,list.itemList.get(i).getQuantity());
                pstmt.setDate(3, Date.valueOf(list.itemList.get(i).getBestBeforeDate()));
                pstmt.setBoolean(4,list.itemList.get(i).getOpen());
                pstmt.setBoolean(5,list.itemList.get(i).getGram());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static PerishableList readPerishable(String url,String tableName){
        PerishableList list = new PerishableList();
        var sql= "SELECT name, quantity, bestbeforedate, isOpen, isGram FROM "+tableName;
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement();
             var rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new PerishableFood(rs.getString("name"),rs.getInt("quantity"),rs.getDate("bestbeforedate").toLocalDate(),rs.getBoolean("isGram")));
                if (rs.getBoolean("isOpen"))list.itemList.getLast().openContainer();
                System.out.printf("%-5s%-25s%-10s%n",
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDate("bestbeforedate").toLocalDate()
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static void createTable(String sql, String url){
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}



