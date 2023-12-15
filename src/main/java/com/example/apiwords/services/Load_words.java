package com.example.apiwords.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class Load_words {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void load_words_first_time() {
        if (!data_in_table_exist()) {
            // Usar esta ruta si se quieren cargar las 100.000 palabras:
            // load_words_from_file("src/main/resources/files/0_palabras_todas.txt");
            // ATENCIÓN: (tiempo de carga: 32 minutos)
            load_words_from_file("src/main/resources/files/muestra.txt");
        }
    }


    private boolean data_in_table_exist() {
        try {
            // Verificar si la tabla 'words' ya existe
            String sql = "SELECT COUNT(*) FROM words";
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

            return count != null && count > 10;
        } catch (Exception e) {
            return false;
        }
    }

    private void load_words_from_file(String ruta_archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta_archivo))) {
            String word;
            while ((word = br.readLine()) != null) {
                if (word != null && !word.trim().isEmpty()) {
                    String sql = "INSERT INTO words (word) VALUES (?)";
                    jdbcTemplate.update(sql, word.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
