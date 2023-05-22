
public abstract class PEOPLE
{
    protected String name;
    protected int age;
    public PEOPLE ( String custname, int custage )
    {
        name = custname;
        age = custage;
    }
    public String getName(  )
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public abstract double discount();
    public abstract void display();
}
