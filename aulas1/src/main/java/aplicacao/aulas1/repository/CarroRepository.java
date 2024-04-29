package aplicacao.aulas1.repository;

import aplicacao.aulas1.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

@Repository
@ApplicationScope
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
