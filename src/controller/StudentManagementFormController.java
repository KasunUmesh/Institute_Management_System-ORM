package controller;

import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * @author : Kasun Umesh
 * @since : 0.1.0
 **/
public class StudentManagementFormController {
    public Pane pnStudentRegister;
    public Pane pnStudentDetails;
    public Pane pnStudentProgramDetails;
    public Button btnStudentDetails;
    public Button btnStudentProgramDetails;
    public StackPane spStudentManagement;

    public void initialize() {

        pnStudentRegister.setVisible(false);
        pnStudentProgramDetails.setVisible(false);
        pnStudentDetails.setVisible(true);
        btnStudentDetails.setDisable(true);
        btnStudentProgramDetails.setDisable(false);
    }

    public void btnStudentRegistorOnAction(ActionEvent actionEvent) {

        pnStudentRegister.setVisible(true);
        pnStudentDetails.setVisible(false);
        pnStudentProgramDetails.setVisible(false);
        new FadeInRight(pnStudentRegister).play();
    }

    public void btnCancelStudentRegistorOnAction(ActionEvent actionEvent) {

        pnStudentRegister.setVisible(false);
        pnStudentProgramDetails.setVisible(false);
        pnStudentDetails.setVisible(true);
    }

    public void btnStudentDetailsOnAction(ActionEvent actionEvent) {

        pnStudentDetails.setVisible(true);
        pnStudentProgramDetails.setVisible(false);
        pnStudentRegister.setVisible(false);
        btnStudentDetails.setDisable(true);
        btnStudentProgramDetails.setDisable(false);
        new ZoomIn(pnStudentDetails).play();

    }

    public void btnStudentProgramDetailsOnAction(ActionEvent actionEvent) {

        pnStudentProgramDetails.setVisible(true);
        pnStudentRegister.setVisible(false);
        pnStudentDetails.setVisible(false);
        btnStudentProgramDetails.setDisable(true);
        btnStudentDetails.setDisable(false);
        new ZoomIn(pnStudentProgramDetails).play();
    }
}
