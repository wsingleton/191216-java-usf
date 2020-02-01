package com.revature.mockERS;

import com.revature.mockERS.dto.ChangeStatusIn;
import com.revature.mockERS.dto.ReimbursementIn;
import com.revature.mockERS.dto.ReimbursementOut;
import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.repositories.ReimbursementRepository;
import com.revature.mockERS.services.ReimbursementService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static org.easymock.EasyMock.expect;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ERS_Reimbursement.class)
public class ReimbursementServiceTest {
    private ReimbursementService sut;
    private ReimbursementRepository rr;
    private Date date;
    @Mock
    private ERS_Reimbursement ers;
    private ReimbursementIn ri;
    private ChangeStatusIn csi;

    @Before
    public void setUp() {
        sut = mock(ReimbursementService.class);
        date = mock(Date.class);
        ers = mock(ERS_Reimbursement.class);
        ri = mock(ReimbursementIn.class);
        rr = mock(ReimbursementRepository.class);
        csi = mock(ChangeStatusIn.class);
    }

    @After
    public void tearDown(){
        sut = null;
    }



    @Test
    public void createNewTest(){
        when(rr.addReimbursement(ers)).thenReturn(true);
        doReturn(true).when(sut).createNew(ri);
        Boolean result = sut.createNew(ri);
        Assert.assertEquals(true, result);
    }

    @Test
    public void returnAllUnprocessedReimbsTest(){
        doReturn(new ArrayList<>()).when(sut).returnAllUnprocessedReimbs();
        List<ReimbursementOut> list = sut.returnAllUnprocessedReimbs();
        Assert.assertEquals(new ArrayList<>(), list);
    }

    @Test
    public void returnReimbursementByUserTest(){
        doReturn(new HashSet<>()).when(rr).getReimbursementByUser(ArgumentMatchers.anyInt());
        Set<ReimbursementOut> set = sut.returnReimbursementByUser(ArgumentMatchers.anyInt());
        Assert.assertEquals(new HashSet<>(), set);
    }

    //todo figure out why mockstatic isn't working
    @Test
    public void updateStatusTest(){
        mockStatic(ERS_Reimbursement.class);
        PowerMockito.when(ERS_Reimbursement.makeReimbursement()).thenReturn(ers);

//        expect(ERS_Reimbursement.makeReimbursement()).andReturn(ers);
        doReturn(true).when(rr).updateReimbStatus(ers);
        Boolean result = sut.updateStatus(csi);
        Assert.assertNotEquals(false, result);
    }

}
