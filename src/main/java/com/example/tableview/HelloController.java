package com.example.tableview;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    public TableView  myTable;
    public TextField name;
    public TextField grade;
    public TextField gpa;
    public TextField sports;
    public Button enter;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Table View!");
    }

    public void initialize() throws Exception{
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



        myTable.getSortOrder().add(name);
        myTable.getSortOrder().add(name);


        try {
            restoreData();
        } catch (Exception ex) {
            // do nothing
        }
    }

        public void enterData(){
                int RealGrade = Integer.parseInt(grade.getText());
                int RealSports = Integer.parseInt(sports.getText());
                float RealGPA = Float.parseFloat(gpa.getText());
               myTable.getItems().add(new Activity(name.getText(), RealGrade,RealSports, RealGPA, true));

        }

        public void SaveData() throws Exception {
            FileOutputStream outputStream = new FileOutputStream("data");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

            ObservableList<Activity> activities = myTable.getItems();

            // Write the number of saved objects
            objOutputStream.writeInt(activities.size());

            // Write each Activity object
            for (Activity activity : activities) {
                objOutputStream.writeObject(activity);
            }

            // Close the streams
            objOutputStream.flush();
            objOutputStream.close();
            outputStream.close();
        }

        void restoreData() throws Exception {
            FileInputStream inputStream = new FileInputStream("data");
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

            // Read the list size
            int numOfSavedObjects = objInputStream.readInt();

            List<Activity> activities = new ArrayList<>();

            // Read each Activity object
            for (int i = 0; i < numOfSavedObjects; i++) {
                Activity activity = (Activity) objInputStream.readObject();
                activities.add(activity);
            }

            // Close the streams
            objInputStream.close();
            inputStream.close();

            // Add the loaded activities to the table
            myTable.getItems().addAll(activities);

        }
}