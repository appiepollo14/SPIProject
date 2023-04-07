package nl.avasten.gui;

import nl.avasten.Effect;
import nl.avasten.SoundModule;
import nl.avasten.song.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SoundModuleGUI implements ActionListener {
    private JPanel rootPane;
    private JButton buttonApply;
    private JTextPane textPane1;
    private JPanel OptionPanel;
    private JTextField textField1;
    private JLabel nameLabel = new JLabel();
    //    private JCheckBox checkBoxDeformation;
//    private JCheckBox checkBoxDistortion;
    private SoundModule soundModule;
//    private JCheckBox jCheckBox;

    private boolean intitialized = false;

    public SoundModuleGUI(SoundModule soundModule) {
//        checkBoxDeformation.setText("Deformation");
//        checkBoxDistortion.setText("Distortion");
        nameLabel.setText("Input song name: ");
        buttonApply.addActionListener(this);
//        checkBoxDeformation.setVisible(false);
//        checkBoxDistortion.setVisible(false);
        buttonApply.setText("Choose song");
        this.soundModule = soundModule;
//        checkBoxDistortion.addActionListener(this);
//        checkBoxDeformation.addActionListener(this);
        createCheckBoxes(soundModule.getEffectList());
    }

    public JPanel getRootPane() {
        return rootPane;
    }

    public void createCheckBoxes(List<Effect> effects) {

        // Create GridBagConstraints to specify layout properties
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Set the starting column to 0
        gbc.gridy = 0; // Set the starting row to 0
        gbc.anchor = GridBagConstraints.WEST; // Align checkboxes to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make checkboxes fill available horizontal space

        for (Effect e : effects) {
            JCheckBox checkBox = new JCheckBox(e.getSoundEffectName());
            checkBox.setText(e.getSoundEffectName());
            checkBox.setVisible(true);
            // Add any additional settings or customization to the checkbox
            // For example, you can set the text, add action listeners, etc.
            OptionPanel.add(checkBox, gbc); // Add the checkbox to your OptionPanel
            gbc.gridy++;
        }
    }

    public void setTextpane(String text) {
        textPane1.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonApply) {
            if (!intitialized) {
                if (!textField1.getText().isEmpty() && !textPane1.getText().isEmpty()) {
                    soundModule.addSongToList(new Song(textField1.getText(), textPane1.getText(), soundModule));
                    textPane1.setText(soundModule.playSong(textField1.getText()));
                    textField1.setEditable(false);
                    textPane1.setEditable(false);
                    intitialized = true;
//                    checkBoxDeformation.setVisible(true);
//                    checkBoxDistortion.setVisible(true);
                    buttonApply.setText("Apply effect");
                    buttonApply.setVisible(false);
                } else textPane1.setText("Choose a song name and song lyrics");
            }
            if (intitialized) {


                System.out.println(soundModule.playSong(textField1.getText()));

            }
        }

//        if (e.getSource() == checkBoxDistortion) {
//            if (checkBoxDistortion.isSelected()) {
//                soundModule.addEffectToSong(textField1.getText(), Distortion.getInstance());
//
//            } else if (!checkBoxDistortion.isSelected()) {
//                soundModule.removeEffectFromSong(textField1.getText(), Distortion.getInstance());
//            }
//
//        }
//        if (e.getSource() == checkBoxDeformation) {
//            if (checkBoxDeformation.isSelected()) {
//                soundModule.addEffectToSong(textField1.getText(), Deformation.getInstance());
//            } else if (!checkBoxDeformation.isSelected()) {
//                soundModule.removeEffectFromSong(textField1.getText(), Deformation.getInstance());
//            }
//        }
    }
}
