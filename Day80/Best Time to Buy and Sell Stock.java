class Solution {
  public int maxProfit(int[] prices) {
      int minPrice=Integer.MAX_VALUE;
      int maxProfit=0;

      for(int price:prices){
          if(price<minPrice){
              minPrice=price;
          }
          int profit=price-minPrice;
          maxProfit=Math.max(profit,maxProfit);
      }
      return maxProfit;
  }
}