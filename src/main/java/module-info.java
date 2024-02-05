module com.mycompany.donem_projesi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.donem_projesi to javafx.fxml;
    exports com.mycompany.donem_projesi;
}
