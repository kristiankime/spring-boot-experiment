CREATE TABLE original_product
(
  id UUID NOT NULL PRIMARY KEY,
  description TEXT
);

CREATE TABLE imitation_product
(
  id UUID NOT NULL PRIMARY KEY,
  description TEXT,
  original_id UUID REFERENCES original_product(id)
);


