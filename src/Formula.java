public class Formula
{
    public static double findAreaTriangle(int a, int b, int c)
    {
        final double s = (a + b + c) / 2.0;
        return Math.sqrt( s * (s-a) * (s-b) * (s-c) );
    }

    public static double pyramidSA(double w, double len, double slantH)
    {
        return w * len + (2 * w + 2 * len) / 2. * slantH;
    }
}
