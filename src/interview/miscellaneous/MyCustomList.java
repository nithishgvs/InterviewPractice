package interview.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class MyCustomList<T> {

    List<T> list = new ArrayList<>();

    public void addElement(T data) {
        list.add(data);
    }

    public void deleteElement(T data) {
        list.remove(data);
    }

    static class MyCustomList2<T extends Number> {
        List<T> list = new ArrayList<>();

        public void addElement(T data) {
            list.add(data);
        }

        public void deleteElement(T data) {
            list.remove(data);
        }

        public static void main(String[] args) {

        }
    }


    public static void main(String[] args) {
        MyCustomList<Integer> list1 = new MyCustomList();
        MyCustomList<String> list2 = new MyCustomList();
        MyCustomList2<Long> list3 = new MyCustomList2<>();
        /**
         * As T extends Number we can't use string
         * MyCustomList2<String> list4=new MyCustomList2<>();
         */
    }

}
