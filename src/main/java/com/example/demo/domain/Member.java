package com.example.demo.domain;

//DB에 table 역할을 한다.

import javax.persistence.*;

@Entity
public class Member {

//    DB에 table 역할을 한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private long id;
    @Column
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
