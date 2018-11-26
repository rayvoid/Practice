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
        if(!isRepeated()){
            if(isActive & current < currentTime){
                return currentTime;
            }
            else {
                return -1;
            }
        }
        else{
            if(isActive){
                int nextTime = 0;
                if (current < currentTime){
                    nextTime = currentTime;
                }
                if (current > currentEndTime){nextTime = -1;}
                if (current >= currentTime & current <= currentEndTime){
                    int fullRepeats;
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
}
