import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Student {

    private int id = 0;
    private char grade1 = ' ';
    private char grade2 = ' ';

    // Constructor for a Student object
    public Student(int i, char g1, char g2) {
        id = i;
        grade1 = g1;
        grade2 = g2;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public char getGrade1() {
        return grade1;
    }

    public char getGrade2() {
        return grade2;
    }

    // SETTERS
    public void setId(int i) {
        id = i;
    }

    public void setGrade1(char g1) {
        grade1 = g1;
    }

    public void setGrade2(char g2) {
        grade2 = g2;
    }

    public void getInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter ID Number: ");
        setId(new Integer(in.readLine()));
        System.out.print("Enter First Grade: ");
        setGrade1(in.readLine().charAt(0));
        System.out.print("Enter Second Grade: ");
        setGrade2(in.readLine().charAt(0));
    }

    // Merged the to string and convert from two letter grades to one for
    // convenience
    public String toString() {
        char finalGrade = ' ';
        if (getGrade1() == getGrade2()) {
            finalGrade = getGrade1();
        } else {
            finalGrade = 'B';
        }
        return "ID Number is " + getId() + ", grade 1 is " + getGrade1() + ", grade 2 is " + getGrade2()
                + ", final grade is " + finalGrade;
    }

    public static void main(String[] args) throws IOException {
        Student student = new Student(0, ' ', ' ');
        student.getInput();
        System.out.println(student.toString());

    }
}
