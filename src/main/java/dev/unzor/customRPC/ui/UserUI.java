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
 * @author Unzor
 */
public class UserUI extends JPanel {
    public UserUI() {
        initComponents();
        warninglabel.setVisible(false);
        TimerLabel2.setVisible(false);
        FirstLineField.setText(Constants.firstline);
        SecondLineField.setText(Constants.secondline);
        LargeImageField.setText(Constants.largeimagename);
        LargeImageTextField.setText(Constants.largeimagetext);
        SmallImageNameField.setText(Constants.smallimagename);
        SmallImageTextField.setText(Constants.smallimagetext);
        UpdateDelayField.setText(String.valueOf(Constants.updatedelay));
        AppIDField2.setText(Constants.applicationid);
        sequencefirstline.setSelected(Constants.sequencefirstline);
        sequencesecondline.setSelected(Constants.sequencesecondline);
        sequencelargeimagename.setSelected(Constants.sequencelargeimagename);
        sequencelargeimagetext.setSelected(Constants.sequencelargeimagetext);
        sequencesmallimagename.setSelected(Constants.sequencesmallimagename);
        sequencesmallimagetext.setSelected(Constants.sequencesmallimagetext);
        delayfirstlinefield.setText(String.valueOf(Constants.delaysequencefirstline));
        delaysecondline.setText(String.valueOf(Constants.delaysequencesecondline));
        delaylargeimagename.setText(String.valueOf(Constants.delaysequencelargeimagename));
        delaylargeimagetext.setText(String.valueOf(Constants.delaysequencelargeimagetext));
        delaysmallimageimagename.setText(String.valueOf(Constants.delaysequencesmallimagename));
        delaysmallimagetext.setText(String.valueOf(Constants.delaysequencesmallimagetext));
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
        Constants.sequencefirstline = sequencefirstline.isSelected();
        Constants.sequencesecondline = sequencesecondline.isSelected();
        Constants.sequencesecondline = sequencelargeimagename.isSelected();
        Constants.sequencelargeimagetext = sequencelargeimagetext.isSelected();
        Constants.sequencesmallimagename = sequencesmallimagename.isSelected();
        Constants.sequencesmallimagetext = sequencesmallimagetext.isSelected();
        Constants.delaysequencefirstline = Integer.parseInt(delayfirstlinefield.getText());
        Constants.delaysequencesecondline = Integer.parseInt(delaysecondline.getText());
        Constants.delaysequencelargeimagename = Integer.parseInt(delaylargeimagename.getText());
        Constants.delaysequencelargeimagetext = Integer.parseInt(delaylargeimagetext.getText());
        Constants.delaysequencesmallimagetext = Integer.parseInt(delaysmallimageimagename.getText());
        Constants.delaysequencesmallimagename = Integer.parseInt(delaysmallimagetext.getText());

        ConfigUtil.saveConfig();
    }

    private void start(ActionEvent e) {
        warninglabel.setVisible(false);
        TimerLabel2.setVisible(false);
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
        } else if (Constants.timerunning) {
            TimerLabel2.setVisible(true);
            TimerLabel2.setText("Timer: running");
        } else if (!Constants.timerunning) {
            TimerLabel2.setVisible(false);
        }
        RPCUtil.boot();
        StatusLabel.setText("Status: enabled");
    }
    
    private void stop(ActionEvent e) {
        RPCUtil.terminate();
        StatusLabel.setText("Status: disabled");
    }
    private void forceUpdate(ActionEvent e) {
        System.out.println("Force updated RPC");
        RPCUtil.setPresence();
    }

    private void Timer(ActionEvent e) {
        System.out.println("Timer enabled/disabled");
        if (!Constants.timerunning) {
            Constants.timerunning = true;
            TimerLabel2.setVisible(true);
            TimerLabel2.setText("Timer: running");
            RPCUtil.richPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        } else if (Constants.timerunning) {
            Constants.timerunning = false;
            TimerLabel2.setVisible(false);
            RPCUtil.richPresence.startTimestamp = 0;
        }
    }

