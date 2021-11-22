package me.mrtoke.fbook.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import me.mrtoke.fbook.entities.Writer;

@RepositoryRestResource(collectionResourceRel="apiwriters", path="writers-api")
public interface IWriterRepository extends PagingAndSortingRepository<Writer, Long> {

}
