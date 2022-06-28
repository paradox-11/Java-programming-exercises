import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
class Text_char{
	int num;
	char text;
	public Text_char(int num, char text) {
		this.num = num;
		this.text = text;
	}
}
class Text_String{
	int num;
	String text;
	public Text_String(int num, String text) {
		this.num = num;
		this.text = text;
	}
}
class Statistics{
	String filename;
	List<Text_char>data_char = new LinkedList<Text_char>();
	List<Text_String>data_String = new LinkedList<Text_String>();
	public Statistics(String filename) {
		this.filename = filename;
	}
	public void Acounting_char(String filename) throws IOException{
		FileInputStream in=new FileInputStream(filename);
		for(int i=97;i<=122;i++) {
			data_char.add(new Text_char(0, (char)i));
		}
		int mid;
		while((mid=in.read())!=-1) {
			for(int i=0;i<data_char.size();i++) {
				if(data_char.get(i).text==mid) {
					data_char.get(i).num += 1;
					break;
				}
			}
		}
		in.close();
	}
	public void Acounting_String(String filename) throws IOException {
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String mid;
		while((mid=in.readLine())!=null){
			int opt=0;
			for(int i=0;i<data_String.size();i++) {
				if(data_String.get(i).text.equals(mid)) {
					data_String.get(i).num += 1;
					opt=1;
					break;
				}
			}
			if(opt==0) {
				data_String.add(new Text_String(1, mid));
			}
		}
		in.close();
	}
}
public class Testing_IO {
	public static void main(String[] args) throws IOException {
		int opt;
		Scanner input = new Scanner(System.in);
		//此处设置读取文件的路径
		Statistics statistics = new Statistics("C:\\Users\\lzy\\Desktop\\code_test\\java_xd\\read.txt");
		//此处设置写入文件的路径
		PrintWriter out=new PrintWriter( new BufferedWriter(new FileWriter("C:\\Users\\lzy\\Desktop\\code_test\\java_xd\\write.txt")));
		System.out.println("统计英文字符,请输入'1';统计字符串,请输入'2'");
		opt = input.nextInt();
		if(opt==1) {
			statistics.Acounting_char(statistics.filename);
			System.out.println("将统计结果输出至指定文件,请输入'1';将统计结果输出至屏幕,请输入'2'");
			opt = input.nextInt();
			if(opt==1) {
				out.println("英文字符的统计结果如下:");
				for(int i=0;i<statistics.data_char.size();i++) {
					out.println(statistics.data_char.get(i).text+": " + statistics.data_char.get(i).num);
				}
				out.close();
			}else if(opt==2) {
				System.out.println("英文字符的统计结果如下:");
				for(int i=0;i<statistics.data_char.size();i++) {
					System.out.println(statistics.data_char.get(i).text+": " + statistics.data_char.get(i).num);
				}
			}
		}else if(opt==2) {
			statistics.Acounting_String(statistics.filename);
			System.out.println("将统计结果输出至指定文件,请输入'1';将统计结果输出至屏幕,请输入'2'");
			opt = input.nextInt();
			if(opt==1) {
				out.println("字符串的统计结果如下:");
				for(int i=0;i<statistics.data_String.size();i++) {
					out.println(statistics.data_String.get(i).text+": " + statistics.data_String.get(i).num);
				}
				out.close();
			}else if(opt==2) {
				System.out.println("字符串的统计结果如下:");
				for(int i=0;i<statistics.data_String.size();i++) {
					System.out.println(statistics.data_String.get(i).text+": " + statistics.data_String.get(i).num);
				}
			}
		}
	}
}