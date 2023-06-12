package softUni;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    //•	insert(Student student)

    public String insert(Student student) {
        if (this.data.size() < this.capacity) {
            if (findStudent(student.getFirstName()) == null) {
                data.add(student);
                return String.format("Added student %s %s.",
                        student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the hall.";
            }
        }
        return "The hall is full.";
    }

    public Student findStudent(String name) {
        for (Student student : data) {
            if (student.getFirstName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    //•	remove(Student student)

    public String remove(Student student){
        boolean removed = data.removeIf(s -> s.equals(student));
        if (removed) {
            return "Removed student " + student.getFirstName() + " " + student.getLastName() + ".";
        } else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics(){
        return String.format("Hall size: %d%n%s",
                this.data.size(),
                data.stream()
                        .map(Student::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();

    }
}


