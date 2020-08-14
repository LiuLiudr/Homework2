package day06;

import java.io.*;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后输出该集合中每个员工信息。
 * 该文件800字节，每80个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为int,长度为4个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为字符串，格式"yyyy-MM-dd"，长度为30个字节，编码为:UTF-8
 * 格式可参考当前包中emp.jpg图
 * 提示:
 * 使用RandomAccessFile读取字符串时，例如name,可以先读取32个字节，再按照UTF-8
 * 转换为字符串，读取age时可以直接使用readInt方法。依次类推。
 * @author Bonnie
 *
 */
public class Test13 {
	public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
		//使用类加载器加载当前包中的emp.dat文件
		File file = new File(Test13.class.getClassLoader().getResource("day06/emp.dat").toURI());
		List<Emp> list=new ArrayList<>();
		list=preEmp();
		System.out.println(list);

		
	}
	public static List<Emp> preEmp() throws URISyntaxException, IOException, ParseException {
		List<Emp> list=new ArrayList<>();
		File file = new File(Test13.class.getClassLoader().getResource("day06/emp.dat").toURI());
		FileInputStream red=new FileInputStream(file);
		RandomAccessFile rw=new RandomAccessFile(file,"rw");
		//String name32,int age4,String gender10,int salary4,Date hiredate(String)30
		byte[] a=new byte[32];
		byte[] b=new byte[4];
		byte[] c=new byte[10];
		byte[] d=new byte[30];
		for(int i=0;i<8;i++){
			rw.read(a);
			String name=new String(a,"UTF-8").trim();

			int age=rw.readInt();
			rw.read(c);
			String gender=new String(c,"UTF-8").trim();


			int salary=rw.readInt();

			SimpleDateFormat df=new SimpleDateFormat("YYY-MM-dd");
			rw.read(d);
			Date date=df.parse(new String(d,"UTF-8").trim());

			list.add(new Emp(name,age,gender,salary,date));
		}
		return list;
	}
}
