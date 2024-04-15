package interview.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorPractice {


  static class Employer {

    String name;
    Integer age;
    Float increment;
    Double growth;
    Long salary;
    Character team;

    public Employer(String name, Integer age, Float increment, Double growth, Long salary,
        Character team) {
      this.name = name;
      this.age = age;
      this.increment = increment;
      this.growth = growth;
      this.salary = salary;
      this.team = team;
    }
  }

  public static void main(String[] args) {
    Employer e1 = new Employer("t", 55, 2.5f, -5.0d, 300l, 'Y');
    Employer e2 = new Employer("z", 52, 2.2f, -6.0d, 301l, 'Z');
    Employer e3 = new Employer("c", 57, 2.7f, -4.0d, 201l, 'A');

    List<Employer> list = new ArrayList<>();
    list.add(e1);
    list.add(e2);
    list.add(e3);

    //String comparator
    //Natural order
    Collections.sort(list, (a, b) -> a.name.compareTo(b.name));
    System.out.println(list.get(0).name.equals("c"));

    //Reverse Order
    Collections.sort(list, (a, b) -> b.name.compareTo(a.name));
    System.out.println(list.get(0).name.equals("z"));

    //Integer comparator
    //Natural order
    Collections.sort(list, (a, b) -> a.age.compareTo(b.age));
    System.out.println(list.get(0).age.equals(52));

    //Reverse Order
    Collections.sort(list, (a, b) -> b.age.compareTo(a.age));
    System.out.println(list.get(0).age.equals(57));

    //Float comparator
    //Natural order
    Collections.sort(list, (a, b) -> a.increment.compareTo(b.increment));
    System.out.println(list.get(0).increment.equals(2.2f));

    //Reverse Order
    Collections.sort(list, (a, b) -> b.increment.compareTo(a.increment));
    System.out.println(list.get(0).increment.equals(2.7f));

    //Double comparator
    //Natural order
    Collections.sort(list, (a, b) -> a.growth.compareTo(b.growth));
    System.out.println(list.get(0).growth.equals(-6.0d));

    //Reverse Order
    Collections.sort(list, (a, b) -> b.growth.compareTo(a.growth));
    System.out.println(list.get(0).growth.equals(-4.0d));

    //Long comparator
    //Natural order
    Collections.sort(list, (a, b) -> a.salary.compareTo(b.salary));
    System.out.println(list.get(0).salary.equals(201l));

    //Reverse Order
    Collections.sort(list, (a, b) -> b.salary.compareTo(a.salary));
    System.out.println(list.get(0).salary.equals(301l));

    //Character comparator
    //Natural order
    Collections.sort(list, (a, b) -> a.team.compareTo(b.team));
    System.out.println(list.get(0).team.equals('A'));

    //Reverse Order
    Collections.sort(list, (a, b) -> b.team.compareTo(a.team));
    System.out.println(list.get(0).team.equals('Z'));


  }

}
