package ua.edu.npu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AppController {

    @FXML
    Button button;

    @FXML
    Label label;

    public void click(ActionEvent actionEvent) {
        label.setText("Done!");
    }
}
