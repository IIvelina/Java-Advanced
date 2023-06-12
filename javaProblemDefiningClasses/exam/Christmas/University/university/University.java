package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;

    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount(){
        return students.size();
    }

    public String registerStudent(Student student){
        if (capacity > students.size()){
            if (!students.contains(student)) {
                capacity--;
                students.add(student);
                return String.format("Added student %s %s",
                        student.getFirstName(),
                        student.getLastName());
            }else {
                return "Student is already in the university";
            }
        }else {
            return "No seats in the university";
        }
    }


    public String dismissStudent(Student student) {
        if (students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",
                    student.getFirstName(),
                    student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : students) {
            if (firstName.equals(student.getFirstName())
            && lastName.equals(student.getLastName())){
                return student;
            }
        }
        return null;
    }


    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        for (Student student : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}

