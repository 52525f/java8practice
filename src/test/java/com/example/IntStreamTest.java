package com.example;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class IntStreamTest {
    @Test
    public void canCreateWithBuilder() throws Exception {
        int max = IntStream.builder()
                .add(10)
                .add(20)
                .add(30)
                .build()
                .max().getAsInt();

        assertEquals(max, 30);
    }

    @Test
    public void canConcatIntStreams() throws Exception {
        IntStream stream1 = IntStream.of(1, 2, 3, 4);
        IntStream stream2 = IntStream.of(5, 6, 7, 8);
        IntStream stream3 = IntStream.concat(stream1, stream2);

        assertEquals(stream3.sum(), 36);
    }

    @Test
    public void canGenerateIntStream() throws Exception {
        IntStream stream = IntStream.generate(() -> 1).limit(10);

        assertEquals(stream.sum(), 10);
    }

    @Test
    public void canIterateIntStream() throws Exception {
        List<Integer> list = IntStream.iterate(0, n -> n + 3)
                .limit(3)
                .boxed()
                .collect(Collectors.toList());

        assertEquals((int) list.get(0), 0);
        assertEquals((int) list.get(1), 3);
        assertEquals((int) list.get(2), 6);
    }

    @Test
    public void canConvertStringsToIntStream() throws Exception {
        List<String> list = Arrays.asList("1", "2", "3");
        int sum = list.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        assertEquals(sum, 6);
    }
}
