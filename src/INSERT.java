import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class InsertingImage {

    //Variables

    public static final String driverClass = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/college";
    public static final String username = "root";
    public static final String password = "";


    public static void main(String[] args) {

        //Connection con;
       // PreparedStatement ps;

        try {
            //Added

            // Load and Register the driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college","root","");
            // getting image form below path
             File file=new File("D:\\image.png");
            //File file=new File("C:\\Users\\kbharat\\Desktop\\vid\\vd.txt");

            FileInputStream fis=new FileInputStream(file);



            PreparedStatement ps=con.prepareStatement("insert into pp (ID,image) values(?,?)");
            ps.setString(1,"00");
            ps.setBinaryStream(2,fis,(int)file.length());
            int result=ps.executeUpdate();

            if(result ==0) {
                System.out.println("Image not inserted ...please check ");
            }else {
                System.out.println("Image inderted secessfully");
            }
            con.close();
            ps.close();

        }catch(Exception e) {
            System.out.println("please check the above steps "+e.getMessage());
        }

    }
}
