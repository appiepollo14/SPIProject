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
    private SoundModule soundModule;

    private boolean initialized = false;

    public SoundModuleGUI(SoundModule soundModule) {
        nameLabel.setText("Input song name: ");
        buttonApply.addActionListener(this);
        buttonApply.setText("Choose song");
        this.soundModule = soundModule;
        createCheckBoxes(soundModule.getEffectList());
    }

    public JPanel getRootPane() {
        return rootPane;
    }

    public void createCheckBoxes(List<Effect> effects) {

        // Create GridBagConstraints to specify layout properties
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (Effect e : effects) {
            JCheckBox checkBox = new JCheckBox(e.getSoundEffectName());
            checkBox.setText(e.getSoundEffectName());
            checkBox.setVisible(true);
            checkBox.addActionListener(this);
            checkBox.setActionCommand(e.getClass().getName());
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
            if (!initialized) {
                if (!textField1.getText().isEmpty() && !textPane1.getText().isEmpty()) {
                    soundModule.addSongToList(new Song(textField1.getText(), textPane1.getText(), soundModule));
                    textPane1.setText(soundModule.playSong(textField1.getText()));
                    textField1.setEditable(false);
                    textPane1.setEditable(false);
                    initialized = true;
//                    checkBoxDeformation.setVisible(true);
//                    checkBoxDistortion.setVisible(true);
                    buttonApply.setText("Apply effect");
                    buttonApply.setVisible(false);
                } else textPane1.setText("Choose a song name and song lyrics");
            }
            if (initialized) {


                System.out.println(soundModule.playSong(textField1.getText()));

            }
        } else {
            String actionCommand = e.getActionCommand();
            Effect effect;


            // TODO make this better
            try {
                Class<?> effectClass = Class.forName(actionCommand);

                effect = (Effect) effectClass.newInstance();


            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }

            //TODO make this work.
            // TODO implementation of singleton is an issue
            // TODO echo implementation is incorrect as songtext stays "Test"
            Object source = e.getSource();
            if (source instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) source;
                if (checkBox.isSelected()) {
                    soundModule.addEffectToSong(textField1.getText(), effect);
                } else if (!checkBox.isSelected()) {
                    soundModule.removeEffectFromSong(textField1.getText(), effect);
                }
            }

        }
    }
}
