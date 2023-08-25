module com.guessyourage.guessyourage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.guessyourage.guessyourage to javafx.fxml;
    exports com.guessyourage.guessyourage;
}