package ua.kiev.prog.automation.ui.zvisno.utils.dbmodels;

import ua.kiev.prog.automation.base.Session;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Currency {

    public List<String> getCurrency (){
        List<String> result = new ArrayList<>();
        ResultSet resultSet = Session.getInstance().mysql().executeQuery("SELECT symbol_left, symbol_right title FROM oc_currency;");

        try {
            while (resultSet.next()) {
                String symbol = !resultSet.getString("symbol_left").isEmpty()?
                        resultSet.getString("symbol_left"):
                        resultSet.getString("symbol_right");
                result.add(symbol + " " + resultSet.getString("title"));
            }
        }catch (SQLException e){
            throw new RuntimeException("Can't read result set");
        }
        return result;
    }
    public List <String> getCurrencyEuro (){
        List <String> result = new ArrayList<>();
        ResultSet resultSet = Session.getInstance().mysql().executeQuery("SELECT symbol_right, title FROM oc_currency, WHERE symbol_right != '' AND symbol_right IS NOT NULL;");

        try {
            while (resultSet.next()) {
                result.add(resultSet.getString(1)+" "+resultSet.getString(2));
            }
        }catch (SQLException e){
            throw new RuntimeException("Can't read result set");
        }
        return  result;
    }
}
