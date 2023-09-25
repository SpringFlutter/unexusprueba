create table tbl_cliente_unexus( 
	id_cliente_unexus int8 not null default nextval('tbl_cliente_unexus_sec'::regclass),
	ruc varchar(13),
	razon_social text,
	constraint tbl_cliente_unexus_pkey primary key (id_cliente_unexus)
)

create table tbl_cliente_sucursal_unexus(
	id_cliente_sucursal_unexus int8 not null default nextval('tbl_cliente_sucursal_unexus_sec'::regclass),
	id_cliente_unexus int8,
	direccion text,
	constraint tbl_cliente_sucursal_unexus_pkey primary key (id_cliente_sucursal_unexus),
	CONSTRAINT tbl_cliente_sucursal_unexus_id_cliente_unexus_fkey FOREIGN KEY (id_cliente_unexus) 
	REFERENCES unexus.tbl_cliente_unexus(id_cliente_unexus)
)
