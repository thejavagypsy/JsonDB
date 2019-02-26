package com.thegypsycoder.demo.repository;

import com.thegypsycoder.demo.domain.User;
import org.springframework.data.repository.CrudRepository;





public interface UserRepository extends CrudRepository<User,Long> {

}
