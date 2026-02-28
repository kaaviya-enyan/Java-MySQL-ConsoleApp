import java.sql.*;
import java.util.Scanner;

public class BookstoreApp {

    static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    static final String USER = "root";
    static final String PASSWORD = "mysqlKavya@12";

    static Scanner sc = new Scanner(System.in);
    static Connection con;

    public static void main(String[] args) {

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                showMenu();
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> viewBooks();
                    case 3 -> deleteBook();
                    case 4 -> updateBook();
                    case 5 -> searchBook();
                    case 6 -> {
                        System.out.println("Exiting...");
                        con.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showMenu() {
        System.out.println("\n1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Delete Book");
        System.out.println("4. Update Book");
        System.out.println("5. Search by Title");
        System.out.println("6. Exit");
        System.out.print("Choose option: ");
    }

    static void addBook() throws SQLException {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        String query = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setDouble(3, price);
        ps.executeUpdate();

        System.out.println("Book added successfully!");
    }

    static void viewBooks() throws SQLException {
        String query = "SELECT * FROM books";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    rs.getDouble("price"));
        }
    }

    static void deleteBook() throws SQLException {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM books WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("Book deleted!");
    }

    static void updateBook() throws SQLException {
        System.out.print("Enter Book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new title: ");
        String title = sc.nextLine();
        System.out.print("Enter new author: ");
        String author = sc.nextLine();
        System.out.print("Enter new price: ");
        double price = sc.nextDouble();

        String query = "UPDATE books SET title=?, author=?, price=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setDouble(3, price);
        ps.setInt(4, id);
        ps.executeUpdate();

        System.out.println("Book updated successfully!");
    }

    static void searchBook() throws SQLException {
        System.out.print("Enter title to search: ");
        String title = sc.nextLine();

        String query = "SELECT * FROM books WHERE title LIKE ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "%" + title + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    rs.getDouble("price"));
        }
    }
}