package com.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.es.document.Student;

public interface StudentRepository extends ElasticsearchRepository<Student, Long> {

}
