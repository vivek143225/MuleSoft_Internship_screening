import java.sql.*;
import java.util.*;
public class ConnectionDemo {
  public static void main(String[] args) {
    try {
      Scanner sc = new Scanner(System.in);
      Class.forName("org.sqlite.JDBC");
      Connection con = DriverManager.getConnection("jdbc:sqlite:Movies.db");
      if(con != null) {
    	Statement st=con.createStatement();
    	//int n=st.executeUpdate("create table movie_list(name text,actor_name text,actress_name text,director_name text,release_year int)");
    	PreparedStatement pstmt = con.prepareStatement("insert into movie_list values(?,?,?,?,?)");
        String name=sc.next();
        String actor_name=sc.next();
        String actress_name=sc.next();
        String director_name=sc.next();
        int release_year=sc.nextInt();
        pstmt.setString(1,name);
        pstmt.setString(2,actor_name);
        pstmt.setString(3,actress_name);
        pstmt.setString(4,director_name);
        pstmt.setInt(5,release_year);
        int n = pstmt.executeUpdate();
        System.out.println(n);
        con.close(); 
      }
      
    	 
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
        