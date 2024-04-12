package interview.arrays;

public class GuesstheWord_843 {


  interface Master {
    public int guess(String word);
  }

  private static final int WORD_LENGTH = 6;

  public void findSecretWord(String[] words, Master master) {
    int numWords = words.length;
    boolean[] eliminate = new boolean[numWords];
    int index = 0;
    int output = master.guess(words[index]), lastGuess, total;

    // The main loop continues until the guessed word matches the secret word
    while (output != WORD_LENGTH) {
      // Store the current guess index for reference
      lastGuess = index;
      eliminate[lastGuess] = true;

      // Iterate through the words and eliminate those that don't match the feedback
      for (int i = 0; i < numWords; i++) {
        if (eliminate[i]) {
          continue;
        }

        // Count the number of matching characters between the current guess and other words
        total = 0;
        for (int j = 0; j < WORD_LENGTH; j++) {
          if (words[lastGuess].charAt(j) == words[i].charAt(j)) {
            total++;
          }
        }

        // If the count doesn't match the feedback, eliminate the word; otherwise, update the index
        if (total != output) {
          eliminate[i] = true;
        } else {
          index = i;
        }
      }

      // Make a new guess based on the updated index
      output = master.guess(words[index]);
    }
  }
}
