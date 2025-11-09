public class Board{
    // Made board and all of its members static because the game only uses 1 board universally (no concurrent games)
    static String[][] board;

    public Board(){
        clear();
    }

    static void clear(){
        // clears board
        board = new String[3][3];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = " ";
            }
        }
    }

    static void printBoard() {
        // prints board
        System.out.println("Game Board:\t\tPositions:");    
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\t\t 1 | 2 | 3 ");
        System.out.println("-----------\t\t-----------");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\t\t 4 | 5 | 6 ");
        System.out.println("-----------\t\t-----------");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\t\t 7 | 8 | 9 ");
    }

    static boolean gameOver(){
        /// possible win positions: 
        /// 123, 456, 789 (horizontal)
        /// 147, 258, 369 (vertical)
        /// 159, 357 (diagonal)

        // possible game over: all positions on board filled (tie)
        if(full()){
            System.out.println("Tie!");
            return true;
        }
        
        // rows
        String h1 = board[0][0] + board[0][1] + board[0][2];
        String h2 = board[1][0] + board[1][1] + board[1][2];
        String h3 = board[2][0] + board[2][1] + board[2][2];
        // columns
        String v1 = board[0][0] + board[1][0] + board[2][0];
        String v2 = board[0][1] + board[1][1] + board[2][1];
        String v3 = board[0][2] + board[1][2] + board[2][2];
        // diagonals
        String d1 = board[0][0] + board[1][1] + board[2][2];
        String d2 = board[0][2] + board[1][1] + board[2][0];
        String[] pos = {h1,h2,h3,v1,v2,v3,d1,d2};

        for(String s : pos){
            // gets rows/cols/diagonals as a string and checks if it == XXX or OOO (TicTacToe)
            if(s.equals("XXX")){
                System.out.println("Winner: Player 1");
                return true;
            }
            else if(s.equals("OOO")){
                System.out.println("Winner: Player 2");
                return true;
            }
        }

        return false;
    }

    static boolean full(){
        // checks if board is full
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValidMove(int pos){
        switch(pos){
            case 1: if(board[0][0].equals("X") || board[0][0].equals("O")) return false; break;
            case 2: if(board[0][1].equals("X") || board[0][1].equals("O")) return false; break;
            case 3: if(board[0][2].equals("X") || board[0][2].equals("O")) return false; break;
            case 4: if(board[1][0].equals("X") || board[1][0].equals("O")) return false; break;
            case 5: if(board[1][1].equals("X") || board[1][1].equals("O")) return false; break;
            case 6: if(board[1][2].equals("X") || board[1][2].equals("O")) return false; break;
            case 7: if(board[2][0].equals("X") || board[2][0].equals("O")) return false; break;
            case 8: if(board[2][1].equals("X") || board[2][1].equals("O")) return false; break;
            case 9: if(board[2][2].equals("X") || board[2][2].equals("O")) return false; break;
        }
        return true;
    }

}