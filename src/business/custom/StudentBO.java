package business.custom;

import business.SuperBO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO);
    public List<StudentDTO> findAll();
    public boolean delete(String id);
    public boolean update(StudentDTO studentDTO);
}
