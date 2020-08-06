package day06;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。
 * @author Bonnie
 *
 */
public class Test09 {
    public static void main(String[] args) throws IOException {
        Writer wr=new OutputStreamWriter(new FileOutputStream("./HomeWork/src/day06/note.txt"));
        Scanner console=new Scanner(System.in);
        String m;
        while (!((m=console.next()).equals("exit"))){
            wr.write(m);
            wr.write("\n");
        }
        wr.close();
    }
}
