package com.practice.api_gson.repositories;


import com.practice.api_gson.models.CommentDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<CommentDto, Integer> {
}
