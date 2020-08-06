package day06;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        Scanner console=new Scanner(System.in);
        //String name=console.next();

        while (true){
            String name=console.next();
            File file=new File("./HomeWork/src/day06/"+name);
            newFile(file);
        }
    }
    public static void newFile(File file) throws IOException {
        int count=0;
        String namebaba=file.getName();
        boolean f=file.exists();
        while (f){
            count++;
            file=new File("./HomeWork/src/day06/"+namebaba+"_副本"+count+".txt");
            f=file.exists();
        }
           file.createNewFile();
    }
}
