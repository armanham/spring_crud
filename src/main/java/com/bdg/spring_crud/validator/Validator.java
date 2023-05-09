package com.bdg.spring_crud.validator;

public class Validator {

    public static void checkId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("'id' must be a positive integer number: ");
        }
    }

    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Passed null value: ");
        }
    }

    public static void checkNonNullAndNonEmptyString(String str) {
        checkNull(str);
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Passed an empty string: ");
        }
    }
}