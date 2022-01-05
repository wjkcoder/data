package com.charsmart.data;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Wonder
 * @Date: Created on 2022/1/4 下午5:19
 */
public class FunctionTest {
    @Test
    public void test() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("key", "value");
        map.put("key1", "value1");
        BiConsumer<String, String> consumer = (a, b) -> System.out.println(a + b);
        map.forEach(consumer);
    }

    @Test
    public void streamMap() {
        Stream<String> stream = Stream.of("hello", "123", "good", "good");
        Function<String, Integer> func = s -> s.length() + 1;
        Stream<Integer> processStream = stream.filter(t -> t.length() > 1)
                .distinct()
                .map(func);
        List<Integer> collect =processStream
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
//    @Test
    public void streamFindAny(){
        Stream<String> stream = Stream.of("hello", "123", "good", "good");
        Function<String, Integer> func = s -> s.length() + 1;
        Optional<Integer> any = stream.filter(t -> t.length() > 1)
                .distinct()
                .map(func)
                .findAny();
        any.ifPresent(System.out::println);
    }
}
