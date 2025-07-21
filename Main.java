package Nodes;

public class Main {
    public static void main(String[] args) {
        DynamicHashMap<String, Integer> map = new DynamicHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("grape", 3);


        System.out.println(map.get("banana")); 
        map.remove("banana");
        System.out.println(map.get("banana")); 

        System.out.println(map.get("banana")); // 2
        map.remove("banana");
        System.out.println(map.get("banana")); // null

    }
}
