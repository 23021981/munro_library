package com.assessment.xdesign.munro.library.services;

import com.assessment.xdesign.munro.library.model.Munro;
import com.assessment.xdesign.munro.library.utils.PagingResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * Author: Atul Kumar
 * Interface to fetch result from repository
 * */
public interface MunroService {
    public Munro get(Integer id);
    public PagingResponse get(Specification<Munro> spec, HttpHeaders headers, Sort sort);
    public PagingResponse get(Specification<Munro> spec, Pageable pageable);
    public List<Munro> get(Specification<Munro> spec, Sort sort);

}
