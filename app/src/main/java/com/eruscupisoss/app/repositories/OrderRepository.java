package com.eruscupisoss.app.repositories;

import com.eruscupisoss.app.entities.Order;

//Com JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository  extends JpaRepository<Order, Long>{
    
}

//Com MongoDB
//import com.eruscupisoss.app.domain.User;
//import org.springframework.data.mongodb.repository.MongoRepository;
// @Repository
// public interface UserRepository  extends MongoRepository<User, String>{
    
// }
