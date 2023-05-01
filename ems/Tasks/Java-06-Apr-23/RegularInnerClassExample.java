package com.extra;


class Outer
{
  public void display()
  {
	  InnerClassEx in=new InnerClassEx();
    in.show();
  }

  class InnerClassEx
  {
    public void show()
    {
      System.out.println("Inside inner");
    }
  }
}

class RegularInnerClassExample
{
  public static void main(String[] args)
  {
    Outer ot = new Outer();
    ot.display();
  }
}