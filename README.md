# RomanOnNeetcode
These are my solutions for Neetcode 150 problems using Java. 

The descriptions of exercises are located here: https://neetcode.io/practice?tab=neetcode150

## Requirements
- Java 17

## Useful tips:

### Map

```
interface Map<K, V> {
    boolean containsKey(Object key);    //Returns true if and only if this map contains a mapping for a key k such that Objects. equals(key, k). (There can be at most one such mapping.)
    
    Set<Map.Entry<K, V>> entrySet();    //Returns a set view of the mappings contained in this map
    
    Set<K> keySet();                    //Returns a set view of the keys contained in this map
    
    Collection<V> values();             //Returns a collection view of the values contained in this map
}
```

### Stream
Example of usage...
```
Map.of(...)
    .entrySet()
    .stream()
    .sorted((x1, x2) -> -1 * x1.getValue().compareTo(x2.getValue()))
    .limit(k)
    .map(x -> x.getKey())
    .mapToInt(Integer::intValue)
    .toArray();
```


```
interface Stream<T> {

    IntStream mapToInt(ToIntFunction<? super T> mapper);    // Returns IntStream
    
    Object[] toArray();                                     // Returns an array containing the elements of this stream
    
    Stream<T> sorted(Comparator<? super T> comparator);
    
    Stream<T> limit(long maxSize);                          // Returns the new stream with limited number of elements
}
```

### IntStream

Example of converting a stream of Integers to an array of int values:
```
int[] nums = Stream.of(1, 2, 5)
    .mapToInt(Integer::intValue)
    .toArray();
```

```
interface IntStream {
    int[] toArray(); //Returns an array of int values
}
```

### Queue

```
 interface Queue<E> {
    
    boolean add(E e);   // Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
   
    E poll();           // Retrieves and removes the head of this queue, or returns null if this queue is empty.
      
    E peek();           // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
 }
```

### Priority queue

#### Characteristics of a Priority Queue
A priority queue is an extension of a queue that contains the following characteristics:

Every element in a priority queue has a priority value associated with it. 
The element with the higher priority will be moved to the top and removed first. 
If two elements in a priority queue have the same priority value, they’ll be arranged using the FIFO principle.

Java implementation of the priority queue is based on a priority heap. 
This implementation provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove and add); linear time for the remove and contains methods; and constant time for the retrieval methods (peek, element, and size).