import N_bst.B_application.Concordance;

void main(String[] args) throws FileNotFoundException {
    if (args.length != 1) {
        System.err.println("usage: java ConcordanceApp.java <filename>");
        System.exit(1);
    }

    IO.println("=== Natural order:");
    IO.println(new Concordance(args[0]));

    IO.println("=== Case-insensitive order:");
    IO.println(new Concordance(args[0], String.CASE_INSENSITIVE_ORDER.thenComparing(Comparator.naturalOrder())));
}