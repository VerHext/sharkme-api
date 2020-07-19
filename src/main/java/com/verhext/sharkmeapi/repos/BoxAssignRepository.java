package com.verhext.sharkmeapi.repos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.verhext.sharkmeapi.models.BoxAssignModel;
import com.verhext.sharkmeapi.models.BoxModel;
import org.springframework.data.cassandra.repository.Consistency;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

@Repository
public interface BoxAssignRepository extends CassandraRepository<BoxAssignModel, UUID> {
    @Consistency(DefaultConsistencyLevel.LOCAL_QUORUM)

    @AllowFiltering
    List<BoxAssignModel> findByUserId(UUID id);

    @AllowFiltering
    Optional<BoxAssignModel> findByBoxId(UUID id);

    @AllowFiltering
    Optional<BoxAssignModel> findByBoxIdAndUserId(UUID boxId, UUID userId);

}