package course;

import course.cd_dvd;
import javax.sql.DataSource;
import java.util.List;

// интерфейс работы с таблицой
public interface Icd_dvd_DAO {

    void setDataSource(DataSource ds); // Установка связи с данныими

    void insert(cd_dvd customer); // Вставка новой записи

    void append(String title, String artist, String price, String songs, String genre, int year, double rating, String size, String type); // Добавление новой записи

    void deleteByTitleYear(String title, int year); // удаление записи по заголовку и году

    void deleteYear(int Year); // Удаление записи по году выпуска

    void deleteRating(double Rating); // Удаление записи по рейтингу

    void deleteAll(); // Удаление всех запией

    void updateYear(int oldYear, int newYear); // Изменение записей в таблице Year

    void updateRating(double oldRating, double newRating); // Изменение записей в таблице Rating

    List<cd_dvd> findByTitle(String title); // Получение записей по названию выпуска (или можно с други значением)

    List<cd_dvd> findByYear(int year); // Получение записей по году выпуска (или можно с други значением)

    List<cd_dvd> findByRating(double rating); // Получение записей по рейтингу (или можно с други значением)

    List<cd_dvd> selectAll(); // Получение всех записей
}
