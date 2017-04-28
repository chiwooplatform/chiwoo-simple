
set @cdid := 3141; /* 변수 선언 및 값 대입 */

select  case 
          when count(a.cd_id) > 0
             then a.cd_id
          when @cdid > 0
             then @cdid
          else 
           ( select max(cd_id) + 1 from COM_CODE )
        end as cd_id,
        case 
          when count(a.cd_id) > 0
              then 1
          else 
             0
        end as exists_yn
from    COM_CODE a
where   a.cd_id = @cdid
;