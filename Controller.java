package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    @FXML
    TableView<Numbers> tbl;
    @FXML
    TableColumn<Numbers, String> c1;
    @FXML
    TableColumn<Numbers, String> c2;
    @FXML
    TableColumn<Numbers, String> c3;
    @FXML
    TableColumn<Numbers, String> c4;
    @FXML
    TableColumn<Numbers, String> c5;
    @FXML
    private TextArea txt_max;
    @FXML
    private TextArea txt_min;

    ObservableList<Numbers> items = FXCollections.observableArrayList();

    public void btn_1_ch(ActionEvent actionEvent) {
        if (items.size() != 0) {
            for (int i = 0; i < 5; i++) {
                items.remove(0);
            }
        }
        for (int i = 0; i < 5; i++) {
            double num1 = (Math.random() * 201) - 100;
            double num2 = (Math.random() * 201) - 100;
            double num3 = (Math.random() * 201) - 100;
            double num4 = (Math.random() * 201) - 100;
            double num5 = (Math.random() * 201) - 100;
            items.add(new Numbers(String.valueOf(num1), String.valueOf(num2), String.valueOf(num3), String.valueOf(num4), String.valueOf(num5)));
        }
        c1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN1()));
        c2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN2()));
        c3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN3()));
        c4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN4()));
        c5.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN5()));
    }
    public void btn_2_ch(ActionEvent actionEvent) {
        ArrayList<Double> arrNum = new ArrayList<>();
        HashMap<String, Double> minusHashMap = new HashMap<>();
        HashMap<String, Double> zeroHashMap = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            if (Double.parseDouble(items.get(i).getN1()) < 0) {
                minusHashMap.put(String.valueOf(i), Double.parseDouble(items.get(i).getN1()));
            }
            if (Double.parseDouble(items.get(i).getN2()) < 0) {
                minusHashMap.put(String.valueOf(i + "" + i), Double.parseDouble(items.get(i).getN2()));
            }
            if (Double.parseDouble(items.get(i).getN3()) < 0) {
                minusHashMap.put(String.valueOf(i + "" + i + "" + i), Double.parseDouble(items.get(i).getN3()));
            }
            if (Double.parseDouble(items.get(i).getN4()) < 0) {
                minusHashMap.put(i + "" + i + "" + i + "" + i, Double.parseDouble(items.get(i).getN4()));
            }
            if (Double.parseDouble(items.get(i).getN5()) < 0) {
                minusHashMap.put(i + "" + i + "" + i + "" + i + "" + i, Double.parseDouble(items.get(i).getN5()));
            }
            arrNum.add(Double.parseDouble(items.get(i).getN1()));
            arrNum.add(Double.parseDouble(items.get(i).getN2()));
            arrNum.add(Double.parseDouble(items.get(i).getN3()));
            arrNum.add(Double.parseDouble(items.get(i).getN4()));
            arrNum.add(Double.parseDouble(items.get(i).getN5()));
            if (Double.parseDouble(items.get(i).getN1()) == 0.0) {
                zeroHashMap.put(String.valueOf(i), 0.0);
            }
            if (Double.parseDouble(items.get(i).getN2()) == 0.0) {
                zeroHashMap.put(String.valueOf(i + "" + i), 0.0);
            }
            if (Double.parseDouble(items.get(i).getN3()) == 0.0) {
                zeroHashMap.put(String.valueOf(i + "" + i + "" + i), 0.0);
            }
            if (Double.parseDouble(items.get(i).getN4()) == 0.0) {
                zeroHashMap.put(i + "" + i + "" + i + "" + i, 0.0);
            }
            if (Double.parseDouble(items.get(i).getN4()) == 0.0) {
                zeroHashMap.put(i + "" + i + "" + i + "" + i + "" + i, 0.0);
            }
        }
        double minNum = arrNum.get(0);
        double maxNum = arrNum.get(0);
        for (int i = 0; i < arrNum.size(); i++) {
            if (maxNum <= arrNum.get(i)) {
                maxNum = arrNum.get(i);
            }
        }
        for (int i = 0; i < arrNum.size(); i++) {
            if (minNum >= arrNum.get(i)) {
                minNum = arrNum.get(i);
            }
        }
        txt_max.setText(String.valueOf(maxNum));
        txt_min.setText(String.valueOf(minNum));
        if (minNum / 10 == maxNum) {
            for (Map.Entry entry : minusHashMap.entrySet()) {
                String[] arr = String.valueOf(entry.getKey()).split("");
                if (arr.length == 1) {
                    items.get(Integer.parseInt(arr[0])).setN1(String.valueOf(Double.parseDouble(items.get(Integer.parseInt(arr[0])).getN1()) * (-1)));
                } else if (arr.length == 2) {
                    items.get(Integer.parseInt(arr[0])).setN2(String.valueOf(Double.parseDouble(items.get(Integer.parseInt(arr[0])).getN2()) * (-1)));
                } else if (arr.length == 3) {
                    items.get(Integer.parseInt(arr[0])).setN3(String.valueOf(Double.parseDouble(items.get(Integer.parseInt(arr[0])).getN3()) * (-1)));
                } else if (arr.length == 4) {
                    items.get(Integer.parseInt(arr[0])).setN4(String.valueOf(Double.parseDouble(items.get(Integer.parseInt(arr[0])).getN4()) * (-1)));
                } else if (arr.length == 5) {
                    items.get(Integer.parseInt(arr[0])).setN5(String.valueOf(Double.parseDouble(items.get(Integer.parseInt(arr[0])).getN5()) * (-1)));
                }
            }
            for (Map.Entry zeroEntry : zeroHashMap.entrySet()) {
                String[] zeroArr = String.valueOf(zeroEntry.getKey()).split("");
                if (zeroArr.length == 1) {
                    items.get(Integer.parseInt(zeroArr[0])).setN1(String.valueOf(1.0));
                } else if (zeroArr.length == 2) {
                    items.get(Integer.parseInt(zeroArr[0])).setN2(String.valueOf(1.0));
                } else if (zeroArr.length == 3) {
                    items.get(Integer.parseInt(zeroArr[0])).setN3(String.valueOf(1.0));
                } else if (zeroArr.length == 4) {
                    items.get(Integer.parseInt(zeroArr[0])).setN4(String.valueOf(1.0));
                } else if (zeroArr.length == 5) {
                    items.get(Integer.parseInt(zeroArr[0])).setN5(String.valueOf(1.0));
                }
            }
        }
        tbl.refresh();
}
    public void initialize() {
        tbl.setEditable(true);
        tbl.itemsProperty().setValue(items);
        for (int i = 0; i < 5; i++) {
            items.add(new Numbers());
        }
        c1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN1()));
        c1.setCellFactory(TextFieldTableCell.forTableColumn());
        c1.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Numbers, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Numbers, String> event) {
                ((Numbers) event.getTableView().getItems().get(event.getTablePosition().getRow())).setN1(event.getNewValue());
            }
        });
        c2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN2()));
        c2.setCellFactory(TextFieldTableCell.forTableColumn());
        c2.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Numbers, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Numbers, String> event) {
                ((Numbers) event.getTableView().getItems().get(event.getTablePosition().getRow())).setN2(event.getNewValue());
            }
        });
        c3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN3()));
        c3.setCellFactory(TextFieldTableCell.forTableColumn());
        c3.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Numbers, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Numbers, String> event) {
                ((Numbers) event.getTableView().getItems().get(event.getTablePosition().getRow())).setN3(event.getNewValue());
            }
        });
        c4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN4()));
        c4.setCellFactory(TextFieldTableCell.forTableColumn());
        c4.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Numbers, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Numbers, String> event) {
                ((Numbers) event.getTableView().getItems().get(event.getTablePosition().getRow())).setN4(event.getNewValue());
            }
        });
        c5.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getN5()));
        c5.setCellFactory(TextFieldTableCell.forTableColumn());
        c5.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Numbers, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Numbers, String> event) {
                ((Numbers) event.getTableView().getItems().get(event.getTablePosition().getRow())).setN5(event.getNewValue());
            }
        });
    }
}
