import java.sql.*;
public class Tools {
    public Connection getConn() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String  url = "jdbc:mysql://localhost:3306/management";
        String user = "root";
        String password = "19840220";
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
    //查询全部学生信息
    public void findAllStu() throws ClassNotFoundException, SQLException{
        Statement st = getConn().createStatement();
        String sql = "select * from 学生信息表";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            String Id = rs.getString(1);
            String Name = rs.getString(2);
            String Gender = rs.getString(3);
            String Phone = rs.getString(4);
            String Date = rs.getString(5);
            String Address = rs.getString(6);
            String Vaccine_id = rs.getString(7);
            String Doctor_id = rs.getString(8);
            System.out.println(Id+"\t"+Name+"\t"+Gender+"\t"+Phone+"\t"+Date+"\t"+Address+"\t"+Vaccine_id+"\t"+Doctor_id);
        }
    }
    //查询全部医生信息
    public void findAllDoc() throws ClassNotFoundException, SQLException{
        Statement st = getConn().createStatement();
        String sql = "select * from 医生信息表";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            String Id = rs.getString(1);
            String Name = rs.getString(2);
            String Degree = rs.getString(3);
            System.out.println(Id+"\t"+Name+"\t"+Degree);
        }
    }
    //查询全部疫苗信息
    public void findAllVac() throws ClassNotFoundException, SQLException{
        Statement st = getConn().createStatement();
        String sql = "select * from 疫苗信息表";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            String Id = rs.getString(1);
            String Type = rs.getString(2);
            String Date = rs.getString(3);
            String S_id = rs.getString(4);
            System.out.println(Id+"\t"+Type+"\t"+Date+"\t"+S_id);
        }
    }
    //按学号查询信息
    public void findByID() throws ClassNotFoundException, SQLException{
        Statement st = getConn().createStatement();
        String sql = "select s.Student_Name,v.Vaccine_ID,v.Vaccine_Type from 学生信息表 s,疫苗信息表 v where s.Student_ID = v.Student_ID;";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            String S_Name = rs.getString(1);
            String V_ID = rs.getString(2);
            String V_Type = rs.getString(3);
            System.out.println(S_Name+"\t"+V_ID+"\t"+V_Type);
        }
    }
    //增加一个学生的信息
    public int insertOne(String id,String name, String gender,String phone,String date,String address,String Vaccine_id,String Doctor_id) throws ClassNotFoundException, SQLException{
        String sql =  "insert into 学生信息表 values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, name);
        ps.setString(3, gender);
        ps.setString(4, phone);
        ps.setString(5, date);
        ps.setString(6, address);
        ps.setString(7, Vaccine_id);
        ps.setString(8, Doctor_id);
        return ps.executeUpdate();
    }
    //删除一个学生的信息
    public int deleteOne(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from 学生信息表 where Student_ID =?";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ps.setString(1, id);
        return ps.executeUpdate();
    }

    //修改一个学生的信息
    public int updateOne(String id ,String name) throws ClassNotFoundException, SQLException{
        String sql = "update 学生信息表 set Student_Name = ? where Student_ID = ?";
        PreparedStatement ps = getConn().prepareStatement(sql);
        ps.setString(2, id);
        ps.setString(1, name);
        return ps.executeUpdate();
    }
}
