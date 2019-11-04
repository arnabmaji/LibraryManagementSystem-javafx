module Library.Management.System {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.jfoenix;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;

    opens io.github.arnabmaji19;
    opens io.github.arnabmaji19.model;
    opens io.github.arnabmaji19.controller;
    opens io.github.arnabmaji19.resources.fxml;
}