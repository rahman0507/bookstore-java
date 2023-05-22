
public class STAFFS extends PEOPLE
{
    private String idstaff;
    public STAFFS(String custname, int custage, String staffId)
    {
        super(custname,custage);
        idstaff = staffId;
    }
    public void setId(String staffId)
    {
        idstaff = staffId;
    }
    public String getId()
    {
        return idstaff;
    }
    public double discount()
    {
        double discount = 0.00;
        discount = 0.1;
        return discount;
    }
    public double pricediscount(double totalboth)
    {
        double price = 0.00;
        price = totalboth * discount();
        return price;
    }
    public double totalpay(double totalboth)
    {
        double total=0.00;
        total = totalboth-(totalboth*discount());
        return total;
    }
    public void display()
    {
        System.out.println("\nStaff Name: " + super.getName().toUpperCase() + "\nStaff Age: " + super.getAge() + "\nStaff Id: " + idstaff );
    }
    public String print()
    {
        return("\nStaff Name: " + super.getName().toUpperCase() + "\nStaff Age: " + super.getAge() + "\nStaff id: " + idstaff );
    }
}