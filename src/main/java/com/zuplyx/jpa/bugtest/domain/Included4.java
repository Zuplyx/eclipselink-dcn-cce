package com.zuplyx.jpa.bugtest.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TEST_TAB_INCLUDED4")
public class Included4 {
    @Id
    private long id;

    private String name;

    @Column(name = "MY_ENTITY_ID", nullable = false, precision = 14, updatable = false, insertable = false)
    private long myEntityId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "MY_ENTITY_ID", referencedColumnName = "ID", nullable = false)})
    private MyTestEntity myTestEntity;

    public Included4() {
    }

    public Included4(long id) {
        this.id = id;
    }

    public Included4(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getMyEntityId() {
        return myEntityId;
    }

    public void setMyEntityId(long myEntityId) {
        this.myEntityId = myEntityId;
    }

    public MyTestEntity getMyTestEntity() {
        return myTestEntity;
    }

    public void setMyTestEntity(MyTestEntity myTestEntity) {
        this.myTestEntity = myTestEntity;
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
