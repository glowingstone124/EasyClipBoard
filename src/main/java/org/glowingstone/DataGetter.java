package org.glowingstone;

import org.glowingstone.utils.Device;
import org.glowingstone.utils.Request;
import org.json.JSONObject;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.TimerTask;

public class DataGetter extends TimerTask {
    @Override
    public void run() {
        JSONObject getObj = null;
        try {
            getObj = new JSONObject(Request.sendGetRequest(Device.getGetApi()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (getObj.getInt("code") == 0){
            String newText = getObj.getString("content");
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selection = new StringSelection(newText);
            clipboard.setContents(selection, null);
        }
    }
}
