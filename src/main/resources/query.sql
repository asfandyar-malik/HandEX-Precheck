CREATE TABLE export
(
  id serial NOT NULL,
  company_name character varying NOT NULL,
  email character varying NOT NULL,
  importer_country character varying NOT NULL,
  payment_term character varying NOT NULL,
  contract_value bigint NOT NULL,
  industry_type character varying,
  project_description character varying,
  createdat timestamp with time zone,
  CONSTRAINT pk_export_id PRIMARY KEY (id)
)