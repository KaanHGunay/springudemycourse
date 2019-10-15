package com.khg.springaopudemy.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Metotlarda kullanılacak
@Retention(RetentionPolicy.RUNTIME)  // Runtime da aktif olsun
public @interface TrackTime {
}
