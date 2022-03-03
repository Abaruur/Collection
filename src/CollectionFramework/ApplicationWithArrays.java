package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ApplicationWithArrays {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge", "Premier Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.00);
        Room piccadilly  = new Room("Piccadilly", "Guest", 3, 125.00);
        Room oxford  = new Room("Oxford", "Suite", 5, 225.00);

        //Declaring new array you should know the of elements the array stores up front! Then you have to store
        //each room within its index.This can lead to errors that throw indexOutOfBound exceptions.
        Room[] rooms = new Room[3];
        rooms[0] = cambridge;
        rooms[1] = manchester;
        rooms[2] = piccadilly;

        //If we would like to add a new element into this array, we actually have to make a copy of it.Let us copy

        Room[] moreRooms = new Room[4]; // Use array copy method, below
        System.arraycopy(rooms, 0, moreRooms, 0, rooms.length);
        // Store the new room in the last index within our new array. Just subtract 1 from the length
        moreRooms[moreRooms.length -1] = oxford;



        // Better now COLLECTIONS! less or no errors, relatively easy to instantiate a collection and add elements.
        //NO Need to declare the size of the array up front.

       // Collection<Room> rooms = new ArrayList<>(List.of(cambridge, manchester));

        //No need for index to add rooms. No indexOutOfBound exception.
        //rooms.add(piccadilly);
        //rooms.add(oxford);

        getPotentialRevenue(rooms);
    }
    private static double getPotentialRevenue(Room[] rooms)
    {
        return Arrays.stream(rooms)
                .mapToDouble(r - > r.getRate())
                .sum();
    }
}
