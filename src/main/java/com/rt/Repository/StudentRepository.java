package com.rt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rt.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
