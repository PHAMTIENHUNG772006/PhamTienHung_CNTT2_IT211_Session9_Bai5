package com.re.session9.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
    public void createOrder() {
        throw new RuntimeException("Đứt kết nối DB!");
    }
}