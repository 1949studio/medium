package me.mrtoke.fbook.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import me.mrtoke.fbook.entities.User;

public interface IUserRepository extends CrudRepository<User, Long>{
	@Override
	public List<User> findAll();
}
