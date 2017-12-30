import com.springwithhibernate.model.Account;
import com.springwithhibernate.service.ITestHibernateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Main {
    @Resource(name = "testHibernateService")
    private ITestHibernateService testHibernateService;

    @Test
    public void testTransation() {
        boolean b;
        try {
            System.out.println("is null :  " + testHibernateService);
            b = testHibernateService.transfer(200, 1, 2);
            if(b){
                System.out.println("转账成功");
            }else{
                System.out.println("转账失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }

    @Test
    public void testsave(){
        Account account = new Account();
        account.setMoney(1000);
        account.setName("zhonglin");
        testHibernateService.save(account);
    }
    @Test
    public void testGet(){

        Account account = testHibernateService.getEntity(Account.class,1);
        Account account2 = testHibernateService.getEntity(Account.class,2);
        System.out.println(account);
        System.out.println(account2);
    }
}