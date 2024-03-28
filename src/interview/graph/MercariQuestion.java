package interview.graph;

import java.util.HashMap;
import java.util.Map;

class PersonTravel {

  int time;
  String startStation;

  public PersonTravel(int time, String startStation) {
    this.time = time;
    this.startStation = startStation;
  }
}


class Cache {

  int totalTime;
  int totalTrips;

  public Cache(int totalTime, int totalTrips) {
    this.totalTime = totalTime;
    this.totalTrips = totalTrips;
  }
}

public class MercariQuestion {

  Map<String, Cache> cacheMap = new HashMap<>();

  Map<Integer, PersonTravel> checkInCheckOutMap = new HashMap<>();


  public void checkIn(int id, String stationName, int t) {
    if (checkInCheckOutMap.containsKey(id)) {
      return;
    }
    checkInCheckOutMap.put(id, new PersonTravel(t, stationName));
  }

  public void checkOut(int id, String stationName, int t) {
    PersonTravel personTravel = checkInCheckOutMap.get(id);
    String cacheKey = personTravel.startStation + "|" + stationName;
    if (!cacheMap.containsKey(cacheKey)) {
      Cache cache = new Cache(t - personTravel.time, 1);
      cacheMap.put(cacheKey, cache);
    } else {
      Cache cache = cacheMap.get(cacheKey);
      cache.totalTime += t - personTravel.time;
      cache.totalTrips += 1;
      cacheMap.put(cacheKey, cache);
    }
    checkInCheckOutMap.remove(id);
  }


  public Double getAverageTime(String startStation, String endStation) {
    String cacheKey = startStation + "|" + endStation;
    Cache cache = cacheMap.get(cacheKey);
    return (double) cache.totalTime / cache.totalTrips;
  }


  public static void main(String[] args) {
    var sln = new MercariQuestion();

    sln.checkIn(45, "San Francisco", 3);
    sln.checkIn(32, "San Mateo", 8);
    sln.checkIn(27, "San Francisco", 10);

    sln.checkOut(45, "Palo Alto", 15);
    sln.checkOut(27, "Palo Alto", 20);
    sln.checkOut(32, "Mountain View", 22);

    System.out.println(sln.getAverageTime("San Mateo", "Mountain View")); // 14
    System.out.println(sln.getAverageTime("San Francisco", "Palo Alto")); // 11
  }
}