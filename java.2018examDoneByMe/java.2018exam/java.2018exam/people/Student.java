
/**
 * Write a description of class Student here.
 *
 * @author Patrick Chimeudeonwo
 * @version July 2018
 */
public class Student extends Member
{
    // instance variables - replace the example below with your own
    private String name;
    private int yearOfBirth;
    private int StudentID;

    /**
     * Default Constructor for objects of class Student
     */
    public Student()
    {
        // initialise instance variables
    
    }
    
    public Student(String name, int year, int id)
    {
        // initialise instance variables
        this.name = name;
        this.yearOfBirth = year;
        this.StudentID = id;
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
    
  
    public int getStudentID()
    {
      return this.StudentID;
    }
    
    @Override
    public String toString()
    {
      return name + " " + getYearOfBirth() + " " + getStudentID();
    }

}
