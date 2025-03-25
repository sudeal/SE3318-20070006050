package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MagicClassroom {
    private List<HogwartsStudent> students;

    // Constructor
    public MagicClassroom() {
        this.students = new ArrayList<>();
    }


    public boolean addStudent(HogwartsStudent student) {
        if (student != null) {
            students.add(student);
            return true;
        }
        return false;
    }


    public HogwartsStudent findStudent(String name) {
        return students.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    public HogwartsStudent findStudentBySpell(String spell) {
        return students.stream()
                .filter(student -> student.knowsSpell(spell))
                .findFirst()
                .orElse(null);
    }

    // Method to get students by house
    public List<HogwartsStudent> getStudentsByHouse(String house) {
        return students.stream()
                .filter(student -> student.getHouse().equalsIgnoreCase(house))
                .collect(Collectors.toList());
    }

    // Method to get all students sorted by house
    public List<HogwartsStudent> getStudentsSortedByHouse() {
        return students.stream()
                .sorted((s1, s2) -> s1.getHouse().compareTo(s2.getHouse()))
                .collect(Collectors.toList());
    }
}
