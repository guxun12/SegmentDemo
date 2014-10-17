package com.example.injector;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;  
import java.lang.annotation.RetentionPolicy;  

@Target({ ElementType.FIELD })  
@Retention(RetentionPolicy.RUNTIME)  
public @interface InjectView {  
    public int value();  
}  