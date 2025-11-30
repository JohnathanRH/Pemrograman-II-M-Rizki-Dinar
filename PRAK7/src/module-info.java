module PROJEK7 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	
	
	exports application;
	opens application to javafx.graphics, javafx.fxml;
    opens controller to javafx.fxml;
    opens model to javafx.base;
}
