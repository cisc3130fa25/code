void main() {
    List<Integer> unmodifiable = List.of(1, 2, 3);
    // unmodifiable.add(4); // exception
    // unmodifiable.set(1, 10); // exception

    // side note: unmodifiable does not mean immutable, as in this example:
    StringBuilder sb1 = new StringBuilder("a");
    StringBuilder sb2 = new StringBuilder("b");
    List<StringBuilder> sbs = List.of(sb1, sb2);
    // sbs.set(0, new StringBuilder("ac")); // exception
    sb1.append("d");
    IO.println(sbs); // [ad, b]

    List<Integer> modifiable = Arrays.asList(1, 2, 3);
    modifiable.set(1, 10); // works
    // modifiable.add(4); // exception, since not resizeable

    List<Integer> resizeable = new ArrayList<>(List.of(1, 2, 3));
    resizeable.set(1, 10); // works
    resizeable.add(4); // works
}