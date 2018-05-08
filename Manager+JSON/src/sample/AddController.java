package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;


import static sample.Controller.data;



public class AddController  {



   public ObservableList< String > priorityList = FXCollections.observableArrayList("Low", "Medium", "High");


    public  TextField title;
    public  ComboBox priority;
    public  DatePicker date;
    public  TextArea area;
    public TitledPane addPane;
    public static Stage primaryStage;

    public void initialize() {
        priority.setItems(this.priorityList);


    }




    public void taskAdd(ActionEvent add) throws NullPointerException{

        try{

            if (title.getText().equals("") || priority.getSelectionModel().isEmpty() || date.getValue() == null) {


                throw new NullPointerException();

            }
            else {
                String titles = title.getText();

                int day = (this.date.getValue().getDayOfMonth());
                int month = (this.date.getValue().getMonthValue());
                int year = (this.date.getValue().getYear());
                String priorit = (String) this.priority.getValue();
                String areas = this.area.getText();

                data.add(new Task(titles, areas, year, month, day, priorit));
                primaryStage.close();
            }

        }
        catch (NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText(" Complete all data ");
           alert.show();
        }






    }
}
