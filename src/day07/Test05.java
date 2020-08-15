package day07;

import java.io.*;

/**
 * 使用字符流复制当前程序的源文件到当前项目根目录下。
 *
 * @author Bonnie
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        //String path = Test05.class.getClassLoader().getResource("day07/test05.class").getPath();
        // BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        //PrintWriter ot = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./HomeWork/src/test05_fb.class")));
        BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream("./HomeWork/src/day07/test05.java")));
        PrintWriter ot = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./HomeWork/src/test05_fb.java")));
        String str;
        while ((str = rd.readLine()) != null) {
            ot.println(str);
        }
        rd.close();
        ot.close();
       // System.out.println(path);
    }
}
