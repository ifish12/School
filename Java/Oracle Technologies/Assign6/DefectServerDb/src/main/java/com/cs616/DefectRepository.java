package com.cs616;

/**
 * Created by 1345356 on 2015-12-01.
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "defect", path = "defect")
public interface DefectRepository extends CrudRepository<Defect, Long> {
    List<Defect> findByStatus(@Param("status") Status status);
    List<Defect> findByCreatedBetween(@Param("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")  Date startDate, @Param("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")  Date endDate);
}
