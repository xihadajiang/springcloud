package org.inspurcloud.ibase;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inspur.incloud.InspurCloudIbaseApplication;
import com.inspur.incloud.ibase.client.model.user.UserApiModel;
import com.inspur.incloud.ibase.rabbitmq.user.IUserMessageProvider;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={InspurCloudIbaseApplication.class,AppTest.class})
public class AppTest 
{
	
	@Autowired
	private IUserMessageProvider iUserMessageProvider;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
    @Test
    public void testSendMq()
    {
    	UserApiModel c = new UserApiModel();
    	c.setAccount("wangqiang11111");
    	c.setEmail("wq2@163.com");
    	iUserMessageProvider.send(c);
    }
    
    
    
}
