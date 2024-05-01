package com.practice.api_gson.domain.repositories;


import com.practice.api_gson.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<CommentEntity, Integer> {
}
