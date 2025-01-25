CREATE TABLE LOG (
    ID int not Null,
    FECHA varchar(15),
    HORA varchar(15),
    MENSAJE varchar(300),
    CONSTRAINT PK_LOG PRIMARY KEY (ID)
)