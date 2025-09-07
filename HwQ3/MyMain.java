import java.io.*;

public class MyMain {
    public static void main(String[] args) throws Exception {
        PersonList list = new PersonList();

        // Load persons from file
        FileInputStream in = new FileInputStream("persons.txt");
        list.store(in);
        in.close();

        // Display
        System.out.println("All people:");
        list.display(System.out);

        // Test find()
        System.out.println();
        System.out.println("find(\"A123\") -> " + list.find("A123"));
        System.out.println("find(\"B456\") -> " + list.find("B456"));
        System.out.println("find(\"XYZ\")  -> " + list.find("XYZ"));
    }
}
