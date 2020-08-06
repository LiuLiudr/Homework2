package day06;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 * @author Bonnie
 *
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        Scanner console=new Scanner(System.in);
        String name=console.next();
        File file=new File("./HomeWork/src/day06/"+name);
        file.mkdirs();
        String[] arry=name.split("/");
        deleFile(new File("./HomeWork/src/day06/"+arry[0]));
    }
    public static void deleFile(File file){
        File[] files=file.listFiles();
        if(files!=null){
            for(File f:files){
                deleFile(f);
            }
        }
        file.delete();
    }
}
