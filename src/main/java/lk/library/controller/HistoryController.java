package lk.library.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoryController {
    @FXML private TableView<Record> historyTable;
    @FXML private TableColumn<Record,String> memberCol, bookCol, issueCol, dueCol, returnCol, statusCol;

    @FXML
    private void initialize() {
        memberCol.setCellValueFactory(new PropertyValueFactory<>("member"));
        bookCol.setCellValueFactory(new PropertyValueFactory<>("book"));
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        dueCol.setCellValueFactory(new PropertyValueFactory<>("due"));
        returnCol.setCellValueFactory(new PropertyValueFactory<>("returned"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        historyTable.setItems(FXCollections.observableArrayList(
            new Record("M001","Clean Code","2026-10-01","2026-10-15","-","Borrowed"),
            new Record("M002","Java Fundamentals","2026-09-20","2026-10-04","2026-10-03","Returned"),
            new Record("M003","The Alchemist","2026-09-01","2026-09-15","-","Overdue")
        ));
    }

    public static class Record {
        private final String member,book,issue,due,returned,status;
        public Record(String member,String book,String issue,String due,String returned,String status){
            this.member=member;this.book=book;this.issue=issue;this.due=due;this.returned=returned;this.status=status;
        }
        public String getMember(){return member;} public String getBook(){return book;}
        public String getIssue(){return issue;} public String getDue(){return due;}
        public String getReturned(){return returned;} public String getStatus(){return status;}
    }
}
