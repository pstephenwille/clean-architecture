package com.practice.api_gson.drivers_3;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends CrudRepository<DBCommentItem, Integer> {
    Iterable<DBCommentItem> findAllByParent(int parent);
}
