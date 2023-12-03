package window;
import text.FontType;
import text.TextSize;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public class TextSpinnerForm extends JSpinner{
    private static final TextSpinnerForm fontSizeSpinner =
            new TextSpinnerForm(new SpinnerNumberModel(12, 1, 80, 5), 45, 30);

    TextSpinnerForm(SpinnerNumberModel spinnerNumberModel, int width, int height) { //set details
        setPreferredSize(new Dimension(width, height));
        setValue(12);
        addChangeListener(new ChangeDetector());
      }

    private class ChangeDetector implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if (e.getSource() instanceof JSpinner) {
                FontType.FontTypeSetting();
                JSpinner spinner = (JSpinner) e.getSource();
                Object value = spinner.getValue();
                System.out.println("Spinner value changed: " + value);
            }

            TextSize.applySelectedAttributes();
        }
    }

    public static TextSpinnerForm getFontSizeSpinner() {
        return fontSizeSpinner;
    }
}
