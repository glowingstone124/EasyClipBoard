package org.glowingstone.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Device {
    public static final Path DEVICE_PATH = Path.of("device.json");
    public static String getDevice(){
        try {
            JSONObject deviceOBJ = new JSONObject(Files.readString(DEVICE_PATH));
            return deviceOBJ.getString("deviceid");
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean check(){
        File file = new File(String.valueOf(DEVICE_PATH));
        boolean returnvalue = false;
        if (file.exists()) {
            returnvalue = true;
            return returnvalue;
        } else {
            return returnvalue;
        }
    }
    public static void generate() throws IOException {
        File file = new File(String.valueOf(DEVICE_PATH));
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        JSONObject deviceobj = new JSONObject();
        deviceobj.put("deviceid", generateDeviceid());
        deviceobj.put("PostSource", "localhost:8080/postclipboard");
        deviceobj.put("GetSource", "localhost:8080/getclipboard");
        writer.write(deviceobj.toString());
        writer.close();
    }
    private static String generateDeviceid() {
        int charCount = 64; // Number of characters in the generated text
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Letters

        StringBuilder randomText = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < charCount; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);

            randomText.append(randomChar);
        }

        return randomText.toString();
    }
    public static String getPostApi(){
        try {
            JSONObject deviceOBJ = new JSONObject(Files.readString(DEVICE_PATH));
            return deviceOBJ.getString("PostSource");
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getGetApi(){
        try {
            JSONObject deviceOBJ = new JSONObject(Files.readString(DEVICE_PATH));
            return deviceOBJ.getString("GetSource");
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
