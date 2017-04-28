
create table if not exists COM_CODE_GROUP (
    grp_cd_id       SMALLINT                COMMENT '그롭 코드 아이디',
    grp_cd_name     VARCHAR(255) NOT NULL   COMMENT '그롭 코드 명',
    descr           VARCHAR(255)            COMMENT '설명',
    use_yn          TINYINT(1) NOT NULL default 1 COMMENT '사용 여부',
    ordno           SMALLINT                COMMENT '정렬 순번',
    register_id     INT                     COMMENT '등록자',
    reg_dtm         TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '등록 일시',
    modifier_id     INT                     COMMENT '수정자',
    upd_dtm         TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시'
);

alter table COM_CODE_GROUP add constraint PK_COM_CODE_GROUP primary key (grp_cd_id);


create table if not exists COM_CODE (
        cd_id       SMALLINT                COMMENT '코드 아이디',
        up_cd_id    SMALLINT                COMMENT '상위 코드 아이디',
        cd_val      VARCHAR(255)            COMMENT '코드 값',
        cd_name     VARCHAR(255) NOT NULL   COMMENT '코드 명',
        cd_eng_name VARCHAR(255)            COMMENT '코드 영문 명',
        descr       VARCHAR(255)            COMMENT '설명',
        use_yn      TINYINT(1) NOT NULL default 1 COMMENT '사용 여부',
        ordno       SMALLINT                COMMENT '정렬 순번',
        ext_val     VARCHAR(255)            COMMENT '참조 값',
        register_id INT                     COMMENT '등록자',
        reg_dtm     TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '등록 일시',
        modifier_id INT                     COMMENT '수정자',
        upd_dtm     TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시'
);

alter table COM_CODE add constraint PK_COM_CODE primary key ( cd_id );
alter table COM_CODE add constraint `FK_COM_CODE_GROUP_01` foreign key (`up_cd_id`) references COM_CODE_GROUP(`grp_cd_id`);


create table if not exists IAM_ROLE (
        role_id     SMALLINT                COMMENT '롤 아이디',
        role_name   VARCHAR(255) NOT NULL   COMMENT '롤 명',
        role_cd     SMALLINT     NOT NULL   COMMENT '롤 유형 코드 COM_CODE.cd_id=101',
        descr       VARCHAR(255)            COMMENT '설명',
        use_yn      TINYINT(1) NOT NULL default 1 COMMENT '사용 여부',
        ordno       SMALLINT                COMMENT '정렬 순번',
        register_id INT                     COMMENT '등록자',
        reg_dtm     TIMESTAMP  DEFAULT CURRENT_TIMESTAMP COMMENT '등록 일시',
        modifier_id INT                     COMMENT '수정자',
        upd_dtm     TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시'
);

alter table IAM_ROLE add constraint PK_IAM_ROLE primary key (role_id);


create table if not exists COM_I18N_MESSAGE (
    code      varchar(100) not null,
    locale    varchar(20)  not null,   
    message   varchar(255) not null,
    use_yn    smallint     not null default 1,
    upd_dtm   timestamp    NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
); 

alter table COM_I18N_MESSAGE add constraint PK_COM_I18N_MESSAGE primary key (code, locale);
