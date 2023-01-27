//NAME:-SATYASWARUP OJHA
//CODECLAUSE GOLDEN PROJECT
//PROJECT NAME:- EXAM SEATING ARRANGEMENT SYSTEM
import java.sql.*;
import java.util.*;
 class connection
 {
     public static void main(String[] args) throws Exception
     {

         System.out.println("................WELCOME TO EXAM SEATING ARRANGEMENT SYSTEM..................");

         //JDBC CONNECTION
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
         Statement st=con.createStatement();
         //TO CHECK WHETHER YOU ARE STUDENT OR ADMIN
         Scanner sc=new Scanner(System.in);
         System.out.println("ENTER [1] IF YOU ARE THE ADMIN");
         System.out.println("ENTER [2] IF YOU ARE A STUDENT");
         int tr=sc.nextInt();
         int dec=1,dec1=1;
         if(tr==1)
         {
             while(dec!=0)
             {
                 //TO PERFORM THE FUNCTIONS BY THE ADMIN


             System.out.println("ENTER [1] TO ADD DETAILS ABOUT A STUDENT");
             System.out.println("ENTER [2] TO VIEW STUDENT DETAILS");
             System.out.println("ENTER [3] TO ENTER CLASS ROOM DETAILS");
             Scanner scc=new Scanner(System.in);
             int ch=scc.nextInt();
             switch(ch) {
                 case 1:

                     Scanner sc1 = new Scanner(System.in);
                     String name2,branch;
                     int roll, sem;
                     System.out.println("ENTER YOUR ROLL NUMBER");
                     roll = sc1.nextInt();
                     Scanner sc6=new Scanner(System.in);
                     System.out.println("ENTER YOUR NAME IN SINGLE QUOTES");
                     name2 = sc6.nextLine();
                     System.out.println("ENTER  YOUR BRANCH IN SINGLE QUOTES");
                     branch = sc6.nextLine();
                     System.out.println("ENTER YOUR SEMESTER");
                     sem = sc1.nextInt();
                     String stmt1 = "insert into stdt values("+roll+","+name2+","+branch +","+sem+")";
                     st.executeUpdate(stmt1);

                     break;
                 case 2:
                     int roll1;
                     Scanner sc2 = new Scanner(System.in);
                     System.out.println("ENTER [1] TO VIEW PARTICULAR STUDENT DETAILS BASED ON ROLL NO");
                     System.out.println("ENTER [2] TO VIEW THE DETAILS OF ALL STUDENTS");
                     int ch1 = sc2.nextInt();
                     if (ch1 == 1) {
                         System.out.println("ENTER THE ROLL NUMBER OF THAT STUDENT");
                         roll1 = sc2.nextInt();
                         String stmt2 = "select * from stdt where roll="+roll1;
                         ResultSet rs1 = st.executeQuery(stmt2);
                         while (rs1.next()) {
                             System.out.println(rs1.getInt(1) + "  " + rs1.getString(2) + " " + rs1.getString(3) + " " + rs1.getInt(4));
                         }

                     }
                     if (ch1 == 2) {
                         ResultSet rs2 = st.executeQuery("select * from stdt");
                         while (rs2.next()) {
                             System.out.println(rs2.getInt(1) + "  " + rs2.getString(2) + " " + rs2.getString(3) + " " + rs2.getInt(4));
                         }


                     }
                     break;
                 case 3:
                     Scanner sc3 = new Scanner(System.in);
                     int total, classes, seats, columns;
                     System.out.println("ENTER THE TOTAL NUMBER OF STUDENTS");
                     total = sc3.nextInt();
                     System.out.println("ENTER THE TOTAL NUMBER OF CLASSES");
                     classes = sc3.nextInt();
                     System.out.println("ENTER THE TOTAL NUMBER OF SEATS IN EACH CLASS");
                     seats = sc3.nextInt();
                     System.out.println("ENTER THE TOTAL NUMBER OF COLUMNS IN EACH CLASS");
                     columns = sc3.nextInt();
                     System.out.println("ENTER 1 TO GENERATE THE SEATING ARRANGEMENTS");
                     int rows = seats / columns;
                     int ch2 = sc3.nextInt();
                     int a=1;
                     for (int i = 1; i <= rows; i++) {
                         System.out.print("ROW" + i + "::");
                         for (int j = 1; j <= columns; j++) {
                             System.out.print(a + " ");
                             a++;
                         }
                         System.out.println();
                     }
                     break;
             }

             Scanner sc7=new Scanner(System.in);
             System.out.println("ENTER [1] TO CONTINUE AND [0] TO EXIT");
             dec= sc7.nextInt();



             }}
         //TO PERFORM THE FUNCTIONS BY A STUDENT
         if(tr==2)

         {
             while(dec1!=0)
             {

             System.out.println("HAVE YOU REGISTRED?");
             System.out.println("ENTER [1] IF ALREADY REGISTERED");
             System.out.println("ENTER [2] IF NOT REGISTERED");
             int ch4;
             Scanner sc8=new Scanner(System.in);
             ch4=sc8.nextInt();
             if(ch4==1)
             {
                 System.out.println("THANK YOU FOR REGISTERING!");

             }
             if(ch4==2)
             {
                 Scanner sc4=new Scanner(System.in);
                 String name1,branch1; int roll1,sem1;
                 System.out.println("ENTER YOUR ROLL NUMBER");
                 roll1 = sc4.nextInt();
                 Scanner sc9=new Scanner(System.in);
                 System.out.println("ENTER YOUR NAME IN SINGLE QUOTES");
                 name1 = sc9.nextLine();
                 System.out.println("ENTER  YOUR BRANCH IN SINGLE QUOTES");
                 branch1 = sc9.nextLine();
                 System.out.println("ENTER YOUR SEMESTER");
                 sem1 = sc4.nextInt();
                 String stmt4 = "insert into stdt values("+roll1+","+name1+","+branch1+","+sem1+")";
                 st.executeUpdate(stmt4);

             }}


         }
         con.close();
   }
 }