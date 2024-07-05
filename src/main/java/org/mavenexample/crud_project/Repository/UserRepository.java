package org.mavenexample.crud_project.Repository;



import org.mavenexample.crud_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
