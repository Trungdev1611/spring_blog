package com.example.Blog_model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataExists extends  RuntimeException{
    String message= "Data is exists. Please provide another input and try again";

    public DataExists(String message) {
        this.message = message;
    }
}
