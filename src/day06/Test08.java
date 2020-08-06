package day06;

import java.io.*;

/**
 * 创建一个"raf.dat"的文件，并在其中写出一个int的最大值，long的最大值，
 * 然后将其分别读取出来并输出
 * @author Bonnie
 *
 */
public class Test08 {
    public static void main(String[] args) throws IOException {
        File file=new File("./HomeWork/src/day06/raf.dat");
        RandomAccessFile rw=new RandomAccessFile(file,"rw");

        rw.writeLong(Long.MAX_VALUE);
        rw.writeInt(Integer.MAX_VALUE);

        byte[] b=new byte[8];
        int i;
        //while ((i=rw.read(b))!)
    }
}
