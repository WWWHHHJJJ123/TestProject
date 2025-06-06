package com.whj.redis.interfaceIdempotency.model;

import lombok.Data;

/**
 * @author CiZhong
 * @date 2025-03-24
 */
@Data
public class OrderRequest {
    private String productId;
    private int quantity;
}
