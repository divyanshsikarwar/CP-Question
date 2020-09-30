#include <bits/stdc++.h> 
using namespace std;
#define all(x) x.begin(), x.end()
#define fo(i, n) for(int i = 0; i < n; i++)
#define ll long long
#define vl vector<ll>
#define vi vector<int>
#define ui unordered_set<int>
#define pb push_back
vector<vector<int> > graph;
vector<int> moves;
vector<bool> visit;
queue<int> fifo;

void bfs(){
    while(!fifo.empty())
    {
        int a = fifo.front();
        fifo.pop();
        for(int i = 0; i < graph[a].size(); i++)
        {
            int b = graph[a][i];
            if(!visit[b])
            {
                visit[b] = true;
                moves[b] = min(moves[b], moves[a] + 1);
                fifo.push(b);
            }
        }
    }
}

int main(){
    int t;
    scanf("%d", &t);
    while(t--)
    {
        
        graph = vector<vector<int> > (101);
        moves = vector<int> (101, 100);
        visit = vector<bool> (101, false);
        for(int i = 1; i <= 100; i++)
        {
            for(int j = 1; j <= 6 && i + j <= 100; j++)
            {
                graph[i].push_back(i+j);
            }
        }

        int l;
        scanf("%d", &l);
        int u, v;
        for(int i = 0; i < l; i++)
        {
            scanf("%d %d", &u, &v);
            int j = u - 6;
            if(j < 1)
                j = 1;

            for(; j < u; j++)
            {
                for(int k = 0; k < graph[j].size(); k++)
                {
                    if(graph[j][k] == u)
                    {
                        graph[j][k] = v;
                        break;
                    }
                }
            }
        }

        int s;
        scanf("%d", &s);
        for(int i = 0; i < s; i++)
        {
            scanf("%d %d", &u, &v);
            int j = u - 6;
            if(j < 1) 
                j = 1;

            for(; j < u; j++)
            {
                for(int k = 0; k < graph[j].size(); k++)
                {
                    if(graph[j][k] == u)
                    {
                        graph[j][k] = v;
                        break;
                    }
                }
            }
        }

        fifo.push(1); 
        visit[1] = true;
        moves[1] = 0;
        bfs();

        if(moves[100] > 17)
        {
            printf("-1\n");
        }
        else
        {
            printf("%d\n", moves[100]);
        }
    }
    return 0;
}
