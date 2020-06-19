/*
    275. H-Index II

    Runtime: 0 ms
    Memory Usage: 46.8 MB
 */

class Solution {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length-1, len  = citations.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(citations[mid] == (len -mid)) return len-mid;
            if(citations[mid] > (len -mid)){
                high = mid-1;
            }else{
                // it means there are atlease 'mid' number of papers which have citation count 'mid' or more
                // but we need to get the highest number
                low = mid+1;
            }
        }
        return len-low;
    }
}