int[] node = new int[n];

for(int i=0;i<n;i++){
    node[i] = i;
}

int findRoot(int x,int[] node){
    if(pre[x]==x) return x;
    return pre[x] = findRoot(node[x],node);
}

void union(int i,int j){
    pre[i] = i;
    pre[j] = i;
}