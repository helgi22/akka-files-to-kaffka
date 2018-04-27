--drop KEYSPACE IF EXISTS cpa;

--For productive usage
/*CREATE KEYSPACE
IF NOT EXISTS cpa
WITH replication = {
 'class': 'NetworkTopologyStrategy',
 'dgt' : 2, 'whg' : 2
 };*/

--for local develop
CREATE KEYSPACE
IF NOT EXISTS dmp
WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
