package com.email.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmailModel {
    private String to;
    private String message;
    private String subject;

}
