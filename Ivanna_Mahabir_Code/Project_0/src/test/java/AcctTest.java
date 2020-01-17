import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.bank.AppDriver;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.Account;
import com.revature.bank.models.User;
import com.revature.bank.repos.AcctRepository;
import com.revature.bank.services.AcctService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AppDriver.class)
@PowerMockIgnore({"org.mockito.*"})


public class AcctTest {

    AcctService sut;
    AcctRepository acctRepository;
    Account acct = mock(Account.class);

    ArrayList<Account> mAcct = new ArrayList<>();

    @Before
    public void init(){
        sut = new AcctService(acctRepository);
        mAcct.add(new Account(1, "User3", 0.0));
        mAcct.add(new Account(2, "User3", 0.0));
        mAcct.add(new Account(3, "User3", 2.059752));
        mAcct.add(new Account(4, "User3", -2.2));

    }

    @After
    public void tearDown(){
        sut = null;
        mAcct.removeAll(mAcct);
    }

    @Test
    public void testIsUserValidWithNegativeValue(){
        Double with = -2.5;
        //mAcct.add(null);
        Double _expectedResult = mAcct.get(2).getBalance();
        Assert.assertEquals(false, sut.validateWith(_expectedResult, with));
    }
    @Test
    public void testIsUserValidWithPostiveValue(){
        Double with = 2.5;
        //mAcct.add(null);
        Double _expectedResult = mAcct.get(3).getBalance();
        Assert.assertEquals(false, sut.validateWith(_expectedResult, with));
    }

    @Test
    public void testIsUserValidDepositNegativeValue(){
        Double with = -2.5;
        //mAcct.add(null);
        Double _expectedResult = mAcct.get(2).getBalance();
        Assert.assertEquals(false, sut.validateDeposit(_expectedResult, with));
    }
}
