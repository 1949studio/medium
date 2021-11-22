package me.mrtoke.fbook.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//@RepositoryRestResource(collectionResourceRel="apicomponents", path="api/components")
import me.mrtoke.fbook.entities.Component;

public interface IComponentRepository extends PagingAndSortingRepository<Component, Long> {
	
}
