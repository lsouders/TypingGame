import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Random;
public class Files {
    
    /**
     * THIS FILE WILL HOLD DATA STRUCTURES OF THE POSSIBLE WORDS THAT CAN BE THROW INTO A PARAGRAPH.
     * PARAGRAPHS WILL BE RANDOMIZED, AND WORDS WILL BE CHOSEN AT RANDOM TO DEVELOP A PARAGRAPH.
     * PROGRAM CAN START BY WRITING A TEXT FILE TO A HASHTABLE FULL OF THE WORDS, AND THERE WILL BE A 
     * SEPERATE HASTABLE TO CHECK IF A WORD HAS BEEN USED ALREADY IN THE SENTENCE.
     */

    
    // WILL TEST THE METHODS WITH A SMALL VERSION FROM A SMALL TEXT FILE
    private int numberOfWords = 0;
    private Hashtable<Integer, String> table;

    public Files(Hashtable<Integer, String> t) {
        this.table = t;
        this.numberOfWords = t.size();
    }

    // default constructor
    public Files() {
        this.table = null;
    }

    // Generate a random string based on the given set of words (will test using all strings from a small set of words)
    public String generateString(Hashtable<Integer, String> t, int n) {
        Random rand = new Random();
        if (t != this.table)
            n = t.size();
        else
            n = numberOfWords; // size of the table, will be needed for the main loop
        String res = "";       // will be the randomly built string for the game
        ArrayList<Integer> check = new ArrayList<Integer>();
        boolean used = false;  // denotes that an index of the original hashtable of strings has been used
        int r = -1;            // used to store the generated random value

        for (int i = 0; i < n; i++) {
            r = rand.nextInt(n);
            
            while (check.contains(r) == true) {
                r = rand.nextInt(n);
            }

            res += this.table.get(r) + " ";
            check.add(r);
        }

        // reformat the string to remove the trailng space character
        if (res.charAt(res.length() - 1) == ' ')
            res = res.substring(0, (res.length() - 1));

        return res;
    }

    // find the WPM from the typing test
    public double wordsPerMinute(double elapsedTime) {
        if (elapsedTime <= 0) return 0;
        
        double minutes = elapsedTime / 60;        // elapsedTime is given in seconds
        return ((double)numberOfWords / minutes); // will give the typed words per minute
    }

    // check the correcness of the input string
    public double checkCorrectness(Hashtable<Integer, String> original, Hashtable<Integer, String> input) {
    
        int count = 0;          // number of incorrect input words
        double correctness = 0; // will be returned as the correctness of the input string
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == null) {
                count++;
                continue;
            }
            if ( input.get(i).equals(original.get(i)) == false ) {
                count++;
            }
        }

        correctness = 100.00 * ((original.size() - (double)count) / original.size());
        correctness = Math.round(correctness*100.00)/100.00;

        return correctness;
    }

    // turn a string into a hashtable
    public Hashtable<Integer, String> stringToTable(String str) {
        Hashtable<Integer, String> res = new Hashtable<Integer, String>();
        String s = "";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i == (str.length() -1)) {
                res.put(count, s);
                break;
            }
            if (str.charAt(i) == ' ' || str.charAt(i) == ',' || str.charAt(i) == '.') {
                res.put(count, s);
                count++;
                s = "";
            }
            else {
                s += str.charAt(i);
            }
        }

        return res;
    }

    // print out a hashtable of integers and strings
    public void printTable(Hashtable<Integer, String> table) {
        for (int i = 0; i < this.table.size(); i++) {
            System.out.print(this.table.get(i) + " ");
        }
    }

}