package dp;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Abbreviation {
    public static void main(String[] args) {

//        System.out.println( is_Abbreviation() );

    }

    public static boolean is_Abbreviation(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        Boolean[][] arr = new Boolean[bLen][aLen];
        Set<String> capitalized = new HashSet<>();

        for(int i = 0; i < bLen; i++) {
            for (int j = 0; j < aLen; j++) {
                arr[i][j] = false;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            char cB = b.charAt(i);
            for(int j = 0; j < arr[i].length; j++) {
                char cA = a.charAt(j);


                if( (i == 0 || j == 0) && (cA == cB || Character.toUpperCase(cA) == cB) ) {
                    if( j > 0 && arr[i][j-1] == true) {
                        arr[i][j] = true;
                    } else if( Character.toUpperCase(cA) == cB ) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                } else if( (i > 0 && j > 0)  && (arr[i-1][j-1] == true && ( cA == cB  || Character.toUpperCase(cA) == cB) ) ){
                    if( j > 0 && arr[i][j-1] == true) {
                        arr[i][j] = true;
                    } else if( Character.toUpperCase(cA) == cB ) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                } else if( j > 0 && arr[i][j-1] == true) {
                    arr[i][j] = true;
                }
            }
        }

        for(int i = 0; i < bLen; i++) {
            for (int j = 0; j < aLen; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        return arr[bLen - 1][aLen - 1];
    }
}

class TestAbbreviation {

    @Test
    public void testAbbreviation1() {
        boolean actual = Abbreviation.is_Abbreviation("aa", "A");
        assertTrue(actual);
    }

    /*@Test
    public void testAbbreviation2() {
        boolean actual = Abbreviation.is_Abbreviation("aaB", "A");
        assertFalse(actual);
    }*/

    @Test
    public void testAbbreviation3() {
        boolean actual = Abbreviation.is_Abbreviation("aaB", "AB");
        assertTrue(actual);
    }

    @Test
    public void testAbbreviation4() {
        boolean actual = Abbreviation.is_Abbreviation("aBcd", "ABD");
        assertTrue(actual);
    }

    @Test
    public void testAbbreviation5() {
        boolean actual = Abbreviation.is_Abbreviation("abc", "A");
        assertTrue(actual);
    }

}
