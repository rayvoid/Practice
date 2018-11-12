package ua.edu.sumdu.j2se.SkidanSergey.tasks;


public class Task {
    private String currentTittle;
    private int currentTime;
    private int currentEndTime;
    private int currentInterval;
    private boolean isActive;


   public  Task(String title, int time){
        this(title, time, -1, 0);
        isActive = false;
   }
    public  Task(String title, int start, int end, int interval){
        currentTittle = title;
        currentTime = start;
        currentEndTime = end;
        currentInterval = interval;
        isActive = false;
    }

    public  String getTitle(){
       return currentTittle;
    }
    public  void setTitle(String title){
        currentTittle = title;
    }
    public boolean isActive(){
       return isActive;
    }
    public  void setActive(boolean active){
        isActive = active;
    }

    public int getTime(){
       if(!isRepeated()){
           return currentTime;
       }
       else return currentTime;
    }

    public void setTime(int time){
       if (!isRepeated()){
            currentTime = time;
        }
        else{
           currentTime = time;
           currentEndTime = -1;
           currentInterval = 0;
        }
    }

    public int getStartTime(){
        if (isRepeated()){
            return currentTime;
        }
        else{
            return currentTime;
        }
    }

    public int getEndTime(){
        if (isRepeated()){
            return currentEndTime;
        }
        else{
           return currentTime;
        }
    }


    public int getRepeatInterval(){
        if (isRepeated()){
            return currentInterval;
        }
        else{
            return 0;
        }
    }

    public void setTime(int start, int end, int interval){
        currentTime = start;
        currentEndTime = end;
        currentInterval = interval;
       }

    public boolean isRepeated(){
       if (currentEndTime != -1) {return true;}
       else {return false;}
    }

    public int nextTimeAfter(int current){
        if(!isRepeated()){                                                  //NoRepetable
            System.out.println("not repeated");
            if(isActive == true & current < currentTime){
                System.out.println(currentTime);
                return currentTime;
            }
            else {
                return -1;
            }
        }
        else{
            if(isActive == true){
                int nextTime = 0;
                //До этого момента все хорошо!

                //Если CURRENT <= StartTime
                if (current < currentTime){nextTime = currentTime;}

                //Если CURRENT > EndTime
                if (current > currentEndTime){nextTime = -1;}

                //Если CURRENT входит в диапазон
                if (current >= currentTime & current <= currentEndTime){

                    int fullRepeats;
                    int next;

                    fullRepeats = (current - currentTime) / currentInterval;
                    nextTime = currentTime + (currentInterval * (fullRepeats + 1));

                    if (nextTime > currentEndTime) {nextTime = -1;}



                }



            return  nextTime;


            }
            else {
                return -1;
            }



        }
    }

    public void taskInfo(){
       if(currentEndTime == -1){
           System.out.println("\nЗадача: " + currentTittle);
           System.out.println("Повторяемая: " + isRepeated());
           System.out.println("Дата начала: " + timeConverter(currentTime));
           System.out.println("Активная: " + isActive);
       }
       else {
           System.out.println("\nЗадача: " + currentTittle);
           System.out.println("Повторяемая: " + isRepeated());
           System.out.println("Дата начала: " + timeConverter(currentTime));
           System.out.println("Дата окончания: " + timeConverter(currentEndTime));
           System.out.println("Интервал: " + currentInterval / 24 + " день");
           System.out.println("Активная: " + isActive);
       }
    }
    public int getInterval(){
       return currentInterval;
    };

    private String timeConverter(int notConvertedTime){
       int days = notConvertedTime / 24;;
       int hours  = notConvertedTime - days * 24;;

       return days + " числа " + "в " +  hours + ":00";
    }

    public int getCurrentEndTime(){
        return currentEndTime;
    }

}
