create table oauth_access_token
(
    token_id varchar(255) null,
    token blob null,
    authentication_id varchar(255) not null,
    user_name varchar(255) null,
    client_id varchar(255) null,
    authentication blob null,
    refresh_token varchar(255) null,
    oauth_access_token_pk varchar(255) not null,
    constraint oauth_access_token_pk
        primary key (authentication_id)
);

create unique index oauth_access_token_pk
    on oauth_access_token (authentication_id);


create table oauth_refresh_token
(
    token_id varchar(255) not null,
    oauth_refresh_token_pk varchar(255) not null,
    token blob null,
    authentication blob null,
    constraint oauth_refresh_token_pk
        primary key (token_id)
);

create unique index oauth_refresh_token_pk
    on oauth_refresh_token (token_id);

alter table oauth_access_token drop column oauth_access_token_pk;

alter table oauth_access_token drop primary key;

alter table oauth_refresh_token drop column oauth_refresh_token_pk;

alter table oauth_refresh_token drop primary key;

