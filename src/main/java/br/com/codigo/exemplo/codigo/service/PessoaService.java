package br.com.codigo.exemplo.codigo.service;

import br.com.codigo.exemplo.codigo.dto.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PessoaService {

   private final ObjectMapper objectMapper;

   private static final Logger LOGGER = LoggerFactory.getLogger(PessoaService.class);

   @Autowired
   public PessoaService(ObjectMapper objectMapper) {
         this.objectMapper = objectMapper;
   }

    public void processaJson() {
       try {
           LOGGER.info("Inicio processo JSON");
           ClassPathResource resource = new ClassPathResource("Pessoa.json");
           LOGGER.info("Pessoa JSON do resource: {}", resource);
           Pessoa pessoa = objectMapper.readValue(resource.getInputStream(), Pessoa.class);
           LOGGER.info("Conversão Json Pessoa {}", pessoa);
       }catch (IOException ex){
            LOGGER.error("Error parse JSON: ",ex);
       }

    }

}
