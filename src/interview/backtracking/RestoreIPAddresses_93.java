package interview.backtracking;

import java.util.*;

public class RestoreIPAddresses_93 {

  public List<String> restoreIpAddresses(String s) {

    /**
     * Snippet 1-3 chars long [0-255]
     * Can't have leading zeros like 025|07
     * Goal is 4 segments and pointer = s.length return
     * Branching factor 3 for each decision, depth=4 (3 power 4=>O(1))
     */

    List<String> restoredIps = new ArrayList<>();
    restoreIps(0, 0, new int[4], s, restoredIps);

    return restoredIps;

  }

  private void restoreIps(
      int progressIndex,
      int currentSegment,
      int[] ipAddressSegments,
      String rawIpString,
      List<String> restoredIps
  ) {
    /*
      If we have filled 4 segments (0, 1, 2, 3) and we are on the 4th,
      we will only record an answer if the string was decomposed fully
    */
    if (currentSegment == 4 && progressIndex == rawIpString.length()) {
      restoredIps.add(buildIpStringFromSegments(ipAddressSegments));
    } else if (currentSegment == 4) {
      return;
    }

    /*
      Generate segments to try, a segment can be 1 to 3 digits long.
          Time Complexity: The time complexity is determined by the number of valid IP addresses that can be formed from the given string. The algorithm explores all possible combinations of segment lengths and values.
        In the worst case, each segment can have up to 3 digits (for example, "255") and there are 4 segments, so the total number of combinations is limited (the worst case scenario is when the input string is "255255255255"). This results in a constant time complexity for each valid IP address construction. So, the time complexity is O(1).

    Space Complexity: The space complexity is determined by the space used by the algorithm's recursive calls and the space used by the restoredIps list to store the valid IP addresses.

        The recursive calls create a stack frame for each recursive call, which can go up to 4 levels deep (for each of the 4 segments). So, the space complexity due to recursion is O(1).

        The space used by the restoredIps list depends on the number of valid IP addresses that are generated. In the worst case, there can be a maximum of 255^4 valid IP addresses (though this is an extremely rare case). So, the space complexity due to the restoredIps list is O(1).
    */
    for (int segLength = 1; segLength <= 3 && progressIndex + segLength <= rawIpString.length();
        segLength++) {

      // Calculate 1 index past where the segment ends index-wise in the original raw ip string
      int onePastSegmentEnd = progressIndex + segLength;

      // Extract int value from our snapshot from the raw ip string
      String segmentAsString = rawIpString.substring(progressIndex, onePastSegmentEnd);
      int segmentValue = Integer.parseInt(segmentAsString);

      // Check the "snapshot's" validity - if invalid break iteration
      if (segmentValue > 255 || segLength >= 2 && segmentAsString.charAt(0) == '0') {
        break;
      }

      // Add the extracted segment to the working segments
      ipAddressSegments[currentSegment] = segmentValue;

      // Recurse on the segment choice - when finished & we come back here, the next loop iteration will try another segment
      restoreIps(progressIndex + segLength, currentSegment + 1, ipAddressSegments, rawIpString,
          restoredIps);
    }
  }

  // Helper Function for building IP address from Integer
  private String buildIpStringFromSegments(int[] ipAddressSegments) {
    return ipAddressSegments[0] + "." + ipAddressSegments[1] + "." + ipAddressSegments[2] + "."
        + ipAddressSegments[3];
  }

}