private void initComponents() {
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
        Start = new JButton();
        SaveConfig = new JButton();
        Stop = new JButton();
        StatusLabel = new JLabel();
        App_IDLabel = new JLabel();
        AppIDField2 = new JTextField();
        warninglabel = new JLabel();
        sequencefirstline = new JCheckBox();
        delaylabel2 = new JLabel();
        delayfirstlinefield = new JTextField();
        sequencesecondline = new JCheckBox();
        sequencelargeimagename = new JCheckBox();
        sequencelargeimagetext = new JCheckBox();
        sequencesmallimagename = new JCheckBox();
        sequencesmallimagetext = new JCheckBox();
        delaylabel3 = new JLabel();
        delaylabel4 = new JLabel();
        delaylabel5 = new JLabel();
        delaylabel6 = new JLabel();
        delaylabel7 = new JLabel();
        delaysecondline = new JTextField();
        delaylargeimagename = new JTextField();
        delaylargeimagetext = new JTextField();
        delaysmallimageimagename = new JTextField();
        delaysmallimagetext = new JTextField();
        button4 = new JButton();
        TimerButton = new JButton();
        TimerLabel2 = new JLabel();

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

        //---- Start ----
        Start.setText("Start");
        Start.addActionListener(e -> start(e));

        //---- SaveConfig ----
        SaveConfig.setText("Save Config");
        SaveConfig.addActionListener(e -> {
            try {
                saveConfig(e);
            } catch (IOException ex) {
                ex.printStackTrace();
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

        //---- sequencefirstline ----
        sequencefirstline.setText("Sequence");

        //---- delaylabel2 ----
        delaylabel2.setText("Delay:");

        //---- sequencesecondline ----
        sequencesecondline.setText("Sequence");

        //---- sequencelargeimagename ----
        sequencelargeimagename.setText("Sequence");

        //---- sequencelargeimagetext ----
        sequencelargeimagetext.setText("Sequence");

        //---- sequencesmallimagename ----
        sequencesmallimagename.setText("Sequence");

        //---- sequencesmallimagetext ----
        sequencesmallimagetext.setText("Sequence");

        //---- delaylabel3 ----
        delaylabel3.setText("Delay:");

        //---- delaylabel4 ----
        delaylabel4.setText("Delay:");

        //---- delaylabel5 ----
        delaylabel5.setText("Delay:");

        //---- delaylabel6 ----
        delaylabel6.setText("Delay:");

        //---- delaylabel7 ----
        delaylabel7.setText("Delay:");

        //---- button4 ----
        button4.setText("Force Update");
        button4.addActionListener(e -> forceUpdate(e));

        //---- TimerButton ----
        TimerButton.setText("Switch timer mode");
        TimerButton.addActionListener(e -> Timer(e));

        //---- TimerLabel2 ----
        TimerLabel2.setText("Timer:  ");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(272, 272, 272)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(TitleLabel)
                        .addComponent(SubtitleLabel))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Stop, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveConfig, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Start, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(UpdateDelayLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UpdateDelayField, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(App_IDLabel)
                            .addGap(18, 18, 18)
                            .addComponent(AppIDField2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(SecondLineLabel)
                                        .addComponent(FirstLineLabel))
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(FirstLineField))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(SecondLineField))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LargeImageLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LargeImageField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LargeImageTextLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LargeImageTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(SmallImageNameLabel)
                                                .addComponent(SmallImageTextLabel))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(SmallImageTextField, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(SmallImageNameField, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(StatusLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(warninglabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(TimerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(TimerLabel2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sequencelargeimagename)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylargeimagename, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sequencelargeimagetext)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylargeimagetext, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sequencesecondline)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaysecondline, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sequencefirstline)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(delayfirstlinefield, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sequencesmallimagetext)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaysmallimagetext, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(sequencesmallimagename)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaylabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(delaysmallimageimagename, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TitleLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SubtitleLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TimerLabel2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TimerButton))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(warninglabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(StatusLabel)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(FirstLineLabel)
                        .addComponent(sequencefirstline)
                        .addComponent(FirstLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delaylabel2)
                        .addComponent(delayfirstlinefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SecondLineLabel)
                        .addComponent(sequencesecondline)
                        .addComponent(SecondLineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delaylabel3)
                        .addComponent(delaysecondline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LargeImageLabel)
                        .addComponent(sequencelargeimagename)
                        .addComponent(LargeImageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delaylabel4)
                        .addComponent(delaylargeimagename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LargeImageTextLabel)
                        .addComponent(sequencelargeimagetext)
                        .addComponent(LargeImageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delaylabel5)
                        .addComponent(delaylargeimagetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SmallImageNameLabel)
                        .addComponent(sequencesmallimagename)
                        .addComponent(SmallImageNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delaylabel6)
                        .addComponent(delaysmallimageimagename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SmallImageTextLabel)
                        .addComponent(sequencesmallimagetext)
                        .addComponent(SmallImageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(delaylabel7)
                        .addComponent(delaysmallimagetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(UpdateDelayLabel)
                        .addComponent(App_IDLabel)
                        .addComponent(AppIDField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(UpdateDelayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addComponent(Start)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SaveConfig)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(Stop)
                    .addGap(7, 7, 7)
                    .addComponent(button4)
                    .addContainerGap())
        );
    }

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
    private JButton Start;
    private JButton SaveConfig;
    private JButton Stop;
    private JLabel StatusLabel;
    private JLabel App_IDLabel;
    private JTextField AppIDField2;
    private JLabel warninglabel;
    public JCheckBox sequencefirstline;
    private JLabel delaylabel2;
    public JTextField delayfirstlinefield;
    public JCheckBox sequencesecondline;
    public JCheckBox sequencelargeimagename;
    public JCheckBox sequencelargeimagetext;
    public JCheckBox sequencesmallimagename;
    private JCheckBox sequencesmallimagetext;
    private JLabel delaylabel3;
    private JLabel delaylabel4;
    private JLabel delaylabel5;
    private JLabel delaylabel6;
    private JLabel delaylabel7;
    public JTextField delaysecondline;
    public JTextField delaylargeimagename;
    public JTextField delaylargeimagetext;
    public JTextField delaysmallimageimagename;
    public JTextField delaysmallimagetext;
    private JButton button4;
    private JButton TimerButton;
    private JLabel TimerLabel2;
}
