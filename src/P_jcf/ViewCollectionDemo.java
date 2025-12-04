void main() {
    List<Integer> original = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> reverse = original.reversed();

    IO.println(original); // [1, 2, 3]
    IO.println(reverse);  // [3, 2, 1]

    original.add(4);
    IO.println(original); // [1, 2, 3, 4]
    IO.println(reverse);  // [4, 3, 2, 1]

    reverse.add(5);
    IO.println(reverse);  // [4, 3, 2, 1, 5]
    IO.println(original); // [5, 1, 2, 3, 4]

    IO.println(original.get(1)); // 1
    IO.println(reverse.get(1));  // 3


    List<Integer> sub = original.subList(1, 3);
    IO.println(sub.size()); // 2
    sub.clear();
    IO.println(original); // [5, 3, 4]


    String[] stringArray = {"a", "b", "c"};
    List<String> stringList = Arrays.asList(stringArray);
    stringList.set(0, "z");
    IO.println(Arrays.toString(stringArray)); // [z, b, c]
    stringArray[1] = "g";
    IO.println(stringList); // [z, g, c]
}
 