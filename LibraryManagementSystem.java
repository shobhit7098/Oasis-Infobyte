import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;

    public Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Member {
    private int id;
    private String name;
    private String contact;

    public Member(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}

public class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private int bookIdCounter = 1;
    private int memberIdCounter = 1;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Add Member");
            System.out.println("4. List Members");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    librarySystem.addBook();
                    break;
                case 2:
                librarySystem.listBooks();
                    break;
                case 3:
                    librarySystem.addMember();
                    break;
                case 4:
                    librarySystem.listMembers();
                    break;
                case 5:
                    System.out.println("Have a good day....");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    @SuppressWarnings("resource")
    public void addBook() {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = sc.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = sc.nextLine();
        System.out.print("Enter the quantity of the book: ");
        int quantity = sc.nextInt();
        
        Book book = new Book(bookIdCounter++, title, author, quantity);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void listBooks() {
        System.out.println("List of Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Quantity: " + book.getQuantity());
            System.out.println("------------------------------");
        }
    }

    @SuppressWarnings("resource")
    public void addMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the member: ");
        String name = sc.nextLine();
        System.out.print("Enter the contact information of the member: ");
        String contact = sc.nextLine();

        Member member = new Member(memberIdCounter++, name, contact);
        members.add(member);
        System.out.println("Member added successfully.");
    }

    public void listMembers() {
        System.out.println("List of Members:");
        for (Member member : members) {
            System.out.println("ID: " + member.getId());
            System.out.println("Name: " + member.getName());
            System.out.println("Contact: " + member.getContact());
            System.out.println("------------------------------");
        }
    }
}
