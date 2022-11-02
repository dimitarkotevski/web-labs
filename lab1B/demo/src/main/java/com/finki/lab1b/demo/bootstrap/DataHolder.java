package com.finki.lab1b.demo.bootstrap;


import com.finki.lab1b.demo.model.Course;
import com.finki.lab1b.demo.model.Student;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    // data za students i courses 4tata tocka od lab vezba samo tuka sho e vo posebna class
    public static List<Student>  studentList=new ArrayList<>();
    public static List<Course> courseList=new ArrayList<>();


    @PostConstruct
    public void init(){

            studentList.add(new Student("dimitarkotevski","1234","Dimtiar","Kotevski"));
            studentList.add(new Student("sandra123","51351","Sandra","Lazarevska"));
            studentList.add(new Student("kristina_tija","asfgasgas","Kristina","Jovsnovska"));
            studentList.add(new Student("goran_veljanov","1251251","Goran","Veljanov"));
            studentList.add(new Student("ivan_bosnakovski","assg123","Ivan","Bosnakovski"));


            courseList.add(new Course("1", "Web programming", "Web programming",
                        List.of(studentList.get(0),studentList.get(1))
                    ));

            courseList.add(new Course("2","Operating System","Operating System",
                    List.of(studentList.get(3),studentList.get(4)
                    )));

            courseList.add(new Course("3"," Electronic and Mobile ..."," Electronic and Mobile ...",
                    List.of(studentList.get(1))
            ));

            courseList.add(new Course("4","Computer Network","Computer Network",
                    List.of(studentList.get(4))
            ));

        }
}
