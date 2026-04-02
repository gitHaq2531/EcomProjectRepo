package DemoTest;

import org.testng.Assert;

import com.clientName.EComProject.BaseClass.BaseClass;

public class Test extends BaseClass
{
	@org.testng.annotations.Test
	public void test1() throws InterruptedException
	{
		System.out.println("test1");
		Thread.sleep(2000);
		Assert.assertEquals("true", "true");
	
	}

}
