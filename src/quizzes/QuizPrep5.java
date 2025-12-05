package quizzes;

import M_trees.BinaryTreeNode;

import java.io.*;
import java.util.*;

class HashSetQuestions {
    public static int maxLength(Set<String> set) {
        int longestLength = 0;

        for (String s : set) {
            int length = s.length();

            if (length > longestLength) {
                longestLength = length;
            }
        }

        return longestLength;
    }

    public static int numUniqueValues(List<Integer> list) {
        return new HashSet<>(list).size();
    }

    public static int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        int count = 0;

        for (Integer element : set1) {
            if (set2.contains(element)) {
                count++;
            }
        }

        return count;
    }

    public static void removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        list.clear();

        for (Integer element : set) {
            list.add(element);
        }
    }

    public static Set<Integer> unionSets(Set<Set<Integer>> setOfSets) {
        Set<Integer> union = new HashSet<>();

        for (Set<Integer> set : setOfSets) {
            for (Integer element : set) {
                union.add(element);
            }
        }

        return union;
    }

    public static int wordCount(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        Set<String> words = new HashSet<>();

        while (fileScanner.hasNext()) {
            words.add(fileScanner.next());
        }

        return words.size();
    }

    public static boolean allUnique_v1(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int element : arr) {
            if (!set.add(element)) {
                return false;
            }
        }

        return true;
    }

    public static boolean allUnique_v2(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int element : arr) {
            set.add(element);
        }

        return set.size() == arr.length;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}

class CountNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> nameCounts = new HashMap<>();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        while (!name.isEmpty()) {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);

            System.out.print("Enter name: ");
            name = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : nameCounts.entrySet()) {
            System.out.println("Entry [" + entry.getKey() + "] has count " + entry.getValue());
        }
    }
}

class HashMapQuestions {
    public static Map<Integer, Integer> counts(List<Integer> list, Set<Integer> set) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : set) {
            map.put(i, 0);
        }

        for (Integer i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }

        return map;
    }

    public static boolean hasDuplicateValue(Map<String, String> map) {
        // one approach:
        // Set<String> valueSet = new HashSet<>();
        // for (String value : map.values())
        //     if (!valueSet.add(value))
        //         return true;
        // return false;

        // another approach:
        return new HashSet<>(map.values()).size() != map.size();
    }

    public static boolean hasThree(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (int count : map.values()) {
            if (count >= 3) {
                return true;
            }
        }

        return false;
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // one way:
        Set<Integer> set = new HashSet<>();
        for (Integer i : occurrences.values()) {
            if (!set.add(i)) {
                return false;
            }
        }
        return true;

        // a different way:
        // return new HashSet<>(occurrences.values()).size() == occurrences.size();
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        for (int num : frequencies.keySet()) {
            if (frequencies.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // keys are the array elements; values are indexes

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static int frequencyCount(List<String> collection, int desiredFrequency) {
        Map<String, Integer> frequencies = new HashMap<>();

        for (String s : collection) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }

        int count = 0;

        for (int frequency : frequencies.values()) {
            if (frequency == desiredFrequency) {
                count++;
            }
        }

        return count;
    }

    public static int maxFrequency(List<String> collection) {
        Map<String, Integer> frequencies = new HashMap<>();

        for (String s : collection) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }

        int max = 0;

        for (int frequency : frequencies.values()) {
            if (frequency > max) {
                max = frequency;
            }
        }

        return max;
    }
}

