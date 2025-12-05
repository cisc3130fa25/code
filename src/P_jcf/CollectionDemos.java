void main() {
    // Iterable: anything that can be iterated over with an enhanced for loop.
    // Primary method: iterator()

    // Collection: an Iterable group of elements.
    // Primary methods: see Iterable, plus: size(), add(e), remove(o), contains(o)

    // SequencedCollection: a Collection whose elements have a predicable order.
    // Primary methods: see Collection,
    // plus: addFirst(e), addLast(e), getFirst(), getLast(), removeFirst(), removeLast(), reversed()

    // List: a SequencedCollection that offers access via indexes.
    // Primary methods: see SequencedCollection,
    // plus: add(index, e), remove(index), get(index), set(index, e),
    // indexOf(o), subList(index1, index2), sort(comparator)
    List<Integer> unmodifiableList = List.of(1, 2, 3);
    List<Integer> modifiableButNotResizableList = Arrays.asList(1, 2, 3);
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new LinkedList<>();

    // Set: a Collection that forbids duplicates.
    // Primary methods: see Collection.
    Set<Integer> unmodifiableSet = Set.of(1, 2, 3);
    Set<Integer> set = new HashSet<>();

    // SequencedSet: a Set that is also a SequencedCollection.
    // LinkedHashSet uses insertion order.
    // Primary methods: see Set and SequencedCollection.
    SequencedSet<Integer> sequencedSet = new LinkedHashSet<>();

    // SortedSet: a SequencedSet that uses sorted order.
    // Primary methods: see Set,
    // plus: getFirst(), getLast(), removeFirst(), removeLast(), reversed(),
    // headSet(toElement), tailSet(fromElement), subSet(fromElement, toElement)
    SortedSet<Integer> sortedSet = new TreeSet<>();

    // NavigableSet: a SortedSet with extra methods.
    NavigableSet<Integer> navigableSet = new TreeSet<>();

    // Queue: a Collection of elements awaiting processing.
    // Elements are removed one at a time from the head of the queue.
    // Primary methods: isEmpty(), add(e), peek(), remove().
    // In a typical queue, the element at the head is the least-recently added one.
    // Thus a typical queue allows one to process elements in FIFO order.
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new LinkedList<>();

    // In a PriorityQueue, each element has a priority, and the element at the head
    // is the one with the lowest priority.
    // Thus a PriorityQueue allows one to process elements based on priority.
    Queue<Integer> priorityQueue = new PriorityQueue<>();

    // Deque: a SequencedCollection, a Queue that allows access at both ends.
    // Primary methods: see SequencedCollection.
    Deque<Integer> deque1 = new ArrayDeque<>();
    Deque<Integer> deque2 = new LinkedList<>();

    // A Deque can also be used as a stack: a collection whose elements can be processed in LIFO order.
    // Primary methods: isEmpty(), push(e), peek(), pop()
    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack2 = new LinkedList<>();

    // Map: associates each element of a set of keys with a value.
    // In other words, it stores entries, where each entry consists of a unique key plus a value.
    // Allows for the lookup of values based on keys.
    // Doesn't inherit from Collection or even from Iterable.
    // Primary methods: size(), put(key, value), get(key), containsKey(o), remove(key),
    // keySet(), values(), entrySet()
    Map<String, Integer> unmodifiableMap1 = Map.of("a", 1, "b", 2, "c", 3);
    Map<String, Integer> unmodifiableMap2 = Map.ofEntries(Map.entry("a", 1), Map.entry("b", 2), Map.entry("c", 3));
    Map<String, Integer> map = new HashMap<>();

    // SequencedMap: a Map whose keys have a predicable order.
    // LinkedHashMap uses either insertion order or access order.
    // Primary methods: see Map,
    // plus: firstEntry(), lastEntry(), pollFirstEntry(), pollLastEntry(), reversed()
    SequencedMap<String, Integer> sequencedMap = new LinkedHashMap<>();

    // SortedMap: a SequencedMap that uses sorted order.
    // Primary methods: see SequencedMap, plus:
    // firstKey(), lastKey(), subMap(fromKey, toKey), headMap(toKey), tailMap(fromKey)
    SortedMap<String, Integer> sortedMap = new TreeMap<>();

    // NavigableMap: a SortedMap with extra methods.
    NavigableMap<String, Integer> navigableMap = new TreeMap<>();
}