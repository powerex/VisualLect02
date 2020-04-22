package ua.edu.npu.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class AppController {

    ToggleGroup group = new ToggleGroup();
    ArrayList<Image> imageList = new ArrayList();

    @FXML
    Button button;

    @FXML
    Label label;

    @FXML
    Label labelRadio;

    @FXML
    ChoiceBox<String> choiceBox;

    @FXML
    Button addButton;

    @FXML
    Button clearButton;

    @FXML
    TextField textOption;

    @FXML
    ComboBox<String> combo;

    @FXML
    RadioButton radio1;

    @FXML
    RadioButton radio2;

    @FXML
    RadioButton radio3;

    @FXML
    ListView<String> list;

    @FXML
    ImageView imageView;

    public void click(ActionEvent actionEvent) {
        String s = choiceBox.getSelectionModel().getSelectedItem();
        label.setText(s);
    }

    public void initialize() {
        label.setText("Loaded...");
        choiceBox.getItems().setAll(FXCollections.observableArrayList("Опція 1", "Опція 2", "Опція 3"));
        choiceBox.getSelectionModel().select(0);

        combo.getItems().addAll("Ванільне", "Шоколадне", "Лимонне");
        combo.getSelectionModel().select(1);

        list.getItems().addAll("Шоколад", "Горіхи", "Джем");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        radio1.setToggleGroup(group);
        radio2.setToggleGroup(group);
        radio3.setToggleGroup(group);

        group.selectedToggleProperty().addListener(radioChange);
        loadPictures();
    }

    public void addOption(ActionEvent actionEvent) {
        if (textOption.getText() != null && !textOption.getText().equals("")) {
            choiceBox.getItems().add(textOption.getText());
        }
    }

    public void clearButton(ActionEvent actionEvent) {
        radio1.selectedProperty().setValue(false);
        radio2.selectedProperty().setValue(false);
        radio3.selectedProperty().setValue(false);
        labelRadio.setText("Зробіть вибір");
    }

    ChangeListener radioChange = new ChangeListener<Toggle>() {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
            if (group.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) group.getSelectedToggle();
                labelRadio.setText("Обрано " + button.getText());
            }
        }
    };

    public void selectToping(MouseEvent mouseEvent) {
        ObservableList<String> selectedItems =  list.getSelectionModel().getSelectedItems();
        for(String s : selectedItems){
            System.out.println("selected item " + s);
        }
    }

    public void comboIce(ActionEvent actionEvent) {
        switch (combo.getSelectionModel().getSelectedIndex()) {
            case 0: imageView.setImage(imageList.get(0)); break;
            case 1: imageView.setImage(imageList.get(1)); break;
            case 2: imageView.setImage(imageList.get(2)); break;
            default: imageView.setImage(imageList.get(0));
        }
    }

    public void loadPictures() {
        imageList.add(new Image("milky_icecream.png"));
        imageList.add(new Image("chocolate_icecream.png"));
        imageList.add(new Image("lemon_icecream.png"));
    }
}
