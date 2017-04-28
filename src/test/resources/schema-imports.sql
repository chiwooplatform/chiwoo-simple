
INSERT INTO `COM_I18N_MESSAGE` (`code`, `locale`, `message`, `use_yn` ) VALUES
    ('ui.app.name', 'en', 'App Name', 1 ),
    ('ui.app.name', 'ko', '앱 이름', 1 ),
    ('validation.Code.cdId', 'ko', '\'코드 아이디\'는 필수 입력 항목 입니다.', 1 ),
    ('validation.Code.cdName', 'ko', '\'코드 명\'은 필수 입력 항목 입니다.', 1 ),
    ('validation.Code.cdVal', 'ko', '\'코드 값\'은 필수 입력 항목 입니다.', 1 ),
    ('validation.Code.ordno', 'ko', '\'정렬 순번\'은 숫자 형식의 필수 입력 항목 입니다.', 1 ),
    ('validation.Code.cdId', 'en', '\'cdId\' is may not be null', 1 ),
    ('validation.Code.cdName', 'en', '\'cdName\' is may not be null', 1 ),
    ('validation.Code.cdVal', 'en', '\'cdVal\' is may not be null', 1 ),
    ('validation.Code.ordno', 'en', '\'ordno\' is may not be null and data type is number', 1 )
    ;

    

INSERT INTO `COM_CODE_GROUP` (`grp_cd_id`, `grp_cd_name`, `descr`, `use_yn`, `ordno`, `register_id` ) VALUES
    (10, '사업자 유형', '사업자 유형', 1, 1, 1 ),
    (11, '노티 유형',    '노티 유형', 1, 2, 1 );


INSERT INTO `COM_CODE` (`cd_id`, `up_cd_id`, `cd_val`, `cd_name`, `cd_eng_name`, `descr`, `use_yn`, `ordno`, `ext_val`, `register_id` ) VALUES
    (1, 10, '10', '일반사용자', 'Normal', '사용자유형-일반', 1, 1, NULL, 1 ),
    (2, 10, '11', '개인사업자', 'Pri. BiZ', '사용자유형-개인', 1, 2, NULL, 1 ),
    (313, 10, '12', '법인사업자', 'Corp. Biz', '사용자유형-법인', 1, 3, NULL, 1 ),
    (314, 11, '10', 'SMS', 'SMS', '노티유형 - SMS', 1, 1, NULL, 1 );
