package com.olemba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tomasz on 28.08.2016.
 */
@RestController
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.PUT)
    public List<Student> add(@RequestBody Student student){
        studentRepository.save(student);
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<Student> delete(@PathVariable Long id){
        studentRepository.delete(id);
        return studentRepository.findAll();
    }

    @RequestMapping
    public List<Student> update(@PathVariable Long id, @RequestBody Student student){
        Student updated = studentRepository.findOne(id);
        updated.setName(student.getName());
        updated.setSurname(student.getSurname());
        studentRepository.save(updated);
        return studentRepository.findAll();
    }
}
