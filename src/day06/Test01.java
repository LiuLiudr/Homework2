package day06;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2017-06-30 14:22:16
 * @author Bonnie
 *
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File file=new File("./HomeWork/src/day06/myfile.txt");
        file.getAbsoluteFile();
        System.out.println(file.getAbsoluteFile());
        file.createNewFile();
        System.out.println("文件名："+file.getName());
        System.out.println(file.length());
        SimpleDateFormat df=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date date=new Date();
        date.setTime(file.lastModified());
        String last=df.format(date);
        System.out.println(last);
    }
}
