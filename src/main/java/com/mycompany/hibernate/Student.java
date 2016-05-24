/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
/**
 *
 * @author Paweł
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	private String fname;
        private String lname;

}
