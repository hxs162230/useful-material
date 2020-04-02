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


2.2 优化合并
并查集就是一组树构成的森林，与通常的搜索树相比只是链接关系从parent->child变成了child->parent，所以也会出现搜索树中的问题。极端情况下n个节点像链表那样构成n层，对于最底层的节点，find复杂度自然是O(n)，而union由于调用find复杂度也会变成O(n)。
既然树的高度影响效率，那么可以设法避免高树出现，也就是本小节的优化合并；也可以设法把高树变矮，也就是下一小节的路径压缩。

优化合并就是优化union操作，简单粗暴地讲，就是合并时永远把矮树作为高树的子树。判断哪棵树比较矮有union-by-size和union-by-height两种做法，union-by-height是在类中添加height数组记录每个节点的高度，union-by-size是在类中添加size数组记录每个节点的子节点数量，两者效果完全相同。我采用union-by-height，感兴趣union-by-size的可以看这里

在类中添加height数组：

class UnionFindSet {
    public:
        UnionFindSet(int n);
        int Find(int x);
        void Union(int x, int y);
        void Display(void);
    private:
        std::vector<int> parent;
        std::vector<int> height;
};
修改构造函数UnionFindSet(int n)：

UnionFindSet::UnionFindSet(int n) {
    parent.resize(n);
    height.resize(n);

    for (int i = 0; i < n; ++i) {
        parent[i] = i;
        height[i] = 0;
    }
}
新的union算法：

void UnionFindSet::Union(int x, int y) {
    int root_x = Find(x);
    int root_y = Find(y);

    if (root_x == root_y)
        return;

    if (height[root_x] > height[root_y]) {
        parent[root_y] = root_x;
    } else if (height[root_x] < height[root_y]) {
        parent[root_x] = root_y;
    } else {
        parent[root_y] = root_x;
        ++height[root_x];
    }
}
注意只有根节点高度相同时需要更新height，因为两棵树高度不相等时矮的那棵至少比高的矮一层。因此对于有n个节点的并查集，height的最大值为lgn，所以find和union的算法复杂度都至多为O(lgn)。

