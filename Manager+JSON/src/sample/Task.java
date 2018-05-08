package sample;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    private String title;
    private String area;
    private LocalDate date ;
    private String priority;
    private String color;

    public String getColor() {
        return color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }



    public Task(String title, String area,int year, int month , int day, String priority) {
        this.title = title;
        this.area = area;
        this.date = date.now();
        this.priority = priority;
      this.date = LocalDate.of(year, month, day);

      if(priority == "High"){
          color="red";
      }
        if(priority == "Low"){
            color="black";
        }
        if(priority == "Medium"){
            color="green";
        }


    }

    public String toString(){

        return title;
    }
}