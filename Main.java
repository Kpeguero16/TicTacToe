// Khalil Peguero 2023
// Tic Tac Toe
// 
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        TicTacToe board = new TicTacToe();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Tic Tac Toe\n");
        
        System.out.println("Please select a gamemode:\n1. singlePlayer\n2. localPlay");
        int gamemode = input.nextInt();
        if(gamemode == 1)
        {
            singlePlayer(board, input);
        }
        else if(gamemode == 2)
        {
            localPlay(board, input);
        }
        else
        {
            System.out.println("Invalid input");
            playAgain(board, input);
        }

    }
    
    public static void localPlay(TicTacToe board, Scanner input)
    {
        int row = 0;
        int column = 0;
        
        // Checks if there are no more available spaces
        if(board.getTurn() == 9)
        {
            board.printBoard();
            System.out.println("\nIt's a tie, better luck next time!!");
            playAgain(board, input);
        }
        // If the are, keep playing
        else 
        {
            board.printBoard();
            // Prompt user to get position
            try
            {
                System.out.println("\nEnter the desired row: ");
                row = input.nextInt();
                System.out.println("Enter the desired column: ");
                column = input.nextInt();
            }
            catch(Exception e)
            {
                System.out.println("Please input a valid integer :)");
                localPlay(board, input);
                
            }
            try 
            {
                // Check if the space is available
                if(board.pickLocation(row, column))
                {
                    board.takeTurn(row, column);
                }
                else
                {
                    System.out.println("\nThis spot is already taken!\nTry again...");
                    localPlay(board, input);
                }
            }
            catch(Exception e) {
                System.out.println("\nInvalid input...\nPlease input a number between 0 and 2\n");
                localPlay(board, input);
            }
            
            // Checks if anyone won already
            if(board.checkWin())
            {
                board.printBoard();
                
                if(board.getTurn() % 2 == 0)
                {
                    System.out.println("Player O wins, congratulations!!");
                    playAgain(board, input);
                    
                }
                else
                {
                    System.out.println("Player X wins, congratulations!!");
                    playAgain(board, input);
                    
                }
            }
            else
            {
                localPlay(board, input);
            }
        }
    }
    
    public static void singlePlayer(TicTacToe board, Scanner input)
    {
        int row = 0;
        int column = 0;
        // Same as localPlay, check if there are any more
        // available moves 
        if(board.getTurn() == 9)
        {
            board.printBoard();
            System.out.println("\nIt's a tie, better luck next time!!");
            playAgain(board, input);
            
        }
        else 
        {
            board.printBoard();
            
            // Check whose turn it is
            // Even - user's turn 
            // Odd - CPU's turn 
            if(board.getTurn() % 2 == 0)
            {
                try
                {
                    System.out.println("\nEnter the desired row: ");
                    row = input.nextInt();
                    System.out.println("Enter the desired column: ");
                    column = input.nextInt();
                }
                catch(Exception e)
                {
                    System.out.println("Please input a valid integer :)");
                    singlePlayer(board, input);
                }
                try 
                {
                    if(board.pickLocation(row, column))
                    {
                        board.takeTurn(row, column);
                    }
                    else
                    {
                        System.out.println("\nThis spot is already taken!\nTry again...");
                        singlePlayer(board, input);
                    }
                }
                catch(Exception e) 
                {
                    System.out.println("\nInvalid input...\nPlease input a number between 0 and 2\n");
                    singlePlayer(board, input);
                }
                if(board.checkWin())
                {
                    board.printBoard();
                
                    if(board.getTurn() % 2 == 0)
                    {
                        System.out.println("Player O wins, congratulations!!");
                        playAgain(board, input);
                    }
                    else
                    {
                        System.out.println("Player X wins, congratulations!!");
                        playAgain(board, input);
                    }
                }
                else
                {
                    singlePlayer(board, input);
                }
            }
            else
            {
                // CPU 
                
                // Generates a random position
                row = randomize(row);
                column = randomize(column);
                
                while(true)
                {
                    if(board.pickLocation(row, column))
                    {
                        board.takeTurn(row, column);
                        break;
                    }
                    row = randomize(row);
                    column = randomize(column);
                }
                
                singlePlayer(board, input);
            }
        }
    }
    
    public static void playAgain(TicTacToe board, Scanner input)
    {
        String response = "";
        System.out.println("Would you like to play again? (y/n)");
        input.nextLine();
        response = input.nextLine();
        
        if(response.equals("y") || response.equals("Y"))
        {
            board.reset();
            System.out.println("Please select a gamemode:\n1. singlePlayer\n2. localPlay");
            int gamemode = input.nextInt();
            if(gamemode == 1)
            {
                singlePlayer(board, input);
            }
            else if(gamemode == 2)
            {
                localPlay(board, input);
            }
            else
            {
                System.out.println("Invalid input");
                playAgain(board, input);
            }
        } 
        else if(response.equals("n") || response.equals("N"))
        {
            System.out.println("Thank you for playing!!");
        }
        else 
        {
            System.out.println("Invalid input");
            playAgain(board, input);
        }
    }
    
    public static int randomize(int n)
    {
        n = (int)(Math.random() * 3);
        return n;
    }
}