package todolist;

import java.util.Scanner;

public class Todo_list {
	String title;
    float date;
    float duedate;
    String content;
	
	
	void add_todolistt(){
		
		Scanner s= new Scanner(System.in);
		System.out.println("����  : ");
		title = s.nextLine();
		System.out.println("������¥  : ");
		date =s.nextFloat();
		System.out.println("������¥  : ");
		duedate = s.nextFloat();
		System.out.println("����  : ");
		content = s.nextLine();
	}
	
	void menu_todolist(){
		
		
		
		System.out.println("1. �߰�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. �� ���� Ȯ��");
		System.out.println("5. ������");
		
		Scanner s= new Scanner(System.in);
		int num = s.nextInt();
		
	}
	void list_todolist(){} 
	
	
	void delete_todolist(){}
	void modify_todolist(){}
	
    void datail_todolist(){}
    
	public static void main(String[] args) {
		
		Todo_list todolist = new Todo_list();
		
		System.out.println("1. ����ó ����");
		System.out.println("2. �� �� ����");
		System.out.println("3. ���  ����");
		
		Scanner s= new Scanner(System.in);
		int num = s.nextInt();
		
		switch (num) {
		
		case 1: break;
		case 2: todolist.menu_todolist(); 
		todolist.list_todolist();
		int n = s.nextInt();
		
		if(n == 1) todolist.add_todolistt();
		else if(n == 2) todolist.delete_todolist();
		else if(n == 3) todolist.modify_todolist();
		else if(n == 4) todolist.datail_todolist();
		else 
		
		break;
		
		case 3: break;
		}
		
		// TODO Auto-generated method stub

	}

}
