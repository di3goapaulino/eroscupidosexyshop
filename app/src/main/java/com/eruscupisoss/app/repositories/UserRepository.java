package com.eruscupisoss.app.repositories;

import com.eruscupisoss.app.entities.User;

import org.springframework.stereotype.Repository;


//Com JPA
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
    
}

//Com MongoDB
//import com.eruscupisoss.app.domain.User;
//import org.springframework.data.mongodb.repository.MongoRepository;
// @Repository
// public interface UserRepository  extends MongoRepository<User, String>{
    
// }
