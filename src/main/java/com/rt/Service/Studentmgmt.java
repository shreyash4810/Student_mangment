package com.rt.Service;

import java.util.List;

import com.rt.Model.Student;

public interface Studentmgmt {

    public String Registerstudent(Student student);

    public List<Student> Fetchall();

    public Student FetchallsStudentsbyid(Integer id);

    public String removeStudentbyid(Integer id);

    public String updateStudentbyid(Integer id, Student student);

}
