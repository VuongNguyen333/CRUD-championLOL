package com.example.champions.exception;

public class UserNotFoundException extends RuntimeException{
   public UserNotFoundException(String message) {
      super(message);
   }
}
