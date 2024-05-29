package interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class MinimumGeneticMutation_433 {


  public int minMutation(String startGene, String endGene, String[] bank) {

    int minMutations = 0;

    Queue<String> queue = new LinkedList<>();
    queue.add(startGene);

    Set<String> possibleGenes = new HashSet<>();

    for (String b : bank) {
      possibleGenes.add(b);
    }

    Set<String> visited = new HashSet<>();

    char[] genesPossible = {'A', 'C', 'G', 'T'};
    visited.add(startGene);

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String currGene = queue.poll();

        if (currGene.equals(endGene)) {
          return minMutations;
        }

        for (int j = 0; j < currGene.length(); j++) {

          char[] arr = currGene.toCharArray();
          char ch = arr[j];

          for (char c : genesPossible) {
            if (ch != c) {
              arr[j] = c;
              String newString = String.valueOf(arr);
              if (!visited.contains(newString) && possibleGenes
                  .contains(newString)) {
                queue.add(newString);
                visited.add(newString);
              }
            }
          }

        }
      }

      minMutations++;
    }

    return -1;

  }


  @Test
  public void test() {
    System.out.println(minMutation("AAAAAAAA", "CCCCCCCC",
        new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC",
            "ACCACCCC", "ACCCCCCC", "CCCCCCCA"}));
  }

}
