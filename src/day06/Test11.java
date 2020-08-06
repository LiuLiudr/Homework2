package day06;

import java.io.*;
import java.util.*;

/**
 * 编写一个程序，将当前目录下所有员工文件进行读取，并解析出所有员工为Emp
 * 对象并存入集合。然后排序该集合，按照员工的年龄排序，年龄大的靠前，年龄小
 * 的靠后。排序完毕后输出结果。
 * @author Bonnie
 *
 */
public class Test11 {
    public static void main(String[] args) throws IOException {
        File file=new File("./HomeWork/src/day06/");
        List<String> list=new ArrayList<>();
       // List<Emp> list1=new ArrayList<>();
        File[] files=file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                return pathname.getName().contains(".emp");
            }
        });


        for(int i=0;i<files.length;i++){

            BufferedReader rd=new BufferedReader(new InputStreamReader(new FileInputStream("./HomeWork/src/day06/"+files[i].getName())));
            String str;
            while ((str = rd.readLine()) != null) {//读一整行。
                //System.out.println(str);
                list.add(str);
            }
            rd.close();
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i =Integer.parseInt(o2.split(",")[1])-Integer.parseInt(o1.split(",")[1]);
                return i;
            }
        });
        System.out.println(list);
    }
}
