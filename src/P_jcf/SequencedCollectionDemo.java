void main() {
    List<Integer> list = new ArrayList<>(List.of(10, 20, 50, 40, 30));
    Deque<String> deque = new ArrayDeque<>(List.of("a", "b", "c", "d"));
    SequencedSet<Integer> insertionOrderSet = new LinkedHashSet<>(List.of(10, 20, 50, 40, 30));
    SortedSet<Integer> sortedSet = new TreeSet<>(List.of(10, 20, 30, 40, 50));
}

void printFirstAndLast(SequencedCollection<?> sequencedCollection) {
    IO.println(sequencedCollection.getFirst());
    IO.println(sequencedCollection.getLast());
}

void printEveryOtherElement(SequencedCollection<?> sequencedCollection) {
    for (Iterator<?> it = sequencedCollection.iterator(); it.hasNext(); ) {
        IO.println(it.next());

        if (it.hasNext()) {
            it.next(); // obtain the next element, thus advancing the iterator, but don't print
        }
    }
}