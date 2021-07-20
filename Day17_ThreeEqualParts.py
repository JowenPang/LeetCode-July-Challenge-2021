def threeEqualParts(list):
    count =list.count(1)
    if count%3!=0:
        return [-1,-1]
    if(count==0):
        return [0,len(list)-1]
    index = []
    n = 0
    y = 1
    # 1 3 5
    # 1 4 7
    # 1 5 9
    z=0 # index
    for x in list:
        if x==1:
            n+=1
            if n==y:
                index.append(z)
                y=y+count/3
        z+=1
    a,b,c = index
    a1,b1,c1 =a,b,c
    ans =[-1,-1]
    l=len(list)
    while c<l and list[a]==list[b]==list[c]:
        a=a+1
        b=b+1
        c=c+1
        ans = [a-1,b]
    if (c==l):
        return ans
    else:
        return [-1,-1]






# num = [0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1]
num = [0,0,0,0,0]
ans = threeEqualParts(num)
print(ans)
