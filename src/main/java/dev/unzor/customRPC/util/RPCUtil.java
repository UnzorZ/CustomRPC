package dev.unzor.customRPC.util;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RPCUtil {

    public static final DiscordRichPresence richPresence = new DiscordRichPresence();
    private static final DiscordRPC discordRPC = DiscordRPC.INSTANCE;
    private static Thread thread;


    public static String[] secondline = Constants.secondline.split(";");



    static Thread threadsecondline = new Thread(() -> {
        for (int i=0; i<secondline.length; i++) {
            richPresence.state = secondline[i];
            try {
                Thread.sleep(Constants.delaysequencesecondline);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i==secondline.length-1) {
                i=-1;
            }
        }});


    public static void setPresence() {
        if (Constants.sequencefirstline) {
            Thread threadfirstline = new Thread(() -> {
                String[] firstline = Constants.firstline.split(";");
                for (int i=0; i<firstline.length; i++) {
                    System.out.println(firstline[i]);
                    richPresence.details = firstline[i];
                    try {
                        Thread.sleep(Constants.delaysequencefirstline);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (i==firstline.length-1) {
                        i=-1;
                    }
                }}); threadfirstline.start();
        } else richPresence.details = Constants.firstline;

        if (Constants.sequencesecondline)
            threadsecondline.start();
        else richPresence.state = Constants.secondline;



        richPresence.largeImageKey = Constants.largeimagename;
        richPresence.largeImageText = Constants.largeimagetext;
        richPresence.smallImageKey = Constants.smallimagename;
        richPresence.smallImageText = Constants.smallimagetext;
    }

    public static void boot() {
        System.out.println("Starting RPC");
        DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
        discordRPC.Discord_Initialize(Constants.applicationid, eventHandlers, true, "");
        richPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        setPresence();
        discordRPC.Discord_UpdatePresence(richPresence);
        thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                discordRPC.Discord_RunCallbacks();
                setPresence();
                discordRPC.Discord_UpdatePresence(richPresence);
                try { Thread.sleep(Constants.updatedelay); } catch (Exception ignored) {}
            }
        }, "RPC-Callback-Handler");
        thread.start();
    }

    public static void terminate() {
        System.out.println("Terminating RPC");
        if(thread != null && !thread.isInterrupted())
            thread.interrupt();

        discordRPC.Discord_Shutdown();
    }




}
