package com.app.sharecabs.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
 class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String email;
    String mobileNo;
    List<User> previousCompanions;
}
