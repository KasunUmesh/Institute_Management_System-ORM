package controller;

import business.BOFactory;
import business.BOType;
import business.custom.impl.CourseBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import views.tm.CourseTm;

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
        }
    }
}
