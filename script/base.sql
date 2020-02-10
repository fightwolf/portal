/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/2/7 20:38:49                            */
/*==============================================================*/


drop table if exists portal_action_logs;

drop table if exists portal_article;

drop table if exists portal_group;

drop table if exists portal_module;

drop table if exists portal_notice;

drop table if exists portal_project;

drop table if exists portal_project_role;

drop table if exists portal_role_group;

drop table if exists portal_roles;

drop table if exists portal_user_group;

drop table if exists portal_user_role;

drop table if exists portal_users;

/*==============================================================*/
/* Table: portal_action_logs                                    */
/*==============================================================*/
create table portal_action_logs
(
   Id                   bigint not null auto_increment,
   operation_type       varchar(64),
   operation_name       varchar(36),
   parent_code          varchar(36),
   describes            varchar(4000),
   ip                   varchar(64),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_article                                        */
/*==============================================================*/
create table portal_article
(
   Id                   bigint not null auto_increment,
   title                varchar(128),
   sub_title            varchar(128),
   icon                 varchar(256),
   link                 varchar(256),
   contents             blob,
   ar                   int,
   status               int,
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_group                                          */
/*==============================================================*/
create table portal_group
(
   Id                   bigint not null auto_increment,
   role_code            varchar(64),
   role_name            varchar(64),
   ar                   int,
   describes            varchar(1024),
   status               int,
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_module                                         */
/*==============================================================*/
create table portal_module
(
   Id                   bigint not null auto_increment,
   module_name          varchar(64),
   module_code          varchar(36),
   parent_code          varchar(36),
   icon                 varchar(256),
   link                 varchar(256),
   describes            varchar(4000),
   ar                   int,
   status               int,
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_notice                                         */
/*==============================================================*/
create table portal_notice
(
   Id                   bigint not null auto_increment,
   title                varchar(128),
   sub_title            varchar(128),
   position_id          int,
   position_name        varchar(36),
   icon                 varchar(256),
   link                 varchar(256),
   begin_times          datetime,
   end_times            datetime,
   contents             blob,
   ar                   int,
   status               int,
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_project                                        */
/*==============================================================*/
create table portal_project
(
   Id                   bigint not null auto_increment,
   project_code         varchar(64),
   project_name         varchar(36),
   project_type         int,
   parent_code          varchar(36),
   url                  varchar(256),
   url_name             varchar(256),
   describes            varchar(1024),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_project_role                                   */
/*==============================================================*/
create table portal_project_role
(
   Id                   bigint not null, auto_increment
   role_code            varchar(64),
   project_code         varchar(64),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_role_group                                     */
/*==============================================================*/
create table portal_role_group
(
   Id                   bigint not null auto_increment,
   group_code           varchar(64),
   role_code            varchar(64),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_roles                                          */
/*==============================================================*/
create table portal_roles
(
   Id                   bigint not null auto_increment,
   role_code            varchar(64),
   role_name            varchar(64),
   ar                   int,
   describes            varchar(1024),
   status               int,
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_user_group                                     */
/*==============================================================*/
create table portal_user_group
(
   Id                   bigint not null auto_increment,
   user_code            varchar(64),
   role_code            varchar(64),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_user_role                                      */
/*==============================================================*/
create table portal_user_role
(
   Id                   bigint not null auto_increment,
   user_code            varchar(64),
   role_code            varchar(64),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

/*==============================================================*/
/* Table: portal_users                                          */
/*==============================================================*/
create table portal_users
(
   Id                   bigint not null auto_increment,
   user_code            varchar(64),
   user_name            varchar(36),
   user_pwd             varchar(64),
   user_type            varchar(64),
   user_email           varchar(128),
   user_phone           varchar(16),
   avatar               varchar(36),
   registe_ip           varchar(64),
   creator_id           varchar(36),
   creator_name         varchar(36),
   create_timestamp     datetime default CURRENT_TIMESTAMP,
   last_update_timestamp datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (Id)
);

