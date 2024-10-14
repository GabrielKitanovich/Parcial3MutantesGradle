package com.example.Mutantes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MutantesApplicationTests {

    @Mock
    private MutantService mutantService;

    @Mock
    private DnaRepository dnaRepository;

    @InjectMocks
    private MutantController mutantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void checkMutantReturnsBadRequestForInvalidDna() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA"}; // Invalid DNA (not a square matrix)
        DnaRequest dnaRequest = new DnaRequest(dna);

        ResponseEntity<String> response = mutantController.checkMutant(dnaRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid DNA sequence", response.getBody());
    }

    @Test
    void getStatsReturnsZeroWhenNoData() {
        when(dnaRepository.countByIsMutant(true)).thenReturn(0L);
        when(dnaRepository.countByIsMutant(false)).thenReturn(0L);

        Map<String, Object> stats = mutantController.getStats();

        assertEquals(0L, stats.get("count_mutant_dna"));
        assertEquals(0L, stats.get("count_human_dna"));
        assertEquals(1.0, stats.get("ratio"));
    }

    @Test
    void checkMutantHandlesNullDnaRequest() {
        ResponseEntity<String> response = mutantController.checkMutant(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid DNA sequence", response.getBody());
    }
}