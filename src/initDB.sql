-- drop table skills

DROP SCHEMA IF EXISTS module_2;

CREATE SCHEMA IF NOT EXISTS module_2;

alter table if exists developers_skills drop constraint developers_skills_developer_id_fk;
alter table if exists developers_skills drop constraint developers_skills_skill_id_fk;
alter table if exists projects drop constraint projects_project_customer_id_fk;
alter table if exists projects drop constraint projects_project_company_id_fk;
alter table if exists developers drop constraint developers_developer_company_id_fk;
alter table if exists developers drop constraint developers_developer_project_id_fk;

drop table if exists SKILLS;
drop table if exists CUSTOMERS;
drop table if exists COMPANIES;
drop table if exists PROJECTS;
drop table if exists DEVELOPERS;
drop table if exists DEVELOPERS_SKILLS;

create table skills(
    skill_id serial PRIMARY KEY,
    skill_name varchar not null
);

create table customers(
    customer_id serial PRIMARY KEY,
    customer_name varchar not null
);

create table companies (
    company_id serial not null PRIMARY KEY,
    company_name varchar(30) not null
);

create table projects (
    project_id serial PRIMARY KEY,
    project_name character varying(30) not null,
    project_company_id_fk integer references companies(company_id),
    project_customer_id_fk integer references customers(customer_id)
);

create table developers (
    developer_id serial PRIMARY KEY,
    developer_first_name character varying(15) not null,
    developer_last_name character varying(15) not null,
    developer_email character varying(50) not null,
    developer_phone character varying(15) not null,
    developer_project_id_fk integer references projects(project_id),
    developer_company_id_fk integer references companies(company_id)
);


create table developers_skills(
    developer_id_fk integer references developers (developer_id) on delete no action on update no action,
    skill_id_fk integer references skills (skill_id) on delete no action on update no action
);


    alter table projects add production_date date;