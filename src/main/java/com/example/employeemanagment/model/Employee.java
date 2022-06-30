package com.example.employeemanagment.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.engine.jdbc.Size;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column( nullable = false)
    private String empName;

    //@NotNull
    @Column
    private String location;

//    @JoinColumn(name = "fk_mid")
//    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//    private Manager manager;



    @UpdateTimestamp
    private LocalDateTime updateTime;

    @CreationTimestamp
    private LocalDateTime createTime;

//       @ManyToOne
//       @JoinColumn(name = "m_id")
//       private Manager manager;

        @ManyToMany(mappedBy = "employee", cascade = CascadeType.ALL)
        private List<Manager> manager = new ArrayList<>();




}
