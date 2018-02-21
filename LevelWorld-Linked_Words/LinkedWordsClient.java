// Leul Wolde
// LinkedWordsClient class
// Started  2/19/18
// Plays the Link word game


import java.util.*;
import java.io.*;

public class LinkedWordsClient{
   
   public static void main(String[] args) throws FileNotFoundException{
      LinkedWordsManager L1 = new LinkedWordsManager();
      Scanner console = new Scanner(System.in);
      String start = L1.start();
      game(L1, console, start);
  }
  
  // Starts the game
  public static void game(LinkedWordsManager L, Scanner console, String inPlace) throws FileNotFoundException{
   while(!L.winnerFound()){
      System.out.println("Link the word : " + inPlace);
      String user = console.next();
      if(L.isLegal(inPlace,user) ){
         L.addToBank(user.charAt(0));
         L.toPrintBank();
         game(L,console,user);
      }
   }
   System.out.println("Congratualtions you won in " + L.score() + " moves");
   System.out.println("Wanna Play again? y or n");
   String responce = console.next().toLowerCase();
   if(responce.charAt(0) == 'y');
      String[] args ={};
      LinkedWordsClient.main(args);
  }
  
}