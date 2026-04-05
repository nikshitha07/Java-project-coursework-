import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Record System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);

        JButton addBtn = new JButton("Add");
        JButton showBtn = new JButton("Show All");
        JButton searchBtn = new JButton("Search");

        JTextArea output = new JTextArea(10, 30);

        frame.add(new JLabel("ID:"));
        frame.add(idField);
        frame.add(new JLabel("Name:"));
        frame.add(nameField);

        frame.add(addBtn);
        frame.add(showBtn);
        frame.add(searchBtn);
        frame.add(output);

        // Add student
        addBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            students.add(new Student(id, name));
            output.setText("Student added.\n");
        });

        // Show all students
        showBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Student s : students) {
                sb.append("ID: ").append(s.id)
                  .append(", Name: ").append(s.name)
                  .append("\n");
            }
            output.setText(sb.toString());
        });

        // Search student
        searchBtn.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            for (Student s : students) {
                if (s.id == id) {
                    output.setText("Found: " + s.name);
                    return;
                }
            }
            output.setText("Not found");
        });

        frame.setVisible(true);
    }
}
