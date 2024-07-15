package Collection;

public class Student implements Comparable<Student> {
   public String name;
    public double psp;
    public String univName;
    public Student(String name, double psp, String univName){
        this.name = name;
        this.psp = psp;
        this.univName = univName;
    }
    public Student(){

    }

    /*
    Comparable interface is to define the natural ordering of
    user defined classes.
     */
    @Override
    public int compareTo(Student student) {
        if(this.psp < student.psp){  //wheneevr we compare the first object with second we do asc order
            return -1;
        } else if(student.psp < this.psp){
            return 1;
        }else{
            return this.name.compareTo(student.name);
        }
    }
}