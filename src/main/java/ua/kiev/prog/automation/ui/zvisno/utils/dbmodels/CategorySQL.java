package ua.kiev.prog.automation.ui.zvisno.utils.dbmodels;
import ua.kiev.prog.automation.base.Session;

import lombok.Builder;
import lombok.Value;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategorySQL {

    @Value
    @Builder(toBuilder = true)
    public static class CategoryItem {
        Integer categoryId;
        Integer parentId;
        String name;
    }

    public Map <Integer, CategoryItem> getIdCategory() {
        Map <Integer, CategoryItem> map = new HashMap<>();
        ResultSet resultSet = Session.getInstance().mysql().executeQuery("SELECT oc_category.category_id, oc_category.parent_id, oc_category_description.name " +
                "FROM oc_category INNER JOIN oc_category_description " +
                "ON oc_category.category_id = oc_category_description.category_id ");
        try {
            while (resultSet.next()) {
                CategoryItem value;
                Integer id = resultSet.getInt("category_id");
                value = CategoryItem.builder().
                        categoryId(resultSet.getInt("category_id")).
                        parentId(resultSet.getInt("parent_id")).
                        name(resultSet.getString("name")).
                        build();
                map.put(id, value);
            }
    }catch (SQLException e) {
            throw new RuntimeException("Can not read result set");
        }
        return map;
    }
}
