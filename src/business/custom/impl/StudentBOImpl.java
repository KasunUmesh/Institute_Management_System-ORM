package business.custom.impl;

import business.custom.StudentBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) {
        return studentDAO.add(new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getNic(),
                studentDTO.getContact(),
                studentDTO.getBirthday(),
                studentDTO.getGender(),
                studentDTO.getRegDate()
        ));
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> dtoArrayList = new ArrayList<>();

        for (Student student : all) {
            dtoArrayList.add(new StudentDTO(
                    student.getStudentId(),
                    student.getName(),
                    student.getAddress(),
                    student.getNic(),
                    student.getContact(),
                    student.getBirthday(),
                    student.getGender(),
                    student.getRegDate()
            ));
        }
        return dtoArrayList;
    }

    @Override
    public boolean delete(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return studentDAO.update(new Student(
                studentDTO.getStudentId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getNic(),
                studentDTO.getContact(),
                studentDTO.getBirthday(),
                studentDTO.getGender(),
                studentDTO.getRegDate()
        ));
    }
}
