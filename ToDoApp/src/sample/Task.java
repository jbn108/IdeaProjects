package sample;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.sql.Wrapper;
import java.time.LocalDate;

public class Task {
    private final StringProperty description;
    private final ObjectProperty<LocalDate> dueDate;
    private final BooleanProperty isCompleted;


    public Task(String description){
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleObjectProperty<>(LocalDate.now().plusDays(2));
        this.isCompleted = new SimpleBooleanProperty();
    }

    public Task(){
        this("");
    }

    public StringProperty getDescriptionProperty(){
        return description;
    }

    public ObjectProperty<LocalDate> getDueDateProperty() {
        return dueDate;
    }

    public BooleanProperty getIsCompletedProperty(){
        return isCompleted;
    }

    public String getDescription() {
        return this.description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDueDate() {
        return dueDate.get();
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate.set(dueDate);
    }

    public boolean getIsComplete(){
        return this.isCompleted.get();
    }

    public void setIsCompleted(boolean completed){
        this.isCompleted.set(completed);
    }

    public void postpone(int numberOfDays){
        this.setDueDate(this.getDueDate().plusDays(numberOfDays));
    }

    public void complete(){
        this.isCompleted.set(true);
    }

    public static void saveTasks(ObservableList<Task> tasks) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TaskListWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        TaskListWrapper wrapper = new TaskListWrapper();
        wrapper.setTasks(tasks);

        m.marshal(wrapper, new File("Tasks.xml"));
    }

    public static ObservableList<Task> loadTasks() throws JAXBException{
        File file = new File("Tasks.xml");
        if (!file.exists()){
            return FXCollections.observableArrayList();
        }
        JAXBContext context = JAXBContext.newInstance(TaskListWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        TaskListWrapper wrapper =  (TaskListWrapper) um.unmarshal(file);
        return FXCollections.observableArrayList(wrapper.getTasks());
    }
}
