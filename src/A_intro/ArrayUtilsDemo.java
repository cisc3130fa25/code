import A_intro.ArrayUtils;

void main() {
    double[] a = {5, 8, 2, 9, 6};
    IO.println(ArrayUtils.max(a)); // 9.0

    double[] b = {5};
    IO.println(ArrayUtils.max(b)); // 5.0

    double[] c = {};
    IO.println(ArrayUtils.max(c));
}