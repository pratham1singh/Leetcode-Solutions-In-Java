

int lengthOfLastWord(char * s)
{
    int i, n=strlen(s)-1,l=0;
    for(i=n;i>=0;i--)
    {
        if(s[i]==' '&&l==0)
            continue;
        if(s[i]==' '&&l!=0)
            break;
        else
        {
            l++;
            
        }
    }
    return l;

}