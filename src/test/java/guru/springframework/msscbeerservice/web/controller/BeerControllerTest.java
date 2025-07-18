package guru.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import guru.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/{beerId}",UUID.randomUUID().toString()))
                .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().
                id(null)
                .version(null)
                .createdDate(null)
                .lastModifiedDate(null)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(123456789012L)
                .price(BigDecimal.valueOf(300))
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerByid() throws Exception {
        BeerDto beerDto = BeerDto.builder().
                id(null)
                .version(null)
                .createdDate(null)
                .lastModifiedDate(null)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(123456789012L)
                .price(BigDecimal.valueOf(300))
                .build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/{beerId}",UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

    }
}