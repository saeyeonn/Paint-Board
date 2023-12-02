package domain.panel;

import domain.box.BoldTypeBox;
import domain.box.LineTypeBox;
import domain.box.TextBox;
import domain.box.TextCheckBoxForm;
import domain.button.Button;
import domain.button.Buttons;
import domain.label.TextLabel;
import domain.spinner.TextSpinnerForm;
import repository.ButtonRepository;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ToolBar extends JToolBar{
    private final JPanel panel;

    public ToolBar() {
        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setPreferredSize(new Dimension(190, 300));
        toolbarPanel.setBackground(new Color(222, 237, 239));
        toolbarPanel.setLayout(new FlowLayout());

        Buttons buttonList = Buttons.create("src/resource/toolBar");
        List<Button> buttons = buttonList.getButtons();
        ButtonRepository.getInstance().addAll(buttons);

        for (Button button : buttons) {
            if (button.getName().equals("16_reset") || button.getName().equals("17_line")) {
                toolbarPanel.add(Box.createVerticalStrut(1));
            } else if (button.getName().equals("21_lineEraser")) {
                toolbarPanel.add(Box.createVerticalStrut(50));
                toolbarPanel.add(TextLabel.getLineTypeLabel());

                LineTypeBox lineType = LineTypeBox.create();
                toolbarPanel.add(lineType.getBox());
                toolbarPanel.add(TextLabel.getLineBoldLabel());

                BoldTypeBox boldType = BoldTypeBox.create();
                toolbarPanel.add(boldType.getBox());
                toolbarPanel.add(Box.createVerticalStrut(50));
            }
            toolbarPanel.add(button);
        }

        toolbarPanel.add(Box.createVerticalStrut(50));

        TextBox text = TextBox.create();
        JComboBox<String> textType = text.getBox();
        toolbarPanel.add(textType);
        toolbarPanel.add(Box.createHorizontalStrut(2));
        toolbarPanel.add(TextSpinnerForm.getFontSizeSpinner());
        toolbarPanel.add(Box.createHorizontalStrut(5));
        toolbarPanel.add(TextCheckBoxForm.getFontBoldBox());
        toolbarPanel.add(TextCheckBoxForm.getFontUnderLineBox());
        this.panel = toolbarPanel;


    }


    public static ToolBar create() {
        return new ToolBar();
    }

    public JPanel getPanel() {
        return panel;
    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // Set and Display Color List External Box line
        int colStartX = 20, colStartY = 44, colWidth = 120, colHeight = 118;
        int colArcWidth = 7, colArcHeight = 7;

        Graphics2D g= (Graphics2D) graphics;
        graphics.setColor(Color.BLACK);
        (g).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(colStartX, colStartY, colWidth, colHeight, colArcWidth, colArcHeight);

        // Set and Display Shape List External Box Line
        int shpStartX = 20, shpStartY = 170, shpWidth = 160, shpHeight = 40;
        int shpArcWidth = 7, shpArcHeight = 7;

        graphics.setColor(Color.BLACK);
        (g).setStroke(new BasicStroke(1));
        graphics.drawRoundRect(shpStartX, shpStartY, shpWidth, shpHeight, shpArcWidth, shpArcHeight);
    }
}
