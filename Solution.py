class Solution:
    def findMaxValueOfEquation(self, ps: List[List[int]], k: int) -> int:
        d = collections.deque()
        ans=float('-inf')
        for x,y in ps:
            while d and d[0][1]<x-k:
                d.popleft()
            if not d:
                d.append([y-x,x])
                continue
            ans=max(ans,x+y+d[0][0])
            while d and d[-1][0]<=y-x:
                d.pop()
            d.append([y-x,x])
        return ans
