import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        new Managment();
    }

    public static class Managment extends JFrame implements ActionListener {
        private JLabel label2, label3, label4, label5, label6;

        private JTextField text2;
        private JTextField text3;
        private JTextField text4;
        private JTextField text5;
        private JTextField text6;
        private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
        private JPanel panel;
        private ArrayList<String[]> books = new ArrayList<String[]>();

        public Managment() {
            setTitle("Library Management System");
            setSize(600, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);



            label2 = new JLabel("Book Title");
            label3 = new JLabel("Author");
            label4 = new JLabel("Publisher");
            label5 = new JLabel("Year of Publication");
            label6 = new JLabel("Cost of Book");


            text2 = new JTextField(20);
            text3 = new JTextField(20);
            text4 = new JTextField(20);
            text5 = new JTextField(10);
            text6 = new JTextField(20);


            addButton = new JButton("Add");
            viewButton = new JButton("View");
            editButton = new JButton("Edit");
            deleteButton = new JButton("Delete");
            clearButton = new JButton("Clear");
            exitButton = new JButton("Exit");


            addButton.addActionListener(this);
            viewButton.addActionListener(this);
            editButton.addActionListener(this);
            deleteButton.addActionListener(this);
            clearButton.addActionListener(this);
            exitButton.addActionListener(this);

            panel = new JPanel(new GridLayout(10, 2));
            panel.add(label2);
            panel.add(text2);
            panel.add(label3);
            panel.add(text3);
            panel.add(label4);
            panel.add(text4);
            panel.add(label5);
            panel.add(text5);
            panel.add(label6);
            panel.add(text6);
            panel.add(addButton);
            panel.add(viewButton);
            panel.add(editButton);
            panel.add(deleteButton);
            panel.add(clearButton);
            panel.add(exitButton);

            add(panel);
            setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                String[] book = new String[6];

                book[0] = text2.getText();
                book[1] = text3.getText();
                book[2] = text4.getText();
                book[3] = text5.getText();
                book[4] = text6.getText();
                books.add(book);
                JOptionPane.showMessageDialog(this, "Book added successfully");
                clear();
            } else if (e.getSource() == viewButton) {
                String[] columns = {"Book Title", "Author", "Publisher", "Year of Publication", "Cost of Book"};
                Object[][] data = new Object[books.size()][6];
                for (int i = 0; i < books.size(); i++) {
                    data[i][0] = books.get(i)[0];
                    data[i][1] = books.get(i)[1];
                    data[i][2] = books.get(i)[2];
                    data[i][3] = books.get(i)[3];
                    data[i][4] = books.get(i)[4];

                }
                JTable table = new JTable(data, columns);
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame frame = new JFrame("View Books");
                frame.add(scrollPane);
                frame.setSize(800, 400);
                frame.setVisible(true);
            }
            else if (e.getSource() == editButton) {
                String bookName = JOptionPane.showInputDialog(this, "Enter book name to edit:");
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i)[0].equals(bookName)) {
                        String[] book = new String[6];
                        book[0] = bookName;
                        book[1] = text3.getText();
                        book[2] = text4.getText();
                        book[3] = text5.getText();
                        book[4] = text6.getText();
                        books.set(i, book);
                        JOptionPane.showMessageDialog(this, "Book edited successfully");
                        clear();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Book not found");
            }
            else if (e.getSource() == deleteButton) {
                String bookName = JOptionPane.showInputDialog(this, "Enter book name to delete");
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i)[0].equals(bookName)) {

                        books.remove(i);
                        JOptionPane.showMessageDialog(this, "Book deleted successfully");
                        clear();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Book not found");
            }
            else if (e.getSource() == clearButton) {
                clear();
            }
            else if (e.getSource() == exitButton) {
                System.exit(0);
            }
        }

        public void clear() {

            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            text6.setText("");

        }



    }
}