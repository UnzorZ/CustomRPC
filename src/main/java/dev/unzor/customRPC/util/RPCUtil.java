package dev.unzor.customRPC.util;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class RPCUtil {

    public static final DiscordRichPresence richPresence = new DiscordRichPresence();
    private static final DiscordRPC discordRPC = DiscordRPC.INSTANCE;
    private static Thread thread;

    public static void setPresence() {
        richPresence.details = Constants.firstline;
        richPresence.state = Constants.secondline;
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
