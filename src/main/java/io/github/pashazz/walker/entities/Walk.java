package io.github.pashazz.walker.entities;

import javax.persistence.*;


@Entity
public class Walk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    private String name;


    public Walk () {}

    public Walk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

