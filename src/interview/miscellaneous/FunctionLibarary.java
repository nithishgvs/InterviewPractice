package interview.miscellaneous;

import java.util.*;

/**
 * class Function {
 * 	String name;
 * 	List<String> argumentTypes;
 * 	boolean isVariadic;
 *
 * 	Function(String name, List<String> argumentTypes, boolean isVariadic) {
 * 		this.name = name;
 * 		this.argumentTypes = argumentTypes;
 * 		this.isVariadic = isVariadic;
 *    }
 * }
 *
 * class FunctionLibrary {
 * 	public void register(Set<Function> functionSet)  {
 * 		// implement this method.
 *  }
 *
 * 	public List<Function> findMatches(List<String> argumentTypes) {
 * 		// implement this method.
 * 		return null;
 *  }
 * }
 * Note:
 * If a function is marked as isVariadic=true, then the last argument can occur one or more number of times.
 *
 * Example:
 * FuncA: [String, Integer, Integer]; isVariadic = false
 * FuncB: [String, Integer]; isVariadic = true
 * FuncC: [Integer]; isVariadic = true
 * FuncD: [Integer, Integer]; isVariadic = true
 * FuncE: [Integer, Integer, Integer]; isVariadic = false
 * FuncF: [String]; isVariadic = false
 * FuncG: [Integer]; isVariadic = false
 *
 * findMatches({String}) -> [FuncF]
 * findMatches({Integer}) -> [FuncC, FuncG]
 * findMatches({Integer, Integer, Integer, Integer}) -> [FuncC, FuncD]
 * findMatches({Integer, Integer, Integer}) -> [FuncC, FuncD, FuncE]
 * findMatches({String, Integer, Integer, Integer}) -> [FuncB]
 * findMatches({String, Integer, Integer}) -> [FuncA, FuncB]
 */

class Function {
  String name;
  List<String> argumentTypes;
  boolean isVariadic;

  Function(String name, List<String> argumentTypes, boolean isVariadic) {
    this.name = name;
    this.argumentTypes = argumentTypes;
    this.isVariadic = isVariadic;
  }

  @Override
  public String toString() {
    return name;
  }
}

class TrieNodeFunction {
  Map<String, TrieNodeFunction> children;
  List<Function> functions;
  List<Function> variadicFunctions;

  TrieNodeFunction() {
    this.children = new HashMap<>();
    this.functions = new ArrayList<>();
    this.variadicFunctions = new ArrayList<>();
  }
}

class FunctionLibraryConfluent {
  private TrieNodeFunction root;

  public FunctionLibraryConfluent() {
    this.root = new TrieNodeFunction();
  }

  public void register(Set<Function> functionSet) {
    for (Function function : functionSet) {
      addFunction(function);
    }
  }

  private void addFunction(Function function) {
    TrieNodeFunction node = root;
    List<String> argumentTypes = function.argumentTypes;

    for (int i = 0; i < argumentTypes.size(); i++) {
      String argumentType = argumentTypes.get(i);
      node.children.putIfAbsent(argumentType, new TrieNodeFunction());
      node = node.children.get(argumentType);

      if (function.isVariadic && i == argumentTypes.size() - 1) {
        node.children.putIfAbsent("*", new TrieNodeFunction());
        node.children.get("*").variadicFunctions.add(function);
      }
    }
    node.functions.add(function);
  }

  public List<Function> findMatches(List<String> argumentTypes) {
    List<Function> matchedFunctions = new ArrayList<>();
    findMatchesHelper(root, argumentTypes, 0, matchedFunctions);
    return matchedFunctions;
  }

  private void findMatchesHelper(TrieNodeFunction node, List<String> argumentTypes, int index, List<Function> matchedFunctions) {
    if (node == null) return;

    if (index == argumentTypes.size()) {
      matchedFunctions.addAll(node.functions);
      return;
    }

    String currentArg = argumentTypes.get(index);

    if (node.children.containsKey(currentArg)) {
      findMatchesHelper(node.children.get(currentArg), argumentTypes, index + 1, matchedFunctions);
    }

    if (node.children.containsKey("*")) {
      matchedFunctions.addAll(node.children.get("*").variadicFunctions);
      findMatchesHelper(node.children.get("*"), argumentTypes, index + 1, matchedFunctions);
    }
  }

  public static void main(String[] args) {
    FunctionLibraryConfluent library = new FunctionLibraryConfluent();
    Set<Function> functions = new HashSet<>(Arrays.asList(
        new Function("FuncA", Arrays.asList("String", "Integer", "Integer"), false),
        new Function("FuncB", Arrays.asList("String", "Integer"), true),
        new Function("FuncC", Collections.singletonList("Integer"), true),
        new Function("FuncD", Arrays.asList("Integer", "Integer"), true),
        new Function("FuncE", Arrays.asList("Integer", "Integer", "Integer"), false),
        new Function("FuncF", Collections.singletonList("String"), false),
        new Function("FuncG", Collections.singletonList("Integer"), false)
    ));
    library.register(functions);

    List<String> args1 = Collections.singletonList("String");
    System.out.println("findMatches({String}) -> " + library.findMatches(args1));

    List<String> args2 = Collections.singletonList("Integer");
    System.out.println("findMatches({Integer}) -> " + library.findMatches(args2));

    List<String> args3 = Arrays.asList("Integer", "Integer", "Integer", "Integer");
    System.out.println("findMatches({Integer, Integer, Integer, Integer}) -> " + library.findMatches(args3));

    List<String> args4 = Arrays.asList("Integer", "Integer", "Integer");
    System.out.println("findMatches({Integer, Integer, Integer}) -> " + library.findMatches(args4));

    List<String> args5 = Arrays.asList("String", "Integer", "Integer", "Integer");
    System.out.println("findMatches({String, Integer, Integer, Integer}) -> " + library.findMatches(args5));

    List<String> args6 = Arrays.asList("String", "Integer", "Integer");
    System.out.println("findMatches({String, Integer, Integer}) -> " + library.findMatches(args6));
  }
}


