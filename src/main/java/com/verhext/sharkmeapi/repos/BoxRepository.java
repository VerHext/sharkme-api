package com.verhext.sharkmeapi.repos;

import java.util.Optional;
import java.util.UUID;

import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.verhext.sharkmeapi.models.BoxModel;
import org.springframework.data.cassandra.repository.Consistency;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.CassandraRepository;

@Repository
public interface BoxRepository extends CassandraRepository<BoxModel, UUID> {
    @Consistency(DefaultConsistencyLevel.LOCAL_QUORUM)
    Optional<BoxModel> findById(UUID id);

}