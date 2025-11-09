import java.util.Scanner;

public class Player{
    protected String XO = "";
    protected int n = 0;
    
    public Player(String p){
        XO = p;
        if(XO.equals("X"))
            n = 1;
        else // using basic else statement because XO is determined by programmer not user 
            n = 2;
    }
    
    public void move(){
        if(!Board.gameOver()){
            Scanner scanner = new Scanner(System.in);
            String[][] board = Board.board;
            System.out.println("Player " + n + ", please enter a move (1-9): ");
            int pos = scanner.nextInt();
            if(Board.isValidMove(pos)){
                switch(pos) {
                    case 1: board[0][0] = XO; break;
                    case 2: board[0][1] = XO; break;
                    case 3: board[0][2] = XO; break;
                    case 4: board[1][0] = XO; break;
                    case 5: board[1][1] = XO; break;
                    case 6: board[1][2] = XO; break;
                    case 7: board[2][0] = XO; break;
                    case 8: board[2][1] = XO; break;
                    case 9: board[2][2] = XO; break;
                    default: System.out.println("Invalid position, try again."); this.move();
                }
            }
            else{
                System.out.println("Invalid move, try again.");
                this.move();
            }
        }
    }


}

