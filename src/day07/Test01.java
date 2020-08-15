package day07;

import java.io.*;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File file=new File("./HomeWork/src/day07/myfile.txt");
        FileInputStream in=new FileInputStream("./HomeWork/src/day07/myfile.txt");
        FileOutputStream ot=new FileOutputStream("./HomeWork/src/day07/myfile_cp.txt");
        int i;
        while ((i=in.read())!=-1){
            ot.write(i);
        }
    }
}
