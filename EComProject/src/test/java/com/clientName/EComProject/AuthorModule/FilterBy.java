package com.clientName.EComProject.AuthorModule;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.clientName.EComProject.BaseClass.BaseClass;


public class FilterBy extends BaseClass
{
	@Test
	public void sortByLowToHighPrice()
	{
		hp.getChetanBhagat().click();
		WebElement sort = driver.findElement(By.name("sort"));
		sort.click();
		wu.selectByVisibleText(sort, "Low To High Price ");
		
		
		List<WebElement> ogPrice = driver.findElements(By.xpath("//span[@style='text-decoration:line-through;color:#828282;']"));
		List<Integer> prices = new ArrayList<>();
			// Convert WebElement → Integer
			for(WebElement e : ogPrice)
			{
			    String text = e.getText();           // Example: Rs. 299
			    int price = Integer.parseInt(text.replaceAll("[^0-9]", ""));
			    prices.add(price);
			}

			// Now check sorting
			boolean isSorted = true;

			for(int i = 0; i < prices.size() - 1; i++)
			{
			    if(prices.get(i) > prices.get(i + 1))
			    {
			        isSorted = false;
			        break;
			    }
			}
			assertTrue(isSorted);
	}
}
