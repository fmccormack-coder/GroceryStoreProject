
public class GroceryListTester {
    public static void main(String[] args) {
        GroceryList list = new GroceryList(null);
        list.add("milk");
        list.add("eggs");
        list.add("bread");
        System.out.println(list); 
        list.add("butter", 1);
        System.out.println(list); 
        list.remove(2);
        System.out.println(list); 
        System.out.println(list.size());


    }
} 