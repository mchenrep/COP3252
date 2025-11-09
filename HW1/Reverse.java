import java.util.Scanner;


class Reverse{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Reverse your (long) integer!");
        System.out.println("----------------------------------------");
        System.out.print("Please enter a long integer (0 to quit): ");
        long x = input.nextLong();
        System.out.println();

        // essentially reverses the int through modulus/division
        while(x != 0){
            long copy = x;
            long r = 0;
            while(copy > 0){
                r = (copy%10) + r*10; // r*10 to move the digits up, add modulus for the next digit
                copy/=10;
            }
            System.out.println("The number reversed is: " + r);
            System.out.print("\nPlease enter a long integer (0 to quit): ");
            x = input.nextLong();
            System.out.println();
        }
    }
}