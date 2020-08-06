package day06;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名，并复制当前目录中该文件，并取名为"原文件名_copy.后缀名"
 * 定义两个方法分别使用单字节形式复制，以及字节数组形式复制
 * @author Bonnie
 *
 */
public class Test07 {
	public static void main(String[] args) throws IOException {
		Scanner console=new Scanner(System.in);
		String name=console.next();
		//copy1(name);
		copy2(name);
	}
	/**
	 * 使用单字节方式复制
	 * @param name 要复制的文件名
	 */
	public static void copy1(String name) throws IOException {
		File file=new File("./HomeWork/src/day06/"+name);
		InputStream in=new FileInputStream("./HomeWork/src/day06/"+name);
		String[] nm=name.split("\\.");
		OutputStream ot_copy=new FileOutputStream("./HomeWork/src/day06/"+nm[0]+"_copy."+nm[1]);
		int i;
		while ((i=in.read())!=-1){
			ot_copy.write(i);
		}
	}
	/**
	 * 使用字节数组形式复制
	 * @param name 要复制的文件名
	 */
	public static void copy2(String name) throws IOException {
		File file=new File("./HomeWork/src/day06/"+name);
		InputStream in=new FileInputStream("./HomeWork/src/day06/"+name);
		String[] nm=name.split("\\.");
		OutputStream ot_copy=new FileOutputStream("./HomeWork/src/day06/"+nm[0]+"_copy."+nm[1]);
		int len;
		byte[] b=new byte[8];
		while ((len=in.read(b))!=-1){
			ot_copy.write(b,0,len);
		}
	}
}
