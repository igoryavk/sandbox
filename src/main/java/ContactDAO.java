import java.util.List;

public interface ContactDAO {
    List <Contact> findAll();
    List<Contact> findByFirstName(String firstName);
    void insert(Contact contact);
    void update(Contact contact);
    void delete(Contact contact);
}
