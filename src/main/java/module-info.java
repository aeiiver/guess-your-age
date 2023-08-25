module org.canieven.canieven {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens org.canieven.canieven to javafx.fxml;
    exports org.canieven.canieven;
}