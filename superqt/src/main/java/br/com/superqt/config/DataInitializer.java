package br.com.superqt.config;

import br.com.superqt.model.Aluno;
import br.com.superqt.model.Perfil;
import br.com.superqt.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class DataInitializer{
    @Bean
    CommandLineRunner initDatabase(AlunoRepository repository) {
        return args -> {
            // Verifica se o admin com esse CPF já existe para não duplicar
            if (repository.findByCpfaluno("000.000.000-00").isEmpty()) {
                Aluno admin = new Aluno();
                admin.setNome("Admin do Sistema");
                admin.setCPFaluno("000.000.000-00");
                admin.setSenha("admin123"); // Em produção, aqui usaria criptografia
                admin.setIdade(99);
                admin.setPerfil(Perfil.ADMIN); // Define explicitamente como ADMIN

                repository.save(admin);
                System.out.println("--> Usuário ADMINISTRADOR criado com sucesso! (CPF: 000.000.000-00)");
            }
        };
    }
}
