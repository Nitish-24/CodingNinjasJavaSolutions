#include <bits/stdc++.h>
using namespace std;

void traversal(unordered_map<int, list<int> > &adjList, unordered_map<int, bool> &visited, vector<int> &answer, int node) {
    queue<int> Q;
    Q.push(node);
    visited[node] = 1;

    while(!Q.empty()) {
        int frontVal = Q.front();
        Q.pop();
        visited[frontVal] = true;
        answer.push_back(frontVal);

        for(auto i : adjList[frontVal]) {
            if(!visited[i]) {
                Q.push(i);
            }
        }
    }
}

vector<int> BFS(int vertex, vector< pair<int, int> > edges) {
    unordered_map<int, list<int> > adjList;
    vector<int> answer;
    unordered_map<int, bool> visited;
    
    // Creating Adjacency List
    for(int i=0; i<edges.size( ); i++) {
        int u = edges[i].first;
        int v = edges[i].second;

        adjList[u].push_back(v);
        adjList[v].push_back(u);
    }

    // Traversing all components of a graph
    for(int i=0; i<vertex; i++) {
        if(!visited[i]) {
            traversal(adjList, visited, answer, i);
        }
    }

    return answer;
}

int main() {
    int n, m;

    cout << "Enter the number of nodes : ";
    cin >> n;

    cout << "Enter the number of edges : ";
    cin >> m;

    vector< pair<int,int> > edges(m, {0,0});

    for(int i=0; i<m; i++) {
        cin >> edges[0].first;
        cin >> edges[0].second;
    }

    vector<int> solution = BFS(n, edges);

    cout << "BFS Traversal : ";
    for(auto i : solution) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}
// Enter the number of nodes : 8
// Enter the number of edges : 7
// 0 1
// 0 2
// 0 3
// 1 4
//  1 71 7
// 2 5
// 3 6
// BFS Traversal : 0 1 2 3 6 4 5 7 