import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    // Reads data from input stream and stores in linked list
    public static void store(InputStream in, LinkedList<Person> list) {
        Scanner sc = new Scanner(new InputStreamReader(in));
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            String[] parts = line.split(",");
            String first = parts[0].trim();
            String last  = parts[1].trim();
            String id    = parts[2].trim();

            list.add(new Person(first, last, id));
        }
        sc.close();
    }

    // Displays all persons
    public static void display(PrintStream out, LinkedList<Person> list) {
        for (Person p : list) {
            out.println(p);
        }
    }

    // Finds person by id
    public static int find(String sid, LinkedList<Person> list) {
        int idx = 0;
        for (Person p : list) {
            if (p.getId().equals(sid)) return idx;
            idx++;
        }
        return -1;
    }

    // Main program
    public static void main(String[] args) throws Exception {
        LinkedList<Person> people = new LinkedList<>();

        FileInputStream in = new FileInputStream("persons.txt");
        store(in, people);
        in.close();

        System.out.println("All people:");
        display(System.out, people);

        System.out.println();
        System.out.println("find(\"A123\") -> " + find("A123", people));
        System.out.println("find(\"B456\") -> " + find("B456", people));
        System.out.println("find(\"XYZ\")  -> " + find("XYZ", people));
    }
}
