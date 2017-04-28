DELIMITER //
 

CREATE /* DEFINER=`%`@`%` */ FUNCTION `nvl`( value VARCHAR(255), rep_val VARCHAR(255)) 
RETURNS VARCHAR(255)

BEGIN

    DECLARE rtn_value VARCHAR(255); 
    
    select case 
              when value is null then rep_val
              when value = '' then rep_val
              when trim(value) = '' then rep_val
              else value
           end into rtn_value;
    return rtn_value;

END //

DELIMITER ;