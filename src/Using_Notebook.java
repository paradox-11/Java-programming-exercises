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
		System.out.println("��������ıʼǱ�������");
		name = input.next();
		List<String>book = new LinkedList<String>();
		Notebook notebook = new Notebook(name, book);
		do {
			System.out.println("��ȡ�Ѿ��洢�ļ�¼����,������'1';׷�Ӽ�¼,������'2';չʾ�Ѿ��洢��ȫ����¼,������'3';չʾ�Ѿ��洢������һ����¼,������'4';ɾ���Ѿ��洢��ȫ����¼��������'5';ɾ���Ѿ��洢������һ����¼,������'6';ѡ���˳�,������'7'");
			opt = input.nextInt();
			if(opt==1) {
				System.out.println("�Ѿ��洢�ļ�¼����Ϊ:");
				System.out.println(notebook.book.size());
			}else if(opt==2) {
				System.out.println("�������Ҫ׷�ӵļ�¼");
				String text = input.next();
				notebook.book.add(text);
				System.out.println("��׷�Ӽ�¼:");
				System.out.println(text);
			}else if(opt==3) {
				System.out.println("�Ѿ��洢��ȫ����¼Ϊ:");
				for(i = 0;i < notebook.book.size();i++) {
					System.out.println(notebook.book.get(i));
				}
			}else if(opt==4) {
				System.out.println("�������Ҫչʾ�ļ�¼�����");
				i = input.nextInt();
				System.out.println("Ҫ��չʾ������Ϊ:");
				System.out.println(notebook.book.get(i-1));
			}else if (opt==5) {
				notebook.book.clear();
				System.out.println("�Ѿ�ɾ���洢��ȫ����¼");
			}else if(opt==6) {
				System.out.println("�������Ҫɾ���ļ�¼�����");
				i = input.nextInt();
				notebook.book.remove(i-1);
				System.out.println("�Ѿ�ɾ��Ҫ��ļ�¼:");
				System.out.println(notebook.book.get(i-1));
			}
		}while(opt!=7);
	}
}