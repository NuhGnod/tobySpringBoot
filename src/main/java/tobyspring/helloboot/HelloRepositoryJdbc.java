package tobyspring.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        System.out.println("name = " + name);
        try {
            Hello hello = jdbcTemplate.queryForObject("select * from hello where name = '" + name + "'",
                    (rs, rowNum) -> new Hello(rs.getString("name"), rs.getInt("count")));
            System.out.println("hello = " + hello);
            return hello;
        } catch (EmptyResultDataAccessException e) {
            System.out.println("error!!!");
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            jdbcTemplate.update("insert into hello values (?,?)", name, 1);
            return;
        }
        jdbcTemplate.update("update hello  set count = ? where name = ?", hello.getCount() + 1, name);

    }
}
