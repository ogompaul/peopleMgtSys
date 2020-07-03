
/**
 * Abstract class Member - write a description of the class here
 *
 * @author Patrick Chimeudeonwo
 * @version July 2018
 */
public abstract class Member implements Person
{
    // instance variables - replace the example below with your own
    private String name;
    private int yearOfBirth;
   
    /**
      *
     * @param  
     * @return    
     */
    public String toString()
    {
        // put your code here
        Person student = new Student();
        Person staff = new staffMember();
        //return "all information on student and staff";
        return student.toString() + staff.toString();
    }
}
