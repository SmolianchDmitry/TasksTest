SELECT count(*)
FROM users LEFT JOIN usersessions u on users.userid = u.userid
WHERE u.userid IS NULL;

SELECT userid
FROM usersessions
GROUP BY userid
EXCEPT
SELECT userid
FROM usersessions
WHERE mobappversion = 1
GROUP BY userid;

SELECT max(USERS.userid)
FROM users INNER JOIN usersessions u on users.userid = u.userid
WHERE status != 1;

SELECT mobappversion, count(*)
FROM usersessions
WHERE (mobosversion < 80 OR mobosversion IS NULL) AND channeltype = 9
GROUP BY mobappversion;

--EST: 1h
