package controller;

import business.BOFactory;
import business.BOType;
import business.custom.impl.CourseBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import views.tm.CourseTm;

import java.util.List;

/**
 * @author : Kasun Umesh
 * @since : 0.1.0
 **/
public class ProgramManagementFormController {
    public StackPane spProgramManagement;
    public JFXTextField txtProgramID;
    public JFXTextField txtProgramDetail;
    public JFXTextField txtDuration;
    public JFXTextField txtProgramFree;
    public TableView<CourseTm> tblProgramDetails;
    public TableColumn colProgramId;
    public TableColumn colProgramDetails;
    public TableColumn colDuration;
    public TableColumn colFree;

    CourseBOImpl courseBO = BOFactory.getInstance().getBO(BOType.COURSE);

    public  void initialize(){
        findAll();
        tableListener();
        setCellValueFactory();

    }

    private void setCellValueFactory(){
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramDetails.setCellValueFactory(new PropertyValueFactory<>("programDetail"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFree.setCellValueFactory(new PropertyValueFactory<>("programFree"));
    }

    private void tableListener() {
        tblProgramDetails.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(CourseTm tm){
        txtProgramID.setText(tm.getProgramId());
        txtProgramDetail.setText(tm.getProgramDetail());
        txtDuration.setText(tm.getDuration());
        txtProgramFree.setText(String.valueOf(tm.getProgramFree()));
    }

    private void findAll(){
        ObservableList<CourseTm> tmList = FXCollections.observableArrayList();
        List<CourseDTO> all = courseBO.findAll();
        for (CourseDTO dto : all){
            CourseTm tm = new CourseTm(
                    dto.getProgramId(),
                    dto.getProgramDetail(),
                    dto.getDuration(),
                    dto.getProgramFree()
            );
            tmList.add(tm);
        }
        tblProgramDetails.setItems(tmList);
    }

    public void btnAddProgramOnAction(ActionEvent actionEvent) {
        String id = txtProgramID.getText();
        String details = txtProgramDetail.getText();
        String duration = txtDuration.getText();
        double salary = Double.parseDouble(txtProgramFree.getText());

        if (courseBO.add(new CourseDTO(
                id,
                details,
                duration,
                salary
        ))){
            txtProgramID.setText(null);
            txtProgramDetail.setText(null);
            txtDuration.setText(null);
            txtProgramFree.setText(null);
            new Alert(Alert.AlertType.INFORMATION, "Added...!").show();
            findAll();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtProgramID.getText();
        String details = txtProgramDetail.getText();
        String duration = txtDuration.getText();
        double salary = Double.parseDouble(txtProgramFree.getText());

        if (courseBO.update(new CourseDTO(
                id,
                details,
                duration,
                salary
        ))){

            txtProgramID.setText(null);
            txtProgramDetail.setText(null);
            txtDuration.setText(null);
            txtProgramFree.setText(null);
            findAll();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Wrong").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        boolean courseDelete = courseBO.delete(txtProgramID.getText());

        if (courseDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Delete Successfully", ButtonType.OK).show();
            findAll();
            txtProgramID.clear();
            txtProgramDetail.clear();
            txtDuration.clear();
            txtProgramFree.clear();
        }else {
            new Alert(Alert.AlertType.WARNING,"Delete Error",ButtonType.OK).show();
        }
    }
}
