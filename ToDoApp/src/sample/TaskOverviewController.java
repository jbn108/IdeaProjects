package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;

public class TaskOverviewController {
    private ObservableList<Task> tasks;
    private Task selectedTask;
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> descriptionColumn;
    @FXML
    private TableColumn<Task, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<Task, Boolean> isCompletedColumn;

    @FXML
    public void initialize(){
        loadTasks();

        taskTable.setItems(tasks);
        taskTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedTask = newValue;
        });

        // Initialize the person table with the two columns.
        descriptionColumn.setCellValueFactory(
                cellData -> cellData.getValue().getDescriptionProperty());
        dueDateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getDueDateProperty());
        isCompletedColumn.setCellValueFactory(
                cellData -> cellData.getValue().getIsCompletedProperty());


    }

    private void loadTasks() {
        try {
            tasks = Task.loadTasks();
        } catch (JAXBException ex) {
            showError(ex);
        }
    }

    private void saveTasks(){
        try{
            Task.saveTasks(tasks);
        } catch (JAXBException ex) {
            showError(ex);
        }
    }

    @FXML
    private void addTaskClicked(){
        TextInputDialog input = new TextInputDialog();
        input.setHeaderText("Add Task");
        input.setTitle("Add Task");
        input.setContentText("Please provide a description for your new task");

        String description = input.showAndWait().get();

        tasks.add(new Task(description));
        saveTasks();
    }
    @FXML
    private void postpone1DayClicked(){
        if (selectedTask == null){
            showMissingSelectionWarning();
            return;
        }
        selectedTask.postpone(1);
        saveTasks();
    }
    @FXML
    private void postpone1MonthClicked(){
        if (selectedTask == null){
            showMissingSelectionWarning();
            return;
        }
        selectedTask.postpone(30);
        saveTasks();
    }
    @FXML
    private void completeTaskClicked(){
        if(selectedTask == null){
            showMissingSelectionWarning();
            return;
        }
        selectedTask.complete();
        saveTasks();
    }

    private void showMissingSelectionWarning(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("No task selected!");
        alert.setContentText("You need to select a task");
        alert.showAndWait();
    }

    private void showError(Exception ex){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("An error occurred");
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }

}
