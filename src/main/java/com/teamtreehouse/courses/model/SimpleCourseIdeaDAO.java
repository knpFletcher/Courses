package com.teamtreehouse.courses.model;

import org.mozilla.javascript.NotAFunctionException;

import java.util.ArrayList;
import java.util.List;

//simple way to do this, not how it should actually be done
public class SimpleCourseIdeaDAO implements CourseIdeaDAO{
    private List<CourseIdea> ideas;

    public SimpleCourseIdeaDAO() {
        ideas = new ArrayList<>();
    }

    @Override
    public boolean add(CourseIdea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
            //not reference to the list, brand new list
    }

    @Override
    public CourseIdea findBySlug(String slug) {
        return ideas.stream()
                .filter(idea -> idea.getSlug().equals(slug))
                    //look at each idea
                .findFirst()
                    //return 1st
                .orElseThrow(NotFoundException::new);
    }
}
