package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Gender gender;



}
