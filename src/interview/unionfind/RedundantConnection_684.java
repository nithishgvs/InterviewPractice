package interview.unionfind;

public class RedundantConnection_684 {

  class UnionFind {

    int size;
    int[] sz;
    int[] id;

    public UnionFind(int size) {
      this.size = size;
      this.sz = new int[size];
      this.id = new int[size];
      for (int i = 0; i < size; i++) {
        sz[i] = 1;
        id[i] = i;
      }
    }

    private int find(int p) {
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

    private void union(int p, int q) {
      int root1 = id[p];
      int root2 = id[q];

      if (sz[root1] < sz[root2]) {
        sz[root2] += sz[root1];
        id[root1] = root2;
        sz[root1] = 0;
      } else {
        sz[root1] += sz[root2];
        id[root2] = root1;
        sz[root2] = 0;
      }
    }

    private boolean connected(int p, int q) {
      return find(p) == find(q);
    }

  }

  public int[] findRedundantConnection(int[][] edges) {
    UnionFind unionFind = new UnionFind(edges.length);

    for (int[] edge : edges) {
      if (!unionFind.connected(edge[0] - 1, edge[1] - 1)) {
        unionFind.union(edge[0] - 1, edge[1] - 1);
      } else {
        return edge;
      }
    }

    return null;
  }
}
