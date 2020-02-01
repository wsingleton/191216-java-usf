package com.revature.unit;

import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.Type;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"org.mockito.*"})

public class ReimbursementServiceTest {
    ReimbursementService sut;
    ReimbursementRepository reimbRepo = mock(ReimbursementRepository.class);

    ArrayList<Reimbursement> mockReimb = new ArrayList<>();

    @Before
    public void setUp() {
        sut = new ReimbursementService(reimbRepo);
        mockReimb.add(new Reimbursement(1, "20", 1, Status.getById(1), Type.getById(1)));
        mockReimb.add(new Reimbursement(2, "20", 2, Status.getById(1), Type.getById(1)));
    }

    @After
    public void tearDown() {
        sut = null;
        mockReimb.removeAll(mockReimb);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testFindReimbByIdWithUnknownID() throws ResourceNotFoundException {
        int testId = 3;
        Optional<Reimbursement> _expectedResult = mockReimb.stream().filter(r -> r.getId() == testId ).findFirst();
        when(reimbRepo.findById(testId)).thenReturn(_expectedResult);
        sut.getReimbursementById(testId);
    }
    @Test
    public void testFindReimbByIdWithknownID() throws ResourceNotFoundException {
        int testId = 1;
        Optional<Reimbursement> _expectedResult = mockReimb.stream().filter(r -> r.getId() == testId ).findFirst();
        when(reimbRepo.findById(testId)).thenReturn(_expectedResult);
        sut.getReimbursementById(testId);
    }
    @Test
    public void testGetAllReimbs() {
        int length = 2;
        Set<Reimbursement> expectResult = new HashSet<>();
        expectResult.add(mockReimb.get(0));
        expectResult.add(mockReimb.get(1));
        when(reimbRepo.findAll()).thenReturn(expectResult);
        int allReimb = sut.getAllReimbursements().size();
        Assert.assertEquals(true,allReimb == length);
    }

    @Test
    public void testGetAllReimbsWithWrongLength() {
        int length = 3;
        Set<Reimbursement> expectResult = new HashSet<>();
        expectResult.add(mockReimb.get(0));
        expectResult.add(mockReimb.get(1));
        when(reimbRepo.findAll()).thenReturn(expectResult);
        int allReimb = sut.getAllReimbursements().size();
        Assert.assertEquals(false,allReimb == length);
    }



}
