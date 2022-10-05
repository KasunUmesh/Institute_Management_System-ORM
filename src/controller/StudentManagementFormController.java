package controller;

import animatefx.animation.*;
import business.BOFactory;
import business.BOType;
import business.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
    public JFXTextField txtFullName;
    public JFXTextField txtStudentId;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNumber;
    public JFXDatePicker dpBirthday;
    public JFXTextField txtregDate;
    public JFXTextField txtNic;
    public JFXComboBox cmbProgramID;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFree;
    public JFXComboBox cmbGender;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize() {

        pnStudentRegister.setVisible(false);
        pnStudentProgramDetails.setVisible(false);
        pnStudentDetails.setVisible(true);
        btnStudentDetails.setDisable(true);
        btnStudentProgramDetails.setDisable(false);

        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

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

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtStudentId.getText();
        String name = txtFullName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();
        String contact = txtContactNumber.getText();
        String birthday = String.valueOf(dpBirthday.getValue());
        String gender = (String) cmbGender.getValue();
        String regDate = txtregDate.getText();

        if (studentBO.add(new StudentDTO(
                id,
                name,
                address,
                nic,
                contact,
                birthday,
                gender,
                regDate
        ))){
            txtStudentId.setText(null);
            txtFullName.setText(null);
            txtAddress.setText(null);
            txtNic.setText(null);
            txtContactNumber.setText(null);
            dpBirthday.setValue(null);
            cmbGender.setValue(null);
            txtregDate.setText(null);
            new Alert(Alert.AlertType.INFORMATION, "Added...!").show();
        }

    }
}
