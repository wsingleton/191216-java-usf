package com.revature.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {

    @Id
    private String id;
    private String link;
}
