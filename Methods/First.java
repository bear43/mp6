package Methods;

import java.util.HashMap;
import java.util.Map;

public class First implements Method
{
    /*Function: x - lnx -> min*/
    private float h;

    private float a;

    private float b;

    private float eps;

    private int n;

    private float min;

    private Function function = new Function();

    private long startTime;

    private long endTime;

    public First(int n, float a, float b, float eps)
    {
        this.h = (b-a)/(float)(n-1);
        this.a = a;
        this.b = b;
        this.n = n;
        this.eps = eps;
    }

    public float findMinPoint()
    {
        startTime = System.nanoTime();
        if(b-a < eps) return a;
        if(h <= 0) return a;
        float minValue = Float.MAX_VALUE;
        float minPoint = 0;
        Map<Float, Float> xy = new HashMap<>();
        for(float x = a; x <= b; x += h)
            xy.put(x, function.evaluate(x));
        for(Map.Entry<Float, Float> entry : xy.entrySet())
        {
            if(entry.getValue() < minValue)
            {
                minValue = entry.getValue();
                minPoint = entry.getKey();
            }
        }
        min = new First(n, minPoint - h, minPoint + h, eps).findMinPoint();
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
        return String.format("First method found minimal point on [%f, %f]: %f | time: %d", a, b, min, getTime());
    }
}
