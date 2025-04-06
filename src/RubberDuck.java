public class RubberDuck
{
   private String color;
   private int location;
   
   public RubberDuck(String c, int loc)
   {
      color = c;
      location = loc;
   }
   
   public RubberDuck(String c)
   {
      this(c, 0);
   }
   
   public RubberDuck()
   {
      this("yellow", 0);
   }
   
   public void squeak(int n)
   {
      System.out.println("squeak " + n + " times");
   }
   
   public int moveFast(int n)
   {
       return 2 *n;
   }
   
   public String toString()
   {
      return String.format("color=%s, location=%d", color, location);
   }
}