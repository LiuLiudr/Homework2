package day07;


import javax.xml.crypto.Data;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户控制台输入想输入的员工人数（至少5个），然后依序输入员工信息，每行为
 * 一条员工信息，格式如:张三,25,男,5000,2006-3-18
 * 然后将该对象写入到文件<name>.obj并保存到当前项目根目录中，例如:张三.obj。
 *
 * @author Bonnie
 */
public class Test03 {
    public static void main(String[] args) throws ParseException, IOException, ClassNotFoundException {
        ObjectOutput ot = new ObjectOutputStream(new FileOutputStream("./HomeWork/src/day07/name.obj"));
//        ObjectInput in = new ObjectInputStream(new FileInputStream("./HomeWork/src/day07/name.obj"));
        Scanner consol = new Scanner(System.in);
        String str;
        int m = prenum();
        for (int i = 0; i < m; i++) {
            str = consol.next();
            Emp emp = preEmp(str);
            ot.writeObject(emp);
//            System.out.println((Emp) in.readObject());
        }
        ot.close();
    }

    public static int prenum() {
        Scanner consol = new Scanner(System.in);
        System.out.println("请输入员工人数>5个:");
        int m;
        for (; ; ) {
            m = consol.nextInt();
            if (m >= 5) {
                break;
            } else {
                System.out.println("人数不足，重新输入:");
            }
        }
        return m;
    }

    public static Emp preEmp(String str) throws ParseException {
        //张三,25,男,5000,2006-3-18
        //String name, int age, String gender, int salary, Data hiredate
        String[] arry = str.split(",");
        String name = arry[0];
        int age = Integer.valueOf(arry[1]);
        String gender = arry[2];
        int salary = Integer.parseInt(arry[3]);
        SimpleDateFormat df = new SimpleDateFormat("YYY-MM-dd");
        Date date = df.parse(arry[4]);
        return new Emp(name, age, gender, salary, date);
    }
}
