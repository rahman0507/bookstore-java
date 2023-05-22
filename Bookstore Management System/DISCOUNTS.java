
public class DISCOUNTS
{
   private CUSTOMERS cust;
   private double total;
   public DISCOUNTS ( CUSTOMERS csts, double totalboth )
   {
       cust = csts;
       total = totalboth;
   }
   public void setAll( CUSTOMERS csts, double totalboth )
   {
       cust = csts;
       total = totalboth;
   }
   public double discounts()
   {
       double discount=0.00;
       discount = total * cust.discount();
       return discount;
   }
   public double totalpay()
   {
       double totalpay = 0.00;
       totalpay = total - discounts();
       return totalpay;
    }
   public String toString()
   {
       return("Total you need to pay after discount: RM" + totalpay() );
   }
}