package ua.edu.sumdu.j2se.SkidanSergey.tasks;

public class ArrayTaskList {
    private final int ARRAY_SIZE = 1;
    private int freeSlot = 0;


    public Task[] array = new Task[ARRAY_SIZE];

    public int size(){

        if(array[0] == null){
            return 0;
        }
        return array.length - 1;
    }

    public Task getTask(int index){
        return array[index];
    }

    public void add(Task task){
        if (array[freeSlot] == null){
            array[freeSlot] = task;
            sizeUp();
        }
    }

    private void sizeUp(){
        Task tempArray[] = new Task[array.length + 1];
        System.arraycopy(array,0,tempArray,0,array.length);
        array = tempArray;
        freeSlot++;
    };

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

    public ArrayTaskList incoming(int from, int to){

        ArrayTaskList tempArrayTaskList = new ArrayTaskList();

        for (int i = 0; i < array.length -1; i++) {

            if (array[i].isActive() != false) {
                if (array[i].isRepeated()) {
                    for (int j = array[i].getStartTime() - 1; j < array[i].getEndTime(); j = j + array[i].getRepeatInterval()) {

                        System.out.println(array[i].getTitle() + ": " + array[i].nextTimeAfter(j));

                        if (array[i].nextTimeAfter(j) > from && array[i].nextTimeAfter(j) <= to) {
                            tempArrayTaskList.add(array[i]);
                            break;
                        }
                    }
                }
                else if (!array[i].isRepeated()) {
                    if(array[i].getTime() > from && array[i].getTime() <= to){
                        System.out.println("Задача: " + array[i].getTitle() + " Добавлена в массив!");
                        tempArrayTaskList.add(array[i]);
                    }
                }
            }
        }

        System.out.println(tempArrayTaskList.size());
        return tempArrayTaskList;
    }
}
