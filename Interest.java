package javaFXLabs;


import java.text.DecimalFormat;

public class Interest {

   private double p;
   private double r;
   private double i;
   private int n;
   private int t;
   DecimalFormat dollarFormat = new DecimalFormat("$#.##");

   public Interest(double p, double r, int n, int t) {
      this.p = p;
      this.r = r / 100;
      this.n = n;
      this.t = t;
      this.i = Amount() - p;
   }

   public double Amount() {

      return this.p * Math.pow((1 + (this.r / this.n)), (this.n * this.t));
   }

   public void Display() {

      System.out.println("Principal Investement: " + dollarFormat.format(p) + "\n" +
              "Interest Earned: " + dollarFormat.format(i) + "\n" +
              "Final Amount: " + dollarFormat.format(i + p));

   }

   public double getI() {
      return i;
   }

   public void setI(double i) {
      this.i = i;
   }

}