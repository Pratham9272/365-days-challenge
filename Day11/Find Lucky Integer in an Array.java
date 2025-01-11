class Solution {
  public int findLucky(int[] arr) {
      HashMap<Integer,Integer> hm=new HashMap<>();

      for(int i=0;i<arr.length;i++){
          int element=arr[i];

          if(hm.containsKey(element)==true){
              hm.put(element,hm.get(element)+1);
          }else{
              hm.put(element,1);
          }
      }
      int ans=-1;
      for(int key : hm.keySet()){
          if(hm.get(key)==key){
              ans=Math.max(ans,key);
          }
      }
      return ans;
  }
}