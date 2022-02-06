package arrays;

import models.TrieNode;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.hackerrank.com/challenges/contacts/problem
 */
public class Contacts {
    private static TrieNode root = new TrieNode();
    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */


    /*************** USING LIST *****************/
    public static List<Integer> contactsUsingList(List<List<String>> queries) {
        // Write your code here
        List<String> contacts = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(List<String> query : queries) {
            if(query.get(0).equals("add")) {
                contacts.add(query.get(1));
            } else if(query.get(0).equals("find")) {
                result.add(find(contacts, query.get(1)));
            }
        }
        return result;
    }

    public static Integer find(List<String> contacts, String query) {
        return Math.toIntExact(contacts.parallelStream().filter(c -> c.startsWith(query)).count());
    }

    /*************** LIST ENDS *****************/

    /*************** USING TRIE *****************/
    public static List<Integer> contactsUsingTrie(List<List<String>> queries) {
        List<String> contacts = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(List<String> query : queries) {
            if(query.get(0).equals("add")) {
                addContact(query.get(1));
            } else if(query.get(0).equals("find")) {
                result.add(search(query.get(1)).size());
            }
        }
        return result;
    }

    /**
     * Add word to trie
     * @param word
     */
    public static void addContact(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = (char) (word.charAt(i) - 'a');
            if(current != null) {
                if( current.childrens[ch] == null ) {
                    current.childrens[ch] = new TrieNode();
                }
                current = current.childrens[ch];
            }
        }
        current.isEnd = true;
    }


    public static List<String> search(String word) {
        TrieNode current = root;
        List<String> results = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            char ch = (char) (word.charAt(i) - 'a');
            if(current.childrens != null && current.childrens[ch] != null) {
                current = current.childrens[ch];
            } else {
                return new ArrayList<>();
            }
        }
        dfs(current, results, word);
        return results;
    }

    public static void dfs(TrieNode current, List<String> answer, String word) {
        if(current == null) return;
        if( current.isEnd ) answer.add(word);
        for(int i = 0 ; i < current.childrens.length; i++) {
            dfs(current.childrens[i], answer, word + Character.toString ((char) ('a'+i)));
        }
    }

    /*************** TRIE ENDS *****************/

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Contacts.contactsUsingList(queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class TestContacts {

    @Test
    public void TestContacts() {
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("add", "ed"));
        queries.add(Arrays.asList("add", "eddie"));
        queries.add(Arrays.asList("add", "edward"));
        queries.add(Arrays.asList("find", "ed"));
        queries.add(Arrays.asList("add", "edwina"));
        queries.add(Arrays.asList("find", "edw"));
        queries.add(Arrays.asList("find", "a"));

        List<Integer> actual = Contacts.contactsUsingList(queries);
        List<Integer> expected = Arrays.asList(3,2,0);
        assertEquals(true, actual.equals(expected));
    }


    @Test
    public void TestContacts1() {
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("add", "ed"));
        queries.add(Arrays.asList("add", "eddie"));
        queries.add(Arrays.asList("add", "edward"));
        queries.add(Arrays.asList("find", "ed"));
        queries.add(Arrays.asList("add", "edwina"));
        queries.add(Arrays.asList("find", "edw"));
        queries.add(Arrays.asList("find", "a"));

        List<Integer> actual = Contacts.contactsUsingList(queries);
        List<Integer> expected = Arrays.asList(3,2,0);

        assertEquals(true, actual.equals(expected));

    }


    @Test
    public void TestContactsUsingTrie() {
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("add", "ed"));
        queries.add(Arrays.asList("add", "eddie"));
        queries.add(Arrays.asList("add", "edward"));
        queries.add(Arrays.asList("find", "ed"));
        queries.add(Arrays.asList("add", "edwina"));
        queries.add(Arrays.asList("find", "edw"));
        queries.add(Arrays.asList("find", "a"));

        List<Integer> actual = Contacts.contactsUsingTrie(queries);
        List<Integer> expected = Arrays.asList(3,2,0);

        assertEquals(true, actual.equals(expected));

    }

}
