package interview.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignInMemoryFileSystem_588 {


  class TrieNode {

    String content;
    boolean isFile;
    Map<String, TrieNode> children;

    public TrieNode() {
      //The answer should in lexicographic order, therefore using TreeMap
      this.children = new TreeMap<>();
      this.isFile = false;
      this.content = new String();
    }
  }


  class FileSystem {

    TrieNode root;

    public FileSystem() {
      root = new TrieNode();
    }

    public List<String> ls(String path) {

      List<String> result = new ArrayList<>();

      String[] split = path.split("/");

      TrieNode current = root;

      for (int i = 1; i < split.length; i++) {
        String folderName = split[i];
        current = current.children.get(folderName);
      }

      if (current.isFile) {
        result.add(split[split.length - 1]);
      } else {
        for (Map.Entry<String, TrieNode> child : current.children.entrySet()) {
          result.add(child.getKey());
        }
      }

      return result;
    }

    public void mkdir(String path) {

      TrieNode current = root;

      String[] split = path.split("/", -1);
      //First entry would be empty string so for loop from 1st index
      for (int i = 1; i < split.length; i++) {
        String folderName = split[i];
        current.children.putIfAbsent(folderName, new TrieNode());
        current = current.children.get(folderName);
      }

    }

    public void addContentToFile(String filePath, String content) {
      TrieNode current = root;

      String[] split = filePath.split("/", -1);

      for (int i = 1; i < split.length; i++) {
        String folderName = split[i];
        current.children.putIfAbsent(folderName, new TrieNode());
        current = current.children.get(split[i]);
      }
      current.isFile = true;
      current.content += content;
    }

    public String readContentFromFile(String filePath) {
      TrieNode current = root;

      String[] split = filePath.split("/", -1);

      for (int i = 1; i < split.length; i++) {
        String folderName = split[i];
        current = current.children.get(folderName);
      }

      return current.content;
    }
  }

  public static void main(String[] args) {
    DesignInMemoryFileSystem_588 obj = new DesignInMemoryFileSystem_588();
    FileSystem fileSystem = obj.new FileSystem();
    System.out.println(fileSystem.ls("/"));
    fileSystem.mkdir("/a/b/c");
    fileSystem.addContentToFile("/a/b/c/d", "hello");
    System.out.println(fileSystem.ls("/"));
    System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
  }

}
