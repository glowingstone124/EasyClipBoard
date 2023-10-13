package org.glowingstone;

import org.glowingstone.utils.Device;
import org.glowingstone.utils.Request;
import org.json.JSONObject;

import java.sql.Timestamp;

public class ClipboardDataPoster {
    public static boolean Post(String content, String post) throws Exception{
        long currentTimeMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        JSONObject clipboardObj = new JSONObject();
        clipboardObj.put("timestamp", timestamp.toString());
        clipboardObj.put("content", content);
        clipboardObj.put("device", Device.getDevice());
        Request.sendPostRequest(clipboardObj.toString(), Device.getPostApi());
        return true;
    }
}
