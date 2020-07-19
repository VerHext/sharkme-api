package com.verhext.sharkmeapi.repos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.verhext.sharkmeapi.models.CardModel;

import org.springframework.data.cassandra.repository.Consistency;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

@Repository
public interface CardRepository extends CassandraRepository<CardModel, UUID> {
    @Consistency(DefaultConsistencyLevel.LOCAL_QUORUM)
    Optional<CardModel> findById(UUID id);

    @AllowFiltering
    List<CardModel> findAllByBox(UUID box);

}