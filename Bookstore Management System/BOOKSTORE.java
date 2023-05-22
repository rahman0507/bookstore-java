
public class BOOKSTORE
{
       public String titles;
       public String genres;
       public String languages;
       public double prices;
       public int yearPublished;
       public BOOKSTORE ( )
       {
           titles = null;
           genres = null;
           languages = null;
           prices = 0.00;
           yearPublished = 0;
       }
       public BOOKSTORE ( String t, String g, String l, int y , double p )
       {
           titles = t;
           genres = g;
           languages = l;
           yearPublished = y;
           prices = p;
       }
       public void setAll ( String t, String g, String l, int y , double p )
       {
           titles = t;
           genres = g;
           languages = l;
           yearPublished = y;
           prices = p;
       }
       public String getTitle ( )
       {
           return titles;
       }
       public String getGenre()
       {
           return genres;
       }
       public String getLanguage()
       {
           return languages;
       }
       public double getPrice()
       {
           return prices;
       }
       public int getYearPublished()
       {
           return yearPublished;
       }
       public double findlanguage(String findlanguage, int choose, int numbook)
       {
           double price=0.00;
           price = priceFindByLanguage( choose, numbook);
           return price;
       }
       public double priceFindByLanguage ( int choose, int numbook )
       {
           double total= 0.00;
           if ( getLanguage().equalsIgnoreCase("Melayu") )
           {
               if ( choose == 1 )
               {
                   total = 15.60 * numbook;
               }
               else if ( choose == 2 )
               {
                   total = 29.80 * numbook;
               }
               else if ( choose == 3 )
               {
                   total = 42.50 * numbook;
               }
               else if ( choose == 4 )
               {
                   total = 45.90 * numbook;
               }
               else if ( choose == 5 )
               {
                   total = 39.99 * numbook;
               }
           }
           else if ( getLanguage().equalsIgnoreCase("English") )
           {
               if ( choose == 1 )
               {
                   total = 49.99 * numbook;
               }
               else if ( choose == 2 )
               {
                   total = 29.50 * numbook;
               }
               else if ( choose == 3 )
               {
                   total = 39.50 * numbook;
               }
               else if ( choose == 4 )
               {
                   total = 16.50 * numbook;
               }
               else if ( choose == 5 )
               {
                   total = 32.50 * numbook;
               }
           }
           return total;
        }
       public double priceFindByTitle ( String findtitle, int numbook )
       {
           double total= 0.00;
           if ( findtitle.equalsIgnoreCase("Lawak Kampus") )
           {
               total = 15.60 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Makanan Berkhasiat") )
           {
               total = 29.80 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Sejarah") )
           {
               total = 42.50 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Sehingga Bertemu Lagi") )
           {
               total = 45.90 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Asrama") )
           {
               total = 39.99 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("How to invest") )
           {
               total = 49.99 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Ghost") )
           {
               total = 29.50 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Witch's Love") )
           {
               total = 39.50 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Politics in Malaysia") )
           {
               total = 16.50 * numbook;
           }
           else if ( findtitle.equalsIgnoreCase("Five Feet Apart") )
           {
               total = 32.50 * numbook;
           }
           return total;
        }
       public String toString()
       {
           return("Title: " + titles +
                  "\nGenre: " + genres +
                  "\nLanguage: " + languages +
                  "\nYear Published: " + yearPublished +
                  "\nPrice: RM" + prices +"\n" );
       } 
       public void displaybook()
       {
           String listbook;
           listbook = toString();
           System.out.println(listbook);
       }  
       public String displayoutput(int numbook)
       {
           return("Title book: " + getTitle() +
                  "\nPrice: RM" + getPrice() +
                  "\nTotal you buy this book: " + numbook +
                  "\nTotal Price: RM" + (getPrice() * numbook) );
       }
}
