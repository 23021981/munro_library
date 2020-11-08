package com.assessment.xdesign.munro.library.services;

import com.assessment.xdesign.munro.library.enums.PagingHeaders;
import com.assessment.xdesign.munro.library.model.Munro;
import com.assessment.xdesign.munro.library.repository.MunroRepository;
import com.assessment.xdesign.munro.library.utils.PagingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

/**
 * Author: Atul Kumar
 * This implements Munro service.
 * */

@Service
public class MunroServiceImpl implements MunroService{

    private final MunroRepository munroRepository;

    public MunroServiceImpl(MunroRepository munroRepository){
        this.munroRepository = munroRepository;
    }

    /**
     * @param id element ID
     * @return element
     * @throws EntityNotFoundException Exception when retrieve element
     */
    @Override
    public Munro get(Integer id) {
        return munroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Can not find the entity Munro (%s = %s).", "id", id.toString())));
    }

    /**
     * get element using Criteria.
     *
     * @param spec    *
     * @param headers pagination data
     * @param sort    sort criteria
     * @return retrieve elements with pagination
     */
    @Override
    public PagingResponse get(Specification<Munro> spec, HttpHeaders headers, Sort sort) {
        if (isRequestPaged(headers)) {
            return get(spec, buildPageRequest(headers, sort));
        } else {
            List<Munro> entities = get(spec, sort);
            return new PagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities);
        }
    }

    private boolean isRequestPaged(HttpHeaders headers) {
        return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
    }

    private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }

    /**
     * get elements using Criteria.
     *
     * @param spec     *
     * @param pageable pagination data
     * @return retrieve elements with pagination
     */
    @Override
    public PagingResponse get(Specification<Munro> spec, Pageable pageable) {
        Page<Munro> page = munroRepository.findAll(spec, pageable);
        List<Munro> content = page.getContent();
        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content);
    }

    /**
     * get elements using Criteria.
     *
     * @param spec *
     * @return elements
     */
    @Override
    public List<Munro> get(Specification<Munro> spec, Sort sort) {
        return munroRepository.findAll(spec, sort);
    }

}