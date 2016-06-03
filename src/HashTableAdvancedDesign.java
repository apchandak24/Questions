// Hashtable class where the keys are strings, vals are integers. Exposes put, get and delete api. Should not use java.util.map internally. Email me at krishna@pinterest.com 
class HashEntryAdvanced{
  
  private String key;
  private Integer value;
  private HashEntryAdvanced next;
  
  public HashEntryAdvanced(String key, Integer value){
    this.key = key;
    this.value = value;
  }
  
  public String getKey(){
    return key;
  }
  
 public Integer getValue(){
    return value;
  }
  public void setValue(int value){
    this.value = value;
  }
  public HashEntryAdvanced getNext(){
    return next;
  }
  
  public void setNext(HashEntryAdvanced data){
    this.next = data;
  }
  
}
class HashTableAdvanced{
  
  private HashEntryAdvanced[] list;
  private int size;
  
  public HashTableAdvanced(int size){
    this.size = size;
    list = new HashEntryAdvanced[size];
  }
  //Put function to add the key value pair to the array. If data is already
  //present for the key then modify the existing value
  public int put(String key, Integer value){
    int hashCode = getHashCode(key);
    HashEntryAdvanced entry = new HashEntryAdvanced(key,value);
    if(list[hashCode]==null ){
      list[hashCode] = entry;
      return hashCode;
    }else{
    	HashEntryAdvanced data  = list[hashCode];
      if(data.getKey().equals(key)){
        data.setValue(value);
        return hashCode;
      }
      HashEntryAdvanced next = data.getNext();
      HashEntryAdvanced prev = data;
      while(next!=null){
        prev = next;
        if(next.getKey().equals(key)){
          next.setValue(value);
          return hashCode;
        }
        next = next.getNext();
      }
      prev.setNext(new HashEntryAdvanced(key,value));
      return hashCode;
    }
  }
  // Get function returns the value associated with key. It will return -1 if key is not present
  public int get(String key){
    int hashCode = getHashCode(key);
    HashEntryAdvanced data = list[hashCode];
    if(data!=null){
      if(data.getKey().equals(key))
        return data.getValue();
      else{
    	  HashEntryAdvanced next = data.getNext();
        while(next!=null){
          if(next.getKey().equals(key))
            return next.getValue();
          next = next.getNext();
        }
        return -1;
      }
    }
    else
      return -1;
  }  
  //Remove function to remove the value associated with key. It will return true if key is present and false if key is not present
  public boolean remove(String key){
   int hashCode = getHashCode(key);
   HashEntryAdvanced data = list[hashCode];
    if(data!=null){
      if(data.getKey().equals(key)){
        list[hashCode] = data.getNext();
        return true;
      }
      else{
    	  HashEntryAdvanced next = data.getNext();
    	  HashEntryAdvanced prev = data;
        while(next!=null){
          if(next.getKey().equals(key)){
            prev.setNext(next.getNext());
            return true;
          }
          prev=next;
          next=next.getNext();
        }
        return false;
      }

    }else{
      return false;
    }
  }
  // Helper function to compute the hash code for a key
  private int getHashCode(String key){
    return key.length()%size;
  }
}

public class HashTableAdvancedDesign{
  
  public static void main(String[] args){
    HashTable table = new HashTable(3);
    System.out.println("-- Adding data for key 'sky' and 'ocean' --");
    table.put("sky",1);
    table.put("ocean",2);
    
    System.out.println("Value for key 'sky': "+table.get("sky"));
    System.out.println("Value for key 'ocean': "+table.get("ocean"));
    
    System.out.println("-- Adding data for key 'sea' and 'fly' --");
    table.put("sea",3);
    table.put("fly",4);
    System.out.println("Value for key 'sea': "+table.get("sea"));
    System.out.println("Value for key 'fly': "+table.get("fly"));

    System.out.println("-- Removing entry for key 'sea' --");
    table.remove("sea");
    
    System.out.println("-- New updated values for keys --");
    System.out.println("Value for key 'sky': "+table.get("sky"));
    System.out.println("Value for key 'ocean': "+table.get("ocean"));
    System.out.println("Value for key 'sea': "+table.get("sea"));
    System.out.println("Value for key 'fly': "+table.get("fly"));

    System.out.println("-- Modifying entry for key 'fly' --");
    table.put("fly",5);
    System.out.println("New updated value for key 'fly ': "+table.get("fly"));
  }
}

