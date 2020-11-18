import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> result=new ArrayList<>();
        SimpleContactDAO dao=new SimpleContactDAO();

        result=dao.findAll();
        for (Contact contact : result) {
            System.out.println("Name:"+contact.getName()+"  Phone:"+contact.getPhone());
        }
    }
}
