package ru.vsu.cs.volobueva;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.util.Locale;

public class GuiMain {
    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        winMain();
    }
}
