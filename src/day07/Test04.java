package day07;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个List集合中，然后按照员工工资从多到少的顺序依次输出员工信息
 *
 * @author Bonnie
 */
public class Test04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File[] files = priFiles();
        List<Emp> list = new ArrayList<>();
        list = preEmps(files);
        Collections.sort(list, (o1 , o2)->
           o2.getSalary()-o1.getSalary()
        );
        list.stream().forEach(System.out::println);
    }

    public static File[] priFiles() {
        File file = new File("./HomeWork/src/day07");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains(".obj");
            }
        });
        return files;
    }

    public static List<Emp> preEmps(File[] files) throws IOException, ClassNotFoundException {
        List<Emp> list = new ArrayList<>();
        for (File fi : files) {
            ObjectInput in = new ObjectInputStream(new FileInputStream(fi));
            Emp emp;
            while (true) {
                try {
                    emp = (Emp) in.readObject();
                    //System.out.println(emp);
                    list.add(emp);
//                    if (emp == null) {
//                       // break;
//                    }
                } catch (EOFException e) {
                    break;
                }
            }
            in.close();
        }
        return list;
    }
}
