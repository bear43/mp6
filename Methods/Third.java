package Methods;

public class Third implements Method
{
    private float a;

    private float b;

    private float eps;

    private float min;

    private float x;

    private Function function = new Function();

    private long startTime;

    private long endTime;

    public Third(float a, float b, float eps, float x)
    {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.x = x;
    }

    @Override
    public float findMinPoint()
    {
        startTime = System.nanoTime();
        float x, x1;
        x = x1 = this.x;
        do
        {
            try
            {
                x = x1;
                x1 = x - (function.evaluateDerivative(x) / function.evaluateSecondDerivative(x));
            }
            catch (Exception ex)
            {
                x1 += eps;
            }

        } while (Math.abs(x1 - x) >= eps && x > a && x < b);
        min = function.evaluate(x);
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
        return String.format("Third method found minimal point on [%f, %f]: %f | time: %d", a, b, min, getTime());
    }
}
