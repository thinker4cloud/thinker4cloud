DROP TABLE IF EXISTS oauth_client_details;
DROP TABLE IF EXISTS oauth_client_token;

CREATE TABLE oauth_client_details (
  client_id               VARCHAR(255) PRIMARY KEY,
  resource_ids            VARCHAR(255),
  client_secret           VARCHAR(255),
  scope                   VARCHAR(255),
  authorized_grant_types  VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities             VARCHAR(255),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(255)
);

INSERT INTO oauth_client_details
(client_id, resource_ids, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity,
 additional_information, autoapprove)
  VALUE
  ('mobile', NULL, '$2a$10$ASvu868SSb2ViSFTHUrNX.fTyJEEfy32y6ZeRv6UmYk9cen.nHNmK', 'all', 'password,refresh_token',
             NULL, NULL, NULL,
             NULL, NULL, NULL),
  ('web', NULL, '$2a$10$ASvu868SSb2ViSFTHUrNX.fTyJEEfy32y6ZeRv6UmYk9cen.nHNmK', 'all', 'authorization_code', NULL, NULL,
          NULL,
          NULL, NULL, NULL);


DROP TABLE IF EXISTS oauth_refresh_token;
DROP TABLE IF EXISTS oauth_access_token;

CREATE TABLE oauth_access_token (
  token_id          VARCHAR(255),
  token             BLOB,
  authentication_id VARCHAR(255),
  user_name         VARCHAR(255),
  client_id         VARCHAR(255),
  authentication    BLOB,
  refresh_token     VARCHAR(255)
);

CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(255),
  token          BLOB,
  authentication BLOB
);

DELETE FROM sys_user_role;
DELETE FROM sys_role;
DELETE FROM sys_user;

INSERT INTO sys_role (id, crated_date, created_by, last_modified_by, last_modified_date, name, value)
  VALUE
  (1, now(), 'admin', 'admin', now(), '管理员', 'ROLE_ADMIN'),
  (2, now(), 'admin', 'admin', now(), '用户', 'ROLE_USER');


INSERT INTO sys_user (id, crated_date, created_by, last_modified_by, last_modified_date, email, first_name, last_name, password, username)
  VALUE (1, now(), 'admin', 'admin', now(), 'dev@panjunye.com', 'thinker', 'thinker',
         '$2a$10$ASvu868SSb2ViSFTHUrNX.fTyJEEfy32y6ZeRv6UmYk9cen.nHNmK', 'admin');

INSERT INTO sys_user_role (sys_user_id, sys_role_id) VALUES
  (1, 1);