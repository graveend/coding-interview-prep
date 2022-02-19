package heap;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.hackerrank.com/challenges/find-the-running-median/problem
 */
public class RunnigMedian {
    /**
     *
     * Solution
     *
     * Create a minHeap and MaxHeap
     * Make sure minHeap and MaxHeap must differn i size by max 1 unit.
     * In case of odd number of digits, take the min/max from the queue having greatest size
     * In case of even number of digits, we need to calculate the median.
     * To do that, get the mi from MinHeap ad max from maxHeap and divide by 2.
     *
     */

    // keeps track of the LARGE numbers. Topmost element is smallest i it.
    private static PriorityQueue<Integer> minHeap;

    // keeps track of the SMALL numbers. Topmost element is highest i it.
    private static PriorityQueue<Integer> maxHeap;


    public static List<Double> runningMedian(List<Integer> datas) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Double> result = new ArrayList<>();
        for (Integer data : datas) {
            // update heaps
            if (maxHeap.isEmpty() || maxHeap.peek() >= data) {
                maxHeap.add(data);
            } else if (maxHeap.peek() < data) {
                minHeap.add(data);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }

            // calculate median
            if (minHeap.size() == maxHeap.size()) {
                result.add((( (double) minHeap.peek() + (double) maxHeap.peek()) / 2));
            } else if (minHeap.size() > maxHeap.size()) {
                result.add((double) (minHeap.peek()));
            } else {
                result.add((double) (maxHeap.peek()));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = RunnigMedian.runningMedian(a);

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

class TestRunnigMedian {

    @Test
    public void testRuingMedian() {
        List<Double> actual = RunnigMedian.runningMedian(Arrays.asList(12, 4, 5, 3, 8, 7));
        List<Double> expected = Arrays.asList(12.0, 8.0, 5.0, 4.5, 5.0, 6.0);
        assertEquals(expected, actual);
    }

    @Test
    public void testRuingMedianOneToTen() {
        List<Double> actual = RunnigMedian.runningMedian(Arrays.asList(1,2,3,4));
        List<Double> expected = Arrays.asList(1.0,1.5,2.0,2.5);
        assertEquals(expected, actual);
    }
}
