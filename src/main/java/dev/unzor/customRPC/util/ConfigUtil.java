package dev.unzor.customRPC.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigUtil {
    private static final Path configPath = Paths.get("config.json");
    private static final File configFile = configPath.toFile();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveConfig() throws IOException {
        JsonObject configObject = new JsonObject();
        configObject.addProperty("ApplicationID", Constants.applicationid);
        configObject.addProperty("UpdateDelay", Constants.updatedelay);
        configObject.addProperty("FirstLine", Constants.firstline);
        configObject.addProperty("SecondLine", Constants.secondline);
        configObject.addProperty("LargeImageName", Constants.largeimagename);
        configObject.addProperty("LargeImageText", Constants.largeimagetext);
        configObject.addProperty("SmallImageName", Constants.smallimagename);
        configObject.addProperty("SmallImageText", Constants.smallimagetext);
        configObject.addProperty("StartTimestamp", Constants.startTimestamp);

        OutputStreamWriter fileOutputStreamWriter = new OutputStreamWriter(Files.newOutputStream(configFile.toPath()));
        fileOutputStreamWriter.write(gson.toJson(configObject));
        fileOutputStreamWriter.flush();
        fileOutputStreamWriter.close();
    }

    public static void loadConfig() throws IOException {
        InputStreamReader reader = new InputStreamReader(Files.newInputStream(configFile.toPath()));
        JsonObject configObject = gson.fromJson(reader,JsonObject.class);
        Constants.applicationid = configObject.get("ApplicationID").getAsString();
        Constants.updatedelay = configObject.get("UpdateDelay").getAsInt();
        Constants.firstline = configObject.get("FirstLine").getAsString();
        Constants.secondline = configObject.get("SecondLine").getAsString();
        Constants.largeimagename = configObject.get("LargeImageName").getAsString();
        Constants.largeimagetext = configObject.get("LargeImageText").getAsString();
        Constants.smallimagename = configObject.get("SmallImageName").getAsString();
        Constants.smallimagetext = configObject.get("SmallImageText").getAsString();
        Constants.startTimestamp = configObject.get("StartTimestamp").getAsInt();
    }


    public static void init(){
        if(configFile.exists()){
            try {
                loadConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                saveConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
