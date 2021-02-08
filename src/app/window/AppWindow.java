package app.window;

import javax.swing.*;

public class AppWindow extends JFrame {

    private final AppMainPanel mainPanel;

    public AppWindow(String title) {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel = new AppMainPanel();
        setContentPane(mainPanel.getPanel());

        setVisible(true);
        pack();
    }

    //region Class Methods

    public void repaintCanvas() {
        mainPanel.repaintCanvas();
    }

    //endregion

}
