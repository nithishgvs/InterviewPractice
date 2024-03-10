package interview.unionfind;

import org.junit.Test;

public class GraphValidTree_261 {

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

  public boolean validTree(int n, int[][] edges) {

    UnionFind unionFind = new UnionFind(n);

    for (int[] edge : edges) {
      if (!unionFind.connected(edge[0], edge[1])) {
        unionFind.union(edge[0], edge[1]);
      } else {
        return false;
      }
    }

    return unionFind.numComponents == 1;
  }


  @Test
  public void test() {
    int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    System.out.println(validTree(5, edges));
  }

  @Test
  public void test2() {
    int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    System.out.println(validTree(5, edges));
  }

  @Test
  public void test3() {
    int[][] edges = {{0, 1},  {2, 3}};
    System.out.println(validTree(4, edges));
  }

}
