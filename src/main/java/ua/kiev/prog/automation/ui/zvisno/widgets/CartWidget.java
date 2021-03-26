package ua.kiev.prog.automation.ui.zvisno.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.page.BasePage;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartWidget extends BasePage {

    final static private String ITEMS_COUNT = "items_count";
    final static private String TOTAL_SUM = "total_sum";
    final private SelenideElement cart = Selenide.$x ("//div[@id='cart']");
    final public SelenideElement total = cart.$x(".//span[@id='cart-total']");

    private Map<String,String> parseTotalInfo (){
        Map <String,String> result = new HashMap<>();
        //Товары: 0($0.00)
        Pattern p = Pattern.compile("^.+?:\\s(\\d+?)\\((.+?)\\)$");
        Matcher m = p.matcher(total.getText());
        if(m.matches()){
            result.put(ITEMS_COUNT, m.group(1));
            result.put(TOTAL_SUM,   m.group(2));
        }else{
            p = Pattern.compile("^.+?:\\s(\\d+?).+?(\\S+?)$");
            m = p.matcher(total.getText());
            if(m.matches()) {
                result.put(ITEMS_COUNT, m.group(1));
                result.put(TOTAL_SUM, m.group(2));
            }else{
                throw new RuntimeException("Text does not match pattern");
            }
        }
        return result;
    }

    public Integer getItemsCount (){
        return Integer.parseInt(parseTotalInfo().get(ITEMS_COUNT));

    }

    public String getTotalSum (){
        return parseTotalInfo().get(TOTAL_SUM);
    }

    public void click(){
        cart.click();
    }
}
