package day06;

import java.io.File;

/**
 * 获取并输出当前目录下所有文件的名字
 * @author Bonnie
 *
 */
public class Test06 {
    public static void main(String[] args) {
        File file=new File("./HomeWork/src/");
        visit(file);
    }
    public static void visit(File file){
        File[] files=file.listFiles();
        if(files!=null){
            for (File f : files) {
                  visit(f);
            }
        }
        if(file.isFile()){
            System.out.println(file.getName());
        }
    }
}
