```
根据父id递归查询所有子节点
```
create function getChildrenDept(deptid INT)
returns varchar(4000)
BEGIN
DECLARE oTemp VARCHAR(4000);
DECLARE oTempChild VARCHAR(4000);

SET oTemp = '';
SET oTempChild = CAST(deptid AS CHAR);

WHILE oTempChild IS NOT NULL
DO
SET oTemp = CONCAT(oTemp,',',oTempChild);
SELECT GROUP_CONCAT(id) INTO oTempChild FROM comm_sys_dept WHERE FIND_IN_SET(pid,oTempChild) > 0;
END WHILE;
RETURN oTemp;
END


SELECT * FROM comm_sys_dept WHERE FIND_IN_SET(id,getChildrenDept(31));


```
根据子id递归查询所有父节点
```
SELECT id,name
    FROM (
        SELECT
                @r AS _id,
                (SELECT @r := pid FROM comm_sys_dept WHERE id = _id) AS pid,
                 @l := @l + 1 AS lvl
        FROM
                (SELECT @r := 31, @l := 0) vars,
                comm_sys_dept h
        WHERE @r <> 0) T1
    JOIN comm_sys_dept T2
    ON T1._id = T2.id
ORDER BY id;