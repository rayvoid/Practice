package ua.edu.sumdu.j2se.SkidanSergey.tasks;

public class ArrayTaskList extends TaskList{

    private final int ARRAY_SIZE = 1;
    private int freeSlot = 0;
    public Task[] array = new Task[ARRAY_SIZE];

    @Override
    public void add(Task task){
        if (array[freeSlot] == null){
            array[freeSlot] = task;
            sizeUp();
        }
    }

    @Override
    public boolean remove(Task task) {
        boolean flag = false;
        boolean isInTaskArray = false;

        if (freeSlot != 0){
            for (int i = 0; i < array.length -1; i++){
                if (array[i].equals(task)){
                    array[i] = null;
                    isInTaskArray = true;
                    break;
                }

            }
            if (isInTaskArray){
                Task tempArray[] = new Task[freeSlot];
                int t = 0;
                for(int j = 0; j < array.length; j++){
                    if (array[j] != null){
                        tempArray[t] = array[j];
                        t++;
                    }
                }
                array = tempArray;
                freeSlot--;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public int size(){

        if(array[0] == null){
            return 0;
        }
        return array.length - 1;
    }

    @Override
    public Task getTask(int index){
        return array[index];
    }

    private void sizeUp(){
        Task tempArray[] = new Task[array.length + 1];
        System.arraycopy(array,0,tempArray,0,array.length);
        array = tempArray;
        freeSlot++;
    }
}
