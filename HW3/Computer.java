public class Computer extends Player{
    
    public Computer(String p){
        super(p);
    }

    public void move(){
        String[][] board = Board.board;
        if(!Board.full()){
        /// 1. If a winning move is available, take it.
            if(this.search(XO) != 0){
                int pos = this.search(XO);
                this.place(pos);
                System.out.println("Player " + n + " (computer) chooses position " + pos);
                return;
            }    
        /// 2. If the opponent is threatening a winning play, block it. (Note that if the opponent has two winning plays, only one can be blocked).
            if(XO.equals("X")){
                if(this.search("O") != 0){
                    int pos = this.search("O");
                    this.place(pos);
                    System.out.println("Player " + n + " (computer) chooses position " + pos);
                    return;
                }
            } 
            else{
                if(this.search("X") != 0){
                    int pos = this.search("X");
                    this.place(pos);
                    System.out.println("Player " + n + " (computer) chooses position " + pos);
                    return;
                }
            }
            
        /// 3. If the center square is available, take it
            if(Board.isValidMove(5)){
                board[1][1] = XO;
                System.out.println("Player " + n + " (computer) chooses position 5");
                return;
            }
        /// 4. Else choose randomly between any remaining squares
            int random = (int)(Math.random() * (9) + 1);
            while(!Board.isValidMove(random)){
                random = (int)(Math.random() * (9) + 1);
            }
            this.place(random);
            System.out.println("Player " + n + " (computer) chooses position " + random);
            }
    }

    protected int search(String s){
        // extremely easy search algorithm to look at neighbors to determine winning/defensive move
        // loop through every possible position, if move is free: look at neighbors
        // if neighbors == XO, take the position
        // otherwise, keep searching until move is possible or no possible winning/defensive moves
       
        String[][] board = Board.board;
        String goal = s.repeat(2); // string we are looking for when appending neighbors into a string
        for(int i = 1; i < 10; i++){
            if(Board.isValidMove(i))
            {
                switch(i){
                    case 1:
                    {
                        String h = board[0][1] + board[0][2]; String v = board[1][0] + board[2][0]; String d = board[1][1] + board[2][2];
                        if(h.equals(goal) || v.equals(goal) || d.equals(goal)){
                            return i;
                        }
                        break;
                    }
                    case 2:
                    {
                        String h = board[0][0] + board[0][2]; String v = board[1][1] + board[2][1];
                        if(h.equals(goal) || v.equals(goal)){
                            return i;
                        }
                        break;
                    }
                    case 3:
                    {
                        String h = board[0][0] + board[0][1]; String v = board[1][2] + board[2][2]; String d = board[1][1] + board[2][0];
                        if(h.equals(goal) || v.equals(goal) || d.equals(goal)){
                            return i;
                        }
                        break;
                    }
                    case 4:
                    {
                        String h = board[1][1] + board[1][2]; String v = board[0][0] + board[2][0];
                        if(h.equals(goal) || v.equals(goal)){
                            return i;
                        }
                        break;
                    }
                    case 5:
                        {
                            String h = board[1][1] + board[1][2]; String v = board[0][0] + board[2][0]; String d1 = board[0][0] + board[2][2]; String d2 = board[0][2] + board[2][0];
                            if(h.equals(goal) || v.equals(goal) || d1.equals(goal) || d2.equals(goal)){
                                return i;
                            }
                        }
                        break;
                    case 6:
                        {
                            String h = board[1][0] + board[1][1]; String v = board[0][2] + board[2][2];
                            if(h.equals(goal) || v.equals(goal)){
                                return i;
                            }
                        }                
                        break;
                    case 7:
                        {
                            String h = board[2][1] + board[2][2]; String v = board[0][0] + board[1][0]; String d = board[1][1] + board[0][2];
                            if(h.equals(goal) || v.equals(goal) || d.equals(goal)){
                                return i;
                            }
                        }
                        break;
                    case 8:
                        {
                            String h = board[2][0] + board[2][2]; String v = board[0][1] + board[1][1];
                            if(h.equals(goal) || v.equals(goal)){
                                return i;
                            }
                        }
                        break;
                    case 9:
                        {
                            String h = board[2][0] + board[2][1]; String v = board[1][2] + board[0][2]; String d = board[0][0] + board[1][1];
                            if(h.equals(goal) || v.equals(goal) || d.equals(goal)){
                                return i;
                            }
                        }
                        break;
                    default: break;
                }
            }
        }
        return 0;
    }

    protected void place(int pos){
        // places XO at pos, doesn't need edge cases because search (which has edge cases) determines pos
        String[][] board = Board.board;
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
            default: break;
        }
    }


}
