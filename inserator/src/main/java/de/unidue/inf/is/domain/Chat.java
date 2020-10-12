package de.unidue.inf.is.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private String id;
    private String text;
    private String absender;
    private String empfaenger;
}
