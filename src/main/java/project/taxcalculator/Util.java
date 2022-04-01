package project.taxcalculator;

public class Util {

    private final double[][] federal2022 = {{50197,15},{100392,20.5},{155625,26},{221708,29},{Double.MAX_VALUE,33}};
    private final double[][] federal2021 = {{49020,15},{98040,20.5},{151978,26},{216511,29},{Double.MAX_VALUE,33}};

    private final double[][] newfoundland2021= {{38080,8.7},{59812,14.5},{54390,15.8},{190363,17.3},{Double.MAX_VALUE,18.3}};
    private final double[][] prince2021= {{31985,9.8},{63969,13.8},{Double.MAX_VALUE,16.7}};
    private final double[][] nova2021= {{29590,8.79},{33820,14.95},{57000,16.67},{150000,17.5},{Double.MAX_VALUE,21}};
    private final double[][] newBrunswick2021= {{43836,9.68},{54863,14.82},{19849,16.52},{162383,17.84},{Double.MAX_VALUE,20.3}};
    private final double[][] quebec2021 = {{45105,15},{90200,20},{109755,24},{Double.MAX_VALUE,25.75}};
    private final double[][] ontario2021= {{45145,5.05},{59713,9.15},{70000,11.16},{220000,12.16},{Double.MAX_VALUE,13.16}};
    private final double[][] manitoba2021= {{49162,10.8},{72885,12.75},{Double.MAX_VALUE,17.4}};
    private final double[][] saskatchewan2021= {{84829,10.5},{130506,12.5},{Double.MAX_VALUE,14.5}};
    private final double[][] alberta2021= {{26244,10},{52488,12},{104976,13},{314928,14},{Double.MAX_VALUE,15}};
    private final double[][] british2021= {{42185,5.06},{12497,7.7},{20757,10.5},{41760,12.29},{62937,14.7},{222420,16.8},{Double.MAX_VALUE,20.5}};
    private final double[][] yukon2021= {{49020,6.4},{53938,9},{348022,10.9},{500000,12.8},{Double.MAX_VALUE,15}};
    private final double[][] northwest2021= {{44400,5.9},{55566,8.6},{144362,12.2},{Double.MAX_VALUE,14.05}};
    private final double[][] nunavut2021= {{46740,4},{58498,7},{151978,9},{Double.MAX_VALUE,11.5}};

    private final double[][] newfoundland2022  = {{39137,8.7},{78294,14.5},{139780,15.8},{195693,17.8},{250000,19.8},{500000,20.8}, {1000000,21.3},{Double.MAX_VALUE,21.8}};
    private final double[][] prince2022 = {{31984,9.8},{63969,13.8},{Double.MAX_VALUE,16.7}};
    private final double[][] nova2022 = {{29590,8.79},{59180,14.95},{93000,16.67},{150000,17.5},{Double.MAX_VALUE,21}};
    private final double[][] newBrunswick2022 = {{44887,9.4},{89775,14.82},{145955,16.52},{166280,17.84},{Double.MAX_VALUE,20.3}};
    private final double[][] quebec2022 = {{46295,15},{92580,20},{112655,24},{Double.MAX_VALUE,25.75}};
    private final double[][] ontario2022 = {{46226,5.05},{92454,9.15},{150000,11.16},{220000,12.16},{Double.MAX_VALUE,13.16}};
    private final double[][] manitoba2022 = {{34431,10.8},{74416,12.75},{Double.MAX_VALUE,17.4}};
    private final double[][] saskatchewan2022 = {{46773,10.5},{133638,12.5},{Double.MAX_VALUE,14.5}};
    private final double[][] alberta2022 = {{131220,10},{157464,12},{209952,13},{314928,14},{Double.MAX_VALUE,15}};
    private final double[][] british2022 = {{43070,5.06},{86141,7.7},{98901,10.5},{120094,12.29},{162832,14.7},{227091,16.8},{Double.MAX_VALUE,20.5}};
    private final double[][] yukon2022 = {{50197,6.4},{100392,9},{155625,10.9},{500000,12.8},{Double.MAX_VALUE,15}};
    private final double[][] northwest2022 = {{45462,5.9},{90927,8.6},{147826,12.2},{Double.MAX_VALUE,14.05}};
    private final double[][] nunavut2022 = {{47862,4},{95724,7},{155625,9},{Double.MAX_VALUE,11.5}};



    public double taxOnBracket(double amount, double percent) {
        return (amount * percent) / 100;
    }

    public double getIncomeTax(double[][] taxBrackets, double income) {
        double tax = 0;
        int i = 0;
        while (income > taxBrackets[i][0]) {
            if (i == 0) {
                tax += taxOnBracket(taxBrackets[i][0], taxBrackets[i][1]);
            } else {

                tax += taxOnBracket(taxBrackets[i][0] - taxBrackets[i - 1][0], taxBrackets[i][1]);
            }
            i++;
        }
        if (i == 0) {
            tax += taxOnBracket(income, taxBrackets[i][1]);
        } else {
            tax += taxOnBracket(income - taxBrackets[i - 1][0], taxBrackets[i][1]);
        }

        return tax;
    }

    public double[][] getProvince2021(String name){
        double[][] answer = {};
        return switch (name) {
            case "Ontario" -> ontario2021;
            case "Newfoundland and Labrador" -> newfoundland2021;
            case "Prince Edward Island" -> prince2021;
            case "Nova Scotia" -> nova2021;
            case "New Brunswick" -> newBrunswick2021;
            case "Quebec" -> quebec2021;
            case "Manitoba" -> manitoba2021;
            case "Saskatchewan" -> saskatchewan2021;
            case "Alberta" -> alberta2021;
            case "British Columbia" -> british2021;
            case "Yukon" -> yukon2021;
            case "Northwest Territories" -> northwest2021;
            case "Nunavut" -> nunavut2021;
            default -> answer;
        };
    }

    public double[][] getProvince2022(String name){
        double[][] answer = {};
        return switch (name) {
            case "Ontario" -> ontario2022;
            case "Newfoundland and Labrador" -> newfoundland2022;
            case "Prince Edward Island" -> prince2022;
            case "Nova Scotia" -> nova2022;
            case "New Brunswick" -> newBrunswick2022;
            case "Quebec" -> quebec2022;
            case "Manitoba" -> manitoba2022;
            case "Saskatchewan" -> saskatchewan2022;
            case "Alberta" -> alberta2022;
            case "British Columbia" -> british2022;
            case "Yukon" -> yukon2022;
            case "Northwest Territories" -> northwest2022;
            case "Nunavut" -> nunavut2022;
            default -> answer;
        };
    }

    double[][] getFederal2021(){return federal2021;}
    double[][] getFederal2022(){return federal2022;}
}

