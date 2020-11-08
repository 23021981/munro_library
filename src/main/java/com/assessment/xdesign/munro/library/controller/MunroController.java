package com.assessment.xdesign.munro.library.controller;

import com.assessment.xdesign.munro.library.enums.PagingHeaders;
import com.assessment.xdesign.munro.library.model.Munro;
import com.assessment.xdesign.munro.library.services.MunroService;
import com.assessment.xdesign.munro.library.utils.PagingResponse;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: Atul Kumar
 * This controller responsible to accept request and return response
 * */

@RestController
@RequestMapping("/api/munro")
public class MunroController {

    private final MunroService munroService;

    @Autowired
    public MunroController(MunroService munroService) {
        this.munroService = munroService;
    }
    
    @Transactional
    @GetMapping(value = "/{runningNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Munro get(@PathVariable(name = "runningNo") Integer runningNo) {
        return munroService.get(runningNo);
    }

    @Transactional
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Munro>> get(
            @And({
                    @Spec(path = "heightInMeter", params = "heightInMeter", spec = Equal.class),
                    @Spec(path = "munroName", params = "munroName", spec = Like.class),
                    @Spec(path = "heightInMeter", params = "heightInMeterMax", spec = LessThan.class),
                    @Spec(path = "heightInMeter", params = "heightInMeterMin", spec = GreaterThan.class),
                    @Spec(path = "year1891", params = "year1891", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1921", params = "year1921", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1933", params = "year1933", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1953", params = "year1953", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1969", params = "year1969", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1974", params = "year1974", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1981", params = "year1981", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1984", params = "year1984", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1990", params = "year1990", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "year1997", params = "year1997", defaultVal = {"MUN","TOP"}, spec = In.class),
                    @Spec(path = "yearPost1997", defaultVal = {"MUN","TOP"}, spec = In.class)
            }) Specification<Munro> spec,
            Sort sort,
            @RequestHeader HttpHeaders headers) {
        final PagingResponse response = munroService.get(spec, headers, sort);
        return new ResponseEntity<>(response.getElements(), returnHttpHeaders(response), HttpStatus.OK);
    }

    public HttpHeaders returnHttpHeaders(PagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }

}