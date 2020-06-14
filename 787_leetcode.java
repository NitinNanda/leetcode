//Leetcode: 787. Cheapest Flights Within K Stops

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // this map will contain the data from 2-d array flights
        // Map<source, Map<destination, price>>
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for(int[] f : flights){
            if(!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        
        // creating a min heap using Priority-Queues
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (Integer.compare(a[0], b[0])));
        
        // pq has arrays containing[price to reach this city, city, hops allowed]
        pq.add(new int[] {0, src, k+1});
        
        /*
        while exists cities to explore
        --> get minimum price city from the queue
        -->get current price, city and allowed flights from that city(edges)
        -->if, current city == destination, return the price
        -->else, find all connected flights from that city and add (new price, dest city, allowed flights(edges)) to the pq
        --> return -1 if no city left to explore
        
        */
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if(city == dst) return price;
            if(stops > 0){
                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                for(int a : adj.keySet()){
                    pq.add(new int[] {price + adj.get(a), a, stops-1});
                }
            }
        }
        return -1;
    }
}