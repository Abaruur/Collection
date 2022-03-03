package CollectionFramework;

import java.util.Collection;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge", "Premier Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.00);
        Room piccadilly  = new Room("Piccadilly", "Guest", 3, 125.00);
        Room oxford  = new Room("Oxford", "Suite", 5, 225.00);
        // This code is brutle and it's not very extensible.if you want to add 4th room you will go through
        // the same process! We can do much better using COLLECTION to manage all of these objects as a group.


        //double total = getPotentialRevenue(cambridge, manchester, piccadilly);
        //System.out.println(total);


        Collection<Room> rooms = List.of(cambridge, manchester, piccadilly, oxford);
        rooms.add(piccadilly);
        rooms.add(oxford);
        double total = getPotentialRevenue(rooms);
        System.out.println(total);

    }

    private static double getPotentialRevenue(Collection<Room> rooms)
    {   //Take the collection of rooms and stream it
        return rooms.stream()
           //Use mapToDouble method and get the rate of each room using a lambda expression
                .mapToDouble(r -> r.getRate())
                //Call the sum method to total the rate of each room in the collection
                .sum();
    }
}
