package controller;

import animatefx.animation.FadeInRight;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * @author : Kasun Umesh
 * @since : 0.1.0
 **/
public class DashBoardFormController {
    public StackPane rootHome;
    public Pane pnProgramManagement;
    public Pane pnStudentManagement;
    public Pane pnHomePage;
    public Button btnHomePage;
    public Button btnStudentManagement;
    public Button btnProgramManagement;

    public void initialize() {

        try {

            StackPane pane = FXMLLoader.load(getClass().getResource("../views/HomePageForm.fxml"));
            rootHome.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }

        pnHomePage.setVisible(true);
        pnStudentManagement.setVisible(false);
        pnProgramManagement.setVisible(false);

    }


    public void btnHomePageOnAction(ActionEvent actionEvent) throws IOException {

        StackPane pane = FXMLLoader.load(getClass().getResource("../views/HomePageForm.fxml"));
        rootHome.getChildren().setAll(pane);
        new FadeInRight(rootHome).play();

        pnHomePage.setVisible(true);
        pnStudentManagement.setVisible(false);
        pnProgramManagement.setVisible(false);

        btnHomePage.setDisable(true);
        btnProgramManagement.setDisable(false);
        btnStudentManagement.setDisable(false);
    }

    public void btnStudentManagementOnAction(ActionEvent actionEvent) throws IOException {

        StackPane pane = FXMLLoader.load(getClass().getResource("../views/StudentManagementForm.fxml"));
        rootHome.getChildren().setAll(pane);
        new FadeInRight(rootHome).play();

        pnStudentManagement.setVisible(true);
        pnProgramManagement.setVisible(false);
        pnHomePage.setVisible(false);

        btnHomePage.setDisable(false);
        btnProgramManagement.setDisable(false);
        btnStudentManagement.setDisable(true);
    }

    public void btnProgramManagementOnAction(ActionEvent actionEvent) throws IOException {

        StackPane pane = FXMLLoader.load(getClass().getResource("../views/ProgramManagementForm.fxml"));
        rootHome.getChildren().setAll(pane);
        new FadeInRight(rootHome).play();

        pnProgramManagement.setVisible(true);
        pnStudentManagement.setVisible(false);
        pnHomePage.setVisible(false);

        btnHomePage.setDisable(false);
        btnProgramManagement.setDisable(true);
        btnStudentManagement.setDisable(false);
    }

}
