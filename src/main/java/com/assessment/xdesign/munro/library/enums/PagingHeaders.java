package com.assessment.xdesign.munro.library.enums;

/**
 * Author: Atul Kumar
 * This is used to hold the limit to return entity based on page size.
 * */
public enum PagingHeaders {
    PAGE_SIZE("Page-Size"),
    PAGE_NUMBER("Page-Number"),
    PAGE_OFFSET("Page-Offset"),
    PAGE_TOTAL("Page-Total"),
    COUNT("Count");

    private final String name;

    PagingHeaders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
