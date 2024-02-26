package interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.Test;

public class ReconstructItinerary_332 {


  public List<String> findItinerary(List<List<String>> tickets) {
    List<String> itinerary = new LinkedList<>();

    Map<String, PriorityQueue<String>> itineraryMap = new HashMap<>();
    for (List<String> ticket : tickets) {
      PriorityQueue<String> priorityQueue = itineraryMap
          .getOrDefault(ticket.get(0), new PriorityQueue<>());
      priorityQueue.add(ticket.get(1));
      itineraryMap.put(ticket.get(0), priorityQueue);
    }

    dfsHelper("JFK", itinerary, itineraryMap);

    return itinerary;
  }

  private void dfsHelper(String sourceCity, List<String> itinerary,
      Map<String, PriorityQueue<String>> itineraryMap) {

    PriorityQueue<String> priorityQueue = itineraryMap.get(sourceCity);

    if (priorityQueue != null && !priorityQueue.isEmpty()) {
      while (!priorityQueue.isEmpty()) {
        String destCity = priorityQueue.poll();
        dfsHelper(destCity, itinerary, itineraryMap);
      }
    }
    itinerary.add(0,sourceCity);
  }


  /**
   * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
   * [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
   */

  @Test
  public void test() {
    List<List<String>> tickets = new ArrayList<>();
    List<String> list1 = List.of("JFK", "SFO");
    List<String> list2 = List.of("JFK", "ATL");
    List<String> list3 = List.of("SFO", "ATL");
    List<String> list4 = List.of("ATL", "JFK");
    List<String> list5 = List.of("ATL", "SFO");
    tickets.add(list1);
    tickets.add(list2);
    tickets.add(list3);
    tickets.add(list4);
    tickets.add(list5);
    System.out.println(findItinerary(tickets));
  }

  @Test
  public void test1() {
    List<List<String>> tickets = new ArrayList<>();
    List<String> list1 = List.of("MUC", "LHR");
    List<String> list2 = List.of("JFK", "MUC");
    List<String> list3 = List.of("SFO", "SJC");
    List<String> list4 = List.of("LHR", "SFO");
    //List<String> list5 = List.of("ATL", "SFO");
    tickets.add(list1);
    tickets.add(list2);
    tickets.add(list3);
    tickets.add(list4);
    //tickets.add(list5);
    System.out.println(findItinerary(tickets));
  }

  @Test
  public void test3() {
    List<List<String>> tickets = new ArrayList<>();
    List<String> list1 = List.of("JFK", "KUL");
    List<String> list2 = List.of("JFK", "NRT");
    List<String> list3 = List.of("NRT", "JFK");
    //List<String> list4 = List.of("LHR", "SFO");
    //List<String> list5 = List.of("ATL", "SFO");
    tickets.add(list1);
    tickets.add(list2);
    tickets.add(list3);
    //tickets.add(list4);
    //tickets.add(list5);
    System.out.println(findItinerary(tickets));
  }


}
