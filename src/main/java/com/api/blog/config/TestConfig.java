package com.api.blog.config;

import com.api.blog.entities.Blog;
import com.api.blog.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void run(String... args) throws Exception {
        Blog blog1 = new Blog(null, "WhatsApp testa tradução em tempo real no aplicativo; entenda!", "Recurso que traduz mensagens foi encontrado em versão de testes do mensageiro; veja o que já se sabe sobre a função e quando ela deve ser lançada para todos os usuários!");
        Blog blog2 = new Blog(null, "App Bradesco fora do ar? Usuários relatam problemas para fazer login!", "Aplicativo do banco exige atualização para concluir login, mas não há updates pendentes, segundo usuários; Downdetector acumula mais de 250 reclamações sobre a instabilidade!");
        Blog blog3 = new Blog(null, "Relembre 12 filmes remakes que são considerados melhores que os originais", "Produções como Duna, It: A Coisa, Nasce Uma Estrela e 007: Cassino Royale tiveram mais apelo com crítica e público do que as obras originais que as inspiraram;");
        Blog blog4 = new Blog(null, "Produções como Duna, It: A Coisa, Nasce Uma Estrela e 007: Cassino Royale tiveram mais apelo com crítica e público do que as obras originais que as inspiraram;", "Plataformas de Inteligência Artificial (IA) gratuitas criam letras e melodias originais a partir de comandos de texto e permitem ajustes personalizáveis em canções");

        this.blogRepository.saveAll(Arrays.asList(blog1, blog2, blog3, blog4));
    }
}
