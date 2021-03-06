package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
//import javax.security.auth.callback.Callback;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.Initializable;






public class Controller implements Initializable {




    public  ListView <Task> toDoList;
    public  ListView <Task> doneList;
    public  ListView <Task> progressList;
    public Menu autor;
    public HBox box;
    Stage primaryStage;

    public static ObservableList < Task> data =FXCollections.observableArrayList();
    public static ObservableList < Task> progress =FXCollections.observableArrayList();
    public static ObservableList < Task> done =FXCollections.observableArrayList();

    public static Task task;
    public  static int index;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        toDoList.setItems(data);
        doneList.setItems(done);
        progressList.setItems(progress);


        doneList.setCellFactory(list -> new ColorRectCell()
        );

        toDoList.setCellFactory(list -> new ColorRectCell()
        );
        progressList.setCellFactory(list -> new ColorRectCell()
        );


        Label about = new Label("About");
        about.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information about author");
                alert.setHeaderText("Marcelina Balamut");
                alert.setContentText(null);

                alert.showAndWait();
            }
        });

        autor.setGraphic(about);


        toDoList.setOnKeyPressed(event -> {
                    switch (event.getCode()) {
                        case RIGHT:
                            if (!toDoList.getItems().isEmpty()) {
                                progressList.getItems().add(toDoList.getItems().get(toDoList.getFocusModel().getFocusedIndex()));
                                toDoList.getItems().remove(toDoList.getItems().get(toDoList.getFocusModel().getFocusedIndex()));
                            }
                            break;
                    }
                }
        );


        progressList.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:

                    if (!progressList.getItems().isEmpty()) {
                        doneList.getItems().add(progressList.getItems().get(progressList.getFocusModel().getFocusedIndex()));
                        progressList.getItems().remove(progressList.getItems().get(progressList.getFocusModel().getFocusedIndex()));
                    }
                    break;
                case LEFT:
                    if (!progressList.getItems().isEmpty()) {
                        toDoList.getItems().add(progressList.getItems().get(progressList.getFocusModel().getFocusedIndex()));
                        progressList.getItems().remove(progressList.getItems().get(progressList.getFocusModel().getFocusedIndex()));
                    }
                    break;
            }
        });


        doneList.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    if (!doneList.getItems().isEmpty()) {
                        progressList.getItems().add(doneList.getItems().get(doneList.getFocusModel().getFocusedIndex()));
                        doneList.getItems().remove(doneList.getItems().get(doneList.getFocusModel().getFocusedIndex()));
                    }
                    break;
            }
        });


    }



    public void closeApplication(ActionEvent close){
        System.exit(0);

    }



    public void addTask(ActionEvent add) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("sample/AddTask.fxml"));
        Parent rootLayout = loader.load();
        Scene scene = new Scene(rootLayout);
        primaryStage= new Stage();
        primaryStage.setTitle("Add new task");
        primaryStage.setScene(scene);
        AddController.primaryStage=this.primaryStage;
        primaryStage.show();

    }

    public  void close(){
        this.primaryStage.close();
    }




    static class ColorRectCell extends ListCell<Task> {
        private Rectangle getRectangle(){
            Rectangle rect = new Rectangle(7,7);
            rect.setFill(Color.web(getItem().getColor()));
            return rect;
        }

        @Override
        public void updateItem(Task item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
                setTooltip(null);
            }
            else{
                setText(getItem().getTitle());
                setGraphic(getRectangle());
                Tooltip tooltip = new Tooltip();
                tooltip.setText(getItem().getArea());
                setTooltip(tooltip);
            }
        }
    }


    public void deleteItem(ActionEvent actionEvent) {
        if (toDoList.getSelectionModel().getSelectedIndex() >= 0) {
            int index = toDoList.getSelectionModel().getSelectedIndex();
            toDoList.getItems().remove(index);
        }


    }

    public void deleteItemDone(ActionEvent actionEvent) {
        if (doneList.getSelectionModel().getSelectedIndex() >= 0) {
            int index = doneList.getSelectionModel().getSelectedIndex();
            doneList.getItems().remove(index);
        }


    }
    public void deleteItemProgress(ActionEvent actionEvent) {
        if (progressList.getSelectionModel().getSelectedIndex() >= 0) {
            int index = progressList.getSelectionModel().getSelectedIndex();
            progressList.getItems().remove(index);
        }


    }


    public void editItem(ActionEvent actionEvent) throws IOException {
        if (toDoList.getSelectionModel().getSelectedIndex() >= 0) {
             index = toDoList.getSelectionModel().getSelectedIndex();
            //EditController.show(toDoList.getItems().get(index), index);

             task= toDoList.getSelectionModel().getSelectedItem();

          showEdit();

            EditController.choose= 1;

        }
        }



    public void editItemProgress(ActionEvent actionEvent) throws IOException {
        if (progressList.getSelectionModel().getSelectedIndex() >= 0) {
            index = progressList.getSelectionModel().getSelectedIndex();


            task= progressList.getSelectionModel().getSelectedItem();
            showEdit();


            EditController.choose= 2;
        }
    }



    public void editItemDone(ActionEvent actionEvent) throws IOException {
        if (doneList.getSelectionModel().getSelectedIndex() >= 0) {
            index = doneList.getSelectionModel().getSelectedIndex();


            task= doneList.getSelectionModel().getSelectedItem();
            showEdit();


            EditController.choose= 3;

        }
    }
    public void showEdit() throws IOException {

        FXMLLoader loaders = new FXMLLoader();
        loaders.setLocation(this.getClass().getClassLoader().getResource("sample/EditTask.fxml"));
        Parent rootLayout1 = loaders.load();


        Scene scene = new Scene(rootLayout1);
        primaryStage.setTitle("Edit task");
        primaryStage.setScene(scene);
        EditController.primaryStage=this.primaryStage;

        primaryStage.show();

    }







}


