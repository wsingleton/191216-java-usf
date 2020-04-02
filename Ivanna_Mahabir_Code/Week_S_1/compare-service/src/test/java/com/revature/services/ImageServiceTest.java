package com.revature.services;

import com.revature.entities.Picture;
import com.revature.repositories.ImageMongoRepository;
import com.revature.service.ImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ImageServiceTest {

    @Mock
    ImageMongoRepository repo;

    @InjectMocks
    ImageService sut;

    @Test
    public void testSaveImg(){
        Picture testPic = new Picture("imgD.jpg");
        Picture expectedResult = new Picture("6", "imgB.jpg");

        when(repo.save(Mockito.any())).thenReturn(expectedResult);

        Picture actualResults = sut.save(testPic);
        assertEquals(actualResults, expectedResult);

    }
}
