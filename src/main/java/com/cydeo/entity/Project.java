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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
@Entity
@Where(clause = "is_deleted = false")
public class Project extends BaseEntity{

    private String projectCode;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private Status projectStatus;
    private String projectDetail;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="manager_id")
    private User assignedManager;


}
