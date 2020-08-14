package day06;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有的员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入Map。其中key为该员工的名字，value为该员工的emp对象。
 * 然后，要求用户输入一个员工名字，若该员工存在，则输出该员工的名字，年龄，工资，以及入职20周年的纪念日当周的周六的日期。
 * 即:输入名字"张三"
 * 若该员工存在，则输出如下格式:
 * 张三,25,5000,2006-02-14
 * 入职20周年纪念日派对日期: 2026-02-14  （注:若入职日期为:2006-02-14）
 * 若该员工不存在，则输出:"查无此人"
 *
 * @author Bonnie
 */
public class Test12 {
    public static void main(String[] args) throws IOException, ParseException {
        Map<String, Emp> map = new HashMap<>();
        map = preEmp();
        System.out.println("请输入姓名");
        Scanner console =new Scanner(System.in);
        String name=console.next();
        Set<String> set=map.keySet();
        for (String nam : set) {
            if(nam.equals(name)){
                Emp emp=map.get(nam);
                System.out.println(emp);
                break;
            }
            else {
                System.out.println("查无此人");
                break;
            }
        }
    }

    public static Map<String, Emp> preEmp() throws IOException, ParseException {
        Map<String, Emp> map = new HashMap<>();
        File file = new File("./HomeWork/src/day06");
        File[] files = file.listFiles(pathname -> {
            return pathname.getName().contains(".emp");
        });
        for (File fi : files) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(fi)));
            //System.out.println(fi.getPath());
            String str;
            while ((str = rd.readLine()) != null) {
                String[] arr = str.split(",");
                //a,15, 男, 5000, 2006-02-15
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String gender = arr[2];
                int salary = Integer.parseInt(arr[3]);
                SimpleDateFormat df = new SimpleDateFormat("YYY-MM-dd");
                Date date = df.parse(arr[4]);
                Emp emp = new Emp(name, age, gender, salary, date);
                map.put(emp.getName(), emp);
            }
        }
        // PrintWriter ot = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./HomeWork/src/day06/")));
        return map;
    }
}
