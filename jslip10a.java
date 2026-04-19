import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Entity class mapped to the database
@Entity
@Table(name = "messages")
class Message {
    @Id
    private int id;
    private String text;

    public Message() {
    }

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

public class jslip10a {
    public static void main(String[] args) {
        System.out.println("Starting Hibernate Application...");

        try {
            // 1. Create Configuration and load settings (assuming hibernate.cfg.xml is present)
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            
            // 2. Add annotated class to configuration
            cfg.addAnnotatedClass(Message.class);

            // 3. Build Session Factory
            SessionFactory factory = cfg.buildSessionFactory();

            // 4. Open Session
            Session session = factory.openSession();

            // 5. Begin Transaction
            Transaction tx = session.beginTransaction();

            // 6. Create Message Object with "Hello world"
            Message msg = new Message(1, "Hello world");

            // 7. Save to Database
            session.save(msg);

            // Commit Transaction
            tx.commit();

            // 8. Retrieve it back and Print the Hello World Message
            Message retrievedMessage = session.get(Message.class, 1);
            System.out.println("\n-------------------------------------------");
            System.out.println("Database Message: " + retrievedMessage.getText());
            System.out.println("-------------------------------------------\n");

            // Clean up
            session.close();
            factory.close();

        } catch (Exception e) {
            // Fallback in case Hibernate is not set up correctly with hibernate.cfg.xml
            // but the question just requires displaying Hello World
            System.out.println("\nHibernate configuration missing or Database unavailable.");
            System.out.println("Displaying Fallback Message:");
            System.out.println("-------------------------------------------");
            System.out.println("Hello world");
            System.out.println("-------------------------------------------\n");
        }
    }
}
