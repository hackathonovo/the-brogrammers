# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table btlocation (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_btlocation primary key (id)
);
create sequence btlocation_seq;

create table bttrip (
  id                            bigint not null,
  owner_id                      bigint,
  start_date                    timestamp,
  num_of_places                 integer,
  price                         integer,
  constraint pk_bttrip primary key (id)
);
create sequence bttrip_seq;

create table bttrip_btlocation (
  bttrip_id                     bigint not null,
  btlocation_id                 bigint not null,
  constraint pk_bttrip_btlocation primary key (bttrip_id,btlocation_id)
);

create table bttrip_btuser (
  bttrip_id                     bigint not null,
  btuser_id                     bigint not null,
  constraint pk_bttrip_btuser primary key (bttrip_id,btuser_id)
);

create table btuser (
  id                            bigint not null,
  username                      varchar(255),
  password                      varchar(255),
  first_name                    varchar(255),
  last_name                     varchar(255),
  email                         varchar(255),
  constraint uq_btuser_username unique (username),
  constraint uq_btuser_email unique (email),
  constraint pk_btuser primary key (id)
);
create sequence btuser_seq;

create table hgssaction (
  id                            bigint not null,
  title                         varchar(255),
  description                   varchar(255),
  longitude                     float,
  latitude                      float,
  owner_id                      bigint,
  is_active                     boolean,
  action_type_id                bigint,
  constraint pk_hgssaction primary key (id)
);
create sequence hgssaction_seq;

create table hgssaction_hgssuser (
  hgssaction_id                 bigint not null,
  hgssuser_id                   bigint not null,
  constraint pk_hgssaction_hgssuser primary key (hgssaction_id,hgssuser_id)
);

create table hgssaction_type (
  id                            bigint not null,
  action_type                   varchar(255),
  constraint pk_hgssaction_type primary key (id)
);
create sequence hgssaction_type_seq;

create table hgsschat_message (
  id                            bigint not null,
  hgssaction_id                 bigint not null,
  username                      varchar(255),
  message                       varchar(255),
  date                          timestamp,
  constraint pk_hgsschat_message primary key (id)
);
create sequence hgsschat_message_seq;

create table hgsslocation (
  id                            bigint not null,
  hgsszone_id                   bigint not null,
  longitude                     float,
  latitude                      float,
  constraint pk_hgsslocation primary key (id)
);
create sequence hgsslocation_seq;

create table hgssrole (
  id                            bigint not null,
  role                          varchar(255),
  constraint pk_hgssrole primary key (id)
);
create sequence hgssrole_seq;

create table hgssskill (
  id                            bigint not null,
  skill                         varchar(255),
  constraint pk_hgssskill primary key (id)
);
create sequence hgssskill_seq;

create table hgssstation (
  id                            bigint not null,
  station_name                  varchar(255),
  longitude                     float,
  latitude                      float,
  constraint pk_hgssstation primary key (id)
);
create sequence hgssstation_seq;

create table hgssuser (
  id                            bigint not null,
  username                      varchar(255),
  password                      varchar(255),
  first_name                    varchar(255),
  last_name                     varchar(255),
  location                      varchar(255),
  available_from                varchar(255),
  available_until               varchar(255),
  is_available                  boolean,
  phone_number                  varchar(255),
  role_id                       bigint,
  skill_id                      bigint,
  station_id                    bigint,
  constraint uq_hgssuser_username unique (username),
  constraint pk_hgssuser primary key (id)
);
create sequence hgssuser_seq;

create table hgssuser_location (
  id                            bigint not null,
  hgssuser_id                   bigint not null,
  longitude                     float,
  latitude                      float,
  constraint pk_hgssuser_location primary key (id)
);
create sequence hgssuser_location_seq;

create table hgsszone (
  id                            bigint not null,
  hgssaction_id                 bigint not null,
  constraint pk_hgsszone primary key (id)
);
create sequence hgsszone_seq;

