package chapter13.section02;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import chapter12.section01.EmptyTask;
import chapter12.section01.Task;

import static chapter12.section01.StaticTestData.*;

public class SortedSetTest {

    public static void main(String[] args) {
        // 1:
        Set<Task> naturallyOrderedTasks = new TreeSet<Task>(mondayTasks);
        naturallyOrderedTasks.addAll(tuesdayTasks);
        assert naturallyOrderedTasks.toString().equals("[code db, code gui, code logic, phone Mike, phone Paul]");

        // 2:
        NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
        priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
        priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
        priorityTasks.add(new PriorityTask(databaseCode, Priority.MEDIUM));
        priorityTasks.add(new PriorityTask(interfaceCode, Priority.LOW));
        assert (priorityTasks.toString()).equals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM, code gui: LOW]");

        // 3:
        PriorityTask firstLowPriorityTask = new PriorityTask(new EmptyTask(), Priority.LOW);
        SortedSet<PriorityTask> highAndMediumPriorityTasks = priorityTasks.headSet(firstLowPriorityTask);
        assert highAndMediumPriorityTasks.toString().equals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM]");

        // 4:
        PriorityTask firstMediumPriorityTask = new PriorityTask(new EmptyTask(), Priority.MEDIUM);
        SortedSet<PriorityTask> mediumPriorityTasks = priorityTasks.subSet(firstMediumPriorityTask, firstLowPriorityTask);
        assert mediumPriorityTasks.toString().equals("[code db: MEDIUM, phone Mike: MEDIUM]");

        // 5:
        PriorityTask logicCodeMedium = new PriorityTask(logicCode, Priority.MEDIUM);
        priorityTasks.add(logicCodeMedium);
        assert mediumPriorityTasks.toString().equals("[code db: MEDIUM, code logic: MEDIUM, phone Mike: MEDIUM]");

        // 6:
        mediumPriorityTasks.remove(logicCodeMedium);
        assert priorityTasks.toString().equals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM, code gui: LOW]");

        // 7:
        PriorityTask nextTask = priorityTasks.pollFirst();
        assert nextTask.toString().equals("phone Paul: HIGH");

        // 8:
        PriorityTask mikePhoneMedium = new PriorityTask(mikePhone, Priority.MEDIUM);
        NavigableSet closedInterval = priorityTasks.subSet(firstMediumPriorityTask, true, mikePhoneMedium, true);
        assert (closedInterval.toString()).equals("[code db: MEDIUM, phone Mike: MEDIUM]");
    }
}