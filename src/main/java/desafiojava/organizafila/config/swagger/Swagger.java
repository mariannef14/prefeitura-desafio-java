package desafiojava.organizafila.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Component
public class Swagger {
    
    @Bean
    public OpenAPI retornarinfoApi(){
        return new OpenAPI()
        .info(detalhesApi());
    }

    public Info detalhesApi(){
        return new Info()
        .title("API para organizar filas")
        .description("API para informar a posição dos clientes na fila. Quando é atendido(posição 0), seu cadastro é deletado do banco de dados")
        .version("1.0.0"); 
    }
}