package business.custom.impl;

import business.custom.CourseBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.CourseDAOImpl;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDAOImpl courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);

    @Override
    public boolean add(CourseDTO courseDTO) {
        return courseDAO.add(new Course(
                courseDTO.getProgramId(),
                courseDTO.getProgramDetail(),
                courseDTO.getDuration(),
                courseDTO.getProgramFree()
        ));
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> all = courseDAO.findAll();
        ArrayList<CourseDTO> courseDTOS = new ArrayList<>();
        for (Course course : all){
            courseDTOS.add(new CourseDTO(
                    course.getProgramId(),
                    course.getProgramDetail(),
                    course.getDuration(),
                    course.getProgramFree()
            ));
        }
        return courseDTOS;
    }

    @Override
    public boolean delete(String s) {
        return courseDAO.delete(s);
    }

    @Override
    public boolean update(CourseDTO courseDTO) {
        return courseDAO.update(new Course(
                courseDTO.getProgramId(),
                courseDTO.getProgramDetail(),
                courseDTO.getDuration(),
                courseDTO.getProgramFree()
        ));
    }
}
