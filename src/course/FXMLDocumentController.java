package course;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button exit;
    @FXML
    private TextArea TextArea;
    @FXML
    private Button save;
    @FXML
    private Button update;
    @FXML
    private TextField title;
    @FXML
    private TextField artist;
    @FXML
    private TextField price;
    @FXML
    private TextField songs;
    @FXML
    private TextField genre;
    @FXML
    private TextField year;
    @FXML
    private TextField rating;
    @FXML
    private TextField size;
    @FXML
    private TextField type;
    @FXML
    private Button deleteAll;

    ApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml"); // Загрузка файла с биновами
    cd_dvd_DAO cdDvdDAO = (cd_dvd_DAO) context.getBean("customerDAO"); // Загрузка бина доступа к таблице клиентов 

    double Rating = 0;
    int Year = 0;
    int Id = 0;
    @FXML
    private TextField id;
    @FXML
    private Button deleteById;
    @FXML
    private TextField delete_title;
    @FXML
    private Button findById;
    @FXML
    private TextField titleByID;

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void save(ActionEvent event) {
        try {
            Rating = Double.parseDouble(rating.getText());
            Year = Integer.parseInt(year.getText());
            cdDvdDAO.insert(new cd_dvd(title.getText(), artist.getText(), price.getText(), songs.getText(), genre.getText(), Year, Rating, size.getText(), type.getText()));
        } catch (Exception e) {
        }
    }

    @FXML
    private void update(ActionEvent event) {
        List<cd_dvd> list = cdDvdDAO.selectAll();
        for (cd_dvd myPerson : list) {
            TextArea.appendText(myPerson.getId() + " "
                    + myPerson.getTitle() + " "
                    + myPerson.getArtist() + " "
                    + myPerson.getPrice() + " "
                    + myPerson.getSongs() + " "
                    + myPerson.getGenre() + " "
                    + myPerson.getYear() + " "
                    + myPerson.getRating() + " "
                    + myPerson.getSize() + " "
                    + myPerson.getType() + "\n");
        }
    }

    @FXML
    private void deleteAll(ActionEvent event) {
        cdDvdDAO.deleteAll();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void deleteById(ActionEvent event) {
        Id = Integer.parseInt(id.getText());
        cdDvdDAO.deleteByTitleYear(delete_title.getText(), Id);
    }

    @FXML
    private void findById(ActionEvent event) {
        List<cd_dvd> list = cdDvdDAO.findByTitle(titleByID.getText());
        for (cd_dvd myPerson : list) {
            TextArea.appendText(myPerson.getId() + " "
                    + myPerson.getTitle() + " "
                    + myPerson.getArtist() + " "
                    + myPerson.getPrice() + " "
                    + myPerson.getSongs() + " "
                    + myPerson.getGenre() + " "
                    + myPerson.getYear() + " "
                    + myPerson.getRating() + " "
                    + myPerson.getSize() + " "
                    + myPerson.getType() + "\n");
        }
    }
}
