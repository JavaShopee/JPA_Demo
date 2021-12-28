package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudsRepo extends JpaRepository<Students, Integer>
{
	
}
