package interview.unionfind;

import org.junit.Test;

public class NumberOfConnectedComponentsinanUndirectedGraph_323 {

  class UnionFind {

    int numComponents;
    int size;
    int[] sz;
    int[] id;

    public UnionFind(int size) {
      this.size = size;
      this.numComponents = size;
      id = new int[size];
      sz = new int[size];
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
      if (connected(p, q)) {
        return;
      }

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

  public int countComponents(int n, int[][] edges) {

    UnionFind unionFind = new UnionFind(n);

    for (int[] edge : edges) {
      unionFind.union(edge[0], edge[1]);
    }

    return unionFind.numComponents;
  }

  @Test
  public void test() {
    int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
    System.out.println(countComponents(5, edges));
  }

}
