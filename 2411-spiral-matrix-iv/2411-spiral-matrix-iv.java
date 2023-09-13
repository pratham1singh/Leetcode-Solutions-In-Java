/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
         int r=m,c=n,i=0,j=0,k=1;
        int visited [][] = new int[r][c];
        char dir='r';
        int ans[][]= new int[m][n];
        
        while(k<=r*c){
            if(head!=null){
            ans[i][j]=head.val;
            head=head.next;
            }
            else
              ans[i][j]=-1;
            visited[i][j]=1;
            k+=1;
            
            if(dir=='r'){
                j+=1;
                if(j==c||visited[i][j]==1){
                    j-=1;
                    dir='d';
                    i+=1;
                }
                
            }
            else if(dir=='d'){
                i+=1;
                if(i==r||visited[i][j]==1){
                    dir='l';
                    j-=1;
                    i-=1;
                }
                
            }
            else if(dir=='l'){
                j-=1;
                if(j==-1||visited[i][j]==1){
                    dir='u';
                    i-=1;
                    j+=1;
                }
                
            }
            else if(dir=='u'){
                i-=1;
                if(i==-1||visited[i][j]==1){
                    dir='r';
                    j+=1;
                    i+=1;
                }
                
            }
            

        }
        return ans;
    }
}