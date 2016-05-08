--001.
cmd:> sqlplus \nolog
cmd:> conn sys/root as sysdba

--005. Create table_space
CREATE TABLESPACE PRONTODB1 DATAFILE 'C:\app\oradata\PRONTODB\PRONTODB1.TBS' SIZE 1000M REUSE AUTOEXTEND ON NEXT 100M MAXSIZE UNLIMITED;

--006. Create user
CREATE USER prontodbuser IDENTIFIED BY prontodbuser DEFAULT TABLESPACE PRONTODB1 QUOTA UNLIMITED ON PRONTODB1;

GRANT CREATE PROCEDURE TO prontodbuser;
GRANT CREATE DBLINK TO prontodbuser;
GRANT CREATE SEQUENCE TO prontodbuser;
GRANT CREATE SYNONYM TO prontodbuser;
GRANT CREATE TABLE TO prontodbuser;
GRANT CREATE TRIGGER TO prontodbuser;
GRANT CREATE VIEW TO prontodbuser;
GRANT CREATE TYPE TO prontodbuser;
GRANT CREATE ANY DIRECTORY TO prontodbuser;
GRANT CREATE SESSION, ALTER SESSION TO prontodbuser; 
GRANT CONNECT, RESOURCE TO prontodbuser;
GRANT CREATE DATABASE LINK TO prontodbuser;
GRANT SELECT ANY DICTIONARY TO prontodbuser;
GRANT FLASHBACK ANY TABLE TO prontodbuser;
GRANT SELECT ANY TABLE TO prontodbuser;
GRANT EXECUTE ON dbms_flashback to prontodbuser;
GRANT EXECUTE ON utl_file to prontodbuser;
GRANT imp_full_database to prontodbuser;
GRANT exp_full_database to prontodbuser;
COMMIT;

--008. Create impdp/expdp directory
create directory backup as 'C:\app\backup\';
grant read,write on directory backup to prontodbuser;

--009. Import database
impdp prontodbuser/prontodbuser directory=backup dumpfile=20141028_0411-PMM.DMP full=y 