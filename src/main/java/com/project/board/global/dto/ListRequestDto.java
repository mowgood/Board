package com.project.board.global.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public class ListRequestDto {

    @Builder.Default
    private Integer pageSize = 10;

    @Builder.Default
    private Integer page = 0;

    @Builder.Default
    private Sort.Direction sortDirection = Sort.Direction.DESC;

    private String column;

    public void setPage(Integer page) {
        this.page = page - 1;
        if (page <= 0) {
            this.page = 0;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (pageSize <= 0 || pageSize > 10) {
            this.pageSize = 10;
        }
    }

    public void setSortDirection(String sortDirection) {
        if (sortDirection.equalsIgnoreCase("asc")) {
            this.sortDirection = Sort.Direction.ASC;
        }
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
