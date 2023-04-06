package nl.avasten;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoundModuleGUI implements ActionListener {
    private JPanel rootPane;
    private JButton buttonApply;
    private JTextPane textPane1;
    private JPanel OptionPanel;
    private JTextField textField1;
    private JLabel nameLabel;
    private JCheckBox checkBoxDeformation;
    private JCheckBox checkBoxDistortion;
    private SoundModule soundModule;
    private JCheckBox jCheckBox;

    private boolean intitialized = false;

    public SoundModuleGUI(SoundModule soundModule) {
        checkBoxDeformation.setText("Deformation");
        checkBoxDistortion.setText("Distortion");
        nameLabel.setText("Input song name: ");
        buttonApply.addActionListener(this);
        checkBoxDeformation.setVisible(false);
        checkBoxDistortion.setVisible(false);
        buttonApply.setText("Choose song");
        this.soundModule = soundModule;
        checkBoxDistortion.addActionListener(this);
        checkBoxDeformation.addActionListener(this);
    }

    public JPanel getRootPane() {
        return rootPane;
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
                    checkBoxDeformation.setVisible(true);
                    checkBoxDistortion.setVisible(true);
                    buttonApply.setText("Apply effect");
                    buttonApply.setVisible(false);
                } else textPane1.setText("Choose a song name and song lyrics");
            }
            if (intitialized) {


                System.out.println(soundModule.playSong(textField1.getText()));

            }
        }
        if (e.getSource() == checkBoxDistortion) {
            if (checkBoxDistortion.isSelected()) {
                soundModule.addEffectToSong(textField1.getText(), Distortion.getInstance());

            } else if (!checkBoxDistortion.isSelected()) {
                soundModule.removeEffectFromSong(textField1.getText(), Distortion.getInstance());
            }

        }
        if (e.getSource() == checkBoxDeformation) {
            if (checkBoxDeformation.isSelected()) {
                soundModule.addEffectToSong(textField1.getText(), Deformation.getInstance());
            } else if (!checkBoxDeformation.isSelected()) {
                soundModule.removeEffectFromSong(textField1.getText(), Deformation.getInstance());
            }
        }
    }
}
