package com.practice.api_gson.domain.repositories;


import com.practice.api_gson.domain.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends CrudRepository<CommentEntity, Integer> {
    Iterable<CommentEntity> findAllByParent(int parent);
}
