package com.airtribe.meditrack.interfac;

import java.util.List;

public interface Searchable<T> {

    List<T> searchByName(String name);

    default void printResults(List<T> results) {

        if(results.isEmpty()) {
            System.out.println("No results found");
        } else {
            results.forEach(System.out::println);
        }

    }

}