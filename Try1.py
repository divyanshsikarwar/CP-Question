class RandomizedCollection:
    import random
    def __init__(self):
        self.arr=[]
        self.c={}
 
    def insert(self, val: int) -> bool:
        f=True
        if val not in self.c:
            self.arr.append(val)
            self.c[val]=set()
            self.c[val].add(len(self.arr)-1)
        elif val in self.c:
            f=False
            ind=len(self.arr)
            self.arr.append(val)
            self.c[val].add(ind)
        return f
 
    def remove(self, val: int) -> bool:
        f=False
        if val not in self.c:
            return f
        f=True
        if self.arr[-1]==val:
            self.arr.pop()
            ind=len(self.arr)
            self.c[val].remove(ind)
        else:
            val2=self.arr.pop()
            ind2=len(self.arr)
            self.c[val2].remove(ind2)
            ind1=self.c[val].pop()
            self.arr[ind1]=val2
            self.c[val2].add(ind1)
        if len(self.c[val])==0:
            del self.c[val]
        return f
    def getRandom(self) -> int:
        i=random.randint(0,len(self.arr)-1)
        return self.arr[i]
 
 
# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
