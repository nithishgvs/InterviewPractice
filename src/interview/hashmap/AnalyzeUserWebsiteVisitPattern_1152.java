package interview.hashmap;

import java.util.*;
import javafx.util.Pair;

public class AnalyzeUserWebsiteVisitPattern_1152 {

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

    Map<String, List<Pair<Integer, String>>> usersMap = new HashMap<>();

    for (int i = 0; i < timestamp.length; i++) {
      usersMap.computeIfAbsent(username[i], k -> new ArrayList<>());
      usersMap.get(username[i]).add(new Pair<>(timestamp[i], website[i]));
    }

    Map<String, Set<String>> patternUsersMap = new HashMap<>();

    int maxPatternLength = 0;
    String finalPattern = new String();

    for (Map.Entry<String, List<Pair<Integer, String>>> entry : usersMap.entrySet()) {
      String user = entry.getKey();
      List<Pair<Integer, String>> visits = entry.getValue();
      Collections.sort(visits, Comparator.comparingInt(Pair::getKey));
      //Form all patterns for users visits
      for (int i = 0; i < visits.size() - 2; i++) {
        for (int j = i + 1; j < visits.size() - 1; j++) {
          for (int k = j + 1; k < visits.size(); k++) {
            String pattern =
                visits.get(i).getValue() + "," + visits.get(j).getValue() + "," + visits.get(k)
                    .getValue();
            patternUsersMap.computeIfAbsent(pattern, p -> new HashSet<>());
            patternUsersMap.get(pattern).add(user);
            final int currPatternSize = patternUsersMap.get(pattern).size();
            if (currPatternSize > maxPatternLength) {
              maxPatternLength = currPatternSize;
              finalPattern = pattern;
            } else if (currPatternSize == maxPatternLength) {
              finalPattern = finalPattern.compareTo(pattern) <= 0 ? finalPattern : pattern;
            }
          }
        }
      }

    }

    return Arrays.asList(finalPattern.split(","));
  }

}
