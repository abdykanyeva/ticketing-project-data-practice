package com.cydeo.entity;


import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
@Where(clause = "is_deleted = false")
public class Task extends BaseEntity{

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private User assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    private LocalDate assignedDate;
    @Enumerated(EnumType.STRING)
    private Status status;

}
