package com.automtion.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Practice {

  public static void main(String[] args) {
String name ="nishantkumarsingh";
char[] ar = name.toCharArray();

  Map<Character,Integer> map = new HashMap<Character,Integer>();
  
  for(char ch:ar) {
  Integer  count =map.get(ch);
  if (count==null)
      {
            map.put(ch, 1);
      }
  else 
    map.put(ch,++count);
    
  }
    
  Set<Entry<Character, Integer>> set = map.entrySet();
  for ( Entry <Character, Integer> en :set) {
    
    if (en.getValue()>1)
    {
      System.out.println("Duplicate Character is ---->"+ en.getKey());
     System.out.println("Number of repitition is------>" +en.getValue());
    }
    
  

  }

}
}
