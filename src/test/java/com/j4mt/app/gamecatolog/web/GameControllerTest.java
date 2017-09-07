package com.j4mt.app.gamecatolog.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getGame() throws Exception {

        this.mockMvc.perform(get("/game/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Sonic"));
    }

    @Test
    public void getGames() throws Exception{
        this.mockMvc.perform(get("/game/")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void deleteGame() throws Exception{
        this.mockMvc.perform(delete("/game/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNoContent());

        this.mockMvc.perform(get("/game/1")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(404));
    }

}
