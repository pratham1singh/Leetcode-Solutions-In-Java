class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, i=0, j=n+1, count=0;
        int N = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();

        if(n==1 && nums[0]%2==1) return 1;

        int first = -1;

        while(i<n) {
                if(nums[i]%2==1) {
                    first = i;
                    break;
                }
                i++;
        }

        if(first == -1) return 0;

        j = i+1;
        count = 1;

        while(i<=j && j<n) {
            if(nums[i]%2==0) {
                i++;
                if(i>j) j=i;
                continue;
            }

            while(count<k && j<n) {
                if(nums[j]%2==1)
                    count++;
                j++;
            }
            
            if(nums[j-1]%2==1) {
                arr.add(i);
                arr.add(j-1);
            }
           
            
            i++;
            count--;
        }

        i = 0;
        int ans = 0;

        n = arr.size();

        

        // for(int x: arr)
        //     System.out.print(x + " ");


        while(i<n-1) {
            int a = arr.get(i), b= arr.get(i+1), p=0, q=0;
            
            if(i-2<0) {
               if(a==0) p  = 0;
               else p = a;
            }
            else p = arr.get(i) - arr.get(i-2) -1;

            //  System.out.println(i+2);

            if(i+3>n-1) {
                q = b+1 < N ? N - b -1 : 0;
            }
            else {
                q = arr.get(i+3) - arr.get(i+1) -1;
                // System.out.println(arr.get(i+2) + " ");
            }

            

            // System.out.println(p + " " + q);

            ans+=(p*q);

            ans+=(p+q);

            ans+=1; 

            i+=2;

        }

        return ans;
    }
}