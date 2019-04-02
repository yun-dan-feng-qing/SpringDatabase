package test.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcStudentRepository implements StudentRepository {
    private JdbcOperations jdbcOperations;
    private static final String SQL_UPDATA_STUDENT =
            "update dpc_students set Sage = ?, Sdept = ?," +
                    "Spassword = ? where Sno = ?";
    private static final String SELECT_STUDENT_BY_ID =
            "select * from dpc_students where Sno = ?";

    @Autowired
    public JdbcStudentRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public void addStudent(Student student){
        jdbcOperations.update(SQL_UPDATA_STUDENT,
                student.getSage(),
                student.getSdept(),
                student.getSpassword(),
                student.getSno());
    }

    public Student findOne(String id){
        return jdbcOperations.queryForObject(SELECT_STUDENT_BY_ID,
                new StudentRowMapper(), id);
    }
    private static final class StudentRowMapper
        implements RowMapper<Student>{
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(
                    rs.getString("Sno"),
                    rs.getString("Sname"),
                    rs.getString("Ssex"),
                    rs.getInt("Sage"),
                    rs.getString("Sdept"),
                    rs.getString("Spassword")
            );
        }
    }
}
