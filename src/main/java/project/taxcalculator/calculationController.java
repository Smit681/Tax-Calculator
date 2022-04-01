package project.taxcalculator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class calculationController implements Initializable {
    @FXML
    private TextField federalDeduction;
    @FXML
    private TextField provincialDeduction;
    @FXML
    private TextField deductedIncome;
    @FXML
    private TextField taxableIncome;
    @FXML
    private ChoiceBox<String> applicableYear;
    @FXML
    private ChoiceBox<String> applicableProvince;
    Util ut = new Util();

    private String[] year = {"2021","2022"};
    private String[] province = {"Newfoundland and Labrador", "Prince Edward Island", "Nova Scotia", "New Brunswick", "Quebec", "Ontario", "Manitoba", "Saskatchewan", "Alberta", "British Columbia", "Yukon", "Northwest Territories", "Nunavut"};

    public void onCalculate(){
        try{
            double income = Integer.parseInt(taxableIncome.getText());
            int year = Integer.parseInt(applicableYear.getValue());
            String province = applicableProvince.getValue();

            double federalTaxDeduction = 0;
            double provincialTaxDeduction = 0;

            if(year == 2021){
                federalTaxDeduction = ut.getIncomeTax(ut.getFederal2021(),income);
                provincialTaxDeduction = ut.getIncomeTax(ut.getProvince2021(province),income);
            }
            else{
                federalTaxDeduction = ut.getIncomeTax(ut.getFederal2022(),income);
                provincialTaxDeduction = ut.getIncomeTax(ut.getProvince2022(province),income);
            }

            double totalDeduction = federalTaxDeduction + provincialTaxDeduction;

            federalDeduction.setText(String.format("%.2f",federalTaxDeduction));
            provincialDeduction.setText(String.format("%.2f",provincialTaxDeduction));
            deductedIncome.setText(String.format("%.2f",income - federalTaxDeduction - provincialTaxDeduction));
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applicableYear.getItems().addAll(year);
        applicableProvince.getItems().addAll(province);

    }
}