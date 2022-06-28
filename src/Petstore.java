import java.util.Scanner;
class Pet{
	int id;
	String type;
	String name;
	/*public Pet(int id, String name) {
		this.id = id;
		this.name = name;
	}*///注意：当子类继承父类时，父类不能只有含参的构造函数
	public void feed() {
		System.out.println(id+" "+name);
	}
}
class Dog extends Pet{
	public Dog(int id, String type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}
	public void feed() {
		System.out.println(id+" "+type+" "+name);
	}
}
class Cat extends Pet{
	public Cat(int id, String type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}
	public void feed() {
		System.out.println(id+" "+type+" "+name);
	}
}
class Bird extends Pet{
	public Bird(int id, String type, String name) {
		this.id = id;
		this.type = type;
		this.name = name;
	}
	public void feed() {
		System.out.println(id+" "+type+" "+name);
	}
}
class Taking_pet{
	int time;
	int id;
	public Taking_pet(int time, int id) {
		this.time = time;
		this.id = id;
	}
	public int time_judge(int time) {
		if(time<100) {
			System.out.println("寄养时间还未达到领走标准");
			return 1; 
		}else {
			System.out.println("寄养时间已达到领走标准，领走宠物的信息为：");
			return 2;
		}
	}
}
class Test{
	int cnt;
	Pet[] my_pet_store;
	public Test(Pet[] my_pet_store) {
		this.cnt = 0;
		this.my_pet_store = my_pet_store;
	}
	public void Fostering_care() {
		Scanner input = new Scanner(System.in);
		int opt = input.nextInt();
		System.out.println("请输入您需要寄养的宠物的名称");
		String name = input.next();
		if(opt == 1) {
			my_pet_store[cnt] = new Dog(cnt+1, "狗", name);
		}else if(opt == 2) {
			my_pet_store[cnt] = new Cat(cnt+1, "猫", name);
		}else if(opt == 3) {
			my_pet_store[cnt] = new Bird(cnt+1, "鸟", name);
		}
		type_judge(my_pet_store[cnt]);
		cnt++;
	}
	public void Finding_by_name_of_pet() {
		System.out.println("请输出您要查找的宠物的名称");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		for(int i=0;i<cnt;i++) {
			if(my_pet_store[i].name.equals(name)) {
				my_pet_store[i].feed();
			}
		}
	}
	public void Finding_by_type_of_pet(String type) {
		for(int i=0;i<cnt;i++) {
			if(my_pet_store[i].type.equals(type)) {
				my_pet_store[i].feed();
			}
		}
	}
	public void Finding_by_id_of_pet(int id) {
		int mid;
		if(id<cnt) {
			mid = id;
		}else {
			mid = cnt;
		}
		for(int i=0;i<mid;i++) {
			my_pet_store[i].feed();
		}
	}
	public static void type_judge(Pet a) {
		if(a instanceof Dog) {
			System.out.println("狗");
		}else if(a instanceof Cat) {
			System.out.println("猫");
		}else if(a instanceof Bird) {
			System.out.println("鸟");
		}
	}
	public void Taking_pet_by_id(int id) {
		my_pet_store[id-1].feed();
	}
}
public class Petstore {
	public static void main(String[] args) {
		int opt;
		Test a = new Test(new Pet[10]);
		do {
			System.out.println("寄养宠物,请输入'1';根据名称查找宠物,请输入'2';根据种类查找宠物,请输入'3';根据序号查找宠物,请输入'4';希望带走宠物，请输入'5';选择退出,请输入'6'");
			Scanner input = new Scanner(System.in);
			opt = input.nextInt();
			if(opt == 1) {
				System.out.println("若要寄养狗，请输入'1';若要寄养猫，请输入'2';若要寄养鸟，请输入'3'");
				a.Fostering_care();
			}else if(opt == 2) {
				a.Finding_by_name_of_pet();
			}else if(opt == 3) {
				System.out.println("请输入宠物种类（如：狗，猫，鸟）");
				String type = input.next();
				a.Finding_by_type_of_pet(type);
			}else if(opt == 4) {
				System.out.println("请输入宠物序号");
				int id = input.nextInt();
				a.Finding_by_id_of_pet(id);
			}else if(opt == 5) {
				System.out.println("请输入当前的寄养时间");
				int time = input.nextInt();
				System.out.println("请输入希望领走的宠物的序号");
				int id = input.nextInt();
				Taking_pet b = new Taking_pet(time,id);
				int opt2 = b.time_judge(b.time);
				if(opt2 == 2) {
					a.Taking_pet_by_id(id);
				}
			}
		}while(opt != 6);
		//Pet[] t = new Pet[10];
	}
}