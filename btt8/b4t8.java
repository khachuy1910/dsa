import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
 class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
            new Comparator<Student>() {
                public int compare(Student a, Student b) {
                    if (a.getCgpa() != b.getCgpa())
                        return Double.compare(b.getCgpa(), a.getCgpa()); 
                    else if (!a.getName().equals(b.getName()))
                        return a.getName().compareTo(b.getName());       
                    else
                        return a.getId() - b.getId();                    
                }
            }
        );

        for (String e : events) {
            String[] parts = e.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll(); 
            }
        }

        List<Student> remaining = new ArrayList<>();
        while (!pq.isEmpty())
            remaining.add(pq.poll());

        return remaining;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
