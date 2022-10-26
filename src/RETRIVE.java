import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



class RetriveImage {

    public static final String driverClass = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/college";
    public static final String username = "root";
    public static final String password = "";
    // Testing

    public static void main(String[] args) {


      //  Connection con = null;
       // PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college","root","");

            // file path for retrived image
            File file=new File("D:\\im.png");
            FileOutputStream fos=new FileOutputStream(file);
            byte b[];
            Blob blob;

            PreparedStatement ps=con.prepareStatement("select * from pp where ID=0");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                blob=rs.getBlob("image");
                b=blob.getBytes(1,(int)blob.length());
                fos.write(b);
            }
            System.out.println("Imgae Rerived successfully to "+file.getPath()+"  path");
     ps.close();
     con.close();


        }catch(Exception e) {
            System.out.println("please check the above steps"+e.getMessage());
        }finally{



        }
    }

}
