package day07;

import java.io.*;

/**
 * 使用缓冲流复制myfile.txt文件为myfile_cp2.txt
 * @author Bonnie
 *
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("./HomeWork/src/day07/myfile.txt"));
        BufferedOutputStream ot=new BufferedOutputStream(new FileOutputStream("./HomeWork/src/day07/myfile_cp2.txt"));
        byte [] a=new byte[1024];
        int len;
        while ((len=in.read(a))!=-1){
            ot.write(a);
        }
        ot.close();
    }
}
