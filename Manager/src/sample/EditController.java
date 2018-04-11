package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.Channel;

import static sample.Controller.data;
import static sample.Controller.progress;
import static sample.Controller.done;

public class EditController {



    public ObservableList< String > priorityList = FXCollections.observableArrayList("Low", "Medium", "High");


    public  TextField title;
    public  ComboBox priority;
    public  DatePicker date;
    public   TextArea area;
    public   static int choose;
    public TitledPane editPane;
public static Stage primaryStage;

    public void initialize() {
        priority.setItems(priorityList);

        this.title.setText(Controller.task.getTitle());
        area.setText(Controller.task.getArea());
        priority.setValue(Controller.task.getPriority());
        date.setValue(Controller.task.getDate());
    }


    public void save(ActionEvent event){





        if(choose==1){
            data.remove(Controller.index);
            data.add( Controller.index ,data());
        }
        if(choose ==2){
            progress.remove(Controller.index);
            progress.add( Controller.index ,data());
        }
        if(choose ==3){
            done.remove(Controller.index);
            done.add( Controller.index ,data());
        }

        primaryStage.close();

    }


    public Task data() throws NullPointerException{



                String titles = this.title.getText();

                int day = (this.date.getValue().getDayOfMonth());
                int month = (this.date.getValue().getMonthValue());
                int year = (this.date.getValue().getYear());
                String priorit = (String) this.priority.getValue();
                String areas = this.area.getText();


                return new Task(titles, areas, year, month, day, priorit);




    }

}
