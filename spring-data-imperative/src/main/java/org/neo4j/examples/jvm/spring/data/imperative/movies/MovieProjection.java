package org.neo4j.examples.jvm.spring.data.imperative.movies;

import java.util.List;

public class MovieProjection {

    private String title;

    private List<String> actorNames;

    public List<String> getActorNames() {
        return actorNames;
    }

    public String getTitle() {
        return title;
    }
    
}
