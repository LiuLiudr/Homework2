package day07;

import java.io.*;
import java.util.Scanner;

/**
 * 要求用户输入一个文件，该文件应当是Test07程序生成的文件，然后将该文件中所有字符读取
 * 出来，并以UTF-8编码写入到另一个文件中，实现文件转码工作，该文件取名格式:原文件名_utf.txt。
 *
 * @author Bonnie
 */
public class Test07 {
    public static void main(String[] args) throws IOException {
        System.out.println("输入文件");
        Scanner consol = new Scanner(System.in);
        String oldFile = consol.next();
        newFi(oldFile);
//        File file = new File("./HomeWork/src/day07/" + oldFile);
//        System.out.println(file.getPath());
    }

    public static void newFi(String oldFile) throws IOException {
        File file = new File("./HomeWork/src/day07/" + oldFile);
        BufferedReader bfrd = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));

        String name = oldFile.split("\\.")[0] + "_utf.txt";

        PrintWriter ptwd = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./HomeWork/src/day07/" + name), "UTF-8"));

        String str;
        while ((str = bfrd.readLine()) != null) {
            ptwd.println(str);
        }
        bfrd.close();
        ptwd.close();
    }
}
