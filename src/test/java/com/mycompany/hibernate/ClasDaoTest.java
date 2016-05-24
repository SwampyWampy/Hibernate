/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paweł
 */
public class ClasDaoTest {

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testInsert(){
        //given
        
        ClasDao clasDao = new ClasDao();
        StudentDao studentDao = new StudentDao();
        SubjectDao subjectDao = new SubjectDao();
        
        Student s1 = new Student(0L, "Andrzej", "Nowak");
        Student s2 = new Student(0L, "Maciej", "Agar");
        Student s3 = new Student(0L, "Rafał", "Sienkiewicz");
        Student s4 = new Student(0L, "Gieroj", "Mocarz");
        
        Set<Student> students = new HashSet<>(Arrays.asList(s1,s2));
        students.forEach(studentDao::insert);
        Set<Student> students2 = new HashSet<>(Arrays.asList(s3,s4));
        students2.forEach(studentDao::insert);
        
        Subject su1 = new Subject(0L, "Matematyka");
        Subject su2 = new Subject(0L, "Fizya");
        Subject su3 = new Subject(0L, "Geografia");
        Subject su4 = new Subject(0L, "Polski");
        
        Set<Subject> subjects = new HashSet<>(Arrays.asList(su1,su2));
        subjects.forEach(subjectDao::insert);
        Set<Subject> subjects2 = new HashSet<>(Arrays.asList(su3,su4));
        subjects2.forEach(subjectDao::insert);
        
        Clas clazz1 = new Clas(0L, "A", students, subjects);
        Clas clazz2 = new Clas(0L, "B", students2, subjects2);
        
        clasDao.insert(clazz1);
        clasDao.insert(clazz2);
        //when
        
        
        
        //then
        assertEquals(clasDao.findAll(), Arrays.asList(clazz1, clazz2));
    }
}
