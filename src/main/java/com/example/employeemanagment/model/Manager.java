package com.example.employeemanagment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Manager {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long mId;

    private String mName;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn( name = "fk_mpid" ,referencedColumnName = "mId")
//    private List<Employee> employee;


//    @OneToOne(mappedBy = "manager")
//    private Employee employee;

//    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Employee> employee;
      @ManyToMany(cascade = CascadeType.ALL)
      @JoinTable(name="manager_employee", joinColumns = @JoinColumn(name="mid"),inverseJoinColumns = @JoinColumn(name="id"))
      private List<Employee> employee = new ArrayList<>();
}
