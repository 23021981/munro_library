package com.assessment.xdesign.munro.library.service;

import com.assessment.xdesign.munro.library.enums.PagingHeaders;
import com.assessment.xdesign.munro.library.model.Munro;
import com.assessment.xdesign.munro.library.repository.MunroRepository;
import com.assessment.xdesign.munro.library.services.MunroService;
import com.assessment.xdesign.munro.library.services.MunroServiceImpl;
import com.assessment.xdesign.munro.library.utils.Builder;
import com.assessment.xdesign.munro.library.utils.PagingResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class MunroServiceTest {


    private MunroService munroService;

    private MunroRepository munroRepository = mock(MunroRepository.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.munroService = new MunroServiceImpl(munroRepository);
    }

    @Test(expected = EntityNotFoundException.class)
    public void get_should_throw_EntityNotFoundException() throws EntityNotFoundException {
        // Given

        // When
        munroService.get(1);

        // Then
        fail();
    }

    @Test
    public void get_should_return_the_entity() {
        // Given
        when(munroRepository.findById(eq(1))).thenReturn(Optional.of(Builder.munro(1,
                "Ben Test Munro", new BigDecimal(300.00), "MUN", "MUN",
                "MUN", "MUN", "MUN", "MUN", "MUN", "MUN",
        "MUN", "MUN","MUN")));

        // When
        Munro foundMunro = munroService.get(1);

        // Then
        assertThat(1, equalTo(foundMunro.getRUNNING_NO()));
        assertThat("Ben Test Munro", equalTo(foundMunro.getMunroName()));
        assertThat(new BigDecimal(300.00), equalTo(foundMunro.getHeightInMeter()));
        assertThat("MUN", equalTo(foundMunro.getYear1891()));
        assertThat("MUN", equalTo(foundMunro.getYear1921()));
        assertThat("MUN", equalTo(foundMunro.getYear1933()));
        assertThat("MUN", equalTo(foundMunro.getYear1953()));
        assertThat("MUN", equalTo(foundMunro.getYear1969()));
        assertThat("MUN", equalTo(foundMunro.getYear1974()));
        assertThat("MUN", equalTo(foundMunro.getYear1981()));
        assertThat("MUN", equalTo(foundMunro.getYear1984()));
        assertThat("MUN", equalTo(foundMunro.getYear1990()));
        assertThat("MUN", equalTo(foundMunro.getYear1997()));
        assertThat("MUN", equalTo(foundMunro.getYearPost1997()));

    }

    @Test
    public void get_by_specification_should_return_entities_list() {
        // Given
        Specification querySpec = mock(Specification.class);
        Sort sort = mock(Sort.class);
        when(munroRepository.findAll(querySpec, sort))
                .thenReturn(
                        Arrays.asList(Builder.munro(1,
                                "Ben Test Munro", new BigDecimal(300.00), "MUN", "MUN",
                                "MUN", "MUN", "MUN", "MUN", "MUN", "MUN",
                                "MUN", "MUN","MUN"),
                                Builder.munro(2, "Ben Lui Test", new BigDecimal(250.00),
                                        "TOP", "TOP", "TOP", "TOP", "TOP",
                                        "TOP", "TOP", "TOP", "TOP", "TOP",
                                        "TOP")));

        // When
        List<Munro> foundMunro = munroService.get(querySpec, sort);

        // Then
        verify(munroRepository, times(1)).findAll(querySpec, sort);
        assertThat(2, equalTo(foundMunro.size()));
        assertThat(1, equalTo(foundMunro.get(0).getRUNNING_NO()));
        assertThat("Ben Test Munro", equalTo(foundMunro.get(0).getMunroName()));
        assertThat(new BigDecimal(300.00), equalTo(foundMunro.get(0).getHeightInMeter()));
        assertThat("MUN", equalTo(foundMunro.get(0).getYear1891()));

        assertThat(2, equalTo(foundMunro.get(1).getRUNNING_NO()));
        assertThat("Ben Lui Test", equalTo(foundMunro.get(1).getMunroName()));
        assertThat(new BigDecimal(250.00), equalTo(foundMunro.get(1).getHeightInMeter()));
        assertThat("TOP", equalTo(foundMunro.get(1).getYear1891()));
    }

    @Test
    public void get_by_specification_and_pagination_should_return_paged_entities_list() {
        // Given
        Specification querySpec = mock(Specification.class);
        Sort sort = mock(Sort.class);
        HttpHeaders headers = new HttpHeaders();
        headers.add(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(0));
        headers.add(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(2));

        PageRequest pageRequest = PageRequest.of(0, 2, sort);

        Page<Munro> munros = Mockito.mock(Page.class);
        when(munroRepository.findAll(any(), (Pageable) any())).thenReturn(munros);

        // When
        PagingResponse pagingResponse = munroService.get(querySpec, headers, sort);

        // Then
        verify(munroRepository, times(1)).findAll(querySpec, pageRequest);
        assertThat(0L, equalTo(pagingResponse.getCount()));
        assertThat(0L, equalTo(pagingResponse.getPageNumber()));
        assertThat(0L, equalTo(pagingResponse.getPageSize()));
    }

    @Test
    public void get_by_specification_and_sort_should_return_entities_list() {
        // Given
        Specification querySpec = mock(Specification.class);
        Sort sort = mock(Sort.class);
        HttpHeaders headers = new HttpHeaders();

        PageRequest pageRequest = PageRequest.of(0, 2, sort);

        Page<Munro> munros = Mockito.mock(Page.class);
        when(munroRepository.findAll(any(), (Pageable) any())).thenReturn(munros);

        // When
        munroService.get(querySpec, headers, sort);

        // Then
        verify(munroRepository, times(1)).findAll(querySpec, sort);
    }
}
