package chapter12.section01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static chapter12.section01.StaticTestData.*;

public class CollectionMethodsTest {

    public static void main(String[] args) {
        // Adding Elements We can add new tasks to the schedule:
        mondayTasks.add(new PhoneTask("Ruth", "567 1234"));
        assert mondayTasks.toString().equals("[code logic, phone Mike, phone Ruth]");

        // or we can combine schedules together:
        Collection<Task> allTasks = new ArrayList<Task>(mondayTasks);
        allTasks.addAll(tuesdayTasks);
        assert allTasks.toString().equals("[code logic, phone Mike, phone Ruth, code db, code gui, phone Paul]");

        // Removing Elements When a task is completed, we can remove it from a schedule:
        boolean wasPresent = mondayTasks.remove(mikePhone);
        assert wasPresent;
        assert mondayTasks.toString().equals("[code logic, phone Ruth]");

        // and we can clear a schedule out altogether because all of its tasks have been done (yeah, right):
        mondayTasks.clear();
        assert mondayTasks.toString().equals("[]");

        // The removal methods also allow us to combine entire collections in various ways.
        // For example, to see which tasks other than phone calls are scheduled for Tuesday, we can write:
        Collection<Task> tuesdayNonphoneTasks = new ArrayList<Task>(tuesdayTasks);
        tuesdayNonphoneTasks.removeAll(phoneTasks);
        assert tuesdayNonphoneTasks.toString().equals("[code db, code gui]");

        // or to see which phone calls are scheduled for that day:
        Collection<Task> phoneTuesdayTasks = new ArrayList<Task>(tuesdayTasks);
        phoneTuesdayTasks.retainAll(phoneTasks);
        assert phoneTuesdayTasks.toString().equals("[phone Paul]");
        // This last example can be approached differently to achieve the same result:
        Collection<PhoneTask> tuesdayPhoneTasks = new ArrayList<PhoneTask>(phoneTasks);
        tuesdayPhoneTasks.retainAll(tuesdayTasks);
        assert tuesdayPhoneTasks.toString().equals("[phone Paul]");
        // Note that phoneTuesdayTasks has the type List<Task>, while tuesdayPhoneTasks has the more precise type List<PhoneTask>.

        /* Querying the Contents of a Collection: These methods allow us to check, for example, that the operations above have worked correctly.
           We are going to use assert here to make the system check our belief that we have programmed the previous operations correctly.
           For example the first statement will throw an AssertionError if tuesdayPhoneTasks does not contain paulPhone:*/
        assert tuesdayPhoneTasks.contains(paulPhone);
        assert tuesdayTasks.containsAll(tuesdayPhoneTasks);
        assert mondayTasks.isEmpty();
        assert mondayTasks.size() == 0;

        // Making the Collection Contents Available for Further Processing:
        // throws ConcurrentModificationException
        for (Task t : tuesdayTasks) {
            if (t instanceof PhoneTask) {
                tuesdayTasks.remove(t);
            }
        }

        // Using an iterator explicitly is no improvement if you still use the Collection methods that modify the structure:
        // throws ConcurrentModificationException
        for (Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext(); ) {
            Task t = it.next();
            if (t instanceof PhoneTask) {
                tuesdayTasks.remove(t);
            }
        }

        // But using the iterator’s structure-changing methods gives the result we want:
        for (Iterator<Task> it = tuesdayTasks.iterator(); it.hasNext(); ) {
            Task t = it.next();
            if (t instanceof PhoneTask) {
                it.remove();
            }
        }
    }
}