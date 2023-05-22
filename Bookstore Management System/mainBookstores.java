import java.io.*;
import java.util.*;
import java.text.*;
public class mainBookstores
{
    public static void main ( String[]args)
    {
        String title, genre, language;
        String findlanguage, findtitle, custname, statusmember=null, staffId=null, statusout, staffid;
        int custage, age, numbook, numstat, year, totmember=0, totnonmember=0, totstaff=0, status=0, add, membership=0, nextcust;
        String input, input2, input3, Statnames, name, membershipcust, idmember=null, numember, printout;
        double price, Statprices;
        int  choose=0, buychoice, bookchoice=0, statchoice=0;
        int totalcust=0;
        double totalpricebook, totalpricestat, totalboth, totalsales=0.00, totaldiscount=0.00;
        
        DecimalFormat df = new DecimalFormat("0.00");
        try
        {
            File out = new File("Sales Records.txt");
            FileWriter fw = new FileWriter(out);
            PrintWriter pw = new PrintWriter(fw);
            
            File out2 = new File("Buyer Records.txt");
            FileWriter fw2 = new FileWriter(out2);
            PrintWriter pw2 = new PrintWriter(fw2);
            
            File out3 = new File("Buyer.txt");
            FileWriter fw3 = new FileWriter(out3);
            PrintWriter pw3 = new PrintWriter(fw3);
            
            File in = new File ("booklist.txt");
            FileReader fr = new FileReader(in);
            BufferedReader br = new BufferedReader(fr);
            BOOKSTORE [] book = new BOOKSTORE [10];
            for ( int i =0; i<book.length; i++)
            {
                input = br.readLine();
                StringTokenizer st = new StringTokenizer(input,";");
                title = st.nextToken();
                genre = st.nextToken();
                language = st.nextToken();
                year = Integer.parseInt(st.nextToken());
                price = Double.parseDouble(st.nextToken());
                book[i] = new BOOKSTORE (title,genre,language,year,price);
            }
            br.close();
            
            File in2 = new File ("stationery.txt");
            FileReader fr2 = new FileReader(in2);
            BufferedReader br2 = new BufferedReader(fr2);
            STATIONERY [] stat = new STATIONERY[11];
            for( int j=0; j<stat.length; j++ )
            {
                input2 = br2.readLine();
                StringTokenizer st2 = new StringTokenizer(input2,";");
                Statnames = st2.nextToken();
                Statprices = Double.parseDouble(st2.nextToken() );
                stat[j] = new STATIONERY (Statnames,Statprices);
            }
            br2.close();
            
            Scanner sc = new Scanner (System.in);
            
            nextcust = 1;
            pw2.println("BUYER RECORDS \n");
            while( nextcust==1)
            {
                totalpricebook = 0.00;
                totalpricestat = 0.00;
                totalboth = 0.00;
                System.out.print("Enter your name: ");
                sc.useDelimiter("\n");
                custname = sc.next();
                pw3.print(custname + "*");
                System.out.print("Enter your age: ");
                custage = sc.nextInt();
                pw3.print(custage + "*");
                System.out.println("You status?: \n1-Staff \n2-Customer: ");
                status = sc.nextInt();
                boolean c = false;
                while(c==false)
                {
                    if(status==1)
                    {
                        c=true;
                        pw3.print("staff" +"*");
                    }
                    else if(status==2)
                    {
                        c=true;
                        pw3.print("customer" +"*");
                    }
                    else
                    {
                        System.out.print("Wrong Input! Enter Again: ");
                        status=sc.nextInt();
                        c=false;
                    }
                }
                totalcust = totalcust + 1;
                pw.println("CUSTOMER NAME: " + custname.toUpperCase() );
                pw.println("\n");
                System.out.print('\u000C');
                System.out.println("HI " + custname.toUpperCase() + "! WELCOME TO OUR BOOKSTORE!\n\nWould you like to buy( Choose 1 or 2)?: ");
                add = 1;
                while ( add==1 )
                {
                    System.out.println("1-Book\n2-Others");
                    buychoice = sc.nextInt();
                    boolean condition0 = false;
                    while ( condition0 == false )
                    {
                        if ( buychoice == 1 )
                        {
                            System.out.println("How you want to find your books?: ");
                            System.out.println("\n1-By Language \n2-By Title");
                            bookchoice = sc.nextInt();
                            boolean cond0 = false;
                            while( cond0 == false )
                            {
                                if ( bookchoice == 1 )
                                {
                                    System.out.print("\nEnter book's language: ");
                                    findlanguage = sc.next();
                                    System.out.print('\u000C');
                                    boolean conditions = false;
                                    while ( conditions == false )
                                    {
                                        if ( findlanguage.equalsIgnoreCase("Melayu") )
                                        {
                                            System.out.println("LIST OF MELAYU BOOK: \n");
                                            for (int i=0; i<5;i++)
                                            {
                                                System.out.println("Book " + (i+1) );
                                                book[i].displaybook();
                                            }
                                            boolean condition;
                                            condition = false;
                                            System.out.print("Please choose your book(1-5): ");
                                            choose = sc.nextInt();
                                            while ( condition == false )
                                            {
                                                if ( choose>0 && choose<6 )
                                                {
                                                    System.out.print("How much you want?: ");
                                                    numbook = sc.nextInt();
                                                    totalpricebook = totalpricebook + book[choose-1].priceFindByLanguage(choose,numbook);
                                                    printout=book[choose-1].displayoutput(numbook);
                                                    pw.print(printout);
                                                    condition = true;
                                                }
                                                else
                                                {
                                                    System.out.print("Your choice not in list! \nEnter Again: ");
                                                    choose = sc.nextInt();
                                                    condition = false;
                                                }
                                            }
                                            conditions = true;    
                                        }
                                        else if ( findlanguage.equalsIgnoreCase("English") )
                                        {
                                            System.out.println("LIST OF ENGLISH BOOK: \n");
                                            for (int i=5; i<book.length;i++)
                                            {
                                                System.out.println("Book " + (i-4) );
                                                book[i].displaybook();
                                            }
                                            boolean condition2 = false;
                                            System.out.print("Please choose your book(1-5): ");
                                            choose = sc.nextInt();
                                            while( condition2 == false )
                                            {
                                                if ( choose>0 && choose<6 )
                                                {
                                                    System.out.print("How much you want?: ");
                                                    numbook = sc.nextInt();
                                                    totalpricebook = totalpricebook + book[choose+4].priceFindByLanguage(choose,numbook);
                                                    printout= book[choose+4].displayoutput(numbook);
                                                    pw.println(printout);
                                                    condition2 = true;
                                                }
                                                else
                                                {
                                                    System.out.print("Your choice not in list! \nEnter Again: ");
                                                    choose = sc.nextInt();
                                                    condition2 = false;
                                                }
                                            }
                                            conditions = true;    
                                        }
                                        else
                                        {
                                            System.out.print("Language is not found! Enter Again: ");
                                            findlanguage = sc.next();
                                            conditions = false;
                                        }
                                    }
                                    cond0 = true;    
                                }
                                
                                else if ( bookchoice == 2 )
                                {
                                    System.out.print("\nEnter book's title: ");
                                    sc.useDelimiter("\n");
                                    findtitle = sc.next();
                                    System.out.print('\u000C');
                                    boolean cond;
                                    cond = false;
                                    while( cond == false )
                                    {
                                        for ( int b=0; b<10; b++ )
                                        {
                                            if ( !findtitle.equalsIgnoreCase(book[b].getTitle()) )
                                            {
                                                cond = false;
                                            }  
                                        }
                                        for ( int a=0; a<10; a++ )
                                        {
                                            if (findtitle.equalsIgnoreCase(book[a].getTitle()))
                                            {
                                                cond = true;
                                                System.out.println("\nWe found your book! Book details: ");
                                                printout = book[a].toString();
                                                System.out.println(printout);
                                                System.out.print("How much you want?: ");
                                                numbook = sc.nextInt();
                                                totalpricebook = totalpricebook + book[a].priceFindByTitle(findtitle,numbook);
                                                printout = book[a].displayoutput(numbook);
                                                pw.println(printout);
                                            }
                                        }
                                        if ( cond == false )
                                        {
                                            System.out.print("SORRY WE DONT FIND YOUR BOOK! \nPlease enter again: ");
                                            sc.useDelimiter("\n");
                                            findtitle = sc.next();
                                        }
                                    }
                                    cond0 = true;
                                }
                                else
                                {
                                    System.out.print("Wrong Input! Enter Again: ");
                                    bookchoice = sc.nextInt();
                                    cond0 = false;
                                }
                            }
                            condition0 = true;
                        }
                        
                        else if ( buychoice == 2)
                        {
                            System.out.print('\u000C');
                            System.out.println("Stationeries List: \n");
                            for(int j=0; j<11; j++)
                            {
                                System.out.println( (j+1) + ") " + stat[j].getStatname() + 
                                                    "\nPrice: RM" + stat[j].getStatprice() );
                            }
                            boolean cond2;
                            System.out.print("\nPlease choose(1-11): ");
                            statchoice = sc.nextInt();
                            cond2 = false;
                            while( cond2 == false )
                            {
                                if ( statchoice>0 && statchoice<12)
                                {
                                    System.out.print("How much you want?: ");
                                    numstat = sc.nextInt();
                                    totalpricestat = totalpricestat + stat[statchoice-1].priceStationery(statchoice,numstat);
                                    printout = stat[statchoice-1].displayoutput(numstat);
                                    pw.println(printout);
                                    cond2 = true;
                                }
                                else
                                {
                                    System.out.print("SORRY YOU ENTER UNKNOWN INPUT. PLEASE ENTER AGAIN: ");
                                    statchoice = sc.nextInt();
                                    cond2 = false;
                                }   
                            }
                            condition0 = true;
                        }
                        else
                        {
                            System.out.print("Wrong Input! Enter Again: ");
                            buychoice = sc.nextInt();
                            condition0 = false;
                        }
                    }  
                    boolean cond3 = false;
                    System.out.print("Do you want to add anything? (1-Yes or 2-No)" );
                    add = sc.nextInt();
                    while ( cond3 == false )
                    {
                        if ( add==1 )
                        {
                            cond3=true;
                        }
                        else if ( add==2 )
                        {
                            cond3=true;
                        }
                        else
                        {
                            System.out.println("Wrong input! Enter 1 for add items or 2 for proceed only!: ");
                            add = sc.nextInt();
                            cond3 = false;
                        }
                    }
                    pw.println("\n");
                }
                totalboth = totalpricebook + totalpricestat;
                if(status==1)
                {
                     totstaff++; 
                     System.out.print("Enter your staff id: ");
                     staffId = sc.next();
                     System.out.println("\n_____________________YOUR RECEIPT____________________");
                     System.out.println("\nTotal for book: RM" + (df.format(totalpricebook) ));
                     System.out.println("Total for stationery: RM" + (df.format(totalpricestat) ));
                     System.out.println("Total all items: RM" + (df.format(totalboth) ));
                     pw3.println(staffId + "*");
                     STAFFS stf = new STAFFS(custname,custage,staffId);
                     System.out.println("Discount(-10%): RM" + (df.format(stf.pricediscount(totalboth))) );
                     System.out.println("Total you need to pay: RM" + (df.format(stf.totalpay(totalboth))) );
                     printout=stf.print();
                     pw2.println(printout);
                     totaldiscount = totaldiscount + stf.pricediscount(totalboth);
                }
                else if(status==2)
                {
                    boolean cond4 = false;
                    System.out.print("\nDo you have membership? (1-Yes or 2-No): ");
                    membership = sc.nextInt();
                    while( cond4 == false )
                    {    
                        if ( membership==1 )
                        {
                            totmember++;
                            pw3.print("membership" + "*");
                            System.out.print("Enter Member Id 1(e.g: 1111 or 1122): ");
                            idmember = sc.next();
                            pw3.print(idmember + "*");
                            System.out.print("Enter your status membership (student or normal): ");
                            statusmember = sc.next();
                            System.out.println("\n_____________________YOUR RECEIPT____________________");
                            System.out.println("\nTotal for book: RM" + (df.format(totalpricebook) ));
                            System.out.println("Total for stationery: RM" + (df.format(totalpricestat) ));
                            System.out.println("Total all items: RM" + (df.format(totalboth) ));
                            CUSTOMERS cs = new CUSTOMERS(custname,custage,idmember,statusmember);
                            DISCOUNTS d = new DISCOUNTS(cs,totalboth);
                            totaldiscount = totaldiscount + d.discounts();
                            boolean cond5 = false;
                            while ( cond5 == false )
                            {
                                if( statusmember.equalsIgnoreCase("student") )
                                {
                                    cond5 = true;
                                    pw3.println("student");
                                    System.out.println("Discount(-5%): RM" + (df.format(d.discounts())) );
                                    printout = cs.print(membership);
                                    pw2.println(printout);
                                }
                                
                                else if ( statusmember.equalsIgnoreCase("normal") )
                                {
                                    cond5 = true;
                                    pw3.println("normal");
                                    System.out.println("Discount(-2%): RM" + (df.format(d.discounts())) );
                                    printout = cs.print(membership);
                                    pw2.println(printout);
                                }
                                else
                                {
                                    System.out.print("Wrong input! Enter STUDENT or NORMAL only!: ");
                                    statusmember = sc.next();
                                    cond5 = false;
                                }
                            }
                            System.out.println("Total you need to pay: RM" + (df.format(d.totalpay())) );
                            cond4 = true;
                        }
                        else if (membership==2)
                        {
                            totnonmember++;
                            pw3.print("nonmembership" + "*");
                            System.out.print("Enter your ic: ");
                            idmember = sc.next();
                            System.out.println("\n_____________________YOUR RECEIPT____________________");
                            System.out.println("\nTotal for book: RM" + (df.format(totalpricebook) ));
                            System.out.println("Total for stationery: RM" + (df.format(totalpricestat) ));
                            System.out.println("Total all items: RM" + (df.format(totalboth) ));
                            System.out.println("Total you need to pay: RM" + (df.format(totalboth)) );
                            pw3.print(idmember + "*");
                            statusmember="none";
                            pw3.println(statusmember);
                            CUSTOMERS cs = new CUSTOMERS(custname,custage,idmember,statusmember);
                            printout = cs.print(membership);
                            pw2.println(printout);
                            cond4 = true;
                        }
                        else
                        {
                            System.out.print("Wrong Input! Enter YES or NO only: ");
                            membership = sc.nextInt();
                            cond4 = false;
                        }
                    }
                    System.out.println("_______________________________________________________");
                }
                totalsales = totalsales + totalpricebook + totalpricestat;
                System.out.print("\nNext Customer \n1-Yes \n2-No)?: ");
                nextcust = sc.nextInt();
                System.out.print('\u000C');
                pw.println("\n");
                pw.println("##########################################################");
                pw2.println("\n#############################################\n");
            }
            pw3.close(); 
            File in3 = new File("Buyer.txt");
            FileReader fr3 = new FileReader(in3);
            BufferedReader br3 = new BufferedReader(fr3);
            
            PEOPLE [] p = new PEOPLE[totalcust];
            for(int i=0; i<p.length; i++)
            {
                input3 = br3.readLine();
                StringTokenizer st3 = new StringTokenizer(input3,"*");
                name = st3.nextToken();
                age = Integer.parseInt(st3.nextToken());
                statusout = st3.nextToken();
                if(statusout.equalsIgnoreCase("staff"))
                {
                    staffid = st3.nextToken();
                    p[i] = new STAFFS(name,age,staffid);
                }
                else if(statusout.equalsIgnoreCase("customer"))
                {
                    membershipcust = st3.nextToken();
                    numember = st3.nextToken();
                    statusmember = st3.nextToken();
                    p[i]= new CUSTOMERS(name,age,numember,statusmember);
                } 
            }
            br3.close();
            System.out.print('\u000C');
            System.out.println("\n______________________RESULT FOR TODAY______________________");
            System.out.print("1) SALES");
            System.out.println("\nTotal sales today: RM" + (df.format(totalsales)) );    
            System.out.println("Total discount(-) today: RM" + (df.format(totaldiscount)));
            System.out.println("Total earn today: RM" + (df.format(totalsales-totaldiscount)) );
            pw2.println("\nTOTAL BUYER: " + totalcust);
            pw2.println("TOTAL STAFF: " +totstaff);
            pw2.println("TOTAL MEMBERSHIP: " +totmember);
            pw2.println("TOTAL NOT MEMBERSHIP: " + totnonmember + "\n\n");
            pw.close();
            pw2.close();
            System.out.println("\n2) LIST OF CUSTOMER");
            for(int i=0; i<p.length; i++)
            {
                if(p[i] instanceof STAFFS)
                {
                    STAFFS stf = (STAFFS)p[i];
                    stf.display();
                }
                else if(p[i] instanceof CUSTOMERS)
                {
                    CUSTOMERS cst = (CUSTOMERS)p[i];
                    cst.display();       
                }
            }
        }
        catch (IOException i)
        {
            System.out.println(i.getMessage());
        } 
    }
}