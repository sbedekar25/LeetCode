(select  B.Request_At as "Day", round( (coalesce(c.c_req_at,0)/coalesce(B.c_req_at,1)),2) as "Cancellation Rate"  from
(select A.Request_At, count(Request_At) as c_req_at from
(
(
select t.Request_at,t.Client_id ,u.users_id, t.id from  Users u , Trips t
where   ((u.users_id = t.Driver_Id and u.Role ='driver'))
and (t.status = 'cancelled_by_driver') 
and (t.Request_at  BETWEEN '2013-10-01' AND '2013-10-03') 
and  t.Client_id  in (select users_id from users where Banned ='No')
and u.users_id in (select users_id from users where Banned ='No')
)
union
( 
select t.Request_at,u.users_id ,t.Driver_id, t.id from  Users u , Trips t
where   ((u.users_id = t.Driver_Id and u.Role ='driver'))
and (t.status = 'cancelled_by_client') 
and (t.Request_at  BETWEEN '2013-10-01' AND '2013-10-03') 
and  t.Client_id  in (select users_id from users where Banned ='No')
and u.users_id in (select users_id from users where Banned ='No')
)
) As A group by A.Request_at
) AS C
right outer join 
(select  Request_At, count(Request_At) as c_req_at
from Trips
where  client_id in (select users_id from users where Banned ='No')
and Driver_id in (select users_id from users where Banned ='No')
and (Request_at  BETWEEN '2013-10-01' AND '2013-10-03')
group by Request_At) AS B on C.Request_At = B.Request_At
)
