package io.zucchiniui.backend.support.ddd.morphia;

import io.zucchiniui.backend.support.ddd.EntityNotFoundException;
import io.zucchiniui.backend.support.ddd.PreparedQuery;
import org.mongodb.morphia.query.Query;

import java.util.List;
import java.util.stream.Stream;

class MorphiaPreparedQuery<T> implements PreparedQuery<T> {

    private final Query<T> query;

    public MorphiaPreparedQuery(final Query<T> query) {
        this.query = query;
    }

    @Override
    public List<T> find() {
        return query.asList();
    }

    @Override
    public Stream<T> stream() {
        return MorphiaUtils.streamQuery(query);
    }

    @Override
    public T findOne() {
        final T entity = query.get();
        if (entity == null) {
            throw new EntityNotFoundException(query.getEntityClass(), "Not found by query " + this);
        }
        return entity;
    }

}
