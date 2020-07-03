import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

/**
 * A very simple database of people in a university. This class simply stores
 * persons and, at request, lists them on standard output.
 *
 * Written as a first demo program for BlueJ.
 * 
 * @author  Patrick Chimeudeonwo
 * @version July 2018
 */

public class Database {

    // fields: instance variables
    private String name;
    private int birthYear;
    private ArrayList<Person> persons;

    /**
     * Constructor: creates a new, empty database as a List of Person.
     */
    public Database() 
    {
        // insert proper code here!
        //this.name=name;
        //this.birhYear=birthYear;
        persons = new ArrayList<Person>();
    }

    /**
     * Add a person to the database.
     */
    public void addPerson(Person p) 
    {
        // insert proper code here!
        persons.add(p);
    }

    /**
     * List all the persons currently in the database on standard out while using delegation to the toString-method of Person
     */
    public void listAll () 
    {
        // insert proper code here!
        for(Person p : persons)
        {
          if(p != null)
          {
              System.out.println(p.toString());
          }          
        }
    }
    
    /**
     * Problem 2 b
     */
    public void fillList()
    {
        // insert proper code here!
       /// Person p = new Student()
        persons.add(new Student("Patrick", 1230, 1));
        persons.add(new Student("Chris", 1231, 2));
        persons.add(new Student("Vitalise", 1232, 3));
         persons.add(new Student("Chuks", 1232, 3)); //persons with equal birthyear
        
        persons.add(new staffMember("Emma", 1233, 4));
        persons.add(new staffMember("Ben", 1234, 5));
        persons.add(new staffMember("Otto", 1235, 6));
        persons.add(new staffMember("Wolfgang", 1235, 6)); //personswithsame year
        
        
    }

    /**
     * Problem 2 c
     * prints the first person with BirthYear yr currently in the database on standard out.
     */
    public void printFirstWithBirthYear (int yr) 
    {
        //Iterator i; // assign and use an iterator explicitly to allow breaking the loop after the first person with birthyear yr was found
        // insert proper code here!
        // Iterator to traverse the list 
        boolean found = false;
        Iterator<Person> iterator = persons.iterator();  
  
        while(!found && iterator.hasNext())
        {
            Person p = iterator.next();
            if(p.getYearOfBirth() == yr)
            {
              found = true;
              System.out.println(p.toString());
            }
            //System.out.print(iterator.next() + " ");  
    }
         
    }
    
    public void writeToFile()
    {
      String directory = System.getProperty("user.home");
      String fileName = "sample.txt";
     String absolutePath = directory + File.separator + fileName;

    // Write the content in file 
    try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) 
     {
     String fileContent = "This is a sample text.";
     bufferedWriter.write(fileContent);
    } catch (IOException e) {
    // Exception handling
    }

// Read the content from file
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) 
    {
    String line = bufferedReader.readLine();
    while(line != null) {
        System.out.println(line);
        line = bufferedReader.readLine();
    }
   } catch (FileNotFoundException e) {
    // Exception handling
  } catch (IOException e) {
    // Exception handling
  }
    }
 }
