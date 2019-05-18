package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class MapJsonToModelUtils {
    private String value;
    public  MapJsonToModelUtils(String value){
        this.value = value;
    }
    public static MapJsonToModelUtils of(BufferedReader reader){
        StringBuilder json = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) !=null){
                json.append(line);
            }
        }catch (IOException e){
            e.getMessage();
        }
        return new MapJsonToModelUtils(json.toString());
    }
    public  <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value,tClass);
        } catch (IOException e) {
            return null;
        }
    }
}
