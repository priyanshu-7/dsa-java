class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> candies= new HashMap<>();
        for(int i = 0; i<candyType.length; i++) {
            if(candies.containsKey(candyType[i])) {
                candies.put(candyType[i], candies.get(candyType[i])+1);
            } else {
                candies.put(candyType[i], 1);
            }
        }
        int maxEatables = candyType.length/2;
        int totalTypes = candies.size();
        if(totalTypes>=maxEatables) {
            return maxEatables;
        }
        if(totalTypes<maxEatables) {
            return totalTypes;
        }
        return 0;
    }
}