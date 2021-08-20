--alter session set "_ORACLE_SCRIPT"=true;
CREATE USER MINHACONTA IDENTIFIED BY MINHACONTA_aux;

GRANT CREATE SESSION TO MINHACONTA;
GRANT CREATE TABLE TO MINHACONTA;
GRANT CREATE CLUSTER TO MINHACONTA;
GRANT CREATE SYNONYM TO MINHACONTA;
GRANT CREATE VIEW TO MINHACONTA;
GRANT CREATE SEQUENCE TO MINHACONTA;
GRANT CREATE DATABASE LINK TO MINHACONTA;
GRANT CREATE PUBLIC DATABASE LINK TO MINHACONTA;
GRANT CREATE PROCEDURE TO MINHACONTA;
GRANT CREATE TRIGGER TO MINHACONTA;
GRANT CREATE MATERIALIZED VIEW TO MINHACONTA;
GRANT CREATE TYPE TO MINHACONTA;
GRANT CREATE OPERATOR TO MINHACONTA;
GRANT CREATE INDEXTYPE TO MINHACONTA;
GRANT CREATE DIMENSION TO MINHACONTA;
GRANT CREATE ANY CONTEXT TO MINHACONTA;
GRANT CREATE JOB TO MINHACONTA;

ALTER USER MINHACONTA ACCOUNT UNLOCK;
GRANT CREATE SESSION TO MINHACONTA;
GRANT DBA TO MINHACONTA;
GRANT CREATE USER,DROP USER,ALTER USER ,
CREATE ANY VIEW , DROP ANY VIEW,
EXP_FULL_DATABASE,IMP_FULL_DATABASE,
DBA,CONNECT,RESOURCE,CREATE SESSION TO MINHACONTA;

ALTER SESSION SET CURRENT_SCHEMA = MINHACONTA;

create table VINCULO_EC_USUARIO
(
  CHAVE_PERFIL      VARCHAR2(200 char)           not null,
  COD_EC            NUMBER(19)                   not null,
  USERNAME          VARCHAR2(200 char)           not null,
  DATA_CRIACAO      TIMESTAMP(6) default SYSDATE not null,
  DATA_DESATIVACAO  TIMESTAMP(6),
  DATA_MODIFICACAO  TIMESTAMP(6) default SYSDATE not null,
  LOGIN_MODIFICACAO VARCHAR2(200 char)           not null,
  primary key (CHAVE_PERFIL, COD_EC, USERNAME)
)
/

create index VINC_USERNAME_IDX
  on VINCULO_EC_USUARIO (USERNAME)
/

create index VINC_CHV_PERFIL_IDX
  on VINCULO_EC_USUARIO (CHAVE_PERFIL)
/

create index VINC_LG_MOD_IDX
  on VINCULO_EC_USUARIO (LOGIN_MODIFICACAO)
/

create index VINC_CODEC_IDX
  on VINCULO_EC_USUARIO (COD_EC)
/

create table PREF_USUARIO
(
  USERNAME             VARCHAR2(200 char)           not null
    primary key,
  DATA_ACEITACAO_TERMO TIMESTAMP(6),
  DATA_CRIACAO         TIMESTAMP(6) default SYSDATE not null,
  DATA_MODIFICACAO     TIMESTAMP(6) default SYSDATE not null,
  DATA_REJEICAO_TERMO  TIMESTAMP(6),
  PUSH_NOTIFICATION    NUMBER(1)                    not null,
  EMAIL_VERIFICADO     NUMBER(1)    default 0       not null
)
/

-- auto-generated definition
create table DISPOSITIVOS
(
  MODELO             VARCHAR2(200 char)           not null,
  PLATAFORMA         VARCHAR2(100 char)           not null,
  PLATAFORMA_VERSAO  VARCHAR2(50 char)            not null,
  UUID               VARCHAR2(400 char)           not null,
  APP_VERSAO         VARCHAR2(255 char)           not null,
  DATA_CRIACAO       TIMESTAMP(6) default SYSDATE not null,
  DATA_MODIFICACAO   TIMESTAMP(6) default SYSDATE not null,
  DATA_ULTIMO_ACESSO TIMESTAMP(6) default SYSDATE not null,
  HASH_PUSH          VARCHAR2(255 char),
  LOGOUT             NUMBER(1)                    not null,
  primary key (MODELO, PLATAFORMA, PLATAFORMA_VERSAO, UUID)
)
/

create index DISP_UUID_IDX
  on DISPOSITIVOS (UUID)
/

create index DISP_PLAT_IDX
  on DISPOSITIVOS (PLATAFORMA)
/

create index DISP_PLAT_VERSAO_IDX
  on DISPOSITIVOS (PLATAFORMA_VERSAO)
/

