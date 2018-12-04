package Methods;

public class Function
{
    /**
     * Function: x - lnx -> min
     * @param point X
     * @return f(x)
     */
    public float evaluate(float point)
    {
        return point - (float)Math.log(point);
    }

    /**
     * Derivative function: 1 - (1/x)
     * @param point X
     * @return f'(x)
     */
    public float evaluateDerivative(float point)
    {
        return 1f - (1f/point);
    }

    /**
     * Second derivative function: -1/x*x
     * @param point X
     * @return f''(x)
     */
    public float evaluateSecondDerivative(float point)
    {
        return 1/point*point;
    }
}
