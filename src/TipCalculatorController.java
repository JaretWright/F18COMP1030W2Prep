import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TipCalculatorController implements Initializable{
    @FXML private TextField mealAmountTextField;
    @FXML private TextField tipPercentTextField;
    @FXML private TextField totalTipTextField;
    @FXML private TextField amountToPayTextField;
    @FXML private Label errorMsg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalTipTextField.setEditable(false);
        amountToPayTextField.setEditable(false);
        errorMsg.setText("");
    }

    @FXML public void tipButtonPushed()
    {
        errorMsg.setText("");
        if (!mealAmountTextField.getText().isEmpty()
            && !tipPercentTextField.getText().isEmpty())
        {
            mealAmountTextField.setText(updateStringWithDecimals(mealAmountTextField.getText()));

            try {
                double mealAmount = Double.parseDouble(mealAmountTextField.getText());
                double tipPercent = Double.parseDouble(tipPercentTextField.getText()) / 100;
            
                /***********************************************************
                /*  Student challenge, replace the 0's below              **
                /*  with the formula to calculate the tip amount and the  **
                /*  total meal cost                                       **
                /***********************************************************/
                double tipAmount = 0;
                double totalMealCost = 0;

                totalTipTextField.setText(String.format("%.2f", tipAmount));
                amountToPayTextField.setText(String.format("%.2f", totalMealCost));
            }
            catch (Exception e){
                errorMsg.setText("Fields did not contain numbers");
            };
        }
        else
            errorMsg.setText("Ensure #'s are in the fields");
    }

    public String updateStringWithDecimals(String inputNumber)
    {
        try{
            double number = Double.parseDouble(inputNumber);
            return String.format("%.2f", number);
        }
        catch(Exception e){};
        return null;
    }
}
