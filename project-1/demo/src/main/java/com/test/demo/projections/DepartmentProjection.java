package com.test.demo.projections;

import jakarta.persistence.Column;

public interface DepartmentProjection {

    @Column(name = "id")
    Long getId();

    @Column(name = "name")
    String getName();

}
