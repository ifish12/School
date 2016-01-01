package com.cs616;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by 1345356 on 2015-11-24.
 */

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(@Param("name") String name);
    List<User> findByUserType(@Param("usertype") UserType userType);
}
