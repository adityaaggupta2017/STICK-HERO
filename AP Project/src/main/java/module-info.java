module project.ap_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.media;
    requires junit;
    requires org.testng;
    requires org.junit.jupiter.api;

    opens project to javafx.fxml;
    exports project;
}