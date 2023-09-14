import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    String[] secretWords = new String[] { "arizona", "asu", "sundevils", "computers", "science", "engineering", "software","programming","prototype","studying", "algorithm","binary","autonomous", "java", "javascript", "linux","python","variable","statement"};
    String secretWord = secretWords[(int) (Math.random() * secretWords.length)];
    String secretWordGSF = ""; // GSF -> Guessed so far.
    boolean gameDone = false;

    for (int i = 0; i < secretWord.length(); i++) {
      secretWordGSF += "_";
    }

    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to Hangman!");
    System.out.println("Type 1 to start game. Type 2 to stop");

    int num1 = input.nextInt();
    int lives = 6;
    // Game is now being played code
    // \/--------------------------------------------------------
    if (num1 == 1) {
      while (lives >= 0 && lives <= 6) {
        System.out.print("Pick a letter (enter lowercase):");

        String letter = "";

        letter = input.next();
        System.out.println();
        int length = secretWord.length();
        char letterTest;

        letterTest = letter.charAt(0);

        
        int count = 0;

        boolean FTDW = false;
        for (int i = 0; i < secretWord.length(); i++) {
          if (letterTest == secretWord.charAt(i)) {
           
            secretWordGSF = secretWordGSF.substring(0, i) + letterTest + secretWordGSF.substring(i + 1);
          
            length--;
            count++;
            FTDW = true;

          }

        }
        if (!FTDW) {

          lives--;
        }
        System.out.print(secretWordGSF);
        System.out.println();
        System.out.println("Lives Left " + lives);

        drawMan(lives);

        // CODE TO CHECK IF LIVES IS LESS THAN 1
        if (lives < 1) {
          System.out.print("GAME OVER!");
          break;
        }
        for (int i = 0; i < secretWordGSF.length(); i++) {
          if (secretWordGSF.charAt(i) != '_') {
            gameDone = true;
          } if (secretWordGSF.charAt(i) == '_') {
            gameDone = false;
            break;
          }
        }
        if (gameDone == true) {
          System.out.println("YOU SOLVED THE WORD!");
          break;
        }
      }

    }

    if (num1 == 2) {
      System.out.println("See you later!");
    }

  }

  public static void drawMan(int lives) {
    if (lives == 6) {
      System.out.println("            |----------");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");

    } else if (lives == 5) {
      System.out.println("            |----------");
      System.out.println("            |    |");
      System.out.println("            |    ");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");
    } else if (lives == 4) {
      System.out.println("            |----------");
      System.out.println("            |    |");
      System.out.println("            |    O");
      System.out.println("            |    |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");
    } else if (lives == 3) {
      System.out.println("            |----------");
      System.out.println("            |    |");
      System.out.println("            |    O");
      System.out.println("            |   -|");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");
    } else if (lives == 2) {
      System.out.println("            |----------");
      System.out.println("            |    |");
      System.out.println("            |    O");
      System.out.println("            |   -|-");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");
    } else if (lives == 1) {
      System.out.println("            |----------");
      System.out.println("            |    |");
      System.out.println("            |    O");
      System.out.println("            |   -|-");
      System.out.println("            |   /");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");
    } else {
      System.out.println("            |----------");
      System.out.println("            |    |");
      System.out.println("            |    O");
      System.out.println("            |   -|-");
      System.out.println("            |   / \\");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            |");
      System.out.println("            ==========");
    }
  }
}