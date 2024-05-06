package interview.unionfind;

public class NumberofProvinces_547 {


  class UnionFind {

    int size;
    int[] sz;
    int[] id;
    int numComponents;

    public UnionFind(int size) {
      this.size = size;
      id = new int[size];
      sz = new int[size];
      this.numComponents = size;
      for (int i = 0; i < size; i++) {
        id[i] = i;
        sz[i] = 1;
      }
    }

    public int find(int p) {
      int root = p;

      while (id[root] != root) {
        root = id[root];
      }

      while (p != root) {
        int next = id[p];
        id[p] = root;
        p = next;
      }

      return root;
    }

    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    public void union(int p, int q) {
      int root1 = id[p];
      int root2 = id[q];

      if (sz[root1] > sz[root2]) {
        sz[root1] += sz[root2];
        id[root2] = root1;
        sz[root2] = 0;
      } else {
        sz[root2] += sz[root1];
        id[root1] = root2;
        sz[root1] = 0;
      }
      numComponents--;
    }

  }

  public int findCircleNum(int[][] isConnected) {
    UnionFind unionFind = new UnionFind(isConnected.length);

    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[0].length; j++) {
        if (isConnected[i][j] == 1 && !unionFind.connected(i, j)) {
          unionFind.union(i, j);
        }
      }
    }

    return unionFind.numComponents;
  }
}
