import java.util.Scanner;
import java.util.Hashtable;
import java.io.File;
import java.lang.Math;
public class Game {
    /**
     *  WILL BE A GAME THAT THROWS RANDOM WORDS INTO A LONG SENTENCE/ PARAGRAPH, COUNTS THE WORDS PER MINUTE
     *  AND CHECKS FOR CORRECTNESS (might be a later feature)
     */

    public static void main(String[] args) {

        // Start by reading in the file and adding each string to a hash table.
        String words = "";
        // Stores the words that were read from the input file.
        Hashtable<Integer, String> table = new Hashtable<Integer, String>();

        try {
            Scanner input = new Scanner(new File(args[0]));
            while (input.hasNextLine()) {
                words += input.nextLine();
            }
            // PRINT ORIGINAL STRING HERE IF NEEDED
            //System.out.println(words);
            input.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        Files begin = new Files();
        table = begin.stringToTable(words);
        
        Files obj = new Files(table);
        String res = obj.generateString(table, 2); // string for the game
        Hashtable<Integer, String> given = obj.stringToTable(res);   // turn the given string for the game to a hashtable
        System.out.println("\n" + res);            // pring the string for the game

        Scanner inp = new Scanner(System.in);
        
        System.out.println("\nPress y to start: ");
        char c = inp.next().charAt(0);

        // START THE GAME HERE
        Scanner game = new Scanner(System.in);
        if (c == 'y') {
            Stopwatch time = new Stopwatch();
            time.startWatch();
            String gameResult = game.nextLine();
            time.endWatch();
            double wpm = obj.wordsPerMinute(time.elapsedTime());
            // output the words per minute
            System.out.println((Math.round(wpm*100.00)/100.00) + " words per minute.");
            
            // get accuracy of typing 
            Hashtable<Integer, String> result = result = obj.stringToTable(gameResult);
            double correctness = obj.checkCorrectness(given, result);
            System.out.println("You typed at " + correctness + "% correctness."); // currently a problem with this method
        }
        inp.close();

    }
    /*********** END OF MAIN ********************************/

    
}