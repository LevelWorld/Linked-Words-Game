// Leul Wolde
// LinkedWordsManager class
// Start  2/19/18
// Sort and Organize the game


import java.util.*;
import java.io.*;

public class LinkedWordsManager{
   // All valid entries from the source file
   private ArrayList<String> valid = new ArrayList<String>();
   
   // All used entries from the user
   private ArrayList<String> used = new ArrayList<String>();
   
   // The containiner of the first character of all the user unque entries
   private ArrayList<Character> letterBank = new ArrayList<Character>();
   
   
   // Starts the game using the default file
   public LinkedWordsManager()throws FileNotFoundException {
      this("dictionary.txt");
   }
   
   // Starts the class after gaining access to specified file
   // Pre: file must be sorted and organized with white-space
   public LinkedWordsManager(String fileName) throws FileNotFoundException{
      Scanner scan = new Scanner(new File(fileName) );
      while(scan.hasNext()){
         valid.add(scan.next());
      }
   }
   
   // Returns a String at the beginning of the game
   public String start(){
      Random rand = new Random();
      int r = rand.nextInt(valid.size());
      String word = valid.get(r);
      used.add(word);
      return word;
   }
   
   // Returns true or false in respect to the user's entries follow the guide line 
   public boolean isLegal(String inPlace, String user){
      char first = user.charAt(0);
      char last = inPlace.charAt(inPlace.length() - 1);
      if(first == last){
         if(valid.contains(user)){
            if(!used.contains(user)){
               used.add(user);
               return true;
            }
         }
      }
      return false;
   }
   // Sorts alphabeticly the bank's deposits  and
   // Prints the status of the bank
   public void toPrintBank(){
      Character[] temp = letterBank.toArray(new Character[size()]);
      Arrays.sort(temp);
          
      for(int i = 0; i < size(); i++){
         letterBank.set(i,temp[i]);
      }
      String toPrint = "[";
      if(size() > 0){
         toPrint += Character.toString(letterBank.get(0));
      }
      
      for(int j = 1; j < letterBank.size(); j++){
         toPrint += ","+ Character.toString(letterBank.get(j));
      }
      
      System.out.println( toPrint + "]");
   }
   
   // Determins if the user's deposit to the bank is unque
   public void addToBank(char letter){
      if(Character.isLetter((letter) ) ){
         boolean matchFound = false;
         for(int i = 0; i < letterBank.size(); i++){
            if(letterBank.get(i).equals(letter)){
               matchFound = true;
            }
         }
         if(!matchFound){
            letterBank.add(letter);
         }
      }
   }
   
   // Return true if size() == 26 false otherwise
   public boolean winnerFound(){
      return size() == 26;
   }
   
   // Returns the size of the letterBank
   public int size(){
      return letterBank.size();
   }
   
   // Returns the score of the user
   public int score(){
      return used.size();
   }
   
}