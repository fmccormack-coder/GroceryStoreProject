import java.io.*;
import java.util.*;

public class GroceryList extends Node {
    private Node head; // stores the head of the Linked List

    // No-param default constructor
    public GroceryList() {
        this.head = null;
    }

    // 1-param constructor
    public GroceryList(Node head) {
        this.head = head;
    }

    //method to add item to end of list
    public void add(String item){
        Node incoming = new Node(item);
        if (head == null) {
            head = incoming;;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = incoming;
        }
    }

    // method to add item to specific index
public void add(String item, int idx) {
        Node incoming = new Node(item);
        if (head == null) {
            head = incoming;
        } 
        else if (idx<=size() && idx >=0){
        
            if (idx == 0) {
                incoming.next = head;
                head = incoming;
            } else {
                Node curr = head;
                for (int i=0; i<idx-1; i++) {
                    curr=curr.next;
                }
                
                incoming.next = curr.next;
                curr.next=incoming;
            }

        }
    }        


// method to remove item at specific index
public void remove(int idx) {
        if (head != null && idx<size() && idx >=0) {
            
            if (idx == 0) {
                head = head.next;
            } else {
                Node curr = head;
                for (int i=0; i<idx-1; i++) {
                    curr=curr.next;
                }
                curr.next=curr.next.next;
            }
        }
    }

    // method to return size of list
    public int size() {
        int count = 0;
        Node curr = head;
            while (curr!=null) {
                curr=curr.next;
                count++;
            }
        return count;
    }

    // method to return index of item in list, or if they are not found return -1
    public int indexOf(String data){
            int index = 0; 
            Node curr = head;
            while (curr != null) {
                if (curr.item.equals(data)) {
                    return index; 
                }
                index++;
                curr = curr.next;
            }
            return -1;
        }

        // method to return a map of the grocery items and their prices, using the text file (GroceryList.txt as input

    Map<String, Double> getGroceryMap(String PathName) throws FileNotFoundException{
        File f = new File(PathName);
        Scanner sc = new Scanner(f); 

        Map<String, Double> groceryMap = new HashMap<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String it = line.substring(1, line.indexOf("\" "));
            if(indexOf(it) != -1){
                double price = Double.parseDouble(line.substring(line.indexOf("\" ") +2));
                groceryMap.put(it, price);
            }

        }
        return groceryMap;
    }


// method to return total cost of the grocery list using the map created in the getGroceryMap function above
    public double getCost(Map<String, Double> groceryMap){
        double cost = 0.0;


        for(String k: groceryMap.keySet()){
            cost+= groceryMap.get(k);
        }

        return cost;
    }

    // method to return string of the list with spaces and neat looking format, also includes total cost and status
    public String toString(){
        String result = "";
        Node curr = head;
        while (curr != null) {
            result += curr.item;
            result+= " ";

            curr = curr.next;
        }
        try { 
            double cost = getCost(getGroceryMap("groceryList.txt"));
            result+=cost;
            result += " ";

            result+=status(cost);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
 
        return result;
    }


    //My personal method: It is a method to return the status of the customer based on the total cost of their grocery list. 
    public static String status(double cost){
        if (cost < 10) {
            return "Silver Status";
        } else if (cost >= 10 && cost < 20) {
            return "Gold Status";
        } else {
            return "Platinum Status";
        }
    }

}