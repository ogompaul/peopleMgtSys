/**
 * class Ratio is a stub only, 
 * a sketch of a class that allows elementary calculations
 * on ratios with fields enumeratorerator and denominatorminator via method calls
 * 
 * @author Patrick Chimeudeonwo
 * @version July 2018
 */
public class Ratio
{
    // fields: the instance variables
    private int numerator;
    private int denominator;
    /**
     * Default Constructor
     */
    public Ratio()
    {
        // call Ratio constructor with default enumeratorerator and denominatorminator
       
    }

    /**
     * Constructor
     */
    public Ratio(int enumeratorerator, int denominatorminator)
    {
        // initialize fields
        if(denominatorminator == 0)
        {
         throw new ArithmeticException("Division with 0 is forbidden, denominator cant be zero");
        }
        this.numerator = enumeratorerator;
        this.denominator = denominatorminator;
       
    }

    // getters to be implemented
    public int getnumerator()
    {
      return numerator;
    }
     public int getdenominator()
    {
      return denominator;
    }
    
    
    public void setnumerator(int e)
    {
       numerator = e;
    }
     public void setdenominator(int d)
    {
       denominator = d;
    }
     
    /**
     * Constructor
     */
    public Ratio(Ratio z)
    {
        // call Ratio constructor with proper enumeratorerator and denominatorminator
        z.numerator = numerator;
        z.denominator = denominator;
    }

    /**
     * Method inverse changes the instance to the inverse ratio
     *
     */
    public void inverse()
    {
        // correct operation on the fields
        int temp = 0;
        temp = numerator;
        numerator = denominator;
        denominator = temp;
        //new Ratio(numerator, temp);
        
    }

    /**
     * Method inverted leaves the instance unchanged
     *
     * @return a new instance with the inverted ratio
     */
    public Ratio inverted()
    {
        //return new Ratio(); // replace by proper code!
        inverse();       
        return  new Ratio(numerator, denominator);     
    }

    /**
     * Method add leaves the instance unchanged
     *
     * @param z the ratio to be added to this
     * @return a new instance with the sum calulated
     */
    public Ratio add(Ratio z)
    {
        //return new Ratio(z); // replace by proper code!
       int newnumerator = ((this.numerator * z.getdenominator()) + (z.getnumerator() * this.denominator)); 
       int newdenominator = (this.denominator * z.getdenominator());
       return new Ratio(newnumerator, newdenominator);
    }
    
    /**
     * Method multiply leaves the instance unchanged
     *
     * @param z the ratio to be multiplied with this ratio
     * @return a new instance with the sum calulated
     */
    public Ratio multiply(Ratio z)
    {
        //return new Ratio(z); // replace by proper code!
        int newdenominator = (z.getdenominator() * this.denominator);
        int newnumerator = (z.getnumerator() * this.numerator);
        return new Ratio(newnumerator, newdenominator);
    }

    /**
     * Method toString leaves the instance unchanged,
     * prints the ratio into a String
     *
     * @return a convenient String representation of this ratio
     */
    @Override
    public String toString()
    {
        //return ""; //replace by proper code !
        return "The Ratio is: " + this.numerator + "/" + this.denominator;
    }

    /**
     * Method equals is required for testing
     * because assertEquals will use it,
     * leaves the instance unchanged.
     *
     * @param obj any object that might be a ratio
     * @return true if the argument ratio is mathematically equal to this ratio
     */
    @Override
    public boolean equals(Object obj)
    {
        // return the correct value depending on the following checks:
        // check if obj is identical with this object
        // check if obj is not a Ratio
        // check for mathematical equality
        //return false; // for compilation only
        if(this == obj)
        {
          return true;
        }
        
        if(!(obj instanceof Ratio))
        {
          return false;
        }
        
        Ratio r = (Ratio)obj;
        if(this.numerator * r.denominator == this.denominator * r.numerator)
        {
         return true;
        }else{        
        return false;
    }
    }
    
    /**
     * Method doubleValue leaves the instance unchanged
     *
     * @return value of this ratio, as good as it can get represented by a double value
     */
    public double doubleValue()
    {
        //return 0; // replace by proper code!
        double r = (double) numerator / denominator;
        //return (double) numerator / denominator;
        return r;
    }
}