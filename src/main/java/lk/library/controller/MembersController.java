package lk.library.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MembersController {
    @FXML private TableView<Member> memberTable;
    @FXML private TableColumn<Member,String> idCol, nameCol, emailCol, phoneCol, addressCol;
    @FXML private TextField searchField;

    private final ObservableList<Member> members = FXCollections.observableArrayList(
        new Member("M001","Nethmi Perera","nethmi@gmail.com","0712345678","Colombo"),
        new Member("M002","Kavindu Silva","kavindu@gmail.com","0771234567","Negombo"),
        new Member("M003","Hiruni Fernando","hiruni@gmail.com","0769876543","Gampaha")
    );

    @FXML
    private void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        memberTable.setItems(members);

        searchField.textProperty().addListener((obs, oldValue, newValue) -> {
            String q = newValue.toLowerCase();
            memberTable.setItems(members.filtered(m ->
                m.getId().toLowerCase().contains(q) ||
                m.getName().toLowerCase().contains(q) ||
                m.getEmail().toLowerCase().contains(q)));
        });
    }

    @FXML
    private void deleteMember() {
        Member selected = memberTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            show("Please select a member first.", Alert.AlertType.WARNING);
            return;
        }
        members.remove(selected);
        show("Member deleted successfully.", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void editMember() {
        Member selected = memberTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            show("Please select a member first.", Alert.AlertType.WARNING);
            return;
        }
        TextInputDialog dialog = new TextInputDialog(selected.getName());
        dialog.setTitle("Edit Member");
        dialog.setHeaderText("Change member name");
        dialog.showAndWait().ifPresent(name -> {
            if (!name.isBlank()) {
                selected.setName(name);
                memberTable.refresh();
            }
        });
    }

    private void show(String msg, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setHeaderText(null); a.setContentText(msg); a.showAndWait();
    }

    public static class Member {
        private final String id, email, phone, address;
        private String name;
        public Member(String id, String name, String email, String phone, String address) {
            this.id=id; this.name=name; this.email=email; this.phone=phone; this.address=address;
        }
        public String getId(){return id;} public String getName(){return name;}
        public String getEmail(){return email;} public String getPhone(){return phone;}
        public String getAddress(){return address;} public void setName(String name){this.name=name;}
    }
}
