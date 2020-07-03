/**
 * A person interface for a simple BlueJ demo program. Abstract Person 
 * is an abstract superclass of more specific person classes 
 * that implements this interface.
 * 
 * @author  Patrick Chimeudeonwo
 * @version July 2018
 */

interface Person
{
    /**
     * Return the name of this person.
     */
    public String getName();

    /**
     * Return the birth year of this person.
     */
    public int getYearOfBirth();

    /**
     * Return a string representation of this object.
     */
    public String toString();    // override from "Object"
}
