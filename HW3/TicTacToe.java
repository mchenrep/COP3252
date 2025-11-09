class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        if(args.length == 0){
            // default mode: player vs player
            Player p1 = new Player("X");
            Player p2 = new Player("O");
            Board.printBoard();
            while(!Board.gameOver()){
                p1.move();
                Board.printBoard();
                if(Board.gameOver())
                    break;
                p2.move();
                Board.printBoard();
            }
        }
        else if(args.length == 1 && args[0].equals("-c")){
            Computer c1 = new Computer("X");
            Computer c2 = new Computer("O");
            Board.printBoard();
            while(!Board.gameOver()){
                c1.move();
                Board.printBoard();
                if(Board.gameOver())
                    break;
                c2.move();
                Board.printBoard();
            }
        }
        else if(args.length > 2 && args[0].equals("-c") && args[2].equals("-a")){
                // advanced computer vs player
                if(args[1].equals("1")){
                    advancedComputer a1 = new advancedComputer("X");
                    Player p2 = new Player("O");
                    Board.printBoard();
                    while(!Board.gameOver()){
                        a1.move();
                        Board.printBoard();
                        if(Board.gameOver())
                            break;
                        p2.move();
                        Board.printBoard();
                    }
                }
                else if(args[1].equals("2")){
                    Player p1 = new Player("X");
                    advancedComputer a2 = new advancedComputer("O");
                    Board.printBoard();
                    while(!Board.gameOver()){
                        p1.move();
                        Board.printBoard();
                        if(Board.gameOver())
                            break;
                        a2.move();
                        Board.printBoard();
                    }
                }
        }
        else if(args.length > 1 && args[0].equals("-c")){
            // only valid way to run the file with an argument length > 1

                // computer vs player
                if(args[1].equals("1")){
                    Computer c1 = new Computer("X");
                    Player p2 = new Player("O");
                    Board.printBoard();
                    while(!Board.gameOver()){
                        c1.move();
                        Board.printBoard();
                        if(Board.gameOver())
                            break;
                        p2.move();
                        Board.printBoard();
                    }
                }
                else if(args[1].equals("2")){
                    Player p1 = new Player("X");
                    Computer c2 = new Computer("O");
                    Board.printBoard();
                    while(!Board.gameOver()){
                        p1.move();
                        Board.printBoard();
                        if(Board.gameOver())
                            break;
                        c2.move();
                        Board.printBoard();
                    }
                }
        }     
        else{
            System.err.println("Usage:  java TicTacToe [-c [1|2] [-a]]");
        }
    }
}