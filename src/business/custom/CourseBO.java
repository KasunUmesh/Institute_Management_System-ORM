package business.custom;

import business.SuperBO;
import dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    public boolean add(CourseDTO courseDTO);
    public List<CourseDTO> findAll();
    public boolean delete(String s);
    public boolean update(CourseDTO courseDTO);
}
