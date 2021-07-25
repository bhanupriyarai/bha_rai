import java.util.Scanner;
import java.io.*;
class ATM 
{
static Scanner sc = new Scanner(System.in);
static int balance = 50000;

 public static void main(String...s) throws Exception
{
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  File file = new File("username.txt");
  System.out.print("Please enter the user name : "); 
  FileWriter fstream = new FileWriter("username.txt");
  BufferedWriter o = new BufferedWriter(fstream);
  o.write(in.readLine());
  o.close();
  
  File file1 = new File("password.txt");
  System.out.print("Please enter the password : "); 
  FileWriter gstream = new FileWriter("password.txt");
  BufferedWriter k = new BufferedWriter(gstream);
  k.write(in.readLine());
  k.close();
  FileReader f1 = new FileReader("username.txt");
  FileReader f2 = new  FileReader("password.txt"); 
  System.out.println("enter username");
       String b = sc.next();
             if(f1.equals(b))
	{
	 ATM a = new ATM();
        a.menu();
	}
	else
	{
	System.out.println("invalid username try next time");
	}
}

public void menu() 
{
System.out.println("input choice 1.withdrawal 2.deposit 3.exit 4.mini statement 5.balance");
int c = sc.nextInt();
switch(c)
{
case 1 :withdrawal();
	System.out.println("enter choice 1.continue 2.exit");
	int w = sc.nextInt();
	switch(w)
	{
	case 1 : menu();
	case 2 : System.out.println("you have been logged out"); 
	System.exit(0);
	break;
	}
case 2 :deposit();
	System.out.println("enter choice 1.continue 2.exit");
	int x = sc.nextInt();
	switch(x)
	{
	case 1 : menu();
	case 2 : System.out.println("you have been logged out"); 
	System.exit(0);
	break;
	}
case 3 : System.out.println("you have been logged out"); 
	System.exit(0);
	break;
case 4 : statement();
	System.out.println("enter choice 1.continue 2.exit");
	int y = sc.nextInt();
	switch(y)
	{
	case 1 : menu();
	case 2 : System.out.println("you have been logged out"); 
	System.exit(0);
	break;
	}
case 5 : System.out.println("your current balance is"+balance);
	System.out.println("enter choice 1.continue 2.exit");
	int z = sc.nextInt();
	switch(z)
	{
	case 1 : menu();
	case 2 : System.out.println("you have been logged out"); 
	System.exit(0);
	break;
	}
default : System.out.println("you have been logged out"); 
	System.exit(0);
	break;
}
}
        
public void withdrawal()
{
FileReader  f3 = new  FileReader("password.txt");
System.out.println("input password");
Scanner sc = new Scanner(System.in);
String d = sc.next();
if(f3.equals(d))
{
transac();
}
else
{
System.out.println("invalid pin");
System.exit(0);
}
}

public void transac()
{
System.out.println("your current balance is"+balance);
System.out.println("enter account type 1.savings 2.current");
Scanner sc = new Scanner(System.in);
int e = sc.nextInt();
switch(e)
{
case 1 : System.out.println("enter amount to withdraw");
	  int f = sc.nextInt();
             if(f< balance && f>0)
		{
		 notes(f);		
		balance=balance-f;
	System.out.println("new balance is" +balance);
	}
	     else
		{
		System.out.println("insufficient balance");
		}
	break;
case 2 : System.out.println("you would be charged 5% extra");
	System.out.println("enter amount to withdraw");
	  int g = sc.nextInt();
             if(g< balance && g>0)
		{
		 notes(g);
		System.out.println("amount withdrawn successfully");
		int h = g + (g *5)/100;
		    balance = balance-h;
		    System.out.println("new balance is" +balance);
		}
	     else
		{
		System.out.println("insufficient balance");
		}
	break;
}
}
public void notes(int g)
{
int total = 0;
if(total<g)
{
System.out.println("enter number of 1000 rupee notes");
int i = sc.nextInt();
total = total+ (1000*i);
	if(total<g){
	notes1(total,g);}
	if(total==g){
	System.out.println("amount withdrawn successfully");}
else
{
	System.out.println("amount exceeded try again");
	System.exit(0);
}}}

public void notes1(int total,int g)
{
int total1 = total;
System.out.println("enter number of 500 rupee notes");
int j = sc.nextInt();
total1 = total1+ (500*j);
	if(total1<g){
	notes2(total1,g);}
	if(total1==g){
	System.out.println("amount withdrawn successfully");}
	else{
	System.out.println("amount exceeded try again");
	System.exit(0);}
}


public void notes2(int total1,int g)
{
int total2 = total1;
System.out.println("enter number of 100 rupee notes");
int i = sc.nextInt();
total2 = total2 + (100*i);
	if(total2<g)
	{
	System.out.println("amount not proper try again");
	System.exit(0);
	}
	if(total2==g)
	{
	System.out.println("amount withdrawn successfully");
	}
else
{
	System.out.println("amount exceeded try again");
	System.exit(0);
}
}



public void deposit()
{
FileReader  f4 = new  FileReader("password.txt");
System.out.println("input password");
Scanner sc = new Scanner(System.in);
String l = sc.next();
if(f4.equals(l))
{
submit();
}
else
{
System.out.println("invalid pin");
 System.exit(0);
}
}
public void submit()
{
System.out.println("enter amount to submit");
Scanner sc = new Scanner(System.in);
int m = sc.nextInt();
if(m>0)
		{
		   System.out.println("amount submitted successfully");
		    balance = balance+m;
		    System.out.println("new balance is" +balance);
		}
	     else
		{
		System.out.println("invalid amount");
		}
}

    public void statement() 
{
        System.out.println("Inquire");
        System.out.println("the current balance is");
        System.out.println("your current balance is"+balance);
}
}   