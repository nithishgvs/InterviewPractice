package interview.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class KillProcess_582 {

  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

    Map<Integer, List<Integer>> parentChildMap = new HashMap<>();

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < ppid.size(); i++) {
      if (!parentChildMap.containsKey(ppid.get(i))) {
        parentChildMap.put(ppid.get(i), new ArrayList<>());
      }
      parentChildMap.get(ppid.get(i)).add(pid.get(i));
    }
    helper(result, parentChildMap, kill);
    return result;
  }

  private void helper(List<Integer> result, Map<Integer, List<Integer>> parentChildMap,
      int currKill) {
    result.add(currKill);
    List<Integer> children = parentChildMap.getOrDefault(currKill, new ArrayList<>());
    children.forEach(child -> {
      helper(result, parentChildMap, child);
    });
  }

  @Test
  public void test() {
//pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5

//    List<Integer> pid = Arrays.asList(1, 3, 10, 5);
//    List<Integer> ppid = Arrays.asList(3, 0, 5, 3);

    List<Integer> pid = Arrays.asList(1,2,3,4,5);
    List<Integer> ppid = Arrays.asList(0,1,1,1,1);
    killProcess(pid, ppid, 1);
  }

}
