package com.IT.IT4409.model;

import com.IT.IT4409.entity.JobPost;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobSpecificationsBuilder {

    private final List<JobSearchCriteria> params;

    public JobSpecificationsBuilder() {
        params = new ArrayList<JobSearchCriteria>();
    }

    public JobSpecificationsBuilder with(String key, String operation, Object value, boolean isOrPredicate) {
        params.add(new JobSearchCriteria(key, operation, value, isOrPredicate));
        return this;
    }

    public Specification<JobPost> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(JobSpecification::new)
                .collect(Collectors.toList());

        Specification result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(specs.get(i))
                    : Specification.where(result).and(specs.get(i));
        }
        return result;
    }
}
