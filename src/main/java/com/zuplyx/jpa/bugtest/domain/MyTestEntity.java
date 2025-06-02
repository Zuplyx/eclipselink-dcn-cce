package com.zuplyx.jpa.bugtest.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "TEST_TAB_MY_ENTITY")
public class MyTestEntity {
    @Id
    private long id;

    private String name;
    @OneToMany(mappedBy = "myTestEntity", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Set<Included> includedSet;

    @OneToMany(mappedBy = "myTestEntity", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Set<Included2> included2Set;

    @OneToMany(mappedBy = "myTestEntity", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Set<Included3> included3Set;

    @OneToMany(mappedBy = "myTestEntity", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Set<Included4> included4Set;

    @OneToMany(mappedBy = "myTestEntity", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Set<Included5> included5Set;
    @OneToMany(mappedBy = "myTestEntity", cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Set<Included6> included6Set;

    public MyTestEntity() {
    }

    public MyTestEntity(long id) {
        this.id = id;
    }

    public MyTestEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Included6> getIncluded6Set() {
        return included6Set;
    }

    public void setIncluded6Set(Set<Included6> included6Set) {
        this.included6Set = included6Set;
    }

    public Set<Included5> getIncluded5Set() {
        return included5Set;
    }

    public void setIncluded5Set(Set<Included5> included5Set) {
        this.included5Set = included5Set;
    }

    public Set<Included4> getIncluded4Set() {
        return included4Set;
    }

    public void setIncluded4Set(Set<Included4> included4Set) {
        this.included4Set = included4Set;
    }

    public Set<Included3> getIncluded3Set() {
        return included3Set;
    }

    public void setIncluded3Set(Set<Included3> included3Set) {
        this.included3Set = included3Set;
    }

    public Set<Included2> getIncluded2Set() {
        return included2Set;
    }

    public void setIncluded2Set(Set<Included2> included2Set) {
        this.included2Set = included2Set;
    }

    public Set<Included> getIncludedSet() {
        return includedSet;
    }

    public void setIncludedSet(Set<Included> includedSet) {
        this.includedSet = includedSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
