import java.util.*;
class Solution {

    HashMap<Integer,Long> map = new HashMap<Integer,Long>();

    public long find(int arr[][],int i,int l){
       
        if(i<l){
            
             if(map.get(i)!=null)
                return map.get(i);
            
            else
                {
                    map.put(i, Math.max(arr[i][0]+find(arr,i+arr[i][1]+1,l),find(arr,i+1,l)));
                return map.get(i);
                }
        }
        else
            return 0;
    }
    public long mostPoints(int[][] questions) {

        return find(questions,0,questions.length);
        
    }
}