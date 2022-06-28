import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class account{
	int id;
	Map<String,Double>day_account = new TreeMap<String,Double>();
	public account(int id, Map<String,Double>day_account) {
		this.id = id;
		this.day_account = day_account;
	}
}

public class MyCalendar_GUI extends JFrame implements ActionListener{
	public MyCalendar_GUI(){
		super();
		this.setTitle("日历");
		this.init();
		this.setLocation(400, 200);
 
		this.setResizable(false);
		pack();
	}
	
	List<account>myaccount = new LinkedList<account>();
	JComboBox MonthBox = new JComboBox();
	JComboBox YearBox = new JComboBox();
	JLabel YearLabel = new JLabel("年");
	JLabel MonthLabel = new JLabel("月");
	JButton button_searching = new JButton("日期查询");
	JButton button_noting = new JButton("本月记账");
	JButton button_history = new JButton("记账记录查询");
	JButton button_computing = new JButton("记账汇总查询");
	JButton button_now = new JButton("返回本月");
	JTextField text1 = new JTextField(8);
	JTextField text2 = new JTextField(8);
	JTextField text3 = new JTextField(8);
	JTextField[] text_show = new JTextField[35];
	JButton[] button_day = new JButton[42];
	String[] week = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
	JButton[] button_week = new JButton[7];
	String year_int = null;
	int month_int;
	String search_str;
	
	Date now_date = new Date();
	int now_year = now_date.getYear() + 1900;
	int now_month = now_date.getMonth();
	boolean opt = false;
	
	private void init() {
		Font font = new Font("Dialog",Font.BOLD,16);
		YearLabel.setFont(font);
		MonthLabel.setFont(font);
		button_searching.setFont(font);
		button_noting.setFont(font);
		button_history.setFont(font);
		button_computing.setFont(font);
		button_now.setFont(font);
		text1.setFont(font);
		text2.setFont(font);
		text3.setFont(font);
		for(int i = now_year - 2022;i <= now_year + 500;i++){
			YearBox.addItem(i+"");
		}
		YearBox.setSelectedIndex(2022);
		
		for(int i = 1;i <= 12;i++){
			MonthBox.addItem(i+"");
		}
		MonthBox.setSelectedIndex(now_month);
		
		button_now.addActionListener(this);
		button_searching.addActionListener(this);
		button_noting.addActionListener(this);
		button_history.addActionListener(this);
		button_computing.addActionListener(this);
		
		JPanel panel_opt = new JPanel();
		panel_opt.add(YearBox);
		panel_opt.add(YearLabel);
		panel_opt.add(MonthBox);
		panel_opt.add(MonthLabel);
		panel_opt.add(button_searching);
		panel_opt.add(button_now);
		
		JPanel panel_mid = new JPanel();
		panel_mid.setLayout(new GridLayout(3, 2));
		panel_mid.add(button_noting);
		panel_mid.add(text1);
		panel_mid.add(button_history);
		panel_mid.add(text2);
		panel_mid.add(button_computing);
		panel_mid.add(text3);
		
		JPanel panel_show = new JPanel();
		panel_show.setLayout(new GridLayout(10, 1));
		for(int i=0;i<10;i++) {
			text_show[i] = new JTextField(8);
			text_show[i].setFont(font);
			panel_show.add(text_show[i]);
		}
		
		JPanel panel_day = new JPanel();
		panel_day.setLayout(new GridLayout(7, 7));
		for(int i = 0; i < 7; i++) {
			button_week[i] = new JButton(" ");
			button_week[i].setText(week[i]);
			button_week[i].setForeground(Color.black);
			panel_day.add(button_week[i]);
		}
		button_week[0].setForeground(Color.red);
		button_week[6].setForeground(Color.red);
		
		for(int i = 0; i < 42;i++){
			button_day[i] = new JButton(" ");
			panel_day.add(button_day[i]);
		}
		this.showDay();//显示当前日期
		
		JPanel panel_main = new JPanel();
		panel_main.setLayout(new BorderLayout());
		panel_main.add(panel_day,BorderLayout.WEST);
		panel_main.add(panel_opt,BorderLayout.NORTH);
		panel_main.add(panel_mid,BorderLayout.CENTER);
		panel_main.add(panel_show,BorderLayout.EAST);
		getContentPane().add(panel_main);
	}
 
	private void showDay() {
		if(opt){
			year_int = now_year +"";
			month_int = now_month;
		}else{
			year_int = YearBox.getSelectedItem().toString();
			month_int = MonthBox.getSelectedIndex();		
		}
		int year_sel = Integer.parseInt(year_int) - 1900;
		Date firstDay = new Date(year_sel, month_int, 1);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(firstDay);
		int days = 0;
		int day_week = 0;
		
		if(month_int == 0||month_int == 2||month_int == 4||month_int == 6||month_int == 7||month_int == 9||month_int == 11){
			days = 31;
		}else if(month_int == 3||month_int == 5||month_int == 8||month_int == 10){
			days = 30;
		}else{
			if(cal.isLeapYear(year_sel)){
				days = 29;
			}else{
				days = 28;
			}
		}
		day_week = firstDay.getDay();
		int count = 1;
		
		for(int i = day_week;i<day_week+days;count++,i++){
			if((i == day_week+now_date.getDate()-1)&& month_int==now_month && (year_sel == now_year-1900)){
				button_day[i].setForeground(Color.BLUE);
				button_day[i].setText(count+"");
			}else if(i%7 == 0||(i+1)%7 == 0){
				button_day[i].setForeground(Color.RED);
				button_day[i].setText(count+"");
			}else{
				button_day[i].setForeground(Color.BLACK);
				button_day[i].setText(count+"");
			}
		}
		if(day_week == 0){
			for(int i = days;i<42;i++){
				button_day[i].setText("");
			}
		}else{
			for(int i = 0;i<day_week;i++){
				button_day[i].setText("");
			}
			for(int i=day_week+days;i<42;i++){
				button_day[i].setText("");
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_now){
			opt = true;
			YearBox.setSelectedIndex(2022);
			MonthBox.setSelectedIndex(now_month);
			this.showDay();
		}else if(e.getSource()==button_searching){
			opt = false;
			this.showDay();
		}else if(e.getSource()==button_noting) {
			search_str = text1.getText();
			//System.out.println(search_str);
			String[] mid = search_str.split(";");
			int id = Integer.parseInt(mid[1]);
			Map<String,Double>mid_account = new TreeMap<String,Double>();
			for(int i=2;i+1<mid.length;i+=2) {
				mid_account.put(mid[i], Double.parseDouble(mid[i+1]));
			}
			myaccount.add(new account(id,mid_account));
		}else if(e.getSource()==button_history) {
			for(int i=0;i<10;i++) {
				text_show[i].setText("");
			}
			search_str = text2.getText();
			for(int i=0;i<myaccount.size();i++) {
				text_show[i].setText(myaccount.get(i).id+"、"+myaccount.get(i).day_account.get(search_str));
			}
		}else if(e.getSource()==button_computing) {
			for(int i=0;i<10;i++) {
				text_show[i].setText("");
			}
			search_str = text3.getText();
			double sum = 0.0;
			for(int i=0;i<myaccount.size();i++) {
				sum += myaccount.get(i).day_account.get(search_str);
			}
			text_show[0].setText(""+sum);
		}
	}
	public static void main(String[] args) {
		MyCalendar_GUI test = new MyCalendar_GUI();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}
}