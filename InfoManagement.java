package swg3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InfoManagement {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      

         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         String optstr;
         int opt=1;
         
      
         
         while(opt!=9) {
            
            System.out.println("� ������ �ϰ� ��������?\n");
            System.out.println("1. ����ó");
            System.out.println("2. �� ��");
            System.out.println("3. ��� ����");
            optstr = in.readLine();
            opt = Integer.parseInt(optstr);
            

         switch(opt) {
            
         case 1: //������ Ŭ����
            Contact contacts = new Contact();
                 while(opt!=5) {
            	
               contacts.list_contact();
               System.out.println("����ó�� �� �ϱ� �� �ϼ���?"
                     + "1. �߰� 2. ���� 3.������ 4.���� 5.���ư���");
               optstr = in.readLine();
               opt = Integer.parseInt(optstr);
               
               switch(opt) {
               case 1: contacts.add_contact();break;
               case 4: contacts.delete_contact();break;
               case 3: contacts.detail_contact();break;
               case 2: contacts.modify_contact();break;   
               case 5: break;
               }
               
               
            }
            break;
            
         case 2:
        	  Todolist todolists = new Todolist();
              while(opt!=5) {
            
            todolists.list_todolist();
            System.out.println("��� ���� ���� �ϱ� ���ϼ���?"
                  + "1. �߰� 2. ���� 3.������ 4.���� 5.���ư���");
            optstr = in.readLine();
            opt = Integer.parseInt(optstr);
            
            switch(opt) {
            case 1: todolists.add_todolist();break;
            case 4: todolists.delete_todolist();break;
            case 3: todolists.detail_todolist();break;
            case 2: todolists.modify_todolist();break;
            case 5: break;
            }
            
            
         }
         break;
         
            
         case 3:
        	 Appointment appointments = new Appointment();
             while(opt!=5) {
        	
           appointments.list_appointment();
           System.out.println("����ó�� �� �ϱ� �� �ϼ���?"
                 + "1. �߰� 2. ���� 3.������ 4.���� 5.���ư���");
           optstr = in.readLine();
           opt = Integer.parseInt(optstr);
           
           switch(opt) {
           case 1: appointments.add_appointment();break;
           case 4: appointments.delete_appointment();break;
           case 3: appointments.detail_appointment();break;
           case 2: appointments.modify_appointment();break;   
           case 5: break;
           }
           
           
        }
        break;
        
            
        
            
            
         }


         
         
         }
   }
   
   
      public static class newContact{
         String name;
         String tel;
         String email;
         
         public newContact(String email, String name, String tel) {
            this.name = name;
            this.tel = tel;
            this.email = email;
         }
         

         public String toString() {
            return String.format("�̸���:"+email
                           +"�̸�:"+name
                           +"��ȭ��ȣ:"+tel);
            
         }
         
      }
      

   
      public static class Contact{
      String name;
      String tel;
      String email;
      String changedName;

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       ArrayList<newContact> contacts = new ArrayList<newContact>(); 

      public void add_contact() throws IOException {
 newContact contact = new newContact(email,name,tel);
      
    	  
    	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

 		 Connection con = null;
 	      PreparedStatement pstmt= null;
 	      int rs;
 	      String sql = "";

 	      
            System.out.println("�߰��� ����ó ������ �Է��ϼ���\n");
            
            System.out.println("�̸���:");
            String email = in.readLine();
            System.out.println("\n");

            System.out.println("�̸�:");
            String name = in.readLine();
            System.out.println("\n");

            System.out.println("��ȭ��ȣ:");
            String tel = in.readLine();
            System.out.println("\n");

            contacts.add(contact);
            
            
            try {
 		         Class.forName("com.mysql.jdbc.Driver");
 		         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
 		         con = DriverManager.getConnection(url, "root", "moon3921");
 		         
 		        sql = " INSERT INTO contact(email, name, tel) VALUES (?, ?, ?)"; 
 		        pstmt = con.prepareStatement(sql);
 		        pstmt.setString(1,email);
 		        pstmt.setString(2,name);
 		        pstmt.setString(3,tel);
 		        rs= pstmt.executeUpdate();
 		         
 		       
 				System.out.println("��� ���� ����");
 		      }
 		      catch(Exception e) {
 		         e.printStackTrace();
 		      } finally {
 		      }
 		

      }
      
      public int size() {
         // TODO Auto-generated method stub
         return 0;
      }

      public void modify_contact() throws IOException {
          
          list_contact();
          
          System.out.println("�����ϰ� ���� ����� �̸��� �Է��ϼ���\n");
          System.out.println("�̸�:");
          name = in.readLine();
          System.out.println("\n");
          
          
          System.out.println("������ ������� �Է��ϼ���\n");
          System.out.println("�̸�:");
          changedName = in.readLine();
          System.out.println("\n");
          
          System.out.println("��ȭ��ȣ:");
          tel = in.readLine();
          System.out.println("\n");

          System.out.println("�̸���:");
          email = in.readLine();
          System.out.println("\n");
          
          Connection con = null;
 	      PreparedStatement pstmt= null;
 	      int rs;
 	      String sql = "";

  	    try {
 	         Class.forName("com.mysql.jdbc.Driver");
 	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
 	         con = DriverManager.getConnection(url, "root", "moon3921");
 	         
 	         sql = "UPDATE contact SET email = ?, name = ?, tel = ? WHERE name = ?"; 
 	        
 	         pstmt = con.prepareStatement(sql);
 	         pstmt.setString(1, email);
 	         pstmt.setString(2, changedName);
 	         pstmt.setString(3, tel);
 	         pstmt.setString(4, name);
 	         rs= pstmt.executeUpdate();
 	             
 		       
 			System.out.println("��� ���� ����");
 	         
 	         
  	    }
  	   catch(Exception e) {
 	         e.printStackTrace();
 	      } finally {
 	      }

       }
   

      
      public void list_contact() {
         
    	 Connection con = null;
  	     PreparedStatement pstmt= null;
  	     ResultSet rs= null;
  	     String sql = "";

  	    try {
 	         Class.forName("com.mysql.jdbc.Driver");
 	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
 	         con = DriverManager.getConnection(url, "root", "moon3921");
 	         
 	         sql = "select * from contact"; 
 	        
 	         pstmt = con.prepareStatement(sql);
 	         rs= pstmt.executeQuery();
 	         
 	         while(rs.next()) {
 	        	 String name = rs.getString("name");
 	        	 System.out.format("%s\n", name);
 	        	 
 	         }
  	    }
  	   catch(Exception e) {
 	         e.printStackTrace();
 	      } finally {
 	      }
     
         
      }
      
      public String detail_contact() throws IOException {
    	  list_contact();
          
          System.out.println("���ϰ� �˰� ���� ����ó�� �̸��� �Է��ϼ���:");
          name = in.readLine();
          
          Connection con = null;
  	     PreparedStatement pstmt= null;
  	     ResultSet rs= null;
  	     String sql = "";

  	    try {
 	         Class.forName("com.mysql.jdbc.Driver");
 	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
 	         con = DriverManager.getConnection(url, "root", "moon3921");
 	         
 	         sql = "select * from contact where name = ?"; 
 	        
 	         pstmt = con.prepareStatement(sql);
 	         pstmt.setString(1, name);
 	         rs= pstmt.executeQuery();
 	         
 	         while(rs.next()) {
 	        	 String name = rs.getString("name");
 	        	 String email = rs.getString("email");
 	        	 String tel = rs.getString("tel");
 	        	 System.out.format("%s, %s, %s\n", name, email, tel);
 	        	 
 	     
 	         }
  	    }
  	   catch(Exception e) {
 	         e.printStackTrace();
 	      } finally {
 	      }
     
  
          System.out.println("\n");
          
          return name;
      }
      
      public void delete_contact() throws IOException {
         list_contact();
         System.out.println("�����ϰ� ���� ����ó �̸��� �Է��ϼ���:");
         name = in.readLine();
         
         Connection con = null;
	      PreparedStatement pstmt= null;
	      int rs;
	      String sql = "";

  	    try {
 	         Class.forName("com.mysql.jdbc.Driver");
 	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
 	         con = DriverManager.getConnection(url, "root", "moon3921");
 	         
 	         sql = "DELETE FROM contact where name = ?"; 
 	        
 	         pstmt = con.prepareStatement(sql);
 	         pstmt.setString(1, name);
 	         rs= pstmt.executeUpdate();
 	         
 	        
  	    }
  	   catch(Exception e) {
 	         e.printStackTrace();
 	      } finally {
 	      }
  	    
      }
      
      
      public String toString() {
         return contacts.toString();
      }
   


      }

      public static class newAppointment{
    	  String title;
    	  String date;
    	  String friendname;
    	  String location;
          
          public newAppointment(String title, String date, String friendname, String location) {
             this.title = title;
             this.date = date;
             this.friendname = friendname;
          }
          

          public String toString() {
             return String.format("����:"+title
                            +"��¥:"+date
                            +"ģ���̸�:"+friendname+"���:"+location);
          }
      }
      
      public static class Appointment{
                 String title;
                 String date;
                 String friendname;
                 String location;
                 String changedTitle;

                 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                  ArrayList<newAppointment> appointments = new ArrayList<newAppointment>(); 

                 public void add_appointment() throws IOException {
               	  newAppointment appointment = new newAppointment(title,date,friendname, location);
                 
               	  
               	  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            		  Connection con = null;
            	      PreparedStatement pstmt= null;
            	      int rs;
            	      String sql = "";

            	      
                       System.out.println("�߰��� ��� ������ �Է��ϼ���\n");
                       
                       System.out.println("����:");
                       String title = in.readLine();
                       System.out.println("\n");

                       System.out.println("��¥:");
                       String date = in.readLine();
                       System.out.println("\n");

                       System.out.println("ģ���̸�:");
                       String friendname = in.readLine();
                       System.out.println("\n");

                       System.out.println("���:");
                       String location = in.readLine();
                       System.out.println("\n");
                       
                       appointments.add(appointment);
                       
                       
                       try {
            		         Class.forName("com.mysql.jdbc.Driver");
            		         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
            		         con = DriverManager.getConnection(url, "root", "moon3921");
            		         
            		        sql = " INSERT INTO appointment(title, date, friendname, location) VALUES (?, ?, ?, ?)"; 
            		        pstmt = con.prepareStatement(sql);
            		        pstmt.setString(1,title);
            		        pstmt.setString(2,date);
            		        pstmt.setString(3,friendname);
            		        pstmt.setString(4,location);
            		        rs= pstmt.executeUpdate();
            		         
            		       
            				System.out.println("��� ���� ����");
            		      }
            		      catch(Exception e) {
            		         e.printStackTrace();
            		      } finally {
            		      }
            		

                 }
                 
                 public int size() {
                    // TODO Auto-generated method stub
                    return 0;
                 }

                 public void modify_appointment() throws IOException {
                     
                     list_appointment();
                     
                     System.out.println("�����ϰ� ���� ����� ������ �Է��ϼ���\n");
                     System.out.println("����:");
                     title = in.readLine();
                     System.out.println("\n");
                     
                     System.out.println("������ ������� �Է��ϼ���\n");
                     System.out.println("����:");
                     changedTitle = in.readLine();
                     System.out.println("\n");
                     
                     System.out.println("��¥:");
                     date = in.readLine();
                     System.out.println("\n");

                     System.out.println("ģ���̸�:");
                     friendname = in.readLine();
                     System.out.println("\n");
                     
                     System.out.println("���:");
                     location = in.readLine();
                     System.out.println("\n");
                     
                     Connection con = null;
            	      PreparedStatement pstmt= null;
            	      int rs;
            	      String sql = "";

             	    try {
            	         Class.forName("com.mysql.jdbc.Driver");
            	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
            	         con = DriverManager.getConnection(url, "root", "moon3921");
            	         
            	         sql = "UPDATE appointment SET title = ?, date = ?, friendname = ?, location = ? WHERE title = ?"; 
            	        
            	         pstmt = con.prepareStatement(sql);
            	         
            	         pstmt.setString(1, changedTitle);
            	         pstmt.setString(2, date);
            	         pstmt.setString(3, friendname);
            	         pstmt.setString(4, location);
            	         pstmt.setString(5, title);
            	         rs= pstmt.executeUpdate();
            	             
            		       
            			System.out.println("��� ���� ����");
            	         
            	         
             	    }
             	   catch(Exception e) {
            	         e.printStackTrace();
            	      } finally {
            	      }

                  }
              

                 
                 public void list_appointment() {
                    
               	 Connection con = null;
             	     PreparedStatement pstmt= null;
             	     ResultSet rs= null;
             	     String sql = "";

             	    try {
            	         Class.forName("com.mysql.jdbc.Driver");
            	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
            	         con = DriverManager.getConnection(url, "root", "moon3921");
            	         
            	         sql = "select * from appointment"; 
            	        
            	         pstmt = con.prepareStatement(sql);
            	         rs= pstmt.executeQuery();
            	         
            	         while(rs.next()) {
            	        	 String title = rs.getString("title");
            	        	 System.out.format("%s\n", title);
            	        	 
            	         }
             	    }
             	   catch(Exception e) {
            	         e.printStackTrace();
            	      } finally {
            	      }
                
                    
                 }
                 
                 public String detail_appointment() throws IOException {
               	  list_appointment();
                     
                     System.out.println("���ϰ� �˰� ���� ����� ������ �Է��ϼ���:");
                     title = in.readLine();
                     
                     Connection con = null;
             	     PreparedStatement pstmt= null;
             	     ResultSet rs= null;
             	     String sql = "";

             	    try {
            	         Class.forName("com.mysql.jdbc.Driver");
            	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
            	         con = DriverManager.getConnection(url, "root", "moon3921");
            	         
            	         sql = "select * from appointment where title = ?"; 
            	        
            	         pstmt = con.prepareStatement(sql);
            	         pstmt.setString(1, title);
            	         rs= pstmt.executeQuery();
            	         
            	         while(rs.next()) {
            	        	 String title = rs.getString("title");
            	        	 String date = rs.getString("date");
            	        	 String friendname = rs.getString("friendname");
           	        	 String location = rs.getString("location");
            	        	 System.out.format("%s, %s, %s, %s\n", title, date, friendname, location);
            	        	 
            	     
            	         }
             	    }
             	   catch(Exception e) {
            	         e.printStackTrace();
            	      } finally {
            	      }
                
             
                     System.out.println("\n");
                     
                     return title;
                 }
                 
                 public void delete_appointment() throws IOException {
                    list_appointment();
                    System.out.println("�����ϰ� ���� ��� ������ �Է��ϼ���:");
                    title = in.readLine();
                    
                    Connection con = null;
           	      PreparedStatement pstmt= null;
           	      int rs;
           	      String sql = "";

             	    try {
            	         Class.forName("com.mysql.jdbc.Driver");
            	         String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
            	         con = DriverManager.getConnection(url, "root", "moon3921");
            	         
            	         sql = "DELETE FROM appointment where title = ?"; 
            	        
            	         pstmt = con.prepareStatement(sql);
            	         pstmt.setString(1, title);
            	         rs= pstmt.executeUpdate();
            	         
            	        
             	    }
             	   catch(Exception e) {
            	         e.printStackTrace();
            	      } finally {
            	      }
             	    
                 }
                 
                 
                 public String toString() {
                    return appointments.toString();
                 }
              }
             
             
      
      public static class newTodolist{
         String title;
         String createdate;
         String finishdate;
         String description;
         
         public newTodolist(String title, String createdate, String finishdate, String description) {
            this.title = title;
            this.createdate = createdate;
            this.finishdate = finishdate;
            this.description = description;
         }
         

         public String toString() {
            return String.format("����:"+title
                           +"������¥:"+createdate
                           +"������¥:"+finishdate
                           +"����:"+description);
            
         }
         
      }
      

   
      public static class Todolist{
      String title;
      String createdate;
      String finishdate;
      String description;
      String changedTitle;

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       ArrayList<newTodolist> todolists = new ArrayList<newTodolist>(); 

      public void add_todolist() throws IOException {
    	  newTodolist todolist = new newTodolist(title, createdate, finishdate, description);
      
         
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Connection con = null;
          PreparedStatement pstmt= null;
          int rs;
          String sql = "";

          
            System.out.println("�߰��� ������ �Է��ϼ���\n");
            
            System.out.println("Ÿ��Ʋ:");
            String title = in.readLine();
            System.out.println("\n");

            System.out.println("������¥:");
            String createdate = in.readLine();
            System.out.println("\n");

            System.out.println("������¥:");
            String finishdate = in.readLine();
            System.out.println("\n");

            System.out.println("����:");
            String description = in.readLine();
            System.out.println("\n");

            todolists.add(todolist);
            
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
                con = DriverManager.getConnection(url, "root", "moon3921");
                
               sql = " INSERT INTO todolist(title, createdate, finishdate, description) VALUES (?, ?, ?, ?)"; 
               pstmt = con.prepareStatement(sql); //���� ��ģ�ǵ� Ʋ�������������� Ȯ�κ�Ź�����! 
               pstmt.setString(1,title);
               pstmt.setString(2,createdate);
               pstmt.setString(3,finishdate);
               pstmt.setString(4,description);
               rs= pstmt.executeUpdate();
                
              
             System.out.println("��� ���� ����");
             }
             catch(Exception e) {
                e.printStackTrace();
             } finally {
             }
       

      }
      
      public int size() {
         // TODO Auto-generated method stub
         return 0;
      }

      public void modify_todolist() throws IOException {
          
          list_todolist();
          
          System.out.println("�����ϰ� ���� ������ Ÿ��Ʋ�� �Է��ϼ���\n");
          System.out.println("Ÿ��Ʋ:");
          title = in.readLine();
          System.out.println("\n");
          
          System.out.println("������ ������� �Է��ϼ���\n");
          System.out.println("Ÿ��Ʋ:");
          changedTitle = in.readLine(); 
          System.out.println("\n");
          
          System.out.println("������¥:");
          createdate = in.readLine();
          System.out.println("\n");

          System.out.println("������¥:");
          finishdate = in.readLine();
          System.out.println("\n");

          System.out.println("����:");
          description = in.readLine();
          System.out.println("\n");
          
          Connection con = null;
          PreparedStatement pstmt= null;
          int rs;
          String sql = "";

         try {
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
             con = DriverManager.getConnection(url, "root", "moon3921");
             
             sql = "UPDATE todolist SET title = ?, createdate = ?, finishdate = ?, description = ? WHERE title = ?"; 
            
             pstmt = con.prepareStatement(sql); //���ܵӴϴ�
             pstmt.setString(1, changedTitle);
             pstmt.setString(2, createdate);
             pstmt.setString(3, finishdate);
             pstmt.setString(4, description);
             pstmt.setString(5, title);
             rs= pstmt.executeUpdate();
                 
              
          System.out.println("��� ���� ����");
             
             
         }
        catch(Exception e) {
             e.printStackTrace();
          } finally {
          }

       }
   

      
      public void list_todolist() {
         
        Connection con = null;
          PreparedStatement pstmt= null;
          ResultSet rs= null;
          String sql = "";

         try {
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
             con = DriverManager.getConnection(url, "root", "moon3921");
             
             sql = "select * from todolist"; 
            
             pstmt = con.prepareStatement(sql);
             rs= pstmt.executeQuery();
             
             while(rs.next()) {
                String title = rs.getString("title");
                System.out.format("%s\n", title);
                
             }
         }
        catch(Exception e) {
             e.printStackTrace();
          } finally {
          }
     
         
      }
      
      public String detail_todolist() throws IOException {
         list_todolist();
          
          System.out.println("���ϰ� �˰� ���� ����ó�� �̸��� �Է��ϼ���:");
          title = in.readLine();
          
          Connection con = null;
          PreparedStatement pstmt= null;
          ResultSet rs= null;
          String sql = "";

         try {
             Class.forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
             con = DriverManager.getConnection(url, "root", "moon3921");
             
             sql = "select * from todolist where title = ?"; 
            
             pstmt = con.prepareStatement(sql);
             pstmt.setString(1, title);
             rs= pstmt.executeQuery();
             
             while(rs.next()) {
                String title = rs.getString("title");
                String createdate = rs.getString("createdate");
                String finishdate = rs.getString("finishdate");
                String description = rs.getString("description");
                System.out.format("%s, %s, %s, %s\n", title, createdate, finishdate, description);
                
         
             }
         }
        catch(Exception e) {
             e.printStackTrace();
          } finally {
          }
       
         
          return title;
      }
      
      public void delete_todolist() throws IOException {
         list_todolist();
         System.out.println("�����ϰ� ���� ����ó �̸��� �Է��ϼ���:");
         title = in.readLine();
         
         Connection con = null;
         PreparedStatement pstmt= null;
         int rs;
         String sql = "";

         try {
             Class.forName("com.mysql.jdbc.Driver");//���ܵӴϴ�
             String url = "jdbc:mysql://localhost/mynote?serverTimezone=UTC";
             con = DriverManager.getConnection(url, "root", "moon3921");
             
             sql = "DELETE FROM todolist where title = ?"; 
            
             pstmt = con.prepareStatement(sql);
             pstmt.setString(1, title);
             rs= pstmt.executeUpdate();
             
            
         }
        catch(Exception e) {
             e.printStackTrace();
          } finally {
          }
         
      }
      
      
      public String toString() {
         return todolists.toString();
      }
   }
      
      
      
            
}
      
