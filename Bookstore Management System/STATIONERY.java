
public class STATIONERY
{
    public String Statname;
    public double Statprice;
    public STATIONERY ( )
    {
        Statname = null;
        Statprice = 0.00;
    }
    public STATIONERY ( String sn, double sp )
    {
        Statname = sn;
        Statprice = sp;
    }
    public void setAll( String sn, double sp )
    {
        Statname = sn;
        Statprice = sp;
    }
    public String getStatname ( )
    {
        return Statname;
    }
    public double getStatprice()
    {
        return Statprice;
    }
    public double priceStationery ( int statchoice, int numstat )
    {
        double total=0.00;
        if( statchoice == 1 )
        {
            total = 1.00 * numstat;
        }
        else if( statchoice == 2 )
        {
            total = 1.00 * numstat;
        }
        else if( statchoice == 3 )
        {
            total = 1.50 * numstat;
        }
        else if( statchoice == 4 )
        {
            total = 1.50 * numstat;
        }
        else if( statchoice == 5 )
        {
            total = 1.50 * numstat;
        }
        else if( statchoice == 6 )
        {
            total = 2.50 * numstat;
        }
        else if( statchoice == 7 )
        {
            total = 5.00 * numstat;
        }
        else if( statchoice == 8 )
        {
            total = 3.00 * numstat;
        }
        else if( statchoice == 9 )
        {
            total = 2.50 * numstat;
        }
        else if( statchoice == 10 )
        {
            total = 65.00 * numstat;
        }
        else if( statchoice == 11 )
        {
            total = 1.00 * numstat;
        }
        return total;
    }
    public String displayoutput(int numstat)
    {
        return("Stationery name: " + getStatname() +
               "\nPrice: RM" + getStatprice() +
               "\nQuantity: " + numstat +
               "\nTotal Price: RM" + (getStatprice() * numstat));
    }
}