create index DISP_MODELO_IDX
  on DISPOSITIVOS (MODELO)
/

create index DISP_APP_VERSAO_IDX
  on DISPOSITIVOS (APP_VERSAO)
/

create index DISP_HASH_PUSH_IDX
  on DISPOSITIVOS (HASH_PUSH)
/

-- auto-generated definition
create table DISPOSITIVO_USUARIO
(
  MODELO             VARCHAR2(200)                not null,
  PLATAFORMA         VARCHAR2(100)                not null,
  PLATAFORMA_VERSAO  VARCHAR2(50)                 not null,
  USERNAME           VARCHAR2(200)                not null,
  UUID               VARCHAR2(400)                not null,
  BIOMETRIA          NUMBER(1)    default 0       not null,
  DATA_CRIACAO       TIMESTAMP(6) default SYSDATE not null,
  DATA_MODIFICACAO   TIMESTAMP(6) default SYSDATE not null,
  DATA_ULTIMO_ACESSO TIMESTAMP(6) default SYSDATE not null,
  LOGOUT             NUMBER(1)    default 0       not null,
  primary key (MODELO, PLATAFORMA, PLATAFORMA_VERSAO, USERNAME, UUID)
)
/

create index DISPUSR_UUID_IDX
  on DISPOSITIVO_USUARIO (UUID)
/

create index DISPUSR_PLAT_IDX
  on DISPOSITIVO_USUARIO (PLATAFORMA)
/

create index DISPUSR_PLAT_VERSAO_IDX
  on DISPOSITIVO_USUARIO (PLATAFORMA_VERSAO)
/

create index DISPUSR_MODELO_IDX
  on DISPOSITIVO_USUARIO (MODELO)
/

create index DISPUSR_USERNAME_IDX
  on DISPOSITIVO_USUARIO (USERNAME)
/

-- auto-generated definition
create table CODIGO_VERIFICACAO
(
  ID_COD_VERIF   NUMBER(19)         not null
    primary key,
  CODIGO         NUMBER(10)         not null,
  DATA_EXPIRACAO TIMESTAMP(6)       not null,
  TIPO_CODIGO    VARCHAR2(100 char) not null,
  USERNAME       VARCHAR2(200 char)
)
/

create index CODVER_TPCOD_IDX
  on CODIGO_VERIFICACAO (TIPO_CODIGO)
/

create index CODVER_CODIGO_IDX
  on CODIGO_VERIFICACAO (CODIGO)
/

create index CODVER_USERNAME_IDX
  on CODIGO_VERIFICACAO (USERNAME)
/

-- auto-generated definition
create table PERFIS
(
  CHAVE_PERFIL      VARCHAR2(200 char)           not null
    primary key,
  DATA_CRIACAO      TIMESTAMP(6) default SYSDATE not null,
  DATA_DESATIVACAO  TIMESTAMP(6),
  DATA_MODIFICACAO  TIMESTAMP(6) default SYSDATE not null,
  DESCRICAO         VARCHAR2(200 char)           not null,
  LOGIN_MODIFICACAO VARCHAR2(200 char)           not null
)
/

create index PERF_LG_MOD_IDX
  on PERFIS (LOGIN_MODIFICACAO)
/

-- auto-generated definition
create sequence COD_VERIF_SEQ
  increment by 50 START WITH 1
/

create table SOLICITACAO_VINCULO
(
  ID_SOLICITACAO NUMBER(19)                   not null
    primary key,
  COD_EC         NUMBER(19)                   not null,
  DATA_CRIACAO   TIMESTAMP(6) default SYSDATE not null,
  DATA_EXPIRACAO TIMESTAMP(6),
  USERNAME       VARCHAR2(200 char)           not null,
  constraint SOL_CONSTR_EC_USRN_PERFIL
    unique (COD_EC, USERNAME)
)
/

create sequence SOLICITACAO_EMAIL_SEQ
  increment by 50 START WITH 1
/


create table SOLICITACAO_EMAIL
(
  ID_SOLICITACAO         NUMBER(19)                   not null
    primary key,
  USERNAME               VARCHAR2(200 char)           not null,
  EMAIL_OLD              VARCHAR2(200 char)           not null,
  EMAIL_NEW              VARCHAR2(200 char)           not null,
  DATA_CRIACAO           TIMESTAMP(6) default SYSDATE not null,
  DATA_EXPIRACAO         TIMESTAMP(6),
  SOLICITACAO_CONFIRMADA NUMBER(1)    default 0       not null,
  SOLICITACAO_CANCELADA  NUMBER(1)    default 0       not null,
  SOURCE_USERNAME        VARCHAR2(200 char)           not null
)
/

create index IDX_SOL_EMAIL_USER_DT
  on SOLICITACAO_EMAIL (USERNAME, DATA_CRIACAO)
/