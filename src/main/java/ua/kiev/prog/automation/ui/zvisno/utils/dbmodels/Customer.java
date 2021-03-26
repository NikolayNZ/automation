package ua.kiev.prog.automation.ui.zvisno.utils.dbmodels;

import lombok.Builder;
import lombok.Value;
import ua.kiev.prog.automation.base.Session;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {


    @Value
    @Builder (toBuilder = true)
    public static class Item {
         Integer id;
         String firstName;
         String lastName;
         String email;

        @Override
        public String toString (){
            return "id:" +id + "fn:" +firstName+ "ln:" +lastName+ "email:" +email;
        }

    }

    public List<Integer> getCustomerIDs() {
        List<Integer> result = new ArrayList<>();
        ResultSet resultSet = Session.getInstance().mysql().executeQuery("SELECT customer_id FROM oc_customer;");
        try {
            while (resultSet.next()) {
                result.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't read result set");
        }
        return result;

    }

    public Item getCustomerById(Integer id){
        Item result = null;

        ResultSet resultSet = Session.getInstance().mysql().executeQuery("SELECT * FROM oc_customer WHERE customer_id="+id+";");
        try {
            while (resultSet.next()) {
                result = Item.builder().
                        id(id).
                        firstName(resultSet.getString("firstname")).
                        lastName(resultSet.getString("lastname")).
                        email(resultSet.getString("email")).
                        build();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't read result set");
        }
        return result;

    }
}
