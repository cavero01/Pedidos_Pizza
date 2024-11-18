package com.pizzacustomizer.broker.storage;

import java.util.List;
import java.util.Optional;

public interface IStorageBroker {
    <T> T create(T entity);
    <T> T update(T entity);
    <T> List<T> findAll(Class<T> type);
    <T> Optional<T> findById(Class<T> type, Long id);
}