package com.rt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.Model.Student;
import com.rt.Service.Studentmgmt;

@RestController
@RequestMapping("/api/students")
public class Studentcontroller {

    @Autowired
    private Studentmgmt service;

    @PostMapping
    public ResponseEntity<String> createStudent(@Validated @RequestBody Student studnet) {
        try {
            String msg = service.Registerstudent(studnet);
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("studnet is not registerd", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping
    public ResponseEntity<?> displaystudents() {
        try {
            List<Student> resmsg = service.Fetchall();
            return new ResponseEntity<>(resmsg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("studnet is not avaliable", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> displaystudentsbyid(@PathVariable("id") Integer id) {
        try {
            Student yesmsg = service.FetchallsStudentsbyid(id);
            return new ResponseEntity<>(yesmsg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("studnetid is not avaliable", HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletestudentsbyid(@PathVariable("id") Integer id) {
        try {
            String str = service.removeStudentbyid(id);
            return new ResponseEntity<>(str, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("studnetid is not avaliable", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyStudent(
            @PathVariable("id") Integer id,
            @Validated @RequestBody Student student) {
        try {
            String updatedStudent = service.updateStudentbyid(id, student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Student was not updated", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
