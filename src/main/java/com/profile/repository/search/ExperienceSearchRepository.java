package com.profile.repository.search;

import com.profile.domain.Experience;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Experience entity.
 */
public interface ExperienceSearchRepository extends ElasticsearchRepository<Experience, Long> {
}
