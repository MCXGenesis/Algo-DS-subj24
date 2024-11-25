Public class Main {
    public static void main(String[] args){
        System.out.println("Playing TicTacToe");

        // in main()
    do {
        // Play the game once
        initGame();

    // Prompt the user whether to play again
    System.out.print("Play again (y/n)? ");
    char ans = in.next().charAt(0);
   if (ans != 'y' && ans != 'Y') {
      System.out.println("Bye!");
      System.exit(0);  // terminate the program
   }
} while (true);  // repeat until user did not answer yes
    }
} 