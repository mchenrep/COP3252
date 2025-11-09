import java.util.*;

public class advancedComputer extends Computer{
    public advancedComputer(String p){
        super(p);
    }

    public void move(){
        String[][] board = Board.board;
        if(!Board.full()){
        /// 1. If a winning move is available, take it.
            if(this.search(XO) != 0){
                int pos = this.search(XO);
                this.place(pos);
                System.out.println("Player " + n + " (advanced computer) chooses position " + pos);
                return;
            }   
        }
        /// 2. If the opponent is threatening a winning play, block it. (Note that if the opponent has two winning plays, only one can be blocked).
            if(XO.equals("X")){
                if(this.search("O") != 0){
                    int pos = this.search("O");
                    this.place(pos);
                    System.out.println("Player " + n + " (advanced computer) chooses position " + pos);
                    return;
                }
            } 
        /// 3. Determine which squares can be played that will not eventually result in a loss, and choose randomly between them
            List<Integer> safe = new ArrayList<>(); // keep track of all safe positions
            for(int i = 1; i < 10; i++){
                if(Board.isValidMove(i)){
                    int predict = 0;
                    this.place(i); // emulates "thinking", temporarily places move
                    // checks if after move is placed, will the opponent have a winning space
                    if(XO.equals("X"))
                        predict = this.search("O"); 
                    else
                        predict = this.search("X");
                    if(predict == 0)
                        safe.add(i); // if opponent doesn't have a winning space, add to safe positions
                    switch(i) {
                        // reset move
                        case 1: board[0][0] = " "; break;
                        case 2: board[0][1] = " "; break;
                        case 3: board[0][2] = " "; break;
                        case 4: board[1][0] = " "; break;
                        case 5: board[1][1] = " "; break;
                        case 6: board[1][2] = " "; break;
                        case 7: board[2][0] = " "; break;
                        case 8: board[2][1] = " "; break;
                        case 9: board[2][2] = " "; break;
                    }
                }
            }
            if(!safe.isEmpty()){
                // if there is safe positions, play them
                int pos = safe.get((int)(Math.random() * safe.size()));
                this.place(pos);
                System.out.println("Player " + n + " (advanced computer) chooses position " + pos);
                return;
            }

        /// if there's no "smart" plays, default to Computer's options
            super.move(); 

    }


}