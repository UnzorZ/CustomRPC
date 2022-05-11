package dev.unzor.customRPC.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        configObject.addProperty("SequenceFirstLine", Constants.sequencefirstline);
        configObject.addProperty("SequenceSecondLine", Constants.sequencesecondline);
        configObject.addProperty("SequenceLargeImageName", Constants.sequencesecondline);
        configObject.addProperty("SequenceLargeImageText", Constants.sequencelargeimagetext);
        configObject.addProperty("SequenceSmallImageName", Constants.sequencesmallimagename);
        configObject.addProperty("SequenceSmallImageText", Constants.sequencesmallimagetext);
        configObject.addProperty("DelaySequenceFirstLine", Constants.delaysequencefirstline);
        configObject.addProperty("DelaySequenceSecondLine", Constants.delaysequencesecondline);
        configObject.addProperty("DelaySequenceLargeImageName", Constants.delaysequencelargeimagename);
        configObject.addProperty("DelaySequenceLargeImageText", Constants.delaysequencelargeimagetext);
        configObject.addProperty("DelaySequenceSmallImageText", Constants.delaysequencesmallimagetext);
        configObject.addProperty("DelaySequenceSmallImageName", Constants.delaysequencesmallimagename);
        configObject.addProperty("Timer", Constants.timerunning);

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
        Constants.sequencefirstline = configObject.get("SequenceFirstLine").getAsBoolean();
        Constants.sequencesecondline = configObject.get("SequenceSecondLine").getAsBoolean();
        Constants.sequencelargeimagename = configObject.get("SequenceLargeImageName").getAsBoolean();
        Constants.sequencelargeimagetext = configObject.get("SequenceLargeImageText").getAsBoolean();
        Constants.sequencesmallimagename = configObject.get("SequenceSmallImageName").getAsBoolean();
        Constants.sequencesmallimagetext = configObject.get("SequenceSmallImageText").getAsBoolean();
        Constants.delaysequencefirstline = configObject.get("DelaySequenceFirstLine").getAsInt();
        Constants.delaysequencesecondline = configObject.get("DelaySequenceSecondLine").getAsInt();
        Constants.delaysequencelargeimagename = configObject.get("DelaySequenceLargeImageName").getAsInt();
        Constants.delaysequencelargeimagetext = configObject.get("DelaySequenceLargeImageText").getAsInt();
        Constants.delaysequencesmallimagetext = configObject.get("DelaySequenceSmallImageText").getAsInt();
        Constants.delaysequencesmallimagename = configObject.get("DelaySequenceSmallImageName").getAsInt();
        Constants.timerunning = configObject.get("Timer").getAsBoolean();
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
