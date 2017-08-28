package chapter16.section01;

import java.util.ArrayDeque;
import java.util.EnumMap;
import java.util.Map;
import java.util.Queue;

import chapter12.section01.Task;
import chapter13.section02.Priority;

import static chapter12.section01.StaticTestData.databaseCode;
import static chapter12.section01.StaticTestData.mikePhone;

/**
 * Using the methods of Map example.
 */
public class UsingTheMethodsOfMap {

    public static void main(String[] args) {
        Map<Priority, ArrayDeque<Task>> taskMap = new EnumMap<Priority, ArrayDeque<Task>>(Priority.class);
        for (Priority p : Priority.values()) {
            taskMap.put(p, new ArrayDeque<Task>());
        }
        // populate the lists, for example:
        taskMap.get(Priority.MEDIUM).add(mikePhone);
        taskMap.get(Priority.HIGH).add(databaseCode);

        // Now, to get to one of the task queues—say, the one with the highest-priority tasks— we can write:
        Queue<Task> highPriorityTaskList = taskMap.get(Priority.HIGH);
        // Polling this queue will now give us the high priority to-dos, in the order in which they were entered into the system.
    }
}
