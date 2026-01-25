package com.example.book;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class JaxRsConfig extends Application {
    // Empty on purpose – configuration via annotations
}
