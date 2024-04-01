package interview.miscellaneous;

/*
You are in charge of implementing the dasher payment model. The first
version of the payment model is naively based on how much time dasher
spends on each order. Given the sequence of accepted/fulfilled order
activities from a given dasher on a given day, calculate the dasher
pay based on the following payment rules
 1. base pay rate: $0.3 per minute
 2. multi order pay rate: # ongoing deliveries * base pay rate
     (when dasher is delivering multiple orders at the same time)

Assumptions:
 1. All order activities are from the same calendar day
 2. Order activity sequence is valid. All orders are fulfilled by end
 of day (no duplicates, no fulfillment without pickup, no pickup
     without fulfillment, etc).

Example:
Input:
06:15: Dx accepted order A
06:18: Dx accepted order B
06:36: Dx fulfilled order A
06:45: Dx fulfilled order B

Output: final pay: $14.4

Explanation:
06:15 - 06:18 -> pay = 3 * 0.3 -> $0.9
06:18 - 06:36 -> pay = 2 orders * 0.3 * 18 -> $10.8
06:36 - 06:45 -> pay = 0.3 * 9 = $2.7
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Job {

  int hour;
  int minute;
  Character orderName;
  Character type;

  public Job(int hour, int minute, Character orderName, Character type) {
    this.hour = hour;
    this.minute = minute;
    this.orderName = orderName;
    this.type = type;
  }
}

class Time {

  int hour;
  int minute;

  public Time(int hour, int minute) {
    this.hour = hour;
    this.minute = minute;
  }
}

public class DoorDash {

  public static float function(List<Job> jobs) {

    Map<Character, Time> orderMap = new HashMap<>();
    Job firstJob = jobs.get(0);

    orderMap.put(firstJob.orderName, new Time(firstJob.hour, firstJob.minute));

    float totalMoney = 0;

    for (int i = 1; i < jobs.size(); i++) {
      Job currJob = jobs.get(i);
      Job previousJob = jobs.get(i - 1);
      int hours = currJob.hour - previousJob.hour;
      int minutes = currJob.minute - previousJob.minute;
      totalMoney += (60 * hours * 0.3 + minutes * 0.3) * orderMap.keySet().size();
      if (currJob.type == 'F') {
        orderMap.remove(currJob.orderName);
      } else {
        orderMap.put(currJob.orderName, new Time(currJob.hour, currJob.minute));
      }
    }

    return totalMoney;
  }

  public static void main(String[] args) {
    List<Job> jobs = new ArrayList<>();
    Job job1 = new Job(6, 15, 'A', 'A');
    Job job2 = new Job(6, 18, 'B', 'A');
    Job job3 = new Job(6, 36, 'A', 'F');
    Job job4 = new Job(6, 45, 'B', 'F');
    jobs.add(job1);
    jobs.add(job2);
    jobs.add(job3);
    jobs.add(job4);

    System.out.print(function(jobs));

  }
}
