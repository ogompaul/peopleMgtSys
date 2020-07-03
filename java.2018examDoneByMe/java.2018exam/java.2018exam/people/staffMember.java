
/**
 * Write a description of class staffMember here.
 *
 * @author Patrick Chimeudeonwo
 * @version July 2018
 */
public class staffMember extends Member
{
    // instance variables - replace the example below with your own
    private String name;
    private int yearOfBirth;
    private int roomID;    

    /**
     * Constructor for objects of class staffMember
     */
    public staffMember(String name, int yearOfBirth, int roomID)
    {
        this.name=name;
        this.roomID=roomID;
        this.yearOfBirth=yearOfBirth;
    }
    
    public staffMember()
    {
        //Default
    }
    
    @Override
    public String getName()
    {
      return this.name;
    }
    
    @Override
    public int getYearOfBirth()
    {
      return this.yearOfBirth;
    }
    
  
    public int getRoomID()
    {
      return this.roomID;
    }
    
    @Override
    public String toString()
    {
      return this.name + " " + this.yearOfBirth + " " + this.roomID;
    }


}