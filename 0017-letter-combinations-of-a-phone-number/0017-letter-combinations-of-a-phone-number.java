class Solution {

    ArrayList<String> ans=new ArrayList<>();
    HashMap<Integer,ArrayList> map =new HashMap<>();
    
    public void combi(int live[],int arr[],int n){
        int flag=0;
        
        while(flag>=0){
            
            if(live[n-1]==-1){
                flag=-1;
                for(int i=0;i<n;i++){
                    if(live[n-1-i]>0){
                        flag=0;
                        live[n-1-i]-=1;
                        int j=n-1-i+1;
                        while(j<n){
                            live[j]=map.get(arr[j]).size()-1;
                            j+=1;
                        }
                        break;

                    }
                }
            }
            if(flag==-1){
                break;
            }
            String a="";
            int k=0;
            while(k<n){
                a+=map.get(arr[k]).get(live[k]);
                k+=1;
            }
            ans.add(a);

            // System.out.println(live[0]+" "+live[1]+" "+live[2]);
            live[n-1]-=1;
            
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return ans;
        int k=97;
        for(int i=2;i<=9;i++){
        ArrayList<Character> arr=new ArrayList<>();
        int j=3;
        while(j>0){
            arr.add((char)(k));
            k+=1;
            j-=1;
        }
        if(i==7||i==9){
            arr.add((char)k);
            k+=1;
        }

        map.put(i,arr);
    }
        int n=digits.length();
        int live[]=new int[n];
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Character.getNumericValue(digits.charAt(i));
            live[i]=map.get(arr[i]).size()-1;
        }
    //    System.out.println(live[0]+" "+live[1]+" "+live[2]);
        combi(live,arr,n);
       
        return ans;
    }
}