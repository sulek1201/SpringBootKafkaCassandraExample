package com.example.demo.repository;


import com.example.demo.model.UserFollowers;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowerRepository extends CassandraRepository<UserFollowers, Long> {
}
