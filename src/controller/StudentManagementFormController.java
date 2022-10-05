package controller;

import animatefx.animation.*;
import business.BOFactory;
import business.BOType;
import business.custom.impl.StudentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import views.tm.StudentTm;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.dom4j.dom.DOMNodeHelper.setData;

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
    public TableView tblStudentDetails;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colStAddress;
    public TableColumn colStBirthday;
    public TableColumn colStGender;
    public TableColumn colStNic;
    public TableColumn colStContact;
    public TableColumn colStRegDate;

    StudentBOImpl studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize() {

        pnStudentRegister.setVisible(false);
        pnStudentProgramDetails.setVisible(false);
        pnStudentDetails.setVisible(true);
        btnStudentDetails.setDisable(true);
        btnStudentProgramDetails.setDisable(false);

        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        findAll();
//        tableListner();
        setCellValueFactory();


    }

    private void setCellValueFactory(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colStGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colStNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colStContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
    }

//    private void tableListner(){
//        tblStudentDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            setData((StudentTm) newValue);
//        });
//    }

    private void setData(StudentTm tm) {
        txtStudentId.setText(tm.getStudentId());
        txtFullName.setText(tm.getStudentId());
        txtAddress.setText(tm.getStudentId());
        txtNic.setText(tm.getStudentId());
        txtContactNumber.setText(tm.getStudentId());
        dpBirthday.setValue(LocalDate.parse(tm.getStudentId()));
        cmbGender.setValue(tm.getStudentId());
        txtregDate.setText(tm.getStudentId());
    }

    private void findAll(){
        ObservableList<StudentTm> tmlist = FXCollections.observableArrayList();
        List<StudentDTO> all = studentBO.findAll();
        for (StudentDTO dto : all){
            StudentTm tm = new StudentTm(
                    dto.getStudentId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getNic(),
                    dto.getContact(),
                    dto.getBirthday(),
                    dto.getGender(),
                    dto.getRegDate()
            );
            tmlist.add(tm);
        }
        tblStudentDetails.setItems(tmlist);
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
            findAll();
        }

    }
}
