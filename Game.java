import java.util.Scanner;
import java.util.Hashtable;
import java.io.File;
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
                System.out.println(words);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        if (words.length() != 0) {
            String str = ""; // used to keep track of individual strings in the long built one
            int count = 0;
            for (int i = 0; i < words.length(); i++) {
                if (words.charAt(i) == ' ' || words.charAt(i) == '.') {
                    // add string to hashtable
                    table.put(count, str);
                    count++;
                    str = "";
                }
                else {
                    str += words.charAt(i);
                }
            }
        }
        
        Files obj = new Files();
        String res = obj.generateString(table, 2);
        System.out.println("\n" + res);

    }
    /*********** END OF MAIN ********************************/
}