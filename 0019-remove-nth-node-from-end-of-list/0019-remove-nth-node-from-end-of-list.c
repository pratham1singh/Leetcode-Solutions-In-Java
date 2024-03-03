/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n)
{
    int N=0;
    struct ListNode *ptr=head,*pre=head;
    while(ptr!=NULL)
    {
        N+=1;
        ptr=ptr->next;
    }
    if(N==1)
    {
        head=NULL;
        return head;
    }
    n=N-n+1;
    if(n==1)
    {
        struct ListNode *temp=head->next;
            head->next=NULL;
            head=temp;
            return head;
    }
    ptr=head;
    int c=0;
    while (ptr!=NULL)
    {
        c+=1;
        if(c==n)
        {
            struct ListNode *temp=ptr->next;
            ptr->next=NULL;
            
            pre->next=temp;
            break;
        }
        pre=ptr;
        ptr=ptr->next;
    }
    return head;

}