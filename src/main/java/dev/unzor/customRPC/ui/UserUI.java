/*
 * Created by JFormDesigner on Tue Mar 01 23:08:47 CET 2022
 */

package dev.unzor.customRPC.ui;

import dev.unzor.customRPC.util.ConfigUtil;
import dev.unzor.customRPC.util.Constants;
import dev.unzor.customRPC.util.RPCUtil;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class UserUI extends JPanel {
    public UserUI() {
        initComponents();
        warninglabel.setVisible(false);
        FirstLineField.setText(Constants.firstline);
        SecondLineField.setText(Constants.secondline);
        LargeImageField.setText(Constants.largeimagename);
        LargeImageTextField.setText(Constants.largeimagetext);
        SmallImageNameField.setText(Constants.smallimagename);
        SmallImageTextField.setText(Constants.smallimagetext);
        UpdateDelayField.setText(String.valueOf(Constants.updatedelay));
        AppIDField2.setText(Constants.applicationid);
    }

    private void saveConfig(ActionEvent e) throws IOException {

        Constants.firstline = FirstLineField.getText();
        Constants.secondline = SecondLineField.getText();
        Constants.largeimagename = LargeImageField.getText();
        Constants.largeimagetext = LargeImageTextField.getText();
        Constants.smallimagename = SmallImageNameField.getText();
        Constants.smallimagetext = SmallImageTextField.getText();
        Constants.updatedelay = Integer.parseInt(UpdateDelayField.getText());
        Constants.applicationid = AppIDField2.getText();

        ConfigUtil.saveConfig();
    }

    private void start(ActionEvent e) {
        warninglabel.setVisible(false);
        if (FirstLineField.getText().length()>128) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: maximum characters exceeded in First Line");
            return;
        } else if (SecondLineField.getText().length()>128) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: maximum characters exceeded in Second Line");
            return;
        } else if (LargeImageField.getText().length()>32) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: maximum characters exceeded in the Large Image Name");
            return;
        } else if (LargeImageTextField.getText().length()>128) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: maximum characters exceeded in the Large Image Text");
            return;
        } else if (SmallImageNameField.getText().length()>32) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: maximum characters exceeded in the Small Image Name");
            return;
        } else if (SmallImageTextField.getText().length()>128) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: maximum characters exceeded in the Small Image Text");
            return;
        } else if (AppIDField2.getText().isEmpty()) {
            warninglabel.setVisible(true);
            warninglabel.setText("Warning: no application ID");
            return;
        }
        RPCUtil.boot();
        StatusLabel.setText("Status: enabled");
    }
    
    private void stop(ActionEvent e) {
        RPCUtil.terminate();
        StatusLabel.setText("Status: disabled");
    }

    private void Start(ActionEvent e) {
        // TODO add your code here
    }

