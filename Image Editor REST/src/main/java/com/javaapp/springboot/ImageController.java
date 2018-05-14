package com.javaapp.springboot;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundException extends RuntimeException {
        public static final String message = "Id not found";

        public NotFoundException() {
            super(message);
        }
    }




    public Map<Integer, BufferedImage> map = new HashMap<>();
    int id=-1;

    public int setImage(ServletInputStream inputStream) throws IOException {  // strumien wejsciowy do odczytywania danych binarnych


        InputStream  stream = new BufferedInputStream(inputStream);
        BufferedImage image= ImageIO.read(stream); // klasa do kodowania i dekodowania

        BufferedImage bufferedImage= new BufferedImage(image.getWidth(), image.getHeight(),image.TYPE_BYTE_BINARY);
        bufferedImage.createGraphics().drawImage(image, 0, 0 ,null);
        id=id+1;
        map.put(id,bufferedImage);

        return id;
    }

    public int deleteImage(int id)  {

        if(!map.containsKey(id)){
            throw new NotFoundException();
        }
        map.remove(id);
        return id;


    }

    public JSONObject getGrayImage(int id) throws JSONException {
        if(!map.containsKey(id)){
            throw new NotFoundException();
        }
        JSONObject object= new JSONObject();
        object.put("width", map.get(id).getWidth());
        object.put("height", map.get(id).getHeight());
        return  object;
    }

    public JSONObject getHistogramImage(int id) throws JSONException {
        if(!map.containsKey(id)){
            throw new NotFoundException();
        }

        JSONObject histogram= new JSONObject();

     int one=0;
     int zero=0;

        for (int i=0; i<map.get(id).getWidth(); i++){
            for (int j=0; j<map.get(id).getHeight(); j++){

                if(map.get(id).getRGB(i,j)== Color.BLACK.getRGB()){

                    one=one+1;
                }
                else
                    {
                    zero=zero+1;
                }
            }

        }

        histogram.put("Black", one);
        histogram.put("White", zero);
        return histogram;
    }







    public byte[] getCropImage (int id, int start, int stop, int height, int weight) throws IOException {

        if(!map.containsKey(id)){
            throw new NotFoundException();
        }

        if((start + weight) > map.get(id).getWidth()|| (stop + height) > map.get(id).getHeight()) {
            throw new IOException("Wrong data");
        }

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        BufferedImage image=map.get(id).getSubimage(start, stop,weight,height);

        ImageIO.write( image, "jpg", byteArray );
        byteArray.flush(); // opróznia strumiei zapisuej bajty
        byte[] imageInByte = byteArray.toByteArray();
        byteArray.close();
        return  imageInByte;
    }
}
