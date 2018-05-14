package com.javaapp.springboot;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.sun.jdi.ByteType;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;

import java.awt.*;

import static org.springframework.http.MediaType.IMAGE_PNG;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
public class Controller {

    ImageController imageController= new ImageController();



    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public String addImage(HttpServletRequest requestEntity) throws Exception { // HttpServletRequest informacje o żądaniu klienta
       int id= imageController.setImage(requestEntity.getInputStream());
        return "ID" +id;
    }

    @RequestMapping( path="/image/{id}", method = RequestMethod.DELETE)
    public String deleteImage(@PathVariable int id) {
       int deletedID= imageController.deleteImage(id);
        return "Deleted " + deletedID  ;
    }

    @RequestMapping(path = "/image/gray/{id}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String getGrayImage(@PathVariable int id) throws Exception {
        JSONObject size=imageController.getGrayImage(id);
        return  "Size "+ size;
    }


    @RequestMapping(path = "/image/histogram/{id}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String getGHistogramImage(@PathVariable int id) throws Exception {
        JSONObject histogram=imageController.getHistogramImage(id);
        return  "Histogram "+ histogram;
    }

    @RequestMapping(path = "/image/crop/{id}/{start}/{stop}/{height}/{weight}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public   byte[] getCropImage(@PathVariable int id, @PathVariable("start") int start, @PathVariable("stop") int stop, @PathVariable("height") int heigth, @PathVariable("weight") int weight) throws Exception {
        byte[] crop=imageController.getCropImage(id, start, stop, heigth, weight);
        return   crop;
    }

}
