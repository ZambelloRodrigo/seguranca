package com.rodrigo.seguranca.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.rodrigo.seguranca.util.TokenUtil;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UsuarioControladorIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TokenUtil tokenUtil;

    private String username;
    private String password;
    private Long usuarioId;

    @BeforeEach
    void setUp() throws Exception {
        username = "henrique@gmail.com";
        password = "123456";
        usuarioId = 1L;
    }

    @Test
    public void pegaUsuariPorIdDeveRetornarUnauthorizedQuandoTokenForInvalido() throws Exception {
        ResultActions result = mockMvc.perform(get("/usuarios/" + usuarioId).contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().isUnauthorized());
    }

    @Test
    public void pegaUsuariPorIdDeveRetornarUsuarioQuandoTokenForValido() throws Exception {
        String accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

        ResultActions result = mockMvc.perform(get("/usuarios/" + usuarioId)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").value(1L));
        result.andExpect(jsonPath("$.email").value("henrique@gmail.com"));
    }
}
