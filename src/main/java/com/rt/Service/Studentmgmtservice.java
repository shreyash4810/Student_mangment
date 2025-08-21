package com.rt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.Model.Student;
import com.rt.Repository.StudentRepository;

@Service("studentservice")
public class Studentmgmtservice implements Studentmgmt {

    @Autowired
    private StudentRepository strepo;

    @Override
    public String Registerstudent(Student student) {
        Student saved = strepo.save(student);
        return "studnet is registerd" + saved;
    }

    @Override
    public List<Student> Fetchall() {
        return strepo.findAll();
    }

    @Override
    public Student FetchallsStudentsbyid(Integer id) {
        return strepo.findById(id)
                .orElseThrow(() -> new UnsupportedOperationException(id + "student not found"));

    }

    @Override
    public String removeStudentbyid(Integer id) {
        Optional<Student> opt = strepo.findById(id);
        if (opt.isPresent()) {
            strepo.deleteById(id);
            return "student id is found and deleted";
        } else {
            throw new UnsupportedOperationException(id + "student is not found");
        }

    }

    @Override
    public String updateStudentbyid(Integer id, Student student) {
        Optional<Student> op = strepo.findById(id);
        if (op.isPresent()) {
            strepo.save(student);
            return "student details is updated" + student.getId();

        } else {

            return " studentid is not found" + student.getId();
        }

    }
}
