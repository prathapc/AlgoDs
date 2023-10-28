<h1>AlgoDs</h1>
Algorithms and data structures programs written in java.

<h3>Trees</h3>

- In complete binary tree, there will be 2^height - 1 nodes

<h3>Graphs</h3>
Once you've figured out that the question can be modeled as a graph problem,
you then need to think about the various aspects of a graph i.e.

directed vs undirected
weighted vs unweighted
cyclic vs acyclic

These aspects will help define the algorithm that you can consider for solving the problem at hand.
For example a standard rule of thumb that is followed
- for solving shortest path problems
    - for unweighted graphs we mostly use Breadth-first search [O(V + E)] or DFS
    - for DAGs topology sort [O(V+E)]
    - for non negative weighted cyclic graph we use Dijkstra's algorithm [O(E + VLogV)]
    - for negative weights cyclic Bellman Ford's [ O(VE) ]
      (if graph with "negative weighted cycle" (meaning sum of edges in cycle is negative)then no shortest path exist)
      (basically, bellman-ford is dynamic programming but optimized for space.
      We calculate shortest path using atmost 0,1,2.. n-1 edges, each time we use prev stage results with 1D array)

- spanning tree is a connected subgraph (“weighted undirected graph") in an undirected graph where all vertices are connected with
the min no of edges.
two algorithms for constructing a “minimum spanning tree”:
    1. Kruskal’s Algorithm
    2. Prim’s algorithm

Disjoint sets:

- identify and group elements that are connected into sets by assigning one head for each element in the group

DFS vs BFS

For finding shortest path BFS is better than DFS, because in BFS as soon as we hit destination
that's going to be shortest route and no need to find all paths unlike DFS

Good content:-
https://algs4.cs.princeton.edu/40graphs/


------------------------------------------------------------------------------------------------------------------



<h3>Java Basics</h3>
<h4>Collections </h4>
`ArrayList vs LinkedList` <br />
ArrayList is useful when reads are more than add/remove because of access by index
LinkedLists are more suitable when the addition rate is much higher than the read rate as deletion and additions are quick

`LinkedList vs Deque` <br />

The general-purpose implementations of Deque include LinkedList and ArrayDeque classes. 
The Deque interface supports insertion, removal and retrieval of elements at both ends. 
The ArrayDeque class is the resizeable array implementation of the Deque interface, 
whereas the LinkedList class is the list implementation.

The basic insertion, removal and retrieval operations in the Deque interface addFirst, addLast, 
removeFirst, removeLast, getFirst and getLast. 

The LinkedList implementation is more flexible than the ArrayDeque implementation. 
LinkedList implements all optional list operations. null elements are allowed in the LinkedList implementation
but not in the ArrayDeque implementation.

In terms of efficiency, ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends. 
The best operation in a LinkedList implementation is removing the current element during the iteration. 
LinkedList implementations are not ideal structures to iterate.

The LinkedList implementation consumes more memory than the ArrayDeque implementation.

```
Concurrent Deque Implementations
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The "LinkedBlockingDeque" class is the concurrent implementation of the Deque interface. 
If the deque is empty then methods such as takeFirst and takeLast wait until the element becomes available, 
and then retrieves and removes the same element.
```
```
addFirst() vs offerFirst()
~~~~~~~~~~~~~~~~~~~~~~~~~~
The difference is what happens when the addition fails, due to a queue capacity restriction:

.addFirst() throws an (unchecked) exception,
.offerFirst() returns false.
This is documented in Deque, which ArrayDeque implements.

Of note is that ArrayDeque has no capacity restrictions, so basically .addFirst() will never throw an exception 
(and .offerFirst() will always return true); 
this is unlike, for instance, a LinkedBlockingQueue built with an initial capacity.
```

`Priority Queue` <br />
PriorityQueue<String> pq = new PriorityQueue<String>(); //minHeap
PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //maxHeap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap 

add() always returns true and throws an exception if it can't add the element
offer() is allowed to return false if it can't add the element. 

<h3>Java utilities often used</h3>

<h4>Primitive data types & utilities </h4>
1. Character hacks
   Character.getNumericValue(number.charAt(i))
   Character.isDigit(ch)
   Character.isLetterOrDigit(ch)
   Character.toLowerCase(ch)
   Character.isWhitespace(ch)
   
2. build number from stack of chars
   int currentNumber = 0;
   if (Character.isDigit(ch)) {
        currentNumber = (currentNumber * 10) + (ch - '0');
   }
   or try using Character.getNumericValue(ch)
   
3. Arrays fill
   int[] dp = new int[10];
   Arrays.fill(dp, 1);
   
4. Print array
   System.out.println(Arrays.toString(array));
   System.out.println(Arrays.deepToString(deepArray)); //for multi dimention arrays
   Arrays.stream(arr).forEach(System.out::println);
   
5. Map and Set 
   map.put() returns the previous value associated with key, or null if there was no mapping for key
   set.add() returns true if this set did not already contain the specified element
   With above logic, you can avoid using containsKey and contains in many cases.

6. List / ArrayList
   list.remove(4); //removes element at index 4
   list.remove(Integer.valueOf(4)); //removes element 4 not by index

6. Autoboxing
   int i = 10;
   Integer a = i;
   Integer b = i;
   System.out.println(a == b); //guess what is the output?
   The output was supposed to be false. However, you can test this and you will find it is true.
   Why?

   Because "The JVM is caching Integer values. == only works for numbers between -128 and 127 "
   Then you can try another code:

   int i = 1000; //greater than 127
   Integer a = i;
   Integer b = i;
   System.out.println(a == b); //this time we got false
   
   Look, now you get false. And now it explains why we can pass the small cases 
   (because the indices are in the range of -128 and 127). 
   We also know why it cannot pass the larger test case. 

7. 

<h4>Transformations</h4>
ArrayList to Array:
int[] a = list.toArray() doesn't work as it returns Object[]. We have to do below.
int[] arr = list.stream().mapToInt(i->i).toArray();

ArrayList<int[]> to 2D array:
list.stream().toArray(int[][]::new);

Array to List:
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> integers = Arrays.asList(nums);

List to Set:
Set<Integer> set = new HashSet<>(list);


<h4>Sorting</h4>
`sort pairs/intervals` <br />
sort 1D (Integer[]) : (note its not primitive int; for primitive type to sort in desc we have to do asc and reverse ourself)
1. Arrays.sort(arr, Collections.reverseOrder()); <br />
```
2. Comparator<Integer> comparator = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    // option 1
    Integer[] array = new Integer[] { 1, 24, 4, 4, 345 };
    Arrays.sort(array, comparator);
```
sort 2D (int[][]) : 
Arrays.sort(intervals, (int i1[], int i2[]) -> i1[0]-i2[0]);  <br />

`sort List` <br />
Collections.sort(activities, (a, b) -> a.getFinish() - b.getFinish());

`Reverse list` <br />
Collections.reverse(colors); //works for StringBuilder as well <br />
Collections has reverseOrder method as well which returns comparator. Useful for defining priority queue etc. <br />

<h3>Bitwise operations</h3> 
More here https://leetcode.com/discuss/interview-question/3695233/All-Types-of-Patterns-for-Bits-Manipulations-and-How-to-use-it
```
& => both true
| => either or both true
~ => negation
^ => either true
left shift << => multiplied by 2 / yields double[x << y is x*2^y  ex1: 6<<1 is 6*2  ex2: 6<<3 is 6*2 pow(3)]
right shift >> => divide by half / yields half [x >> y is x/2^y  ex1: 6>>1 is 6/2^1]
```
int a = -1020; <br />
a = a >> 1; // division <br />
System.out.println(a); <br />
// Prints -510. Great! <br />
int b = -1021; <br />
b = b >> 1; <br />
System.out.println(b); <br />
// Prints -511. Ugghh.

The solution is to add 1 before doing the bit-shift on a negative number.
This way, it'll be "correct" regardless of whether the number was odd or even.

int a = -1020; <br />
a = (a + 1) >> 1; <br />
System.out.println(a); <br />
// Prints -510. Great! <br />
int b = -1021; <br />
b = (b + 1) >> 1; <br />
System.out.println(b); <br />
// Prints -510. Yay! <br />
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
tricks:-
1. if num is even
    if x & 1 == 0 then x is even
   
2. to uppercase/lowercase
    xor with 32 (c ^ 32)
   
3. Find the element in an array that is not repeated.
    do xor of all elements in array
   
4. Get First Set Bit
   we first check if the rightmost significant bit is the set bit using bit & 1. 
   If not, we keep shifting left and checking until we find the bit that makes our AND operation yield 1

How to represent -ve number?
~~~~~~~~~~~~~~~~~~~~~~~~~~~
Typically -ve integer gets stored in 2's compliment form. That means very first bit is used to represent the sign.
0 means +ve and 1 means -ve.
remaining bits filled with 2's compliment

Ex: 18 and -18

18 -> 0010010

find ~ of the number

  1101101

add +1 for the outcome

  1101110

add 1 to the most significant position

so -18 => 11101110
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

left and right shift:

+ve number right shift -> add 0 to the left most and remove right most bit

-ve number left shift ->  add 1 to the left most and remove right most bit

left shift has effect of multipying number by 2 and right shift of dividing number by 2 with some truncation
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Bit masking:
Masking means to keep/change/remove a desired part of information. 
