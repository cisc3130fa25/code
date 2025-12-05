package P_jcf;

interface Point {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    default Point reversed() {
        return new Reverse(this);
    }

    class Reverse implements Point {
        private final Point original;

        Reverse(Point original) {
            this.original = original;
        }

        @Override
        public int getX() {
            return original.getY();
        }

        @Override
        public int getY() {
            return original.getX();
        }

        @Override
        public void setX(int x) {
            original.setY(x);
        }

        @Override
        public void setY(int y) {
            original.setX(y);
        }
    }
}

class PointImpl implements Point {
    private int x, y;

    PointImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}

public class ViewDemo {
    static void main() {
        Point p1 = new PointImpl(1, 2);
        Point p2 = p1.reversed();
        IO.println(p1.getX()); // 1
        IO.println(p2.getX()); // 2

        p1.setX(10);
        IO.println(p1.getX()); // 10
        IO.println(p2.getX()); // 2
        IO.println(p2.getY()); // 10
    }
}