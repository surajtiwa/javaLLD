package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompartorExample {
    public static void main(String[] args) {
        List<Student> ls5 = new ArrayList<Student>();

        Student st1 = new Student("Umang", 100, "ABC");
        Student st2 = new Student("Anshuman", 99.99, "Scaler");
        Student st3 = new Student("Kajal ji", 99.99, "Randomxyz");
        ls5.add(st1);
        ls5.add(st2);
        ls5.add((st3));


        Collections.sort(ls5);
        for(Student s : ls5){
            System.out.println(s.name + " " + s.psp + " " + s.univName);
        }


    }
}
