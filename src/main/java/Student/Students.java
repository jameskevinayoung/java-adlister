package Student;

import java.util.List;

public interface Students {
    List<Student> findAll();
    Student findOne(long id);
    void add(Student student);


}