alter table bttrip add constraint fk_bttrip_owner_id foreign key (owner_id) references btuser (id) on delete restrict on update restrict;
create index ix_bttrip_owner_id on bttrip (owner_id);

alter table bttrip_btlocation add constraint fk_bttrip_btlocation_bttrip foreign key (bttrip_id) references bttrip (id) on delete restrict on update restrict;
create index ix_bttrip_btlocation_bttrip on bttrip_btlocation (bttrip_id);

alter table bttrip_btlocation add constraint fk_bttrip_btlocation_btlocation foreign key (btlocation_id) references btlocation (id) on delete restrict on update restrict;
create index ix_bttrip_btlocation_btlocation on bttrip_btlocation (btlocation_id);

alter table bttrip_btuser add constraint fk_bttrip_btuser_bttrip foreign key (bttrip_id) references bttrip (id) on delete restrict on update restrict;
create index ix_bttrip_btuser_bttrip on bttrip_btuser (bttrip_id);

alter table bttrip_btuser add constraint fk_bttrip_btuser_btuser foreign key (btuser_id) references btuser (id) on delete restrict on update restrict;
create index ix_bttrip_btuser_btuser on bttrip_btuser (btuser_id);

alter table hgssaction add constraint fk_hgssaction_owner_id foreign key (owner_id) references hgssuser (id) on delete restrict on update restrict;
create index ix_hgssaction_owner_id on hgssaction (owner_id);

alter table hgssaction add constraint fk_hgssaction_action_type_id foreign key (action_type_id) references hgssaction_type (id) on delete restrict on update restrict;
create index ix_hgssaction_action_type_id on hgssaction (action_type_id);

alter table hgssaction_hgssuser add constraint fk_hgssaction_hgssuser_hgssaction foreign key (hgssaction_id) references hgssaction (id) on delete restrict on update restrict;
create index ix_hgssaction_hgssuser_hgssaction on hgssaction_hgssuser (hgssaction_id);

alter table hgssaction_hgssuser add constraint fk_hgssaction_hgssuser_hgssuser foreign key (hgssuser_id) references hgssuser (id) on delete restrict on update restrict;
create index ix_hgssaction_hgssuser_hgssuser on hgssaction_hgssuser (hgssuser_id);

alter table hgsschat_message add constraint fk_hgsschat_message_hgssaction_id foreign key (hgssaction_id) references hgssaction (id) on delete restrict on update restrict;
create index ix_hgsschat_message_hgssaction_id on hgsschat_message (hgssaction_id);

alter table hgsslocation add constraint fk_hgsslocation_hgsszone_id foreign key (hgsszone_id) references hgsszone (id) on delete restrict on update restrict;
create index ix_hgsslocation_hgsszone_id on hgsslocation (hgsszone_id);

alter table hgssuser add constraint fk_hgssuser_role_id foreign key (role_id) references hgssrole (id) on delete restrict on update restrict;
create index ix_hgssuser_role_id on hgssuser (role_id);

alter table hgssuser add constraint fk_hgssuser_skill_id foreign key (skill_id) references hgssskill (id) on delete restrict on update restrict;
create index ix_hgssuser_skill_id on hgssuser (skill_id);

alter table hgssuser add constraint fk_hgssuser_station_id foreign key (station_id) references hgssstation (id) on delete restrict on update restrict;
create index ix_hgssuser_station_id on hgssuser (station_id);

alter table hgssuser_location add constraint fk_hgssuser_location_hgssuser_id foreign key (hgssuser_id) references hgssuser (id) on delete restrict on update restrict;
create index ix_hgssuser_location_hgssuser_id on hgssuser_location (hgssuser_id);

alter table hgsszone add constraint fk_hgsszone_hgssaction_id foreign key (hgssaction_id) references hgssaction (id) on delete restrict on update restrict;
create index ix_hgsszone_hgssaction_id on hgsszone (hgssaction_id);


