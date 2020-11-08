package com.assessment.xdesign.munro.library.repository;

import com.assessment.xdesign.munro.library.model.Munro;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
* Author: Atul Kumar
 * Interface to intact with database using JPA API's
* */
@Repository
public interface MunroRepository extends PagingAndSortingRepository<Munro, Integer>, JpaSpecificationExecutor<Munro> {
}