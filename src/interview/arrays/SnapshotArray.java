package interview.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {

  private int snapId = 0;

  List<TreeMap<Integer, Integer>> snapShots;

  public SnapshotArray(int length) {
    snapShots = new ArrayList<>();

    for (int i = 0; i < length; i++) {
      TreeMap<Integer, Integer> treeMap = new TreeMap<>();
      treeMap.put(0, 0);
      snapShots.add(treeMap);
    }
  }

  public void set(int index, int val) {
    TreeMap<Integer, Integer> snapshot = snapShots.get(index);
    snapshot.put(snapId, val);
  }

  public int snap() {
    return snapId++;
  }

  public int get(int index, int snap_id) {
    TreeMap<Integer, Integer> snapshot = snapShots.get(index);
    Map.Entry<Integer, Integer> entry = snapshot.floorEntry(snap_id);
    return entry.getValue();
  }
}
