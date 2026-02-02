package j8.collections.assignment;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MapsToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps(){
        Map<String, Integer> channelToSubscribers    = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher       = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers  = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120_000); 
        channelToSubscribers.put("JustForGags", 10_000); 
        channelToSubscribers.put("ContemplationTechniques", 10_000); 
        channelToSubscribers.put("A New Earth", 20_000); 
        
        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)   
        // V2 -> V1
        // Add this channel's subscriber count to the publisher's running total.
        // Map.merge(key, value, remappingFn) inserts the value if the key is new;
        // otherwise it replaces the existing value with remappingFn(oldValue, value).
        // Integer::sum is a method reference to a static method: (oldVal, value) -> Integer.sum(oldVal, value)
        channelToSubscribers.forEach((channel, subs) ->
                // if the publisher is not there, insert the publisher -> subs
                // if the publisher is already there, update the subs to be the current value + subs
                publisherToSubscribers.merge(channelToPublisher.get(channel), subs, Integer::sum)
//                publisherToSubscribers.merge(channelToPublisher.get(channel), subs,
//                        (oldVal, subsToAdd) -> oldVal + subsToAdd)
        );


        // Output "publisherToSubscribers"
//        publisherToSubscribers.forEach(
//                (publisher, numSubscribers) ->
//                    System.out.println("publisher: "+publisher+"; numSubscribers:"+numSubscribers));
        publisherToSubscribers.forEach((publisher, subs) ->
                System.out.printf("Publisher: %s; numSubscribers: %d%n", publisher, subs)
        );

        // Who has the most/least subscribers?
//        int minSubscribers = Collections.min(publisherToSubscribers.values());
//        int maxSubscribers = Collections.max(publisherToSubscribers.values());
//        publisherToSubscribers.forEach((publisher, numSubscribers) -> {
//            if (numSubscribers == maxSubscribers) {
//                System.out.println("Publisher with most subscribers: " + publisher + " " + maxSubscribers);
//            } else if (numSubscribers == minSubscribers) {
//                System.out.println("Publisher with fewest subscribers: " + publisher + " " + minSubscribers);
//            }
//        });

        // publisherToSubscribers:
        //    "Charlie Chaplin" -> 130_000
        //    "Eckhart Tolle"   ->  30_000
        // entrySet() gives us these pairs where each pair is a Map.Entry<K, V>
        // Map.Entry.comparingByValue() returns a Comparator that compares entries by their value
        // i.e. when comparing two entries, compare their subscriber counts (the values)
        var minEntry = Collections.min(publisherToSubscribers.entrySet(), Map.Entry.comparingByValue());
        var maxEntry = Collections.max(publisherToSubscribers.entrySet(), Map.Entry.comparingByValue());

        System.out.println("Publisher with most subscribers: " + maxEntry.getKey() + " " + maxEntry.getValue());
        System.out.println("Publisher with fewest subscribers: " + minEntry.getKey() + " " + minEntry.getValue());
    }
}
