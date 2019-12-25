package com.example.websocketdemo.datasource;

import org.testcontainers.containers.PostgreSQLContainer;

public class UnitTestPostgreSQLContainer extends PostgreSQLContainer<UnitTestPostgreSQLContainer> {
	private static final String IMAGE_VERSION = "postgres:12.1";
	private static UnitTestPostgreSQLContainer container;

	private UnitTestPostgreSQLContainer() {
        super(IMAGE_VERSION);
    }

	public static UnitTestPostgreSQLContainer getInstance() {
		if (container == null) {
			container = new UnitTestPostgreSQLContainer();
		}
		return container;
	}

	@Override
	public void start() {
		super.start();
		System.setProperty("DB_URL", container.getJdbcUrl());
		System.setProperty("DB_USERNAME", container.getUsername());
		System.setProperty("DB_PASSWORD", container.getPassword());
	}

	@Override
	public void stop() {
		// do nothing, JVM handles shut down
	}
}
