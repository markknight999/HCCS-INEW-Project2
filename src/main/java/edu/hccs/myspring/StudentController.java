package edu.hccs.myspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/gpa") // localhost:8080/search/?gpa=3.6&gender=Female
    public double showAllGpas() throws IOException {
        List<Student> students = readData();
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            sum += student.getGpa();
            count++;

        }

        return sum / count;

    }

    @GetMapping("/search") // localhost:8080/search/?gpa=3.6&gender=Female
    public List<Student> searchByGpaAndGender(@RequestParam(name = "gpa") Double gpa,
                                              @RequestParam(name = "gender") String gender) throws IOException {
        List<Student> students = readData();
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (gpa == null || student.getGpa() >= gpa) {
                if (gender == null || student.getGender().equalsIgnoreCase(gender)) {
                    list.add(student);

                }

            }

        }

        return list;

    }

    @GetMapping("/name/{name}") // localhost:8080/name/Caleb
    public List<Student> searchByName(@PathVariable String name) throws IOException {
        List<Student> students = readData();
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                list.add(student);

            }

        }

        return list;

    }

    public List<Student> readData() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/student.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Student> studentList = new ArrayList();

        String header = bufferedReader.readLine();
        String line = bufferedReader.readLine();

        while ( line != null){
            String[] data = line.split(",");
            Student student = new Student(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), data[3], data[4]);
            studentList.add(student);
            line = bufferedReader.readLine();

        }
        return studentList;

    }

}
