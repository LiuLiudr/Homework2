package day07;

import java.io.*;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 *
 * @author Bonnie
 */
public class Test06 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner consoul = new Scanner(System.in);
        System.out.println("请输入文件名：");
        String fileName = consoul.next();
        preFile(fileName);
        PrintWriter wt = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./HomeWork/src/day07/" + fileName), "GBK"));
        System.out.println("请输入：");
        String setin = "ll";
        while (!setin.equals("exit")) {
            setin = consoul.next();
            wt.println(setin);
        }
        wt.close();
    }

    public static void preFile(String file) {
        File file1 = new File("./HomeWork/src/day07" + file);
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
