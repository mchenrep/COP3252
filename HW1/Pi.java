import java.util.Scanner;

class Pi{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Calculate pi from an infinite series!");
        System.out.println("--------------------------------------");
        System.out.print("Compute how many terms in the series? ");
        int x = input.nextInt(); 
        
        // uses the formula given in the HW1 page
        double t = 0;
        System.out.println("terms   PI approximation");
        for(int i = 0; i < x; i++)
        {
            // determines if + or - based on the formula (where even indexes are + and odd indexes are -)
            if(i%2 == 0)
            {
                t += 4.0 / (2 * i + 1);
            }
            else{
                t -= 4.0 / (2 * i + 1);
            }
            
            System.out.println((i+1) + "       " + t);
        }
    }
}
