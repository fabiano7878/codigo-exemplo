package br.com.codigo.exemplo.codigo.service;

import br.com.codigo.exemplo.codigo.dto.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PessoaServiceTest.class);

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private PessoaService pessoaService;

    private Pessoa pessoaMock;

    @BeforeEach
    void setUp() {
        pessoaMock = new Pessoa();
        pessoaMock.setNome("Fabiano dos Santos Silva");
        pessoaMock.setIdade(45);
    }

    @Test
    public void testProcessaJson() throws IOException {
        // Configura o mock para retornar pessoaMock para qualquer InputStream
        when(objectMapper.readValue(any(InputStream.class), eq(Pessoa.class))).thenReturn(pessoaMock);

        // Executa o método processaJson
        pessoaService.processaJson();

        // Verifica se o ObjectMapper foi chamado corretamente
        verify(objectMapper, times(1)).readValue(any(InputStream.class), eq(Pessoa.class));

        // Valida o conteúdo do objeto Pessoa
        assertEquals("Fabiano dos Santos Silva", pessoaMock.getNome());
        assertEquals(45, pessoaMock.getIdade());
    }
}
