public class Fraction
{
    private int numerator = 0;		// numerator (and keeps sign)
    private int denominator = 1;		// always stores positive value

    public Fraction()
    {
    }

    public Fraction(int n, int d)
    {
        if(set(n,d)==false)
            set(0,1);
    }

    public boolean set(int n, int d)
    {
        if (d > 0)
        {
	        numerator = n;
	        denominator = d;
	    return true;
        }
        else
	        return false;
    }
  
    public String toString()
    {
        return (numerator + "/" + denominator);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public double decimal()
    {
        return (double)numerator / denominator;
    }

/*
    ---------------------------------------------------
                        HW METHODS 
    ---------------------------------------------------
 */
    
    public Fraction simplify(){
        // simplify all 0 values to 0/1 as per rules
        if(numerator == 0){
            return new Fraction(0,1);
        }
        
        // fractions simplify by / by greatest common factor (gcf)
        int gcf = 0;
        for(int i = 1; i < Math.min(Math.abs(numerator), denominator); i++){
            if(numerator % i == 0 && denominator % i == 0){
                gcf = i;
            }
        }
        
        // if can't be simplified
        if(gcf == 0){
            return this;
        }
        return new Fraction(numerator/gcf, denominator/gcf);
    }

    public Fraction add(Fraction f){
        // if common denominator, just add
        if(denominator == f.denominator){
            int new_numerator = numerator + f.numerator;
            return (new Fraction(new_numerator, denominator)).simplify();
        }

        // otherwise, multiply both by each other's denominator then add
        int new_numerator = (numerator * f.denominator) + (f.numerator * denominator);
        int new_denominator = denominator * f.denominator;
        return (new Fraction(new_numerator, new_denominator)).simplify();
    }

    public Fraction subtract(Fraction f){
        // if common denominator, just subtract
        if(denominator == f.denominator){
            int new_numerator = numerator - f.numerator;
            return (new Fraction(new_numerator, denominator)).simplify();
        }

        // otherwise, multiply both by each other's denominator then subtract
        int new_numerator = (numerator * f.denominator) - (f.numerator * denominator);
        int new_denominator = denominator * f.denominator;
        return (new Fraction(new_numerator, new_denominator)).simplify();
    }

    public Fraction multiply(Fraction f){
        int new_numerator = numerator * f.numerator;
        int new_denominator = denominator * f.denominator;
        return (new Fraction(new_numerator, new_denominator)).simplify();
    }

    public Fraction divide(Fraction f){
        // if divide by a value = 0, return 0/1 as per rules
        if(f.numerator == 0){
            return new Fraction(0,1);
        }
        
        // otherwise, division is just multiplication of the inversed (flipped) divisor
        if(f.numerator < 0){
            f.numerator *= -1; // if fraction is negative, need to flip the signs when it's flipped
            f.denominator *= -1; 
        }
        Fraction flip = new Fraction(f.denominator, f.numerator);
        return multiply(flip);
    }    

}