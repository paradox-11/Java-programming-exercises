import java.util.*;
class Notebook{
	String name;
	List<String>book = new LinkedList<String>();
	public Notebook(String name, List<String> book) {
		this.name = name;
		this.book = book;
	}
}

public class Using_Notebook {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, opt;
		String name;
		System.out.println("请输出您的笔记本的名字");
		name = input.next();
		List<String>book = new LinkedList<String>();
		Notebook notebook = new Notebook(name, book);
		do {
			System.out.println("获取已经存储的记录数量,请输入'1';追加记录,请输入'2';展示已经存储的全部记录,请输入'3';展示已经存储的其中一条记录,请输入'4';删除已经存储的全部记录，请输入'5';删除已经存储的其中一条记录,请输入'6';选择退出,请输入'7'");
			opt = input.nextInt();
			if(opt==1) {
				System.out.println("已经存储的记录数量为:");
				System.out.println(notebook.book.size());
			}else if(opt==2) {
				System.out.println("请输出需要追加的记录");
				String text = input.next();
				notebook.book.add(text);
				System.out.println("已追加记录:");
				System.out.println(text);
			}else if(opt==3) {
				System.out.println("已经存储的全部记录为:");
				for(i = 0;i < notebook.book.size();i++) {
					System.out.println(notebook.book.get(i));
				}
			}else if(opt==4) {
				System.out.println("请输出需要展示的记录的序号");
				i = input.nextInt();
				System.out.println("要求展示的内容为:");
				System.out.println(notebook.book.get(i-1));
			}else if (opt==5) {
				notebook.book.clear();
				System.out.println("已经删除存储的全部记录");
			}else if(opt==6) {
				System.out.println("请输出需要删除的记录的序号");
				i = input.nextInt();
				notebook.book.remove(i-1);
				System.out.println("已经删除要求的记录:");
				System.out.println(notebook.book.get(i-1));
			}
		}while(opt!=7);
	}
}