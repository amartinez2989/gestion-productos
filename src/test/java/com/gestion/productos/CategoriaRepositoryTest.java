package com.gestion.productos;
import static org.assertj.core.api.Assertions.assertThat;
import com.gestion.productos.entity.Categoria;
import com.gestion.productos.repositories.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Rollback(value = false)
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository repository;

    @Test
    public void testCategoria(){
        Categoria categoriaGuardada = repository.save(new Categoria("Electrónicos"));
        assertThat(categoriaGuardada.getId()).isGreaterThan(0);
    }
}
