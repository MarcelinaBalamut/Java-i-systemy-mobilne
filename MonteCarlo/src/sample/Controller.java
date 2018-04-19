package sample;

import javafx.concurrent.WorkerStateEvent;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;
import java.util.Random;

import static javafx.scene.paint.Color.*;

public class Controller implements PointListener {

//public Equation eq;
    public Canvas canvas;
    public ProgressBar progressBar;
    public Slider slider;
    public Label result;
    public TextField point;
    private AsyncTask task;
    private GraphicsContext gc;
    BufferedImage bi;
    private double hight, width;

    int pointsNumber;



    private void drawShapes(GraphicsContext gc) throws IllegalArgumentException
    {

try {
    gc.setFill(BLUEVIOLET);
    gc.fillRect(gc.getCanvas().getLayoutX(),
            gc.getCanvas().getLayoutY(),
            gc.getCanvas().getWidth(),
            gc.getCanvas().getHeight());
    bi = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);

    if (point.getText().equals("")) {
        pointsNumber = 100000;
    } else {
        pointsNumber = Integer.parseInt(point.getText());
    }
    if (pointsNumber >= 100) {
        progressBar.setVisible(true);
        task = new AsyncTask(pointsNumber, gc);
        task.setListener(this);
        progressBar.progressProperty().bind(task.progressProperty()); // powiazanie kontrolki z watkiem
        new Thread(task).start();
        task.setOnSucceeded(event -> result.setText("result: " + (task.getValue()))); // pobranie z watku danych
    } else {
        gc.setFill(BLUEVIOLET);
        result.setText("");
        progressBar.setVisible(false);

    }
}
catch( IllegalArgumentException e){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");

    alert.setContentText("Wrong data format");

    alert.showAndWait();
    result.setText("");
    progressBar.setVisible(false);
}
    }



    @FXML
    private void handleRunBtnAction(){
        gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        width=(int)gc.getCanvas().getWidth();
        hight=(int)gc.getCanvas().getHeight();


    }
    @FXML
    private void handleStopBtnAction(){
        task.cancel();
    }


    @Override
    public void onPointCalculated(Point event) {
        int a = 1;
        int b = (int)hight - 1;

        int dotX = (int) ((b - a) * (event.getX() +8) / (8 +8) + a);
        int dotY = (int) ((b - a) * (event.getY() +8) / (8 +8) + a);

        dotY =(int) hight - dotY;       // odwrocenie lustrzane

        if(event.isInside())
            bi.setRGB(dotX, dotY, java.awt.Color.YELLOW.getRGB());
        else
            bi.setRGB(dotX, dotY,  java.awt.Color.BLUE.getRGB());
        if(event.getCounter() % (pointsNumber/100) == 0)
            gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0,0 );

    }
}
