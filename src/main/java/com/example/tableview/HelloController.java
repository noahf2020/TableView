package com.example.tableview;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private Label welcomeText;
    public TableView  myTable;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Table View!");
    }

    public void initialize(){
        TableColumn name = new TableColumn<Activity, String>(" Name");
        name.setCellValueFactory(new PropertyValueFactory<Activity, String>("Name"));
        TableColumn grade = new TableColumn<Activity, String>("Grade");
        grade.setCellValueFactory(new PropertyValueFactory<Activity, String>("Grade"));
        TableColumn numofSports = new TableColumn<Activity, String>("Num of sports/activities");
        numofSports.setCellValueFactory(new PropertyValueFactory<Activity, String>("Sports"));
        TableColumn GPA = new TableColumn<Activity, String>("GPA");
        GPA.setCellValueFactory(new PropertyValueFactory<Activity, String>("GPA"));
        TableColumn Standing = new TableColumn<Activity, String>("Standing");
        Standing.setCellValueFactory(new PropertyValueFactory<Activity, String>("Standing"));


        myTable.getColumns().add(name);
        myTable.getColumns().add(grade);
        myTable.getColumns().add(numofSports);
        myTable.getColumns().add(GPA);
        myTable.getColumns().add(Standing);




        myTable.getItems().add(new Activity("Eli",9,5, 4.2, true));
        myTable.getItems().add(new Activity("Eli",9,5, 4.2, true));

    }

}