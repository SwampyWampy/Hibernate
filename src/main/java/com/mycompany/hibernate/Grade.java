/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Paweł
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Grades")
public class Grade implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private Integer grade;
    @OneToOne
    private Student student;
    @OneToOne
    private Teacher teacher;
    @OneToOne
    private Subject subject;
    
}
