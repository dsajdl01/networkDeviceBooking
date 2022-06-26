package org.booking.utils;

public class InvalidArgumentProblem extends Exception
{
   public InvalidArgumentProblem() {
       super();
   }

   public InvalidArgumentProblem(String message) {
       super(message);
   }
}
