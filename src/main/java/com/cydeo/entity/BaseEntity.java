package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isDeleted = false;
    @Column(nullable = false, updatable = false)
    private LocalDateTime insertDateTime;
    @Column(nullable = false, updatable = false)
    private Long insertUserId;
    @Column(nullable = false)
    private LocalDateTime lastUpdateDateTime;
    @Column(nullable = false)
    private Long lastUpdateUserId;


    @PrePersist
    private void onPrePersist(){

        this.insertDateTime = LocalDateTime.now();
        this.insertUserId = 1L;

        this.lastUpdateDateTime = LocalDateTime.now();
        this.lastUpdateUserId = 1L;

    }

    @PreUpdate
    private void onPreUpdate(){
        this.lastUpdateDateTime = LocalDateTime.now();
        this.lastUpdateUserId = 1L;
    }



}
