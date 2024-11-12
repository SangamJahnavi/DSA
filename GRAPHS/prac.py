'''
Murali playing a mobile game, Blast the letters.

In the game he is given a word W and value R.
Murali has to perform the blasting operation as follows:
	- He has to blast the mimeograph M of length R in W, 
	  a mimeograph is a string such that each letter in it should be same.
	- After blasting the mimeograph, the rest of the string on its
	  left side and right side, concatenated together.

Murali has to perform the blasting operation repeatedly, 
until no more blasting is possible. Your task is to return 
the final string after all the blast operations have been done.

Input Format:
-------------
Line-1: A string and an integer, W and R.

Output Format:
--------------
Print a string, the final string after all the blast operations have been done.


Sample Input-1:
--------------- 
ababbaaab 3

Sample Output-1:
----------------
aba


Sample Input-2:
--------------- 
caaabbbaacdddd 2

Sample Output-2:
----------------
cabc

'''
s=input()
n=int(input())
i=0
j=1
while(i<len(s) and j<len(s)):
    if(s[i]==s[j]):
        count=1
        jj=j
        while((jj<len(s)) and (s[i]!=s[jj])):
            count+=1
            jj+=1
        if(count>=n):
            s=s[0:i]+s[i+n:len(s)]
            i=0
            j=1
            continue
    print(s)
    i+=1
    j+=1
print(s)


















