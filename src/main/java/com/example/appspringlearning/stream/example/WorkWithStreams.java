package com.example.appspringlearning.stream.example;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class WorkWithStreams {
    @Test
    void streams() {
        List<String> names = List.of("ali", "vali", "guli");
        Stream<String> stream = names.stream();

    }
}
