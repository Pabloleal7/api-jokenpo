package com.example.apijokenpo.service;

import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.MatchEntity;
import com.example.apijokenpo.entity.PlayerEntity;
import com.example.apijokenpo.repository.MatchRepository;
import com.example.apijokenpo.repository.PlayerRepository;
import com.example.apijokenpo.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MatchService {

    @Autowired
    MatchRepository matchRepository;

    /**
     * Metodo que cria uma partida
     * @param matchEntity
     * @return
     */

    public MatchEntity create(MatchEntity matchEntity) {


        MatchEntity entitySaved = matchRepository.save(matchEntity);

        return entitySaved;
    }

    /**
     * Metodo que lista as partidas
     * @return
     */

    public List<MatchEntity> getAll() {

        return getAllStream().collect(Collectors.toList());

    }

    /**
     * Metodo que rotorna uma partida por id, mas como a partida é so um
     * id para agrupar toda a partida acaba funcionado como um validador para
     * verificar se uma partida existe
     *
     * @param id
     * @return
     */

    public MatchEntity getOneById(Long id){

        return Objects.requireNonNull(matchRepository.findById(id).orElse(null));
    }

    /**
     * Metodo que deleta uma partida
     * @param id
     */
    public void delete(Long id){
        matchRepository.deleteById(id);
    }

    /**
     * Metodo que retorna uma stream de partidas.
     * @return
     */

    public Stream<MatchEntity> getAllStream() {
        return matchRepository.findAll().stream();
    }

}
