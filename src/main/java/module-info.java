module project.taxcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.taxcalculator to javafx.fxml;
    exports project.taxcalculator;
}