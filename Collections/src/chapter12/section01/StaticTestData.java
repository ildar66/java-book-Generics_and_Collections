package chapter12.section01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * We’ve chosen ArrayList as the implementation of Collection to use in this example,
 * but we’re not going to take advantage of any of the special properties of lists;
 * we’re treating Array List as an implementation of Collection and nothing more.
 * As part of the retrieval process, we have organized the tasks into various categories represented by lists,
 * using the methodCollections.addAll introduced in chapter01.4.
 */
public class StaticTestData {

    public static PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
    public static PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
    public static CodingTask databaseCode = new CodingTask("db");
    public static CodingTask interfaceCode = new CodingTask("gui");
    public static CodingTask logicCode = new CodingTask("logic");

    public static Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
    public static Collection<CodingTask> codingTasks = new ArrayList<CodingTask>();
    public static Collection<Task> mondayTasks = new ArrayList<Task>();
    public static Collection<Task> tuesdayTasks = new ArrayList<Task>();

    static {
        Collections.addAll(phoneTasks, mikePhone, paulPhone);
        Collections.addAll(codingTasks, databaseCode, interfaceCode, logicCode);
        Collections.addAll(mondayTasks, logicCode, mikePhone);
        Collections.addAll(tuesdayTasks, databaseCode, interfaceCode, paulPhone);
        assert phoneTasks.toString().equals("[phone Mike, phone Paul]");
        assert codingTasks.toString().equals("[code db, code gui, code logic]");
        assert mondayTasks.toString().equals("[code logic, phone Mike]");
        assert tuesdayTasks.toString().equals("[code db, code gui, phone Paul]");
    }

    public static void main(String[] args) {
        new StaticTestData();
    }
}