package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;
@Service
public class FacultyService {

    Map<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> findFacultiesByColor(String color) {
        List<Faculty> facultiesByColor = new ArrayList<>();
        for (Map.Entry<Long, Faculty> entry : faculties.entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                facultiesByColor.add(entry.getValue());
            }
        }
        return facultiesByColor;
    }
}
