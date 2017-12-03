package com.profile.repository.search;

import com.profile.domain.Education;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Education entity.
 */
public interface EducationSearchRepository extends ElasticsearchRepository<Education, Long> {
}
