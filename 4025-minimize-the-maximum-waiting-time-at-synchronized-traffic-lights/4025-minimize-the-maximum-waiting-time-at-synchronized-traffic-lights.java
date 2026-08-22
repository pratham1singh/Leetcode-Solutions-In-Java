class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = arrivalTime.length, mxL = Integer.MIN_VALUE, mxA = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) arrivalTime[i] = arrivalTime[i]%period;

        for(int x: lights) if(x> mxL) mxL = x;

        for(int i=0;i<n;i++) if(arrivalTime[i] < mxL) arrivalTime[i]= Integer.MAX_VALUE;

         for(int x: arrivalTime) if(x < mxA) mxA = x;

         return (period - mxA) <  0 ? 0 : (period - mxA);

    }
}