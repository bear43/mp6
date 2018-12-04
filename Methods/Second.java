package Methods;

import static java.lang.Float.NaN;

public class Second implements Method
{
    private float a;

    private float b;

    private float eps;

    private Function function = new Function();

    private float min;

    private long startTime;

    private long endTime;

    public Second(float a, float b, float eps)
    {
        this.a = a;
        this.b = b;
        this.eps = eps;
    }

    public float findMinPoint()
    {
        startTime = System.nanoTime();
        float c = a + 0.382f * (b - a);
        float d = a + 0.618f * (b - a);
        while (b - a >= eps)
        {
            if (function.evaluate(c) > function.evaluate(d))
            {
                a = c;
                c = d;
                d = a + 0.618f * (b - a);
            }
            else
            {
                b = d;
                d = c;
                c = a + 0.318f * (b - a);
            }
        }
        min = function.evaluate(c);
        endTime = System.nanoTime();
        return min;
    }

    @Override
    public long getTime()
    {
        return endTime - startTime;
    }

    @Override
    public String toString()
    {
        //findMinPoint();
        return String.format("Second method found minimal point on [%f, %f]: %f | time: %d", a, b, min, getTime());
    }
}
