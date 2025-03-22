class Solution {
  public int subarraySum(int[] nums, int k) {
      Map<Integer, Integer> prefixSumMap=new HashMap<>();
      prefixSumMap.put(0,1);

      int count=0;
      int runningSum=0;

      for(int num:nums){
          runningSum+=num;
          if(prefixSumMap.containsKey(runningSum-k)){
              count+=prefixSumMap.get(runningSum-k);
          }
          prefixSumMap.put(runningSum,prefixSumMap.getOrDefault(runningSum,0)+1);
      }
      return count;
  }
}