package ua.edu.sumdu.j2se.SkidanSergey.tasks;

public abstract class TaskList{

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public TaskList incoming(int from, int to) {

        TaskList tempArray = new ArrayTaskList();

        for (int i = 0; i < this.size(); i++) {

            if (this.getTask(i) != null) {
                if (this.getTask(i).nextTimeAfter(from) != -1 && this.getTask(i).nextTimeAfter(from) <= to && this.getTask(i).isActive()) {
                    tempArray.add(this.getTask(i));
                }
            }
        }
        return tempArray;
    }
}





































