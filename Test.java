import Methods.*;

public class Test
{
    private static final int n = 40;

    private static final float a = -10f;//b = -a

    private static final float eps = 0.001f;

    public static void main(String[] args)
    {
        Method first = new First(n, a, -a, eps);
        Method second = new Second(0, -a, eps);
        Method third = new Third(a, -a, eps, 5f);
        first.findMinPoint();
        second.findMinPoint();
        third.findMinPoint();
        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }
}
