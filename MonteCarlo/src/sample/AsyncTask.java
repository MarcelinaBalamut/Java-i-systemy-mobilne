package sample;

import javafx.concurrent.Task;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class AsyncTask extends Task  {

    private int pointsNumber;
    private GraphicsContext gc;
    private PointListener listener;

    public AsyncTask(int pointsNumber,GraphicsContext gc ){
        this.pointsNumber=pointsNumber;
        this.gc=gc;
    }

    @Override
    protected Object call()  {

        int n = pointsNumber;
        int k = 0; //hits
        for(int i = 0; i < n; ++i) {
            Random random=new Random();
            double x = -8 + (8 +8) * random.nextDouble();
            double y = -8 + (8 +8) * random.nextDouble();

            if(Equation.calc(x,y)) {
                listener.onPointCalculated(new Point(x,y,true,i));
                k++;
            } else {
                listener.onPointCalculated(new Point(x,y,false,i));
            }
            if(i % (pointsNumber/100) == 0) {
                updateProgress(i, pointsNumber); // uaktualnia progres, i -aktualna wartosc postepu, pointnumber-max wartosc popstepu
            }
            if(isCancelled()) break;
        }



        return (16.0*16.0*k/n);

    }

    public void setListener(PointListener listener) {
        this.listener = listener;
    }
}


