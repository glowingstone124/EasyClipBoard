package org.glowingstone;

import org.glowingstone.utils.Device;

import java.util.Optional;
import java.util.Timer;

public class EasyClipBoard {
    public static void main(String[] args){
        start();
    }
    static void start(){
        String version = "1.0";
        System.out.println("EasyClipBoard Version " + version + " Started.");
        if(!Device.check()){
            System.out.println("ERROR: device.json not exist. automatically generate a device.json...");
        }
        Timer timer = new Timer();
        timer.schedule(new ClipBoardListener(), 0, 50);
    }

}
