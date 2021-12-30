import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Random;
class Files {
    
    /**
     * THIS FILE WILL HOLD DATA STRUCTURES OF THE POSSIBLE WORDS THAT CAN BE THROW INTO A PARAGRAPH.
     * PARAGRAPHS WILL BE RANDOMIZED, AND WORDS WILL BE CHOSEN AT RANDOM TO DEVELOP A PARAGRAPH.
     * PROGRAM CAN START BY WRITING A TEXT FILE TO A HASHTABLE FULL OF THE WORDS, AND THERE WILL BE A 
     * SEPERATE HASTABLE TO CHECK IF A WORD HAS BEEN USED ALREADY IN THE SENTENCE.
     */

    
    // WILL TEST THE METHODS WITH A SMALL VERSION FROM A SMALL TEXT FILE
    

    // Generate a random string based on the given set of words (will test using all strings from a small set of words)
    public String generateString(Hashtable<Integer, String> table, int n) {
        Random rand = new Random();
        n = table.size();     // size of the table, will be needed for the main loop
        String res = "";      // will be the randomly built string for the game
        ArrayList<Integer> check = new ArrayList<Integer>();
        boolean used = false; // denotes that an index of the original hashtable of strings has been used
        int r = -1;           // used to store the generated random value

        for (int i = 0; i < n; i++) {
            r = rand.nextInt(n);
            if (check.size() == 0) {
                res += table.get(r) + " ";
                check.add(r);
                continue;
            }
            while (check.contains(r) == true) {
                r = rand.nextInt(n);
            }
            res += table.get(r) + " ";
            check.add(r);
        }

        return res;
    }



    // print out a hashtable of integers and strings
    public void printTable(Hashtable<Integer, String> table) {
        for (int i = 0; i < table.size(); i++) {
            System.out.print(table.get(i) + " ");
        }
    }

}