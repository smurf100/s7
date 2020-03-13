import java.io.*;
import java.sql.*;

class prg5
 {
 	public static void main(String args[])
 	  {
 	  	String name;
 	  	int rno,ch,r,flag=0;
 	  	double per;
 	  	Connection con=null;
 	  	PreparedStatement pst=null;
 	  	ResultSet rs=null;
 	  	Statement st=null;
 	  	try
 	  	 {
 	  	 	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 	  	 	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        con=DriverManager.getConnection("jdbc:odbc:tybcs"); 
            st=con.createStatement();
 	  	 	System.out.println("Main menu for operations on student table:");
 	  	 	System.out.println("1:Insert");
 	  	 	System.out.println("2:Modify");
 	  	 	System.out.println("3:Delete");
 	  	 	System.out.println("4:Search");
 	  	 	System.out.println("5:View All");
 	  	 	System.out.println("6:Exit");
 	  	 	do
 	  	 	 {
 	  	 	   System.out.print("Enter your choice:");
 	  	 	   ch=Integer.parseInt(br.readLine());
 	  	 	   switch(ch)
 	  	 	    {
 	  	 	     	case 1:	System.out.print("Enter the student Roll number:");
 	  	 	 	            rno=Integer.parseInt(br.readLine());
 	  	 	 			    System.out.print("Enter the student name:");
 	  	 	 	            name=br.readLine();
 	  	 	 				System.out.print("Enter the student percentage:");
 	  	 	 				per=Double.parseDouble(br.readLine());
 	  	 	 				pst=con.prepareStatement("insert into student values(?,?,?)");
 	  	 	 				pst.setInt(1,rno);
 	  	 	 				pst.setString(2,name);
 	  	 	 				pst.setDouble(3,per);
 	  	 	 				pst.executeUpdate();
 	  	 	 				break;
 	  	            case 2:	flag=0;
 	  	                    System.out.print("Enter the name for modify the record:");
 	  	 	 	          String nm=br.readLine();
 	  	 	 			    rs=st.executeQuery("select * from student");
 	  	 	 			    while(rs.next())
 	  	                      {
 	  	                        name=rs.getString(2);
 	  	                        if(name.equals(nm))
 	  	                          {
 	  	                            System.out.print("Enter the student Roll number:");
 	  	 	 	            rno=Integer.parseInt(br.readLine());
 	  	 	 			    System.out.print("Enter the student name:");
 	  	 	 	            name=br.readLine();
 	  	 	 				System.out.print("Enter the student percentage:");
 	  	 	 				per=Double.parseDouble(br.readLine());
 	  	 	 			            pst=con.prepareStatement("update student set rno='"+rno+"',name='"+name+"',per='"+per+"'where name='"+nm+"'");
 	  	 	 			            pst.executeUpdate();
 	  	 	 			            System.out.println("The record of name "+nm+" is modify.");
 	  	                            flag=1;
 	  	                            break;
 	  	                          }  
 	    	  	              }
 	    	  	            if(flag==0)
 	  	 	 			      System.out.println("Record not found.");
 	  	                    break;	
 	  	            case 3:	flag=0;
 	  	                    System.out.print("Enter the name for delete the record:");
 	  	 	 	            nm=br.readLine();
 	  	 	 			    rs=st.executeQuery("select * from student");
 	  	 	 			    while(rs.next())
 	  	                      {
 	  	                        name=rs.getString(2);
 	  	                        if(name.equals(nm))
 	  	                          {
 	  	                            pst=con.prepareStatement("delete from student where name='"+nm+"'");
 	  	 	 			            pst.executeUpdate();
 	  	 	 			            System.out.println("The record of name "+nm+" is deleted.");
 	  	                            flag=1;
 	  	                            break;
 	  	                          }  
 	    	  	              }
 	    	  	            if(flag==0) 
 	  	 	 			      System.out.println("Record not found.");
 	  	                    break;  
 	  	            case 4:	flag=0;
 	  	                    System.out.print("Enter the student Roll number for search the record:");
 	  	 	 	            r=Integer.parseInt(br.readLine());
 	  	 	 			    rs=st.executeQuery("select * from student");
 	  	 	 			    while(rs.next())
 	  	 	 			      {
 	  	 	 			        rno=rs.getInt(1);
 	  	 	 			        if(rno==r)
 	  	                         {
					   System.out.println("student roll number found");
 	  	                           System.out.println("The student details is:");
 	  	                           System.out.println("    Roll number  Name   Percentage"); 
 	  	                           name=rs.getString(2);
 	  	                           per=rs.getDouble(3);
 	  	                           System.out.println("\t"+rno+"\t"+name+"\t"+per);
 	  	                           flag=1;
 	  	                           break;
 	  	                         }  
 	  	                      }  
 	    	  	            if(flag==0) 
 	    	  	              System.out.println("Student Roll number not found.");
 	  	                    break;                                	
 	  	 	 	    case 5: System.out.println("The student details is:");
 	  	                    System.out.println("    Roll number  Name   Percentage"); 	  	  	 
 	  	                    rs=st.executeQuery("select * from student");
 	  	                    while(rs.next())
 	  	                      {
 	  	                        rno=rs.getInt(1);
 	  	                        name=rs.getString(2);
 	  	                        per=rs.getDouble(3);
 	  	                        System.out.println("\t"+rno+"\t"+name+"\t"+per);
 	  	                      }
 	  	                    break;
 	  	            case 6: System.exit(0);
 	  	         }
 	  	     }while(ch!=6);               
 	  	                   
 	  	}
 	   catch(Exception e)	
 	  	{
 	  		System.out.println("Error:"+e);
 	  	}
 	 }
 }

/* OUTPUT 

E:\ashwini>javac prg5.java

E:\ashwini>java prg5
Main menu for operations on student table:
1:Insert
2:Modify
3:Delete
4:Search
5:View All
6:Exit
Enter your choice:5
The student details is:
    Roll number  Name   Percentage
        1       Ashwini 78.89
        2       Om      65.78
        3       Yash    89.78
        5       Harshal 67.0
Enter your choice:1
Enter the student Roll number:6
Enter the student name:Seeta
Enter the student percentage:47.12
Enter your choice:5
The student details is:
    Roll number  Name   Percentage
        1       Ashwini 78.89
        2       Om      65.78
        3       Yash    89.78
        5       Harshal 67.0
        6       Seeta   47.12  
Enter your choice:2
Enter the student Roll number for modify the record:5
Student Roll number not found.        
Enter your choice:2
Enter the student Roll number for modify the record:5
Enter the student Roll number:4
Enter the student name:Harshal
Enter the student percentage:67
The record of roll number 5 is modify.
Enter your choice:5
The student details is:
    Roll number  Name   Percentage
        1       Ashwini 78.89
        2       Om      65.78
        3       Yash    89.78
        4       Harshal 67.0 
        6       Seeta   47.12 
Enter your choice:3
Enter the student Roll number for delete the record:5
Student Roll number not found.         
Enter your choice:3
Enter the student Roll number for delete the record:6
The record of roll number 6 is deleted.
Enter your choice:5
The student details is:
    Roll number  Name   Percentage
        1       Ashwini 78.89
        2       Om      65.78
        3       Yash    89.78
        4       Harshal 67.0            
Enter your choice:4
Enter the student Roll number for search the record:8
Student Roll number not found.
Enter your choice:4
Enter the student Roll number for search the record:3
The student details is:
    Roll number  Name   Percentage
        3       Yash    89.78               
Enter your choice:6                                          */