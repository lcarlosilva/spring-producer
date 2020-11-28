package com.luiz.udemy.spring.producer.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private String text;

}
