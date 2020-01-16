package com.fauxnancials.services;

import com.fauxnancials.exceptions.ResourceNotFoundException;
import com.fauxnancials.models.Acct;
import com.fauxnancials.models.AcctType;
import com.fauxnancials.repos.AccountRepository;
import org.junit.*;
import org.mockito.Mockito;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AcctServiceTests {
    AcctService sut;
    AccountRepository acctRepo = Mockito.mock(AccountRepository.class);

    Set<Acct> mockAccts=new HashSet<>();

    @Before
    public void setup() {
        sut=new AcctService(acctRepo);
        mockAccts.add(new Acct(1, AcctType.CHECKING, 25.37, 1));
        mockAccts.add(new Acct(2, AcctType.SAVINGS, 85.28, 1));
        mockAccts.add(new Acct(3, AcctType.CHECKING, 573.12, 2));
    }
    @After
    public void teardown() {
        sut=null;
        mockAccts.removeAll(mockAccts);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testPullAcctWithInvalidId() {
        int id=0;
        Optional<Acct> result=Optional.empty();
        when(acctRepo.findByID(id)).thenReturn(result);
        sut.pullAcct(id);
    }
    @Test
    public void testPullAcctWithValidId() {
        int id=2;
        Acct _expected=new Acct(2, AcctType.SAVINGS, 85.28, 1);
        Optional<Acct> test= Optional.of(new Acct(2, AcctType.SAVINGS, 85.28, 1));
        when(acctRepo.findByID(id)).thenReturn(test);
        Acct result=sut.pullAcct(id);
        assertEquals(_expected, result);
    }
    @Test
    public void testValidInputFalse() {
        boolean result=sut.validInput(-8.3);
        assertEquals(false, result);
    }
    @Test
    public void testValidInputTrue() {
        boolean result=sut.validInput(24.92);
        assertEquals(true, result);
    }
    @Test
    public void testNumericInputCleanupWithDollarSign() {
        String s="$22";
        String e="22";
        String r=sut.numericInputCleanup(s);
        assertEquals(true, e.equals(r));
    }
    @Test
    public void testNumericInputCleanupWithExcessiveDecimalPlaces() {
        String s="22.22355034";
        String e="22.22";
        String r=sut.numericInputCleanup(s);
        assertEquals(true, e.equals(r));
    }
}
