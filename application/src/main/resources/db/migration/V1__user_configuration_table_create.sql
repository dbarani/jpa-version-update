CREATE TABLE IF NOT EXISTS user_configuration
(
    id SERIAL PRIMARY KEY,
    version int,
    created_at TIMESTAMP,
    valid_from TIMESTAMP WITHOUT TIME ZONE,
    valid_to TIMESTAMP WITHOUT TIME ZONE,
    configuration JSONB
);
