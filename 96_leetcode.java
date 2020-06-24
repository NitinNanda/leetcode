/*
96. Unique Binary Search Trees
DP(Recursion)
Runtime: 0 ms
Memory Usage: 36.3 MB
 */

class Solution {
    public int numTrees(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        return numTrees(n, map);
    }

    public int numTrees(int n, Map<Integer, Integer> map){
        // Check if we have already counted number of trees for this n
        if(map.containsKey(n)) return map.get(n);

        int sum = 0;
        for(int i = 1; i<= n; i++)
            sum += numTrees(i-1, map) * numTrees(n-i, map);
        map.put(n, sum);
        return sum;
    }
}

/*
DP(Recursion): approach 2
Runtime: 0 ms
Memory Usage: 36.4 MB
*/
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(n==0 || n==1) return 1;

        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(!map.containsKey(i - 1)){
                map.put(i-1, numTrees(i-1));
            }
            if(!map.containsKey(n - i)){
                map.put(n-1, numTrees(n-i));
            }
            sum += map.get(i-1) * map.get(n-i);
        }
        return sum;
    }

}