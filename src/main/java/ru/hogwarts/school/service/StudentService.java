package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;
@Service
public class StudentService {

    Map<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Collection<Student> findStudentsByAge(int age) {
        List<Student> studentsByAge = new ArrayList<>();
        for (Map.Entry<Long, Student> entry : students.entrySet()) {
            if (entry.getValue().getAge() == age) {
                studentsByAge.add(entry.getValue());
            }
        }
        return studentsByAge;
    }
}
