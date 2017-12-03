package com.profile.repository.search;

import com.profile.domain.Profile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Profile entity.
 */
public interface ProfileSearchRepository extends ElasticsearchRepository<Profile, Long> {
}
