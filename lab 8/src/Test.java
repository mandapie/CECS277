import java.util.*;
/**
 * Amanda Pan
 * 4/6/2016
 * lab 8
 * cecs 277
 */
public class Test {

    public static void main(String[] args) {
        
        Map<Integer, Student> studentMap = new TreeMap<>();
        Map<Student, String> gradeMap = new TreeMap<>();

        boolean end = false;
        while (!end)
        {
            int choice = printMenuAndGetChoice();

            switch (choice)
            {
                case 1:
                    add(gradeMap, studentMap);
                    break;
                case 2:
                    remove(gradeMap, studentMap);
                    break;
                case 3:
                    modify(gradeMap, studentMap);
                    break;
                case 4:
                    printOut(gradeMap);
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("Invalid Choice.");
                    break;
            }
        }
    }

    /**
     * Prints out menu for user to enter a Choice
     * @return choice
     */
    public static int printMenuAndGetChoice()
    {

        int choice;
        Scanner in = new Scanner(System.in);
        System.out.println(
                "1 Add a student\n" +
                "2 Remove a student\n" +
                "3 Modify a student grade\n" +
                "4 Print all IDs, Students, and Grades\n" +
                "0 Exit the Program");
        try
        {
            choice = in.nextInt();
        }
        catch (InputMismatchException e)
        {
            choice =- 1;
        }
        return choice;
    }

    /**
     Adds a student based on user input.  Prints an error if a student
     is added that already exists in the map.
     @param GradeMap the map to associate student object with a grade
     @param StudentMap the map to associate student id with an student.
     */
    public static void add(Map<Student,String> GradeMap,Map<Integer,Student> StudentMap)
    {
        Student s = new Student();
        Scanner input = new Scanner(System.in);
        String grade;

        try
        {
            System.out.println("Enter Student's ID:");
            s.setID(input.nextInt());

            if (StudentMap.containsKey(s.getID()))
                System.out.println("ID numberalready exist.");
            else
            {
                System.out.println("Enter Student's LastName:");
                s.setlName(input.next());

                System.out.println("Enter Student's FirstName:");
                s.setfName(input.next());

               // while (grade.length()!=1) {
                    System.out.println("Enter Student's Grade:");
                    grade = input.next().toUpperCase();
               // }
                StudentMap.put(s.getID(), s);
                GradeMap.put(s, grade);
            }
        }

        catch (InputMismatchException e)
        {
            System.out.println("ID has to be integers.");
        }
    }

    /**
     Removes a student from the map based on user input
     @param GradeMap the map to associate student object with a grade.
     @param StudentMap the map to associate student id with an student.
     */
    public static void remove(Map<Student,String> GradeMap,Map<Integer,Student> StudentMap){

        Student s = new Student();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Student's ID:");
        s.setID(input.nextInt());

        if(StudentMap.containsKey(s.getID()))
        {
            GradeMap.remove(StudentMap.get(s.getID()));
            StudentMap.remove(s.getID());
        }
        else
            System.out.println("ID number doesn't exist.");
    }

    /**
     Modifies an entry based on user input.  Prints an error if an invalid student is modified.
     @param GradeMap the map to associate student object with a grade.
     @param StudentMap the map to associate student id with a student.
     */
    public static void modify(Map<Student,String> GradeMap,Map<Integer,Student> StudentMap){

        Student s = new Student();
        Scanner input = new Scanner(System.in);
        String grade;

        System.out.println("Enter Student's ID:");
        s.setID(input.nextInt());

        if(StudentMap.containsKey(s.getID()))
        {
            System.out.println("Enter Student's LastName:");
            s.setlName(input.next());

            System.out.println("Enter Student's FirstName:");
            s.setfName(input.next());

            System.out.println("Enter Student's Grade:");
            grade=input.next().toUpperCase();

            StudentMap.put(s.getID(), s);
            GradeMap.put(s, grade);
        }
        else
            System.out.println("ID number doesn't exist.");
    }
    /**
     Prints the students and grades
     @param gradeMap the map to print
     */
    public static void printOut(Map<Student,String> gradeMap)
    {
        Set<Student> keys = gradeMap.keySet();

        for (Student s: keys)
            System.out.println(s.getID() + "\t\t" + s.getlName() + " " + s.getfName() + "\t\t" + gradeMap.get(s));
    }
}