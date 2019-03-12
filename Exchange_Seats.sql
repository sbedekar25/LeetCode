select A.Aid as id,student from seat ss
join 
(SELECT s.id as Aid,
CASE
    when s.id = ms.ii and s.id %2 <> 0  then s.id
    when s.id %2 <> 0 then s.id+1
    ELSE s.id-1
END AS newid
FROM seat as s,
(select max(id) as ii from seat) as ms) As A
on ss.id = A.newid