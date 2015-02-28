
CREATE TABLE users(
	id bigint NOT NULL,
	first_name character varying(50) NOT NULL,
	last_name character varying(50) NOT NULL,
	email character varying(50) NOT NULL,
	password character varying(50) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY(id)
);

CREATE TABLE role(
	id bigint NOT NULL,
	name character varying(50) NOT NULL,
	CONSTRAINT role_pkey PRIMARY KEY(id)
);

CREATE TABLE project(
	id bigint NOT NULL,
	title character varying(50) NOT NULL,
	role_id bigint NOT NULL,
	created_date date NOT NULL,
	status character varying(50) NOT NULL,
	CONSTRAINT project_pkey PRIMARY KEY(id)
);

CREATE TABLE task(
	id bigint NOT NULL,
	title character varying(50) NOT NULL,
	creator_id bigint NOT NULL,
	project_id bigint NOT NULL,
	CONSTRAINT task_pkey PRIMARY KEY(id),
	CONSTRAINT task_user_fkey
		FOREIGN KEY(creator_id) references users(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT task_project_fkey
		FOREIGN KEY(project_id) references project(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE comment(
	id bigint NOT NULL,
	content character varying(500) NOT NULL,
	creator_id bigint NOT NULL,
	task_id bigint NOT NULL,
	created_date date NOT NULL,
	CONSTRAINT comment_pkey PRIMARY KEY(id),
	CONSTRAINT comment_user_fkey
		FOREIGN KEY(creator_id) references users(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT comment_task_fkey
		FOREIGN KEY(task_id) references task(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE project_user_role(
	id bigint NOT NULL,
	role_id bigint NOT NULL,
	user_id bigint NOT NULL,
	project_id bigint NOT NULL,
	CONSTRAINT pгк_pkey PRIMARY KEY(id),
	CONSTRAINT pur_role_fkey
		FOREIGN KEY(role_id) references role(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT pur_user_fkey
		FOREIGN KEY(user_id) references users(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT pur_project_fkey
		FOREIGN KEY(project_id) references project(id)
		MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);
