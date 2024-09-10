public class Payload
{
    private int k;
    private String s1;
    private String s2;

    public Payload(int k, String s1, String s2)
    {
        this.k = k;
        this.s1 = s1;
        this.s2 = s2;
    }

    public void modParams()
    {
        k++;
        s1 = s1 + "BB";
        s2 = new String("memory");
    }

    public String toString()
    {
        return String.format("k = %d, s1 = %s, s2 = %s%n", k, s1, s2);
    }
}
