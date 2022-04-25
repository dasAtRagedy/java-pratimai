import document_types.CalendarDocument;
import document_types.ToDoListDocument;
import main.Documents;

public class Main {
    public static void main(String[] args) {
        Documents a = new ToDoListDocument("Deividas");
        System.out.println(a.getDueDate());
        a.delayDueDate();
        System.out.println(a.getDueDate());

        a = new CalendarDocument("Unknown");
        System.out.println(a.getDueDate());
        a.delayDueDate();
        System.out.println(a.getDueDate());
    }
}

// issiaiskint polimorfizmas
/* Polimorfizmas šioje situacijoje:
* Parent klasė Documents turi metodą delayDueDate,
* Child klasė CalendarDocument turi metodą delayDueDate, kuris atkelia renginį kitokiam laikui
* */

// istrinti print'us - Palikti tik getteriai
