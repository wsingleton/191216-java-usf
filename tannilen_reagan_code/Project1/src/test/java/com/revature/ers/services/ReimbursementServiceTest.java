package com.revature.ers.services;

import com.revature.ers.exceptions.InvalidInputException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repos.ReimbursementRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ReimbursementServiceTest {
    ReimbursementService sut;
    ReimbursementRepository reimbRepo=mock(ReimbursementRepository.class);
    Set<Reimbursement> mockReimbs=new HashSet<>();
    @Before
    public void setUp() {
        sut=new ReimbursementService(reimbRepo);
        Reimbursement p1=new Reimbursement(1,500.00,System.currentTimeMillis(),2,1,3);
        Reimbursement p2=new Reimbursement(2,2500.99,System.currentTimeMillis(),2,1,1);
        Reimbursement a1=new Reimbursement(3,8.76,System.currentTimeMillis(),3,2,2);
        mockReimbs.add(p1);
        mockReimbs.add(p2);
        mockReimbs.add(a1);
    }
    @After
    public void tearDown() {
        sut=null;
        mockReimbs.removeAll(mockReimbs);
    }
    @Test
    public void submitNewInvalidType(){
        boolean result=sut.submitNewReimbursement(500.66,85,2);
        assertEquals(false, result);
    }
    @Test
    public void submitNewNegativeAmt(){
        boolean result=sut.submitNewReimbursement(-1.25,3,2);
        assertEquals(false,result);
    }
    @Test
    public void submitNewValid(){
        when(reimbRepo.save(Mockito.notNull())).thenReturn(true);
        boolean result=sut.submitNewReimbursement(25.00, 5, "shenanigans", 2);
        assertEquals(result, true);
    }
    @Test
    public void viewSubmitted(){
        when(reimbRepo.findByAuthor(Mockito.anyInt())).thenReturn(mockReimbs);
        Set<Reimbursement> results=sut.viewSubmitted(1);
        assertNotNull(results);
        assertEquals(3,results.size());
    }
    @Test
    public void findAll(){
        when(reimbRepo.findAll()).thenReturn(mockReimbs);
        Set<Reimbursement> results=sut.viewAll();
        assertNotNull(results);
        assertEquals(3,results.size());
    }
    @Test
    public void updateInvalidReimbursement() {
        Optional<Reimbursement> empty=Optional.empty();
        when(reimbRepo.findById(Mockito.anyInt())).thenReturn(empty);
        boolean result=sut.updateReimb(0,true,2);
        assertEquals(false,result);
    }
    @Test
    public void updateValid() {
        Optional<Reimbursement> full= Optional.of(new Reimbursement(1, 25, System.currentTimeMillis(), 2, 1, 2));
        when(reimbRepo.findById(Mockito.anyInt())).thenReturn(full);
        when(reimbRepo.update(Mockito.notNull())).thenReturn(true);
        boolean result=sut.updateReimb(1,true,1);
        assertEquals(true,result);
    }
}
