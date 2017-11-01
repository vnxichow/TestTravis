package calc;


import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;


public class Calculator extends Application {
    
    TextField tfNum1;
    TextField tfNum2;
    Button btnDivide;
    Button btnMultiply;
    Button btnAddition;
    Button btnSubtraction;
    Label lblAnswer;
    final int sizes = 50;
    
    @Override
    public void start(Stage primaryStage) {
        
        tfNum1 = new TextField();
        tfNum2 = new TextField();
        btnDivide = new Button("/");
        btnMultiply = new Button("*");
        btnAddition = new Button("+");
        btnSubtraction = new Button("-");
        lblAnswer = new Label("?");
        
        lblAnswer.setAlignment(Pos.TOP_CENTER);
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_CENTER);
        
        root.setHgap(10);
        root.setVgap(10);
        
        root.add(btnDivide, 0, 3);
        root.add(btnMultiply, 1, 3);
        root.add(btnAddition, 2, 3);
        root.add(btnSubtraction, 3, 3);
        
        root.add(tfNum1, 1, 2);
        root.add(tfNum2, 2, 2);
        root.add(lblAnswer, 0, 4, 3, 4);
        
        setWidths();
        attachCode();
        
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setWidths() {
        tfNum1.setPrefWidth(sizes);
        tfNum2.setPrefWidth(sizes);
        btnDivide.setPrefWidth(sizes);
        btnMultiply.setPrefWidth(sizes);
        btnAddition.setPrefWidth(sizes);
        btnSubtraction.setPrefWidth(sizes);
        lblAnswer.setPrefWidth(150);
    }

    public void attachCode() {
        //have each button run BTNCODE when clicked
        btnAddition.setOnAction(e -> btncode(e));
        btnSubtraction.setOnAction(e -> btncode(e));
        btnMultiply.setOnAction(e -> btncode(e));
        btnDivide.setOnAction(e -> btncode(e));
    }

    public void btncode(ActionEvent e) {
        int num1, num2, answer;
        char symbol;
        

        
        num1 = Integer.parseInt(tfNum1.getText());
        num2 = Integer.parseInt(tfNum2.getText());
        
        Addition add = new Addition();
        Subtraction sub = new Subtraction();
        Multiply mult = new Multiply();
        Divide div = new Divide();
        
        if (e.getSource() == btnAddition) {
            symbol = '+';
            answer = add.add(num1, num2);
        } else if (e.getSource() == btnSubtraction) {
            symbol = '-';
            answer = sub.subtract(num1, num2);
        } else if (e.getSource() == btnMultiply) {
            symbol = 'x';
            answer = mult.multiply(num1, num2);
        } else {
            symbol = '/';
            answer = div.divide(num1, num2);
        }
        //display answer
        lblAnswer.setText("Result: " + answer);
    }
    
    public static void main(String[] args) {
        launch(args);

    }
}
