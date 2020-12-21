package course;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.TransactionStatus;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

import java.util.List;

public class cd_dvd_DAO implements Icd_dvd_DAO {

    private DataSource dataSource;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(cd_dvd customer) { // Реализация вставки новой записи

        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO disks (title, artist, price, songs, genre, year, rating, size, type) VALUES(?,?,?,?,?,?,?,?,?)",
                new Object[]{customer.getTitle(), customer.getArtist(), customer.getPrice(), customer.getSongs(), customer.getGenre(), customer.getYear(), customer.getRating(), customer.getSize(), customer.getType()});
    }

    @Override
    public void append(String title, String artist, String price, String songs, String genre, int year, double rating, String size, String type) {  // Реализация добавления новой записи
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO disks (title, artist, price, songs, genre, year, ratimg, size, type) VALUES(?,?,?,?,?,?,?,?,?)",
                new Object[]{title, artist, price, songs, genre, year, rating, size, type});
    }

    @Override
    public void deleteByTitleYear(String title, int year) {  // Реализация удаления записей title
        TransactionTemplate transactionTemplate = new TransactionTemplate(new DataSourceTransactionManager(dataSource));

        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {

                try {
                    JdbcTemplate delete = new JdbcTemplate(dataSource);
                    delete.update("DELETE from disks where title= ? AND year = ?", new Object[]{title, year});
                } catch (RuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                } catch (Exception e) {
                    status.setRollbackOnly();
                    throw new RuntimeException(e);
                }
                return null;
            }
        });
    }

    @Override
    public void deleteYear(int Year) {  // Реализация удаления записей по давлению
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("DELETE FROM disks WHERE year LIKE ?", new Object[]{'%' + Year + '%'});
    }

    @Override
    public void deleteRating(double Rating) {  // Реализация удаления записей по давлению
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("DELETE FROM disks WHERE rating LIKE ?", new Object[]{'%' + Rating + '%'});
    }

    @Override
    public void deleteAll() {  // Реализация удаления всех запией
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from disks");
    }

    @Override
    public void updateYear(int oldYear, int newYear) {  // Изменение записей в таблице
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE disks SET year = ? WHERE year = ?", new Object[]{oldYear, newYear});
    }

    @Override
    public void updateRating(double oldRating, double newRating) {  // Изменение записей в таблице
        JdbcTemplate update = new JdbcTemplate(dataSource);
        update.update("UPDATE disks SET rating = ? WHERE rating = ?", new Object[]{oldRating, newRating});
    }

    @Override
    public List<cd_dvd> findByTitle(String title) {  // Реализация поиска записей по году выпуска
        JdbcTemplate select = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM disks WHERE title LIKE ?";
        List<cd_dvd> persons = select.query(sql, new Object[]{'%' + title + '%'}, new RowMap());
        return persons;
    }

    @Override
    public List<cd_dvd> findByYear(int year) {  // Реализация поиска записей по году выпуска
        JdbcTemplate select = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM disks WHERE year LIKE ?";
        List<cd_dvd> persons = select.query(sql, new Object[]{'%' + year + '%'}, new RowMap());
        return persons;
    }

    @Override
    public List<cd_dvd> findByRating(double rating) {  // Реализация поиска записей по рейтингу
        JdbcTemplate select = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM disks WHERE rating LIKE ?";
        List<cd_dvd> persons = select.query(sql, new Object[]{'%' + rating + '%'}, new RowMap());
        return persons;
    }

    @Override
    public List<cd_dvd> selectAll() {  // Реализация получения всех записей
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from disks", new RowMap());
    }
}
