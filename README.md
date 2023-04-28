# Coding interview prep

This is a collection of coding challenges that I've solved, in preparation for coding interviews.

[HelloWorld.java](src/HelloWorld.java) and [HelloWorld.kt](src/HelloWorld.kt) are good templates to use.

## Setup

- In [IntelliJ IDEA](https://www.jetbrains.com/idea/), File -> New -> Project from existing sources
- Import project from external model -> Gradle

You should now be able to add Java or Kotlin files and run individual tests using the editor.

I focus on Java/Kotlin in this repo. For a Python/Go approach,
checkout https://github.com/bluprince13/coding-interview-prep

How to solve?
1. Verify the input constraints
   - Check for positive and negative values?
   - Dupilicate numbers?
   - Will there always be a solution available?
   - Can there be multiple solutions to this question?

2. Write out some test cases

## Complexity analysis
<details>
  <summary>Arrays</summary>
Given n = arr.length,

* Add or remove element at the end: O(1) amortized
* Add or remove element from arbitrary index: O(n)
* Access or modify element at arbitrary index: )(1)
* Check if element exists: O(n)
* Two pointers: O(n⋅k), where k is the work done at each iteration, includes sliding window
* Building a prefix sum: O(n)
* Finding the sum of a subarray given a prefix sum: (1)

</details>

<details>
  <summary>LinkedList</summary>
Given n as the number of nodes in the linked list,

* Add or remove element given pointer before add/removal location: O(1)
</details>
<details>
  <summary>String</summary>
</details>
<details>
  <summary>Map</summary>
</details>
<details>
  <summary>Set</summary>
</details>
<details>
  <summary>Stack</summary>
</details>
<details>
  <summary>Queue</summary>
</details>


## Common patterns

### 1. Two pointer - one input, opposite ends
``` Java
   public int fn(int[] arr) {
       int left = 0;
       int right = arr.length - 1;
       int ans = 0;
   
       while (left < right) {
           // do some logic here with left and right
           if (CONDITION) {
               left++;
           } else {
               right--;
           }
       }
   
       return ans;
   }
```

### 2. Two pointer - two inputs, exhaust both
``` Java
   public int fn(int[] arr1, int[] arr2) {
       int i = 0, j = 0, ans = 0;
   
       while (i < arr1.length && j < arr2.length) {
           // do some logic here
           if (CONDITION) {
               i++;
           } else {
               j++;
           }
       }
       while (i < arr1.length) {
           // do logic
           i++;
       } 
       while (j < arr2.length) {
           // do logic
           j++;
       }
       return ans;
   }
```

### 3. Sliding Window
``` Java
   public int fn(int[] arr) {
       int left = 0, ans = 0, curr = 0;
   
       for (int right = 0; right < arr.length; right++) {
           // do logic here to add arr[right] to curr
   
           while (WINDOW_CONDITION_BROKEN) {
               // remove arr[left] from curr
               left++;
           }
   
           // update ans
       }
   
       return ans;
   }
```

### 4. Prefix Sum
``` Java
   public int[] fn(int[] arr) {
       int[] prefix = new int[arr.length];
       prefix[0] = arr[0];
   
       for (int i = 1; i < arr.length; i++) {
           prefix[i] = prefix[i - 1] + arr[i];
       }
   
       return prefix;
   }
```

### 5. Efficient string building
``` Java
   public String fn(char[] arr) {
       StringBuilder sb = new StringBuilder();
       for (char c: arr) {
           sb.append(c);
       }
   
       return sb.toString();
   }
```

### 6. Linked list slow and fast pointers
``` Java
   public int fn(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       int ans = 0;
   
       while (fast != null && fast.next != null) {
           // do logic
           slow = slow.next;
           fast = fast.next.next;
       }
   
       return ans;
   }
```

### 7. Reversing a linked list
``` Java
   public ListNode fn(ListNode head) {
       ListNode curr = head;
       ListNode prev = null;
       while (curr != null) {
           ListNode nextNode = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextNode;
       }
   
       return prev;
   }
```

### 7. Find number of sub arrays that fit an exact criteria
``` Java
   public int fn(int[] arr, int k) {
       Map<Integer, Integer> counts = new HashMap<>();
       counts.put(0, 1);
       int ans = 0, curr = 0;
   
       for (int num: arr) {
           // do logic to change curr
           ans += counts.getOrDefault(curr - k, 0);
           counts.put(curr, counts.getOrDefault(curr, 0) + 1);
       }
   
       return ans;
   }
```

### 8. Monotonic increasing stack
``` Java
   public int fn(int[] arr) {
       Stack<Integer> stack = new Stack<>();
       int ans = 0;
   
       for (int num: arr) {
           // for monotonic decreasing, just flip the > to <
           while (!stack.empty() && stack.peek() > num) {
               // do logic
               stack.pop();
           }
   
           stack.push(num);
       }
   
       return ans;
   }
```

### 9. Binary tree: DFS (recursive)
``` Java
   public int dfs(TreeNode root) {
       if (root == null) {
           return 0;
       }
   
       int ans = 0;
       // do logic
       dfs(root.left);
       dfs(root.right);
       return ans;
   }
```

### 9. Binary tree: DFS (iterative)
``` Java
   public int dfs(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);
       int ans = 0;
   
       while (!stack.empty()) {
           TreeNode node = stack.pop();
           // do logic
           if (node.left != null) {
               stack.push(node.left);
           }
           if (node.right != null) {
               stack.push(node.right);
           }
       }
   
       return ans;
   }
```

