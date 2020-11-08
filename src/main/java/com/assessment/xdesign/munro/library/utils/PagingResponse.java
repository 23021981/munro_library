package com.assessment.xdesign.munro.library.utils;

import com.assessment.xdesign.munro.library.model.Munro;
import java.util.List;

/**
 * Author: Atul Kumar
 * DTO using for pagination
 */
public class PagingResponse {

    /**
     * entity count
     */
    private Long count;
    /**
     * page number, 0 indicate the first page.
     */
    private Long pageNumber;
    /**
     * size of page, 0 indicate infinite-sized.
     */
    private Long pageSize;
    /**
     * Offset from the of pagination.
     */
    private Long pageOffset;
    /**
     * the number total of pages.
     */
    private Long pageTotal;
    /**
     * elements of page.
     */
    private List<Munro> elements;

    public PagingResponse(long count, long pageNumber, long pageSize, long pageOffset, long pageTotal, List<Munro> elements) {
        this.count = count;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageOffset = pageOffset;
        this.pageTotal = pageTotal;
        this.elements = elements;
    }


    public Long getCount() {
        return count;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public Long getPageOffset() {
        return pageOffset;
    }

    public Long getPageTotal() {
        return pageTotal;
    }

    public List<Munro> getElements() {
        return elements;
    }

}
