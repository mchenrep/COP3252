import java.util.Scanner;


// this would be way easier with a hashmap/table but i'll use arrays since that's is what we've learned so far
public class DiceStats {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Dice Roll Simulator!");
        System.out.println("------------------------");
        System.out.print("How many dice to roll? ");
        int d = s.nextInt();
        System.out.print("How many rolls? ");
        int r = s.nextInt();
        int[] freq = new int[(6*d-d+1)];
        // simulating the rolls
        for(int i = 0; i < r; i++){
            int sum = 0;
            // rolls each die, adds to the sum
            for(int j = 0; j < d; j++){
                sum += (int)(Math.random() * 6) + 1;
            }
            // increases frequency array at index meant for that sum (sum-d)
            freq[sum-d] += 1;
        } 
        System.out.println("\nSum     # of times      Percentage\n");
        
        // for sum do index + d
        // for # of times just print out freq
        // for percentage, divide freq by # of rolls
        // loop through frequency array
        for(int i = 0; i < freq.length; i++){
            int fsum = i+d;
            int ffreq = freq[i];
            float prcent = (float)freq[i]/r;
            System.err.printf("%-10d%-15d%.2f %%\n", fsum, ffreq, prcent);
        }
    }
}
