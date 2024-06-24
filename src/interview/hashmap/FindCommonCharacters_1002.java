package interview.hashmap;

import java.util.*;

public class FindCommonCharacters_1002 {

    public List<String> commonChars(String[] words) {

        if (words.length == 0)
            return new ArrayList<>();

        Map<Character, Integer> map = prepareFreqMap(words[0]);

        List<String> result = new ArrayList<>();


        for (int i = 1; i < words.length; i++) {

            Map<Character, Integer> newMap = prepareFreqMap(words[i]);

            for (Character c : new ArrayList<>(map.keySet())) {
                if (newMap.containsKey(c)) {
                    map.put(c, Math.min(map.get(c), newMap.get(c)));
                } else {
                    map.remove(c);
                }
            }

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character character = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                result.add(character + "");
            }
        }
        return result;
    }

    private Map<Character, Integer> prepareFreqMap(String word) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
