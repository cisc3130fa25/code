void main() {
    // SortedSet by natural order (for Strings, this is alphabetical order)
    SortedSet<String> set1 = new TreeSet<>();
    set1.add("bird");
    set1.add("winter");
    set1.add("sky");
    set1.add("sky");
    IO.println(set1); // [bird, sky, winter]

    // SortedSet<Object> objects = new TreeSet<>();
    // objects.add(new Object()); // throws ClassCastException

    // sorted set by length
    Comparator<String> byLength = new Comparator<>() {
        @Override
        public int compare(String s1, String s2) {
            return Integer.compare(s1.length(), s2.length());
        }
    };
    SortedSet<String> set3 = new TreeSet<>(byLength);
    set3.add("bird");
    set3.add("winter");
    set3.add("sky");
    IO.println(set3); // [sky, bird, winter]

    // sorted set by reverse of natural order
    SortedSet<String> set2 = new TreeSet<>(Comparator.reverseOrder());
    set2.add("bird");
    set2.add("winter");
    set2.add("sky");
    IO.println(set2); // [winter, sky, bird]

    // sorted set by length in reverse order (longest to shortest)
    SortedSet<String> set4 = new TreeSet<>(byLength.reversed());
    set4.add("bird");
    set4.add("winter");
    set4.add("sky");
    IO.println(set4); // [winter, bird, sky]

    // sorted set by length, then alphabetically to break ties
    Comparator<String> alphabetically = Comparator.naturalOrder();
    Comparator<String> byLengthThenAlphabetically = byLength.thenComparing(alphabetically);
    SortedSet<String> set5 = new TreeSet<>(byLengthThenAlphabetically);
    set5.add("bird");
    set5.add("winter");
    set5.add("sky");
    set5.add("cat");
    IO.println(set5); // [cat, sky, bird, winter]

    // sorted map
    SortedMap<String, Integer> map = new TreeMap<>();
    map.put("bird", 3);
    map.put("winter", 5);
    map.put("sky", 7);
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        IO.println(entry.getKey() + " " + entry.getValue());
    }
    // bird 3
    // sky 7
    // winter 5
}