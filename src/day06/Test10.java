package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary,hiredate
 * 例如:
 * 张三,25,男,5000,2006-02-15
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。

 * @author Bonnie
 *
 */
public class Test10 {
    public static void main(String[] args) throws ParseException, IOException {
        Scanner consol=new Scanner(System.in);
        int i=0;
        while (true){
            String person=consol.next();
            String name=prname(person);
            Writer wr=new OutputStreamWriter(new FileOutputStream("./HomeWork/src/day06/"+name+".emp"));
            String writein=preit(person);
            wr.write(writein);
            wr.close();
            i++;
            if(i>=5){
                break;
            }
        }
    }
    public static String preit(String str) throws ParseException {
        String[] pp=str.split(",");
        String name=String.valueOf(pp[0]);
        String gender =String.valueOf(pp[2]);
        int age=Integer.parseInt(pp[1]);
        int salary=Integer.parseInt(pp[3]);
        Date hiredate=new SimpleDateFormat("yyyy-MM-dd").parse(pp[4]);
        Emp emp=new Emp(name,age,gender,salary,hiredate);
        return emp.toString();
    }
    public static String prname(String str){
        String[] pp=str.split(",");
        String name=String.valueOf(pp[0]);
        return name;
    }
}
