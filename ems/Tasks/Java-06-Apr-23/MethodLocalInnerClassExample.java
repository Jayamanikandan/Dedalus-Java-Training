package com.extra;

class MOuter
{
  int count;
  public void Print()
  {
    for(int i=0;i<5;i++)
    {
      //Inner class defined inside for loop
      class InnerClassEx
      {
        public void show()
        {
          System.out.println("From inner class "+(count++));
        }
      }
      InnerClassEx in=new InnerClassEx();
      in.show();
    }
  }
}

class MethodLocalInnerClassExample
{
  public static void main(String[] args)
  {
    MOuter ot = new MOuter();
    ot.Print();
  }
}