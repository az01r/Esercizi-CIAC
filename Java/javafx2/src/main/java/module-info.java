module tss.ciac.javafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens tss.ciac.javafx2 to javafx.fxml;
    exports tss.ciac.javafx2;
}