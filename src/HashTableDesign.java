// Hashtable class where the keys are strings, vals are integers. Exposes put, get and delete api. Should not use java.util.map internally. Email me at krishna@pinterest.com 
import java.util.*;
class HashEntry{
  
  private String key;
  private Integer value;
  private HashEntryAdvanced next;
  
  public HashEntry(String key, Integer value){
    this.key = key;
    this.value = value;
  }
  
  public String getKey(){
    return key;
  }
  
 public Integer getValue(){
    return value;
  }
  public HashEntryAdvanced getNext(){
    return next;
  }
  
  public void setNext(HashEntryAdvanced data){
    this.next = data;
  }
  
}
class HashTable{
  
  private HashEntryAdvanced[] list;
  private int size;
  
  public HashTable(int size){
    this.size = size;
    list = new HashEntryAdvanced[size];
  }
  //Put function to add the key value pair to the array. If data is already
  //present for the key then return -1
  public int put(String key, Integer value){
    int hashCode = getHashCode(key);
    HashEntryAdvanced entry = new HashEntryAdvanced(key,value);
    if(list[hashCode]==null ){
      list[hashCode] = entry;
      return hashCode;
    }else{
     return -1;
    }
  }
  
  public int get(String key){
    int hashCode = getHashCode(key);
    HashEntryAdvanced data = list[hashCode];
    if(data!=null)
      return data.getValue();
    else
      return -1;
  }  
  public boolean remove(String key){
   int hashCode = getHashCode(key);
    if(list[hashCode]!=null){
      list[hashCode]=null;
      return true;
    }else{
      return false;
    }
  }
  
  private int getHashCode(String key){
    return key.hashCode()%size;
  }
}

public class HashTableDesign{
  
  public static void main(String[] args){
    HashTableAdvanced table = new HashTableAdvanced(3);
    table.put("hi",1);
    table.put("hello",2);
    
    System.out.println("Value for key hi: "+table.get("hi"));
    System.out.println("Value for key hello: "+table.get("hello"));
    
    System.out.println("Removing key value hi");
    table.remove("hi");
    System.out.println("Value for key hi: "+table.get("hi"));
    System.out.println("Value for key hello: "+table.get("hello"));

    System.out.println("Adding new value for key hi");
    table.put("hi",3);
    System.out.println("Value for key hi: "+table.get("hi"));
    System.out.println("value for key hello: "+table.get("hello"));
    
  }
}

