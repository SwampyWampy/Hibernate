/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 *
 * @author Paweł
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Teachers")
public class Teacher implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String fname;
        private String lname;
        @OneToMany(fetch = FetchType.EAGER)
        @Fetch(FetchMode.SELECT)
        private Set<Subject> subject;
	
}
