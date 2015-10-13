package com.example.dao;

import com.example.domain.Band;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by daiLlew on 12/10/2015.
 */
public interface BandRepository extends CrudRepository<Band, Long> {

	Band findByName(String name);
}