class TreeSetAndTreeMapQuestions {
    public static void biggestFamily(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        SortedMap<String, SortedSet<String>> families = new TreeMap<>();

        // fill up the map
        while (scanner.hasNext()) {
            String firstName = scanner.next(), lastName = scanner.next();

            if (!families.containsKey(lastName)) {
                families.put(lastName, new TreeSet<>());
            }

            families.get(lastName).add(firstName);
        }

        // find the max family size
        int maxFamilySize = 0;
        for (Set<String> firstNames : families.values()) {
            int familySize = firstNames.size();

            if (familySize > maxFamilySize) {
                maxFamilySize = familySize;
            }
        }

        // print each family whose size is maxFamilySize
        for (Map.Entry<String, SortedSet<String>> family : families.entrySet()) {
            SortedSet<String> firstNames = family.getValue();

            if (firstNames.size() == maxFamilySize) {
                String lastName = family.getKey();
                System.out.print(lastName + " family:");

                for (String firstName : firstNames) {
                    System.out.print(" " + firstName);
                }

                System.out.println();
            }
        }
    }

    public static TreeMap<String, TreeSet<String>> friendList(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        TreeMap<String, TreeSet<String>> map = new TreeMap<>();

        while (sc.hasNext()) {
            String person1 = sc.next(), person2 = sc.next();

            if (!map.containsKey(person1)) {
                map.put(person1, new TreeSet<>(Set.of(person2)));
            } else {
                map.get(person1).add(person2);
            }

            if (!map.containsKey(person2)) {
                map.put(person2, new TreeSet<>(Set.of(person1)));
            } else {
                map.get(person2).add(person1);
            }
        }

        return map;
    }
}

class BinaryTreeNodeQuestions {
    public static <E> List<E> preorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        preorderListHelper(root, list);
        return list;
    }

    private static <E> void preorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            list.add(root.data);
            preorderListHelper(root.left, list);
            preorderListHelper(root.right, list);
        }
    }

    public static <E> List<E> inorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        inorderListHelper(root, list);
        return list;
    }

    private static <E> void inorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            inorderListHelper(root.left, list);
            list.add(root.data);
            inorderListHelper(root.right, list);
        }
    }

    public static <E> List<E> postorderList(BinaryTreeNode<E> root) {
        List<E> list = new ArrayList<>();
        postorderListHelper(root, list);
        return list;
    }

    private static <E> void postorderListHelper(BinaryTreeNode<E> root, List<E> list) {
        if (root != null) {
            postorderListHelper(root.left, list);
            postorderListHelper(root.right, list);
            list.add(root.data);
        }
    }

    public static <E> List<List<E>> levelOrderList(BinaryTreeNode<E> root) {
        Queue<BinaryTreeNode<E>> queue = new ArrayDeque<>();
        List<List<E>> levels = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<E> level = new ArrayList<>();
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<E> current = queue.remove();
                level.add(current.data);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            levels.add(level); // end of one level
        }

        return levels;
    }

    public static int countLeaves(BinaryTreeNode<?> root) {
        if (root == null) {
            return 0;
        } else  {
            return (isLeaf(root) ? 1 : 0) + countLeaves(root.left) + countLeaves(root.right);
        }
    }

    private static boolean isLeaf(BinaryTreeNode<?> node) {
        return node.left == null && node.right == null;
    }

    public static boolean isProper(BinaryTreeNode<?> root) {
        if (root == null) {
            return true;
        } else {
            return hasZeroOrTwoChildren(root) && isProper(root.left) && isProper(root.right);
        }
    }

    private static boolean hasZeroOrTwoChildren(BinaryTreeNode<?> node) {
        return (node.left == null) == (node.right == null);
    }

    public static <E> boolean contains(BinaryTreeNode<E> root, E element) {
        if (root == null) {
            return false;
        } else {
            return Objects.equals(root.data, element) || contains(root.left, element) || contains(root.right, element);
        }
    }

    public static <E> int count(BinaryTreeNode<E> root, E e) {
        if (root == null) {
            return 0;
        } else {
            return (Objects.equals(root.data, e) ? 1 : 0) + count(root.left, e) + count(root.right, e);
        }
    }

    public static int sum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + sum(root.left) + sum(root.right);
        }
    }

    public static int maxPathSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + Math.max(maxPathSum(root.left), maxPathSum(root.right));
        }
    }
}