package com.example.inflearn.domain;

import javax.persistence.*;

//jpa가 관리하는 entity가 된다.
@Entity
public class Member {

    //테이블에서 pk로 사용할 값임을 의미한다.
    @Id
    //db가 해당 column을 자동으로 생성해줌을 identity라고 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