private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        TitleLabel = new JLabel();
        FirstLineField = new JTextField();
        FirstLineLabel = new JLabel();
        SecondLineLabel = new JLabel();
        SecondLineField = new JTextField();
        LargeImageLabel = new JLabel();
        LargeImageField = new JTextField();
        LargeImageTextLabel = new JLabel();
        LargeImageTextField = new JTextField();
        SmallImageNameLabel = new JLabel();
        SmallImageNameField = new JTextField();
        SubtitleLabel = new JLabel();
        SmallImageTextLabel = new JLabel();
        SmallImageTextField = new JTextField();
        UpdateDelayLabel = new JLabel();
        UpdateDelayField = new JTextField();
        AppIDLabel = new JLabel();
        AppIDField = new JTextField();
        Start = new JButton();
        SaveConfig = new JButton();
        Stop = new JButton();
        StatusLabel = new JLabel();
        App_IDLabel = new JLabel();
        AppIDField2 = new JTextField();
        warninglabel = new JLabel();

        //======== this ========

        //---- TitleLabel ----
        TitleLabel.setText("Custom RPC    ");

        //---- FirstLineLabel ----
        FirstLineLabel.setText("First Line:");

        //---- SecondLineLabel ----
        SecondLineLabel.setText("Second Line:");

        //---- LargeImageLabel ----
        LargeImageLabel.setText("Large Image Name:");

        //---- LargeImageTextLabel ----
        LargeImageTextLabel.setText("Large Image Text:");

        //---- SmallImageNameLabel ----
        SmallImageNameLabel.setText("Small Image Name:");

        //---- SubtitleLabel ----
        SubtitleLabel.setText(" Made By Unzor");

        //---- SmallImageTextLabel ----
        SmallImageTextLabel.setText("Small Image Text:");

        //---- UpdateDelayLabel ----
        UpdateDelayLabel.setText("Update Delay:");

        //---- AppIDLabel ----
        AppIDLabel.setText("App ID:");

        //---- Start ----
        Start.setText("Start");
        Start.addActionListener(e -> {
			Start(e);
			start(e);
		});

        //---- SaveConfig ----
        SaveConfig.setText("Save Config");
        SaveConfig.addActionListener(e -> {
            try {
                saveConfig(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //---- Stop ----
        Stop.setText("Stop");
        Stop.addActionListener(e -> stop(e));

        //---- StatusLabel ----
        StatusLabel.setText("Status: ");

        //---- App_IDLabel ----
        App_IDLabel.setText("App ID: ");

        //---- warninglabel ----
        warninglabel.setText("Warning: ");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(SmallImageTextLabel)
                    .addGap(1872, 1872, 1872))
                .addGroup(layout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(TitleLabel))
                        .addComponent(SubtitleLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(StatusLabel)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(UpdateDelayLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UpdateDelayField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(App_IDLabel)
                            .addGap(18, 18, 18)
                            .addComponent(AppIDField2, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup()
                            .addComponent(SmallImageNameLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Start, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addComponent(SaveConfig, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addComponent(Stop, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup()
                                    .addComponent(SmallImageNameField, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SmallImageTextField, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(FirstLineLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FirstLineField))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(SecondLineLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(SecondLineField))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(LargeImageTextLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LargeImageTextField))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(LargeImageLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LargeImageField, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(warninglabel)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AppIDLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(AppIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(TitleLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SubtitleLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(StatusLabel)))
                    .addGap(46, 46, 46)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(FirstLineLabel)
                        .addComponent(FirstLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SecondLineLabel)
                        .addComponent(SecondLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LargeImageLabel)
                        .addComponent(LargeImageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LargeImageTextLabel)
                        .addComponent(LargeImageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SmallImageNameLabel)
                        .addComponent(SmallImageNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SmallImageTextLabel)
                        .addComponent(SmallImageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(UpdateDelayLabel)
                        .addComponent(AppIDLabel)
                        .addComponent(AppIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(UpdateDelayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(App_IDLabel)
                        .addComponent(AppIDField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(Start)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(SaveConfig)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Stop)
                    .addGap(18, 18, 18)
                    .addComponent(warninglabel)
                    .addContainerGap(23, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel TitleLabel;
    public JTextField FirstLineField;
    private JLabel FirstLineLabel;
    private JLabel SecondLineLabel;
    public JTextField SecondLineField;
    private JLabel LargeImageLabel;
    public JTextField LargeImageField;
    private JLabel LargeImageTextLabel;
    public JTextField LargeImageTextField;
    private JLabel SmallImageNameLabel;
    public JTextField SmallImageNameField;
    private JLabel SubtitleLabel;
    private JLabel SmallImageTextLabel;
    public JTextField SmallImageTextField;
    private JLabel UpdateDelayLabel;
    public JTextField UpdateDelayField;
    private JLabel AppIDLabel;
    public JTextField AppIDField;
    private JButton Start;
    private JButton SaveConfig;
    private JButton Stop;
    private JLabel StatusLabel;
    private JLabel App_IDLabel;
    private JTextField AppIDField2;
    private JLabel warninglabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
