import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusTextField implements FocusListener {
    private JTextField text;

    public FocusTextField(JTextField text) {
        this.text = text;
    }

    @Override
    public void focusGained(FocusEvent e) {
        text.select(0, text.getText().length());
        text.setBackground(new Color(72, 94, 130));

    }

    @Override
    public void focusLost(FocusEvent e) {
        text.select(0, 0);
        text.setBackground(new Color(36, 47, 65));
    }
}
