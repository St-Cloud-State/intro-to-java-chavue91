import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> people;

    // Constructor
    public PersonList() {
        people = new LinkedList<>();
    }

    // Store persons from an input stream
    public void store(InputStream in) {
        Scanner sc = new Scanner(new InputStreamReader(in));
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty() || line.startsWith("#")) continue;

            String[] parts = line.split(",");
            String first = parts[0].trim();
            String last  = parts[1].trim();
            String id    = parts[2].trim();

            people.add(new Person(first, last, id));
        }
        sc.close();
    }

    // Display all persons
    public void display(PrintStream out) {
        for (Person p : people) {
            out.println(p);
        }
    }

    // Find person by id, return index or -1
    public int find(String sid) {
        int idx = 0;
        for (Person p : people) {
            if (p.getId().equals(sid)) return idx;
            idx++;
        }
        return -1;
    }
}
