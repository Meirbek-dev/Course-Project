package course;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.sql.ResultSet;


 //Класс загрузки данных в объект Person из считанной записи таблицы БД
 
public class RowMap implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int line) throws SQLException {
        PersonResultSetExtractor extractor = new PersonResultSetExtractor();
        return extractor.extractData(rs);
    }

    
    //Класс загрузки данных в объект данных из считанной записи таблицы
    
    class PersonResultSetExtractor implements ResultSetExtractor {

        @Override
        public Object extractData(ResultSet rs) throws SQLException {
            cd_dvd CD_DVD = new cd_dvd();
            CD_DVD.setId(rs.getInt(1));
            CD_DVD.setTitle(rs.getString(2));
            CD_DVD.setArtist(rs.getString(3));
            CD_DVD.setPrice(rs.getString(4));
            CD_DVD.setSongs(rs.getString(5));
            CD_DVD.setGenre(rs.getString(6));
            CD_DVD.setYear(rs.getInt(7));
            CD_DVD.setRating(rs.getDouble(8));
            CD_DVD.setSize(rs.getString(9));
            CD_DVD.setSongs(rs.getString(10));
            return CD_DVD;
        }
    }
}
