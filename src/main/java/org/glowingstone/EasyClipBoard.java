package org.glowingstone;

import org.glowingstone.utils.Device;

import java.io.IOException;
import java.util.Timer;

public class EasyClipBoard {
    public static void main(String[] args) throws IOException {
        start();
    }
    static void start() throws IOException {
        if(!Device.check()){
            System.out.println("ERROR: device.json not exist. automatically generate a device.json...");
        }
        String version = "1.0";
        System.out.println("EasyClipBoard Version " + version + " Started.");
        Timer timer = new Timer();
        timer.schedule(new ClipBoardListener(), 0, 50);
        timer.schedule(new DataGetter(), 0, 50);
    }

}