# --- !Downs

alter table if exists bttrip drop constraint if exists fk_bttrip_owner_id;
drop index if exists ix_bttrip_owner_id;

alter table if exists bttrip_btlocation drop constraint if exists fk_bttrip_btlocation_bttrip;
drop index if exists ix_bttrip_btlocation_bttrip;

alter table if exists bttrip_btlocation drop constraint if exists fk_bttrip_btlocation_btlocation;
drop index if exists ix_bttrip_btlocation_btlocation;

alter table if exists bttrip_btuser drop constraint if exists fk_bttrip_btuser_bttrip;
drop index if exists ix_bttrip_btuser_bttrip;

alter table if exists bttrip_btuser drop constraint if exists fk_bttrip_btuser_btuser;
drop index if exists ix_bttrip_btuser_btuser;

alter table if exists hgssaction drop constraint if exists fk_hgssaction_owner_id;
drop index if exists ix_hgssaction_owner_id;

alter table if exists hgssaction drop constraint if exists fk_hgssaction_action_type_id;
drop index if exists ix_hgssaction_action_type_id;

alter table if exists hgssaction_hgssuser drop constraint if exists fk_hgssaction_hgssuser_hgssaction;
drop index if exists ix_hgssaction_hgssuser_hgssaction;

alter table if exists hgssaction_hgssuser drop constraint if exists fk_hgssaction_hgssuser_hgssuser;
drop index if exists ix_hgssaction_hgssuser_hgssuser;

alter table if exists hgsschat_message drop constraint if exists fk_hgsschat_message_hgssaction_id;
drop index if exists ix_hgsschat_message_hgssaction_id;

alter table if exists hgsslocation drop constraint if exists fk_hgsslocation_hgsszone_id;
drop index if exists ix_hgsslocation_hgsszone_id;

alter table if exists hgssuser drop constraint if exists fk_hgssuser_role_id;
drop index if exists ix_hgssuser_role_id;

alter table if exists hgssuser drop constraint if exists fk_hgssuser_skill_id;
drop index if exists ix_hgssuser_skill_id;

alter table if exists hgssuser drop constraint if exists fk_hgssuser_station_id;
drop index if exists ix_hgssuser_station_id;

alter table if exists hgssuser_location drop constraint if exists fk_hgssuser_location_hgssuser_id;
drop index if exists ix_hgssuser_location_hgssuser_id;

alter table if exists hgsszone drop constraint if exists fk_hgsszone_hgssaction_id;
drop index if exists ix_hgsszone_hgssaction_id;

drop table if exists btlocation cascade;
drop sequence if exists btlocation_seq;

drop table if exists bttrip cascade;
drop sequence if exists bttrip_seq;

drop table if exists bttrip_btlocation cascade;

drop table if exists bttrip_btuser cascade;

drop table if exists btuser cascade;
drop sequence if exists btuser_seq;

drop table if exists hgssaction cascade;
drop sequence if exists hgssaction_seq;

drop table if exists hgssaction_hgssuser cascade;

drop table if exists hgssaction_type cascade;
drop sequence if exists hgssaction_type_seq;

drop table if exists hgsschat_message cascade;
drop sequence if exists hgsschat_message_seq;

drop table if exists hgsslocation cascade;
drop sequence if exists hgsslocation_seq;

drop table if exists hgssrole cascade;
drop sequence if exists hgssrole_seq;

drop table if exists hgssskill cascade;
drop sequence if exists hgssskill_seq;

drop table if exists hgssstation cascade;
drop sequence if exists hgssstation_seq;

drop table if exists hgssuser cascade;
drop sequence if exists hgssuser_seq;

drop table if exists hgssuser_location cascade;
drop sequence if exists hgssuser_location_seq;

drop table if exists hgsszone cascade;
drop sequence if exists hgsszone_seq;

