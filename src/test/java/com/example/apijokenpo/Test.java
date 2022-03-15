package com.example.apijokenpo;


import com.example.apijokenpo.controller.PlayerController;
import com.example.apijokenpo.dto.request.CreateInputDTO;
import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.PlayerEntity;
import com.example.apijokenpo.repository.PlayerRepository;
import com.example.apijokenpo.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/*
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc*/
public class Test {

    /*@Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PlayerRepository playerRepository;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private PlayerController playerController;


    @Autowired
    private MockMvc mockMvc;*/



   /* @BeforeEach
    void initUseCase() {
        PlayerEntity entity = new PlayerEntity();
        entity.setId(1L);
        entity.setName("Pablo");
        Mockito.when(playerRepository.save(Mockito.any(PlayerEntity.class))).thenReturn(entity);
    }*/

  /*  @org.junit.jupiter.api.Test
    public void testAddPlayerService() {
        CreatePlayerDTO dto = new CreatePlayerDTO();
        dto.setName("Lapalui");

        PlayerResponseDTO saved = playerService.create(dto);

        System.out.println(saved.getId());

        Assertions.assertEquals(saved.getId(), 1L);
    }


    @org.junit.jupiter.api.Test
    void testListAllPlayers() {

        PlayerEntity p1 = new PlayerEntity();
        PlayerEntity p2 = new PlayerEntity();
        PlayerEntity p3 = new PlayerEntity();
        PlayerEntity p4 = new PlayerEntity();


        Mockito.when(playerRepository.findAll()).thenReturn(Arrays.asList(p1, p2, p3, p4));

        ResponseEntity<PlayerResponseDTO[]> responseEntity = restTemplate.getForEntity("/players",
                PlayerResponseDTO[].class);

        int statusCodeRetornado = responseEntity.getStatusCodeValue();
        PlayerResponseDTO[] dtos = responseEntity.getBody();
        int quantidade = dtos.length;

        System.out.println(quantidade);

        assertEquals(statusCodeRetornado, 200);
        assertEquals(quantidade, 4);

    }

    @org.junit.jupiter.api.Test
    void testGetPlayer() throws Exception {

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName("Pablo");
        playerEntity.setId(1L);

        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(1L);
        dto.setName("Pablo");


        // fazer mock do repository
        Mockito.when(playerController.getOneById(Mockito.any())).thenReturn(dto);
        // Mockito.doNothing().when(playerRepository).Mockito.any());


        ObjectMapper objectMapper = new ObjectMapper();
        String requestDTOAsString = objectMapper.writeValueAsString(playerEntity);

        mockMvc.perform(patch("/players/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestDTOAsString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andReturn();
    }
*/

}
