package ua.edu.sumdu.j2se.SkidanSergey.tasks;

public class LinkedTaskList extends TaskList {

    private Node first;
    private Node last;
    private int size = 0;

    public LinkedTaskList() {
        first = new Node(null, null, last);
        last = new Node(null, first, null);
    }

    @Override
    public Task getTask(int index) {
        Node target = first.next;
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.task;
    }

    private Node getNextElement(Node current) {
        return current.next;
    }

    @Override
    public void add(Task task) {
        if (task == null) {
            throw new NullPointerException("Task is NULL");
        } else {
            Node prev = last;
            prev.task = task;
            last = new Node(null, prev, null);
            prev.next = last;
            prev.prev.next = prev;
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node {
        Task task;
        Node next;
        Node prev;

        Node(Task receivedTask, Node prev, Node next) {
            this.task = receivedTask;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public boolean remove(Task task) {
    boolean flag = false;
        if (task == null) {
            throw new NullPointerException("Element must be not empty");
        } else {
            Node target = first.next;
            for (int i= 0;i < size; i++ ){
                if (target.task.equals(task)){

                    if(target.prev != null) target.prev.next = target.next;
                    if (target.next != null) target.next.prev = target.prev;

                    target.task = null;
                    size--;
                    flag = true;
                    break;
                }
                target = getNextElement(target);
            }
            return flag;
        }
    }
}
