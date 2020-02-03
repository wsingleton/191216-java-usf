package com.revature.ers.unit;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.*;
import com.revature.ers.repositories.ReimbursementRepository;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.utils.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ReimbursementService.class)
@PowerMockIgnore({"org.mockito.*","javax.management.*","javax.script.*"})

public class ReimbursementServiceTest {


    ReimbursementService sut;
    ReimbursementRepository mockRepository = mock(ReimbursementRepository.class);
    ConnectionFactory mockConnFac = mock(ConnectionFactory.class);
    Connection mockConn = mock(Connection.class);
    User connUser = mock(User.class);

    Set<Reimbursement> mockReimbursement = new HashSet<>();

    @Before
    public void setup() {
        sut = new ReimbursementService(mockRepository);

        mockReimbursement.add(new Reimbursement(1, 1, LocalDateTime.now(), 0, null, 100, "test1", Type.LODGING, Status.PENDING));
        mockReimbursement.add(new Reimbursement(2, 1, LocalDateTime.now(), 0, null, 100, "test2", Type.LODGING, Status.PENDING));
        mockReimbursement.add(new Reimbursement(3, 2, LocalDateTime.now(), 1, LocalDateTime.now(), 100, "test3", Type.OTHER, Status.APPROVED));
        mockReimbursement.add(new Reimbursement(4, 3, LocalDateTime.now(), 0, null, 100, "test4", Type.FOOD, Status.PENDING));

    }

    @After
    public void teardown(){
        sut = null;
        mockReimbursement.removeAll(mockReimbursement);
    }

    @Test
    public void getAllTest() {

        when(connUser.getRole()).thenReturn(Role.MANAGER);
        when(mockRepository.findAll(connUser)).thenReturn(mockReimbursement);
        Set<Reimbursement> results = sut.getAllReimbursements(connUser);
        assertNotNull(results);
        assertEquals(4, results.size());
    }

    @Test
    public void getAllById() {


        Stream<Reimbursement> expectedStream = mockReimbursement.stream().filter(b -> b.getSubmitId() == 1);
        Set<Reimbursement> expectedResult = expectedStream.collect(Collectors.toSet());
        when(connUser.getRole()).thenReturn(Role.MANAGER);
        when(mockRepository.findByAuthorId(1, connUser)).thenReturn(expectedResult);

        Set<Reimbursement> results = sut.getByAuthorId(1, connUser);
        assertNotNull(results);
        assertEquals(2, results.size());
    }

    @Test
    public void getAllBut() {


        Stream<Reimbursement> expectedStream = mockReimbursement.stream().filter(b -> b.getSubmitId() != 1);
        Set<Reimbursement> expectedResult = expectedStream.collect(Collectors.toSet());
        when(connUser.getRole()).thenReturn(Role.MANAGER);
        when(mockRepository.getAllBut(1, connUser)).thenReturn(expectedResult);
        Set<Reimbursement> results = sut.getAllBut(1, connUser);
        assertNotNull(results);
        assertEquals(2, results.size());
    }



    @Test
    public void placeholder() {
        assert(true);
    }

}
