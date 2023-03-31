public class TicTacToe
{
   //copy over your constructor from the Tic Tac Toe Board activity in the previous lesson!
    private int turn;
    private String[][] board = new String[3][3];
    
    public TicTacToe()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = "-";
            }
        }
    }
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
        System.out.println("\n  0 1 2");
        for(int i = 0; i < board.length; i++)
        {
            System.out.print(i + " ");
            for(int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
       if(board[row][col].equals("-"))
       {
           return true;
       } else return false;
   }
   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
       if (turn % 2 == 0)
       {
           // X
           board[row][col] = "X";
       }
       else 
       {
           // O
           board[row][col] = "O";
       }
       turn++;
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   public boolean checkRow()
   {

       for(int i = 0; i < board.length; i++)
       {
           if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]))
           {
               if(!(board[i][0].equals("-")))
               return true;
           }
       }
       return false;
   }
   
    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
       for(int i = 0; i < board.length; i++)
       {
           if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]))
           {
               if(!(board[0][i].equals("-")))
               return true;
           }
       }
       return false;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
       if(board[1][1].equals(board[0][0]))
       {
           if(board[1][1].equals(board[2][2]))
           {
               if(!(board[1][1].equals("-")))
               return true;
           }
       }
       if(board[1][1].equals(board[0][2]))
       {
           if(board[1][1].equals(board[2][0]))
           {
               if(!(board[1][1].equals("-")))
               return true;
           }
       }
       return false;
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
       if(checkRow() || checkCol() || checkDiag())
       {
           return true;
       } return false;
   }
   
   public void reset() 
   {
       turn = 0;
       for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = "-";
            }
        }
        System.out.println("");
   }

}