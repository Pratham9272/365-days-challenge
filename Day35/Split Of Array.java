import java.util.HashMap;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int count : freqMap.values()) {
            if (count > 2) {
                return false;
            }
        }

        return true;
    }
}
