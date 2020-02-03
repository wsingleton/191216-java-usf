package com.ers.liberation.servicetest;

import com.ers.liberation.models.User;
import com.ers.liberation.repos.ReimbursementRepository;
import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.services.ReimbursementService;
import com.ers.liberation.services.UserService;
import com.ers.liberation.util.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
@RunWith(PowerMockRunner.class)
@PrepareForTest({ ConnectionFactory.class})
@PowerMockIgnore({"org.mockito.*"})
public class ReimbursementServiceTest {


        private ReimbursementService sut;
        public ReimbursementService mockService = mock(ReimbursementService.class);
        public ReimbursementRepository mockRepo = mock(ReimbursementRepository.class);
        /*
        JUnit rules is a component that intercepts test method calls and allows us to do something before a test method has
         run - typically adding additional constraints to the test case.
         */
        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        @Rule
        public Timeout globalTimeout = Timeout.seconds(5);

        @Before
        public void setUp() {
            sut = new ReimbursementService(mockRepo);
        }

        @After
        public void tearDown() {
            sut = null;
        }

        @Test
        public void testValidateAmountForCorrectInputs() {
            String message = "if input is entered correctly, return false";
            double testAmount = 3.50;
            boolean actualResult = sut.validateReimbAmount(testAmount);
            assertTrue(message, actualResult);
        }

        @Test
        public void testValidateAmountForNegativeInputs() {
            String message = "if input is entered correctly, return false";
            double testAmount = -3.50;
            boolean actualResult = sut.validateReimbAmount(testAmount);
            assertFalse(message, actualResult);
        }

        @Test
        public void testValidateAmountForOutOfRangeInputs() {
            String message = "if input is entered correctly, return false";
            double testAmount = 6000;
            boolean actualResult = sut.validateReimbAmount(testAmount);
            assertFalse(message, actualResult);
        }



        @Test
        public void testIfValueIsSanitized() {
            String message = "if a input is invalid, return false";
            double testAmount = 1.130546454548;
            double expectedResult = 1.13;
            double actualResult = sut.sanitizeValue(testAmount);
            assertEquals(message, expectedResult, actualResult, expectedResult);
        }

        @Test
        public void testisValidDescriptionLengthForFalse() {
            String message = "if the input is too long of a string but contains a character, return true";
            String testDescription = "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog" +
                    "!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!" +
                    "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!" +
                    "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!" +
                    "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!" +
                    "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dogdog!dog!dog!dog!dog!dog!" +
                    "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!!dog!dog!dog!dog!" +
                    "dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!dog!";
            boolean actualResult = sut.isValidDescriptionLength(testDescription);
            assertTrue(message, actualResult);
        }


    }
