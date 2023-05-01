package com.extra;

//enclosing outer class
class EnclosingOuterClass {
 
 static int outvar_x = 10; // static var
 int outvar_y = 20; // instance(non-static) var
 private static int outer_private = 30; // private var

 // static nested class
 static class StaticNestedClass {
     void Show()
     {
         
         System.out.println("outer_x = " + outvar_x);// accessing static member of outer class
      
         System.out.println("outer_private = "
                            + outer_private); //can access private static member of outer class

         // Getting compilation error as static nested class cannot directly access non-static members
         // System.out.println("outer_y = " + outer_y);
        
           // creating object of the outer class to access the non-static member
         EnclosingOuterClass out = new EnclosingOuterClass();
           System.out.println("outer_y = " + out.outvar_y);
      
        
     }
 }
}

//Main class
public class StaticNestedClassExample {
 public static void main(String[] args)
 {
     // access a static nested class
	 EnclosingOuterClass.StaticNestedClass innerobj
         = new EnclosingOuterClass.StaticNestedClass();

     innerobj.Show();
 }
}