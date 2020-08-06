package day06;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个目录名并使用File在当前目录下创建出来。
 * 若该目录已经存在，则提示用户该目录已经存在。并创建副本，原则与第二题一致。
 * @author Bonnie
 *
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        Scanner console=new Scanner(System.in);
        while (true){
            String name=console.next();
            File file=new File("./HomeWork/src/day06/"+name);
            newFile(file);
        }
    }
    public static void newFile(File file) throws IOException {
        int count=0;
        boolean f=file.exists();
        String name=file.getName();
        while (f){
            count++;
            file=new File("./HomeWork/src/day06/"+name+"_副本"+count);
            f=file.exists();
        }
        file.mkdirs();
    }
}
