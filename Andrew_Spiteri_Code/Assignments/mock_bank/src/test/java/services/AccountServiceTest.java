package services;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.repositories.AccountRepository;
import com.revature.services.AccountService;
import org.junit.*;
import org.mockito.ArgumentMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    AccountRepository ar;
    AccountService as;


    @Before
    public void setUp(){
        ar = mock(AccountRepository.class);
        as = new AccountService(ar);
    }

    @After
    public void tearDown(){
        ar = null;
    }

    @Test
    public void getAccAmountTest(){
        when(ar.findById(anyInt())).thenReturn(new HashSet<Account>());
        Set<Account> ac = as.getAccAmount(anyInt());
        Assert.assertEquals(new HashSet<Account>(), ac);
    }

    @Test(expected = NullPointerException.class)
    public void makePaymentTestWithNoMoney(){
        Account account = mock(Account.class);
        Boolean bool = as.makePayment(account, 55.5);
        Assert.assertEquals(true, bool);
    }

    @Ignore
    public void makePaymentTestWithMoney(){
        Account account = new Account(11111111,11111111,2555.0,AccountType.AUTOLOAN);
        when(ar.update(account,55.5)).thenReturn(true);
        Boolean bool = as.makePayment(account, 55.5);
        Assert.assertEquals(true, bool);
    }

    @Test
    public void createAccountTest(){
        Account account = mock(Account.c
    }

}
