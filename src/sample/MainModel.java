package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.connect;
public class MainModel {
    Connection connection;

    public MainModel(){
        try {
            this.connection = connect.getConnection();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        if(this.connection == null){
            System.exit(1);
        }
    }

        public boolean dataBaseStatus(){
        return this.connection != null;
        }

        public boolean thelogin(String username, String password, String option) throws Exception{
            PreparedStatement pst = null;
            ResultSet rs = null;

            String sql = "SELECT * FROM login where username = ?  and password = ? and divison =?";

            try {
                pst = this.connection.prepareStatement(sql);
                pst.setString(1,username);
                pst.setString(2,password);
                pst.setString(3,option);

                rs = pst.executeQuery();
                boolean bool;

                if(rs.next()){
                    return true;
                }
                return false;
            }catch(SQLException ex){
                return false;
            }
            finally {
                {
                    pst.close();
                    rs.close();
                }
            }
        }
}