### 9. Binary tree: BFS
``` Java
   public int fn(TreeNode root) {
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       int ans = 0;
   
       while (!queue.isEmpty()) {
           int currentLength = queue.size();
           // do logic for current level
   
           for (int i = 0; i < currentLength; i++) {
               TreeNode node = queue.remove();
               // do logic
               if (node.left != null) {
                   queue.add(node.left);
               }
               if (node.right != null) {
                   queue.add(node.right);
               }
           }
       }
   
       return ans;
   }
```

### 10. Graph: DFS (recursive)
``` Java
Set<Integer> seen = new HashSet<>();

public int fn(int[][] graph) {
       seen.add(START_NODE);
       return dfs(START_NODE, graph);
}

public int dfs(int node, int[][] graph) {
       int ans = 0;
       // do some logic
       for (int neighbor: graph[node]) {
           if (!seen.contains(neighbor)) {
               seen.add(neighbor);
               ans += dfs(neighbor, graph);
           }
       }
       return ans;
}
```

### 11. BFS
``` Java
   public int fn(int[][] graph) {
       Queue<Integer> queue = new LinkedList<>();
       Set<Integer> seen = new HashSet<>();
       queue.add(START_NODE);
       seen.add(START_NODE);
       int ans = 0;
   
       while (!queue.isEmpty()) {
           int node = queue.remove();
           // do some logic
           for (int neighbor: graph[node]) {
               if (!seen.contains(neighbor)) {
                   seen.add(neighbor);
                   queue.add(neighbor);
               }
           }
       }
   
       return ans;
   }
```

### 12. Find top k elements with heap
``` Java
   public int[] fn(int[] arr, int k) {
       PriorityQueue<Integer> heap = new PriorityQueue<>(CRITERIA);
       for (int num: arr) {
           heap.add(num);
           if (heap.size() > k) {
               heap.remove();
           }
       }
   
       int[] ans = new int[k];
       for (int i = 0; i < k; i++) {
           ans[i] = heap.remove();
       }
   
       return ans;
   }
```

### 12. Binary search
``` Java
   public int fn(int[] arr, int target) {
       int left = 0;
       int right = arr.length - 1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] == target) {
               // do something
               return mid;
           }
           if (arr[mid] > target) {
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }
   
       // left is the insertion point
       return left;
   }
```

### 13. Binary search: duplicate elements, left-most insertion point
``` Java
   public int fn(int[] arr, int target) {
       int left = 0;
       int right = arr.length;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] >= target) {
               right = mid
           } else {
               left = mid + 1;
           }
       }
   
       return left;
   }
```

### 14. Binary search: duplicate elements, right-most insertion point
``` Java
   public int fn(int[] arr, int target) {
       int left = 0;
       int right = arr.length;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (arr[mid] > target) {
               right = mid;
           } else {
               left = mid + 1;
           }
       }
   
       return left;
   }
```

### 15. Binary search for greedy problems
If looking for a minimum:
``` Java
   public int fn(int[] arr) {
       int left = MINIMUM_POSSIBLE_ANSWER;
       int right = MAXIMUM_POSSIBLE_ANSWER;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (check(mid)) {
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }
   
       return left;
   }
   
   public boolean check(int x) {
       // this function is implemented depending on the problem
       return BOOLEAN;
   }
```

If looking for a maximum:
``` Java
   public int fn(int[] arr) {
       int left = MINIMUM_POSSIBLE_ANSWER;
       int right = MAXIMUM_POSSIBLE_ANSWER;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (check(mid)) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
   
       return right;
   }
   
   public boolean check(int x) {
       // this function is implemented depending on the problem
       return BOOLEAN;
   }
```

### 16. Backtracking
``` Java
   public int backtrack(STATE curr, OTHER_ARGUMENTS...) {
       if (BASE_CASE) {
           // modify the answer
           return 0;
       }
   
       int ans = 0;
       for (ITERATE_OVER_INPUT) {
           // modify the current state
           ans += backtrack(curr, OTHER_ARGUMENTS...)
           // undo the modification of the current state
       }
   }
```

### 17. Dynamic programming: top-down memoization
``` Java
   Map<STATE, Integer> memo = new HashMap<>();

   public int fn(int[] arr) {
       return dp(STATE_FOR_WHOLE_INPUT, arr);
   }
   
   public int dp(STATE, int[] arr) {
       if (BASE_CASE) {
           return 0;
       }
   
       if (memo.contains(STATE)) {
           return memo.get(STATE);
       }
   
       int ans = RECURRENCE_RELATION(STATE);
       memo.put(STATE, ans);
       return ans;
   }
```

### 18. Build a trie
``` Java
   // note: using a class is only necessary if you want to store data at each node.
   // otherwise, you can implement a trie using only hash maps.
   class TrieNode {
       // you can store data at nodes if you wish
       int data;
       Map<Character, TrieNode> children;
       TrieNode() {
           this.children = new HashMap<>();
       }
   }
   
   public TrieNode buildTrie(String[] words) {
       TrieNode root = new TrieNode();
       for (String word: words) {
           TrieNode curr = root;
           for (char c: word.toCharArray()) {
               if (!curr.children.containsKey(c)) {
                   curr.children.put(c, new TrieNode());
               }
   
               curr = curr.children.get(c);
           }
   
           // at this point, you have a full word at curr
           // you can perform more logic here to give curr an attribute if you want
       }
   
       return root;
   }
```


