use dmp;

--DROP table IF exists configs;

CREATE table IF NOT exists fileRegistry(
id uuid primary key, --unique identifier
fileName text, --file name
fileSize long, -- file size
loadDate  timestamp --load date
) with comment = 'Loaded file register:
id - unique identifier;
fileName - file name;
fileSize - file size
loadDate - load date';
