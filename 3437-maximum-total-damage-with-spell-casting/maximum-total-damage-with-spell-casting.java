class Solution {
    long dp[] = new long [100003];
    long fun(int i, int[] arr,HashMap<Integer, Integer> m){
        if (i >= arr.length){
            return 0;
        }
        int id = arr.length;
        if (dp[i] != -1){
            return dp[i];
        }
        for (int j = i+1; j<arr.length; j++){
            if (arr[j] > arr[i]+ 2){
                id =j;
                break;
            }
        }
        long t = (long) arr[i] * m.get(arr[i]) + fun(id, arr, m); 
        long nt = fun(i+1, arr,m);
        return dp[i] = Math.max(t, nt);
    }
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int a : power){
            m.put(a, m.getOrDefault(a, 0) +1);
        }
        ArrayList<Integer> v1 = new ArrayList<>();

        for (int a : m.keySet()) {
            v1.add(a);
        }

        Collections.sort(v1);

        int[] arr = new int[v1.size()];

        for (int i = 0; i < v1.size(); i++) {
            arr[i] = v1.get(i);
        }

        Arrays.fill(dp, -1);

        return fun(0, arr, m);
    }
}