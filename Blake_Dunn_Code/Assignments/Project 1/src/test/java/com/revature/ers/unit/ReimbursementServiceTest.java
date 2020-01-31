package com.revature.ers.unit;


import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.ReimbursementStatus;
import com.revature.ers.models.ReimbursementType;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.util.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*"})
public class ReimbursementServiceTest {

    ReimbursementService sut;
    ReimbursementRepository reimbRepo = mock(ReimbursementRepository.class);
    Reimbursement mockReimb = mock(Reimbursement.class);
    Comparator<Reimbursement> mockComparator = mock(Comparator.class);

    Set<Reimbursement> mockReimbs = new HashSet<>();

    @Before
    public void setup(){
        sut = new ReimbursementService(reimbRepo);
        mockReimbs.add(new Reimbursement(1,35.0, "lfjslfs", 1, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
        mockReimbs.add(new Reimbursement(2,30.0, "lfjslfs", 2, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
        mockReimbs.add(new Reimbursement(3,45.0, "lfjslfs", 3, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
        mockReimbs.add(new Reimbursement(4,50.0, "lfjslfs", 2, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
    }

    @After
    public void  tearDown() {
        sut = null;
    }

    @Test
    public void testSaveReimbWithValidReimb() {
        Reimbursement reimb = new Reimbursement(30.0, "lfjslfs", 1, ReimbursementType.FOOD);
        when(reimbRepo.save(any())).thenReturn(mockReimb);
        sut.saveReimb(reimb);
    }

    @Test(expected = InvalidRequestException.class)
    public void testSaveReimbWithNegativeAmount() {
        Reimbursement reimb = new Reimbursement(-30.0, "lfjslfs", 1, ReimbursementType.FOOD);
        sut.saveReimb(reimb);
    }

    @Test(expected = InvalidRequestException.class)
    public void testSaveReimbWithZeroAmount() {
        Reimbursement reimb = new Reimbursement(0.0, "lfjslfs", 1, ReimbursementType.FOOD);
        sut.saveReimb(reimb);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetAllReimbsWithEmptySet() {
        Set<Reimbursement> empty = new HashSet<>();
        when(reimbRepo.findAll()).thenThrow(new ResourceNotFoundException());
        sut.getAllReimbs();
    }

    @Test
    public void testGetAllReimbWithValidSet() {
        when(reimbRepo.findAll()).thenReturn(mockReimbs);
        sut.getAllReimbs();
    }

    @Test(expected = NullPointerException.class)
    public void testGetReimbByStatusWithInvalidInput() {
        when(reimbRepo.findReimbByStatus(any())).thenThrow(new NullPointerException());
        sut.getReimbByStatus(3);
    }

//    @Test
//    public void testSortReimbsByAuthor() {
//        String str = "author";
//        SortedSet<Reimbursement> expectedResult = new TreeSet<>();
//        expectedResult.add(new Reimbursement(1,35.0, "lfjslfs", 1, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
//        expectedResult.add(new Reimbursement(2,30.0, "lfjslfs", 2, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
//        expectedResult.add(new Reimbursement(4,50.0, "lfjslfs", 2, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
//        expectedResult.add(new Reimbursement(3,45.0, "lfjslfs", 3, ReimbursementStatus.PENDING, ReimbursementType.FOOD));
//        System.out.println(expectedResult);
//        SortedSet<Reimbursement> actualResult = sut.sortReimbs(str, mockReimbs);
//        assertEquals(expectedResult, actualResult);
//    }

    @Test(expected = InvalidRequestException.class)
    public void testUpdateReimbursementWithPendingStatus() {
        Reimbursement mock = new Reimbursement(1,35.0, "lfjslfs", 1, ReimbursementStatus.PENDING, ReimbursementType.FOOD);
        sut.updateReimbursement(mock);
    }

    @Test
    public void testUpdateReimbursementWithApprovedStatus() {

       Reimbursement mock = new Reimbursement(1,35.0, "lfjslfs", 1, ReimbursementStatus.APPROVED, ReimbursementType.FOOD);
        when(reimbRepo.update(any())).thenReturn(true);
        sut.updateReimbursement(mock);
    }

    @Test
    public void testUpdateReimbursementWithDeniedStatus() {

        Reimbursement mock = new Reimbursement(1,35.0, "lfjslfs", 1, ReimbursementStatus.DENIED, ReimbursementType.FOOD);
        when(reimbRepo.update(any())).thenReturn(true);
        sut.updateReimbursement(mock);
    }
}
