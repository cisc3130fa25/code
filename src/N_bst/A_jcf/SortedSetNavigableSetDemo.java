void main() {
    // SortedSet extends SequencedSet with some additional methods,
    // such as getFirst() and getLast(). And, of course, it is sorted.
    SortedSet<Integer> sortedSet = new TreeSet<>(Set.of(5, 10, 2, 7, 3));
    IO.println(sortedSet); // [2, 3, 5, 7, 10]
    IO.println(sortedSet.getFirst()); // 2
    IO.println(sortedSet.getLast()); // 10

    // NavigableSt extends SortedSet with some additional methods,
    // such as higher(e) and lower(e). It is still sorted, of course.
    NavigableSet<Integer> navigableSet = new TreeSet<>(Set.of(5, 10, 2, 7, 3));
    IO.println(navigableSet); // [2, 3, 5, 7, 10]
    IO.println(navigableSet.getFirst()); // 2
    IO.println(navigableSet.getLast()); // 10

    // S.lower(e): returns the greatest element in S that is less than e,
    //             or null if there is no such element.
    IO.println(navigableSet.lower(7)); // 5
    IO.println(navigableSet.lower(6)); // 5
    IO.println(navigableSet.lower(5)); // 3
    IO.println(navigableSet.lower(2)); // null
    IO.println(navigableSet.lower(12)); // 10

    // S.higher(e): returns the smallest element in S that is greater than e,
    //              or null if there is no such element.
    IO.println(navigableSet.higher(6)); // 7
    IO.println(navigableSet.higher(7)); // 10
    IO.println(navigableSet.higher(10)); // null
    IO.println(navigableSet.higher(0)); // 2
}
