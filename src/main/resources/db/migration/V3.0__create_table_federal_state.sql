CREATE TABLE public.federal_state (
                                      id int8 GENERATED ALWAYS AS IDENTITY NOT NULL,
                                      name varchar NOT NULL,
                                      created_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                      updated_date timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                      uuid uuid NOT NULL,
                                      CONSTRAINT federal_state_pk PRIMARY KEY (id),
                                      CONSTRAINT federal_state_unique UNIQUE (uuid)
);
