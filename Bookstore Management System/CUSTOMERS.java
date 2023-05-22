
public class CUSTOMERS extends PEOPLE
{
    private String id;
    private String status;
    public CUSTOMERS ( String custname, int custage, String idmember, String statusmember)
    {
        super(custname,custage);
        id = idmember;
        status = statusmember;
    }
    public void setAll ( String idmember, String statusmember )
    {
        id = idmember;
        status = statusmember;
    }
    public String getId()
    {
        return id;
    }
    public String getStatus()
    {
        return status;
    }
    public double discount (  )
    {
        double discount = 0.00;
        if( getStatus().equalsIgnoreCase("student") )
        {
            discount = 0.05;
        }
        else if ( getStatus().equalsIgnoreCase("normal") )
        {
            discount = 0.02;
        }
        else if( getStatus().equalsIgnoreCase("none"))
        {
            discount = 0.00;
        }
        return discount;
    }
    public void display()
    {
        System.out.println("\nCustomer Name: " + name.toUpperCase() + "\nCustomer Age: " + super.age + "\nMembership Id: " + id + "\nMembership Status: " + status.toUpperCase());
    }
    public String print(int membership)
    {
        String status=null;
        if(membership==1)
        {
            status = "YES";
        }
        else if(membership==2)
        {
            status = "NO";
        }
        return("CUSTOMER NAME : " + super.getName().toUpperCase() +
               "\nCUSTOMER AGE: " + super.getAge() +
               "\nMEMBERSHIP: " + status +
               "\nMEMBERSHIP ID: " + id +
               "\nMEMBERSHIP STATUS: " + getStatus().toUpperCase() );
    }
}