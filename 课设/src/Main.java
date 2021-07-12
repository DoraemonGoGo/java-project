import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("欢迎您进入学生疫苗接种管理系统");
            System.out.println("输入1：查询当前全部学生接种信息");
            System.out.println("输入2：查询当前全部医生信息");
            System.out.println("输入3：查询当前全部疫苗信息");
            System.out.println("输入4：按学号查询学生接种信息");
            System.out.println("输入5：增加学生接种信息");
            System.out.println("输入6：修改学生接种信息");
            System.out.println("输入8：删除学生接种信息");
            System.out.println("输入0：退出系统");
            Scanner scan = new Scanner(System.in);
            int order = scan.nextInt();
            Tools t = new Tools();
            switch(order) {
                case 1:
                    t.findAllStu();
                    break;
                case 2:
                    t.findAllDoc();
                    break;
                case 3:
                    t.findAllVac();
                    break;
                case 4:
                    t.findByID();
                    break;
                case 5:
                    System.out.println("请输入学号:");
                    String Id = scan.next();
                    System.out.println("请输入姓名:");
                    String name = scan.next();
                    System.out.println("请输入性别:");
                    String gender = scan.next();
                    System.out.println("请输入联系方式:");
                    String phone = scan.next();
                    System.out.println("请输入接种日期:");
                    String date = scan.next();
                    System.out.println("请输入接种地点:");
                    String address = scan.next();
                    System.out.println("请输入接种疫苗编号:");
                    String Vaccine_id = scan.next();
                    System.out.println("请输入接种医师工号:");
                    String Doctor_id = scan.next();
                    int count2 = t.insertOne(Id, name, gender, phone, date, address,Vaccine_id,Doctor_id);
                    System.out.println("成功输入了"+count2+"条数据");
                    break;
                case 6:
                    System.out.println("请输入需要修改同学的学号:");
                    String Id5 = scan.next();
                    System.out.println("请输入修改后的姓名:");
                    String name5 = scan.next();
                    int count6 = t.updateOne(Id5, name5);
                    System.out.println("成功修改了"+count6+"条数据");
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("请输入学生id:");
                    String id2 = scan.next();
                    int count3 =t.deleteOne(id2);
                    if(count3 == 0){
                        System.out.println("没有找到ID为"+id2+"的学生信息");
                    }else {
                        System.out.println("已成功删除了"+count3+"条信息");
                    }
                    break;
                case 0:
                    System.out.println("系统退出成功");
                    System.exit(0);
                    break;
            }
        }
    }

}
