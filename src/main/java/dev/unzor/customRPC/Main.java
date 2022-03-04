package dev.unzor.customRPC;

import com.formdev.flatlaf.FlatDarculaLaf;
import dev.unzor.customRPC.ui.UserUI;
import dev.unzor.customRPC.util.ConfigUtil;

import javax.swing.*;

public class Main extends JPanel{

    public static void main(String[] args) {
        ConfigUtil.init();

        FlatDarculaLaf.install();
        UserUI ui = new UserUI();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(450, 575);
        frame.setTitle("CustomRPC");
        frame.add(ui);
        frame.setVisible(true);

    }
}
