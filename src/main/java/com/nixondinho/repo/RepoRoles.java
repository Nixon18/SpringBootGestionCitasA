package com.nixondinho.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nixondinho.model.Roles;

@Repository
public interface RepoRoles extends JpaRepository<Roles, Integer>, PagingAndSortingRepository<Roles, Integer> {

	

}
