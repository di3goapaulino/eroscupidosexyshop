package com.eruscupisoss.app.repositories;

import com.eruscupisoss.app.entities.Category;

//Com JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long>{
    
}

//Com MongoDB
//import com.eruscupisoss.app.domain.User;
//import org.springframework.data.mongodb.repository.MongoRepository;
// @Repository
// public interface UserRepository  extends MongoRepository<User, String>{
    
// }
