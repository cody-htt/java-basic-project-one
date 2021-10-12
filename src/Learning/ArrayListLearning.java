package Learning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayListLearning {

    public static void main(String[] args) {

        // create HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // put few items
        map.put(113, "Police");
        map.put(114, "FireFighter");
        map.put(115, "Ambulance");
        map.put(116, "Sth else");
        map.put(117, "Other");

        // getting entrySet() into Set
        Set<Entry<Integer, String>> entrySet = map.entrySet();

        // Collection Iterator
        Iterator<Entry<Integer, String>> myIterator = entrySet.iterator();

        // iterate and remove items simultaneously
        while(myIterator.hasNext()) {

            Entry<Integer, String> entry = myIterator.next();
            String removeValue = entry.getValue();

            if(removeValue.equals("Ambulance")) {
                // try to remove, while iterating
                myIterator.remove();
                System.out.println("Value Other is safely removed using Iterator");
            }
            else {
                System.out.println(entry.getKey() + "\t" + entry.getValue());
            }
        }

    }

}
